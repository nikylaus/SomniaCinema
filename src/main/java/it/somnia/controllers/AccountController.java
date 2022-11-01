package it.somnia.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.somnia.dto.AccountDTO;
import it.somnia.dto.AccountInfoDTO;
import it.somnia.dto.AccountUsernameDescrDTO;
import it.somnia.dto.UpdateDescrProfiloDTO;
import it.somnia.dto.UpdateImgProfiloDTO;
import it.somnia.dto.UpdateUsernameDTO;
import it.somnia.exception.NotFoundException;
import it.somnia.model.Account;
import it.somnia.service.AccountService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@CrossOrigin
@RestController
@Log
@RequestMapping(method = RequestMethod.PUT)
public class AccountController {

	@Autowired
	private AccountService service;
	
	@GetMapping("/api/username/{username}")
	public AccountInfoDTO getByUsername(@PathVariable String username) {
		Optional<Account> accOpt = service.getAccountByUsername(username);
		if (accOpt == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		}
		Account account = accOpt.get();
		AccountInfoDTO accountDto = new AccountInfoDTO();
		accountDto.setId(account.getId());
		accountDto.setDataIscrizione(account.getDataIscrizione());
		accountDto.setDataNascita(account.getDataNascita());
		accountDto.setEmail(account.getEmail());
		accountDto.setImg(account.getImg());
		accountDto.setDescrizioneProfilo(account.getDescrizioneProfilo());
		accountDto.setUsername(account.getUsername());
		accountDto.setPrenotazioni(account.getPrenotazioni());
		accountDto.setRuoli(account.getRuoli());
		return accountDto;
	}
	
	
	@GetMapping("/api/email/{email}")
	public AccountInfoDTO getByEmail(@PathVariable String email) {
		Optional<Account> accOpt = service.getAccountByEmail(email);
		if (accOpt == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		}
		Account account = accOpt.get();
		AccountInfoDTO accountDto = new AccountInfoDTO();
		accountDto.setId(account.getId());
		accountDto.setDataIscrizione(account.getDataIscrizione());
		accountDto.setDataNascita(account.getDataNascita());
		accountDto.setEmail(account.getEmail());
		accountDto.setImg(account.getImg());
		accountDto.setDescrizioneProfilo(account.getDescrizioneProfilo());
		accountDto.setUsername(account.getUsername());
		accountDto.setPrenotazioni(account.getPrenotazioni());
		accountDto.setRuoli(account.getRuoli());
		return accountDto;
	}

	@GetMapping("/api/account")
	@SneakyThrows
	public ResponseEntity<List<AccountDTO>> getAllAccount() {
		log.info("Otteniamo tutti gli utenti");
		List<Account> accounts = service.getAllAccount();
		if (accounts.isEmpty()) {
			String errMsg = String.format("Non e' stato trovato alcun utente");
			log.warning(errMsg);
			throw new NotFoundException(errMsg);
		}
		List<AccountDTO> listDto = new ArrayList<AccountDTO>();
		for (Account account : accounts) {
			AccountDTO accountDto = new AccountDTO();
			accountDto.setDataIscrizione(account.getDataIscrizione());
			accountDto.setDataNascita(account.getDataNascita());
			accountDto.setEmail(account.getEmail());
			accountDto.setImg(account.getImg());
			accountDto.setId(account.getId());
			accountDto.setDescrizioneProfilo(account.getDescrizioneProfilo());
			accountDto.setPass(account.getPass());
			accountDto.setUsername(account.getUsername());
			accountDto.setPrenotazioni(account.getPrenotazioni());
			accountDto.setRuoli(account.getRuoli());
			listDto.add(accountDto);
		}
		return new ResponseEntity<List<AccountDTO>>(listDto, HttpStatus.OK);
	}

	@GetMapping("/api/account/{id}")
	public AccountDTO getById(@PathVariable Integer id) {
		Account account = service.getAccountById(id);
		if (account == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		}
		AccountDTO accountDto = new AccountDTO();
		accountDto.setId(account.getId());
		accountDto.setDataIscrizione(account.getDataIscrizione());
		accountDto.setDataNascita(account.getDataNascita());
		accountDto.setEmail(account.getEmail());
		accountDto.setImg(account.getImg());
		accountDto.setDescrizioneProfilo(account.getDescrizioneProfilo());
		accountDto.setPass(account.getPass());
		accountDto.setUsername(account.getUsername());
		accountDto.setPrenotazioni(account.getPrenotazioni());
//		accountDto.setRuoli(account.getRuoli());
		return accountDto;
	}

//	@PostMapping("/admin/api/account/save") 
//	public AccountDTO save(@RequestBody Account account) {
//		System.err.println(account);
//		service.addAccount(account);
//		AccountDTO accountDto = new AccountDTO();
//		accountDto.setDataIscrizione(account.getDataIscrizione());
//		accountDto.setDataNascita(account.getDataNascita());
//		accountDto.setEmail(account.getEmail());
//		accountDto.setImg(account.getImg());
//		accountDto.setPass(account.getPass());
//		accountDto.setUsername(account.getUsername());
//		accountDto.setRuoli(account.getRuoli());
//		return accountDto;
//	}

	@PutMapping("/user/api/account/update/descrizione/{id}")
	public UpdateDescrProfiloDTO updateDescrizione(@PathVariable Integer id, @RequestBody UpdateDescrProfiloDTO descr) {
		Account acc = service.getAccountById(id);
		acc.setDescrizioneProfilo(descr.getDescrizioneProfilo());
		service.updateAccount(id, acc);

		return descr;
	}

	@PutMapping("/user/api/account/update/username/{id}")
	public UpdateUsernameDTO updateUsername(@PathVariable Integer id, @RequestBody UpdateUsernameDTO username) {
		Account acc = service.getAccountById(id);
		acc.setUsername(username.getUsername());
		service.updateAccount(id, acc);
		return username;
	}

	@PutMapping("/user/api/account/update/immagine/{id}")
	public UpdateImgProfiloDTO updateImg(@PathVariable Integer id, @RequestBody UpdateImgProfiloDTO immagine) {
		System.err.println(immagine.getImmagine());
		Account acc = service.getAccountById(id);
		acc.setImg(immagine.getImmagine());
		service.updateAccount(id, acc);
		return immagine;
	}
	
	@PutMapping("/user/api/account/update/usernamedescr/{id}")
	public AccountUsernameDescrDTO updateUsernameDescr(@PathVariable Integer id, @RequestBody AccountUsernameDescrDTO usernameDescr) {
		Account acc = service.getAccountById(id);
		if(acc != null) {
			acc.setUsername(usernameDescr.getUsername());
			acc.setDescrizioneProfilo(usernameDescr.getDescrizione());
			service.updateAccount(id, acc);
			return usernameDescr;
		}
		return null;
	}

	@DeleteMapping("/admin/api/account/delete/{id}")
	public Account delete(@PathVariable Integer id) {
		Account account = service.getAccountById(id);
		if (account == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		} else {
			service.deleteAccountById(id);
			return account;
		}

	}
}
