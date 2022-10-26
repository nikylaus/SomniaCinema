package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Proiezione;

@Repository
public interface ProiezioneRepository extends CrudRepository<Proiezione, Integer>{

}
