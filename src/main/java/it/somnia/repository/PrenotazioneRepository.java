package it.somnia.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.somnia.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Integer> {
	
	@Modifying
    @Query(value = "insert into Prenotazioni (data,valutazione, id_account, id_posto, id_proiezione) VALUES (?,?,?,?,?)", nativeQuery = true)
    @Transactional
    void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);

}
