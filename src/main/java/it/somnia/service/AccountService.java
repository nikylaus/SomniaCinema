package it.somnia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Account;
import it.somnia.repository.AccountRepository;

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

}
