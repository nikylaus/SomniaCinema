package it.somnia.service;

import java.util.List;
import java.util.Optional;

import it.somnia.model.Account;

public interface IAccountService {
	public List<Account> getAllAccount();

	public Account getAccountById(Integer id);

	public Account addAccount(Account account);

	public Account updateAccount(Integer id, Account account);

	public Account deleteAccountById(Integer id);

	public Account saveAccount(Account account);

	public Optional<Account> getAccountByEmail(String email);
	public Optional<Account> getAccountByUsername(String username);

	public Account updateDescrizione(Integer id, String descrizione);

	public Account updateUsername(Integer id, String username);

	public Account updateImg(Integer id, String img);
}
