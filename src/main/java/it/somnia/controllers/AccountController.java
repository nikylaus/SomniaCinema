package it.somnia.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.somnia.dto.AccountDTO;
import it.somnia.exception.NotFoundException;
import it.somnia.model.Account;
import it.somnia.service.AccountService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;


@CrossOrigin
@RestController
@Log
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping("/api/account")
	@SneakyThrows
	public ResponseEntity<List<AccountDTO>>  getAllAccount() {
		log.info("Otteniamo tutti gli utenti");
		List<Account> accounts = service.getAllAccount();
		if(accounts.isEmpty()) {
			String errMsg = String.format("Non e' stato trovato alcun utente");
			log.warning(errMsg);
			throw new NotFoundException(errMsg);
		}
		List<AccountDTO> listDto = new ArrayList<AccountDTO>();
		for(Account account : accounts) {
			AccountDTO accountDto = new AccountDTO();
			accountDto.setDataIscrizione(account.getDataIscrizione());
			accountDto.setDataNascita(account.getDataNascita());
			accountDto.setEmail(account.getEmail());
			accountDto.setImg(account.getImg());
			accountDto.setPass(account.getPass());
			accountDto.setUsername(account.getUsername());
			listDto.add(accountDto);
		}
		return new ResponseEntity <List<AccountDTO>>(listDto, HttpStatus.OK);
	}

	@GetMapping("/api/account/{id}")
	public Account getById(@PathVariable Integer id) {
		Account account = service.getAccountById(id);
		if (account == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		}
		return account;
	}

	@PostMapping("/admin/api/account/save") 
	public Account save(@RequestBody Account account) {
		System.err.println(account);
		service.addAccount(account);
		return account;
	}

	@PutMapping("/admin/api/account/update/{id}")
	public Account update(@PathVariable Integer id, @RequestBody Account account) {
		Account acc = service.updateAccount(id, account);
		if (acc == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account non trovato");
		}
		return acc;
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
