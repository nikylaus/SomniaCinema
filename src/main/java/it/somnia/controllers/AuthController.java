package it.somnia.controllers;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.somnia.dto.LoginAccountDTO;
import it.somnia.dto.LoginResponseDTO;
import it.somnia.dto.RegisterDTO;
import it.somnia.model.Account;
import it.somnia.model.Ruolo;
import it.somnia.security.JWTTokenService;
import it.somnia.service.AccountDetailsService;
import it.somnia.service.AccountService;
import it.somnia.service.RuoloService;
import lombok.extern.java.Log;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
@Log
public class AuthController {
	
	@Autowired 
	private AccountService accountService;
	
	@Autowired
	private RuoloService ruoloService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AccountDetailsService accountDetailsService;

	@Autowired
	private JWTTokenService jwtTokenService;
	
	@PostMapping(value="/signup")
	public ResponseEntity<InfoMsg> accountSignUp(@RequestBody RegisterDTO accountDto){
		/************ MAPPING DTO - ENTITY ******************/
		Account account = new Account();
		account.setDataIscrizione(new Date(System.currentTimeMillis()));
		account.setDataNascita(accountDto.getDataNascita());
		account.setDescrizioneProfilo("Modifica la tua descrizione");
		account.setEmail(accountDto.getEmail());
		account.setPass(passwordEncoder.encode(accountDto.getPass()));
		account.setImg("profilo1.png");
		account.setUsername(accountDto.getUsername());
		log.info("Aggiungiamo il ruolo USER");
		Ruolo ruolo = ruoloService.findRuoloByName("ROLE_USER").get();
		account.addRuolo(ruolo);
		System.err.println("ROLE : " + ruolo.getNome());
		//log.info("data : " + new Date(System.currentTimeMillis()));
		//log.info("Salviamo l'utente con email " + account.getEmail());
		Account nuovoAccount = accountService.saveAccount(account);
		if(nuovoAccount == null) {
			return new ResponseEntity<InfoMsg>(
					new InfoMsg(LocalDate.now(), String.format("Email già presente")),
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<InfoMsg>(
				new InfoMsg(LocalDate.now(), String.format("Inserimento utente %s eseguito con successo", nuovoAccount.getId())), 
				HttpStatus.OK);
	}

	//---------------------- LOGIN UTENTE --------------------------
	@PostMapping("/login")
	public LoginResponseDTO authenticate(@RequestBody LoginAccountDTO authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
					authenticationRequest.getPass()));
		} catch (BadCredentialsException ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		UserDetails userDetails = accountDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		LoginResponseDTO authenticationResponse = new LoginResponseDTO();
		authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
		return authenticationResponse;	
	}
}
