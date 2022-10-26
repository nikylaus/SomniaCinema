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

import it.somnia.model.Posto;
import it.somnia.service.PostoService;

@CrossOrigin
@RestController
public class PostoController {

	@Autowired
	private PostoService service;

	@GetMapping("/api/posto")
	public Iterable<Posto> getAllPosto() {
		return service.getAllPosti();
	}

	@GetMapping("/api/posto/{id}")
	public Posto getById(@PathVariable Integer id) {
		Posto posto = service.getPostoById(id);
		if (posto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Posto non trovato");
		}
		return posto;
	}

	@PostMapping("/admin/api/posto/save") 
	public Posto save(@RequestBody Posto posto) {
		System.err.println(posto);
		service.addPosto(posto);
		return posto;
	}

	@PutMapping("/admin/api/posto/update/{id}")
	public Posto update(@PathVariable Integer id, @RequestBody Posto posto) {
		Posto post = service.updatePosto(id, posto);
		if (post == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Posto non trovato");
		}
		return post;
	}

	@DeleteMapping("/admin/api/posto/delete/{id}")
	public Posto delete(@PathVariable Integer id) {
		Posto posto = service.getPostoById(id);
		if (posto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Posto non trovato");
		} else {
			service.deletePostoById(id);
			return posto;
		}

	}
}
