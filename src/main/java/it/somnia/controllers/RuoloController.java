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

import it.somnia.model.Ruolo;
import it.somnia.service.RuoloService;


@CrossOrigin
@RestController
public class RuoloController {

	@Autowired
	private RuoloService service;

	@GetMapping("/api/ruolo")
	public Iterable<Ruolo> getAllRuoli() {
		return service.getAllRuoli();
	}

	@GetMapping("/api/ruolo/{id}")
	public Ruolo getById(@PathVariable Integer id) {
		Ruolo ruolo = service.getRuoloById(id);
		if (ruolo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		}
		return ruolo;
	}

	@PostMapping("/admin/api/ruolo/save") 
	public Ruolo save(@RequestBody Ruolo ruolo) {
		System.err.println(ruolo);
		service.addRuolo(ruolo);
		return ruolo;
	}

	@PutMapping("/admin/api/ruolo/update/{id}")
	public Ruolo update(@PathVariable Integer id, @RequestBody Ruolo ruolo) {
		Ruolo ruo = service.updateRuolo(id, ruolo);
		if (ruo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		}
		return ruo;
	}

	@DeleteMapping("/admin/api/ruolo/delete/{id}")
	public Ruolo delete(@PathVariable Integer id) {
		Ruolo ruolo = service.getRuoloById(id);
		if (ruolo == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ruolo non trovato");
		} else {
			service.deleteRuoloById(id);
			return ruolo;
		}

	}
}

