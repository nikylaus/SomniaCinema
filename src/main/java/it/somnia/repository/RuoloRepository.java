package it.somnia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Ruolo;

@Repository
public interface RuoloRepository extends CrudRepository<Ruolo, Integer> {

	Optional<Ruolo> findByNome(String ruolo);
}
