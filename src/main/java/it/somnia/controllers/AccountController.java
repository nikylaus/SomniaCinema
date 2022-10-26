package it.somnia.controllers;

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
import it.somnia.model.Account;
import it.somnia.service.AccountService;


@CrossOrigin
@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@GetMapping("/api/account")
	public ResponseEntity<List<AccountDTO>>  getAllAccount() {
		List<Account> accounts = service.getAllAccount();
		///
		return null;
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
