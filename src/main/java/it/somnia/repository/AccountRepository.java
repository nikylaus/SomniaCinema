package it.somnia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	Optional<Account> getByEmail(String email);
	Optional<Account> getByUsername(String username);
}
