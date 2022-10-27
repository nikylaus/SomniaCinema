package it.somnia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.exception.NotFoundException;
import it.somnia.model.Account;
import it.somnia.repository.AccountRepository;
import lombok.SneakyThrows;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> getAllAccount() {
		return (List<Account>) repository.findAll();
	}

	@Override
	public Account getAccountById(Integer id) {
		Optional<Account> accountOpt = repository.findById(id);
		if (accountOpt.isEmpty() == false) {
			return accountOpt.get();
		}
		return null;
	}

	@Override
	public Account addAccount(Account account) {
		return repository.save(account);
	}

	@Override
	public Account updateAccount(Integer id, Account account) {
		Optional<Account> accountOpt = repository.findById(id);
		if (accountOpt.isEmpty() == false) {
			accountOpt.get().setUsername(account.getUsername());
			accountOpt.get().setPass(account.getPass());
			accountOpt.get().setImg(account.getImg());
			repository.save(accountOpt.get());
			return accountOpt.get();
		}
		return null;
	}

	@Override
	public Account deleteAccountById(Integer id) {
		Optional<Account> accountOpt = repository.findById(id);
		if (accountOpt.isEmpty() == false) {
			repository.deleteById(id);
			return accountOpt.get();
		}
		return null;
	}

	@Override
	@SneakyThrows
	public Optional<Account> findAccountByEmail(String email) {
		Optional<Account> accOpt = repository.findByEmail(email);
		if (accOpt.isEmpty()) {
			throw new NotFoundException("Utente non trovato");
		}
		return repository.findByEmail(email);
	}

	@Override
	public Account saveAccount(Account account) {
		Optional<Account> accountOpt = findAccountByEmail(account.getEmail());
		if (accountOpt.isEmpty()) {
			repository.save(account);
			return findAccountByEmail(account.getEmail()).get();
		}
		return null;
	}

	@Override
	public Account updateDescrizione(Integer id, String descrizione) {
		Optional<Account> accountOpt = repository.findById(id);
		if (accountOpt.isEmpty() == false) {
			accountOpt.get().setDescrizioneProfilo(descrizione);
			repository.save(accountOpt.get());
			return accountOpt.get();
		}
		return null;
	}

	@Override
	public Account updateUsername(Integer id, String username) {
		Optional<Account> accountOpt = repository.findById(id);
		if (!accountOpt.isEmpty()) {
			accountOpt.get().setUsername(username);
			repository.save(accountOpt.get());
			return accountOpt.get();
		}
		return null;
	}

}
