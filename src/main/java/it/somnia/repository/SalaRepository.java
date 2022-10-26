package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Sala;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Integer>{

}
