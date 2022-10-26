package it.somnia.service;

import it.somnia.model.Account;

public interface IAccountService {
	public Iterable<Account> getAllAccount();
	public Account getAccountById(Integer id);
	public Account addAccount(Account account);
	public Account updateAccount(Integer id, Account account);
	public Account deleteAccountById(Integer id);
}
