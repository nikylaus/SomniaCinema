package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Integer> {

}
