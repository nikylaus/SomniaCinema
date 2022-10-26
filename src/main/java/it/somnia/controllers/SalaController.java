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

import it.somnia.model.Sala;
import it.somnia.service.SalaService;


@CrossOrigin
@RestController
public class SalaController {

	@Autowired
	private SalaService service;

	@GetMapping("/api/sala")
	public Iterable<Sala> getAllSala() {
		return service.getAllSale();
	}

	@GetMapping("/api/sala/{id}")
	public Sala getById(@PathVariable Integer id) {
		Sala sala = service.getSalaById(id);
		if (sala == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala non trovata");
		}
		return sala;
	}

	@PostMapping("/admin/api/sala/save") 
	public Sala save(@RequestBody Sala sala) {
		System.err.println(sala);
		service.addSala(sala);
		return sala;
	}

	@PutMapping("/admin/api/sala/update/{id}")
	public Sala update(@PathVariable Integer id, @RequestBody Sala sala) {
		Sala sal = service.updateSala(id, sala);
		if (sal == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala non trovata");
		}
		return sal;
	}

	@DeleteMapping("/admin/api/sala/delete/{id}")
	public Sala delete(@PathVariable Integer id) {
		Sala sala = service.getSalaById(id);
		if (sala == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala non trovata");
		} else {
			service.deleteSalaById(id);
			return sala;
		}

	}
}
