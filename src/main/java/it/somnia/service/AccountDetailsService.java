package it.somnia.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.somnia.exception.NotFoundException;
import it.somnia.model.Account;
import it.somnia.model.Ruolo;
import it.somnia.repository.AccountRepository;
import lombok.SneakyThrows;

@Service
public class AccountDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepository repository;

	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Account> accountOpt = repository.getByEmail(email);
		if(accountOpt.isEmpty()) {
			throw new NotFoundException("Utente non trovato");
		} else {
			String role = "";
			Set<Ruolo> ruoli = accountOpt.get().getRuoli();
			Iterator<Ruolo> iterator = ruoli.iterator();
			if(iterator.hasNext()) {
				role += iterator.next().getNome();
			}
			return new User(email, accountOpt.get().getPass(), Collections.singletonList(new SimpleGrantedAuthority(role)));
		}
	}
	
	@SneakyThrows
	public Account getAccountById(Integer id) {
		Optional<Account> accountOpt = repository.findById(id);
		if(accountOpt.isEmpty()) {
			throw new NotFoundException("Utente non trovato");
		}
		return accountOpt.get();			
	}

}
