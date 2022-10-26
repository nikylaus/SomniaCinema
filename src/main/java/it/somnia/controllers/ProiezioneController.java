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

import it.somnia.model.Proiezione;
import it.somnia.service.ProiezioneService;


@CrossOrigin
@RestController
public class ProiezioneController {

	@Autowired
	private ProiezioneService service;

	@GetMapping("/api/proiezioni")
	public Iterable<Proiezione> getAllProiezione() {
		return service.getAllProiezioni();
	}

	@GetMapping("/api/proiezione/{id}")
	public Proiezione getById(@PathVariable Integer id) {
		Proiezione proiezione = service.getProiezioneById(id);
		if (proiezione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proiezione non trovata");
		}
		return proiezione;
	}

	@PostMapping("/admin/api/proiezione/save") 
	public Proiezione save(@RequestBody Proiezione proiezione) {
		System.err.println(proiezione);
		service.addProiezione(proiezione);
		return proiezione;
	}

	@PutMapping("/admin/api/proiezione/update/{id}")
	public Proiezione update(@PathVariable Integer id, @RequestBody Proiezione proiezione) {
		Proiezione proi = service.updateProiezione(id, proiezione);
		if (proi == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proiezione non trovata");
		}
		return proi;
	}

	@DeleteMapping("/admin/api/proiezione/delete/{id}")
	public Proiezione delete(@PathVariable Integer id) {
		Proiezione proiezione = service.getProiezioneById(id);
		if (proiezione == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proiezione non trovata");
		} else {
			service.deleteProiezioneById(id);
			return proiezione;
		}

	}
}

