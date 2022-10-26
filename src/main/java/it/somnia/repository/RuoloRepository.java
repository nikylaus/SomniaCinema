package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Ruolo;

@Repository
public interface RuoloRepository extends CrudRepository<Ruolo, Integer> {

}
