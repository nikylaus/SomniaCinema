package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
