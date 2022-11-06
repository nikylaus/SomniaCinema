package it.somnia.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.somnia.dto.PrenotazioneQueryDTO;
import it.somnia.dto.ValutazioneDTO;
import it.somnia.model.Prenotazione;
import it.somnia.service.AccountService;
import it.somnia.service.PostoService;
import it.somnia.service.PrenotazioneService;
import it.somnia.service.ProiezioneService;

@CrossOrigin
@RestController
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService service;
	
	@Autowired
	private AccountService serviceAccount;
	
	@Autowired
	private PostoService servicePosto;
	
	@Autowired
	private ProiezioneService serviceProiezione;

	@GetMapping("/api/prenotazione")
	public Iterable<Prenotazione> getAllPrenotazione() {
		return service.getAllPrenotazioni();
	}

	@GetMapping("/api/prenotazione/{id}")
	public Prenotazione getById(@PathVariable Integer id) {
		Prenotazione prenotazione = service.getPrenotazioneById(id);
		if (prenotazione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prenotazione non trovata");
		}
		return prenotazione;
	}

	@PostMapping("/user/api/prenotazione/save")
	public Prenotazione save(@RequestBody PrenotazioneQueryDTO prenotazioneDto) {
		//System.err.println(prenotazione);
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setAccountPrenotazione(serviceAccount.getAccountById(prenotazioneDto.getIdAccount()));
		prenotazione.setData(new Date(System.currentTimeMillis()));
		prenotazione.setPosto(servicePosto.getPostoById(prenotazioneDto.getIdPosto()));
		prenotazione.setProiezione(serviceProiezione.getProiezioneById(prenotazioneDto.getIdProiezione()));
		prenotazione.setValutazione(0);
		service.addPrenotazione(prenotazione); // bisogna a
		return prenotazione;
	}

	@PutMapping("/user/api/prenotazione/update/{id}")
	public Prenotazione update(@PathVariable Integer id, @RequestBody ValutazioneDTO valutazione) {
		Prenotazione pren = service.updatePrenotazione(id, valutazione);
		if (pren == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prenotazione non trovata");
		}
		return pren;
	}

	@DeleteMapping("/admin/api/prenotazione/delete/{id}")
	public Prenotazione delete(@PathVariable Integer id) {
		Prenotazione prenotazione = service.getPrenotazioneById(id);
		if (prenotazione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prenotazione non trovata");
		} else {
			service.deletePrenotazioneById(id);
			return prenotazione;
		}

	}
	
//	@PostMapping("/user/api/prenotazione/save")
//	public insertWithQuery(Person person) {
//	    entityManager.createNativeQuery("INSERT INTO person (id, first_name, last_name) VALUES (?,?,?)")
//	      .setParameter(1, person.getId())
//	      .setParameter(2, person.getFirstName())
//	      .setParameter(3, person.getLastName())
//	      .executeUpdate();
//	}
}
