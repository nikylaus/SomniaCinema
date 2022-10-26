package it.somnia.controllers;

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

import it.somnia.model.Prenotazione;
import it.somnia.service.PrenotazioneService;


@CrossOrigin
@RestController
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService service;

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

	@PostMapping("/admin/api/prenotazione/save") 
	public Prenotazione save(@RequestBody Prenotazione prenotazione) {
		System.err.println(prenotazione);
		service.addPrenotazione(prenotazione); //bisogna a
		return prenotazione;
	}

	@PutMapping("/admin/api/prenotazione/update/{id}")
	public Prenotazione update(@PathVariable Integer id, @RequestBody Prenotazione prenotazione) {
		Prenotazione pren = service.updatePrenotazione(id, prenotazione);
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
}
