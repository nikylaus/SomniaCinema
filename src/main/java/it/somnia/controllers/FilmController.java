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

import it.somnia.model.Film;
import it.somnia.service.FilmService;


@CrossOrigin
@RestController
public class FilmController {

	@Autowired
	private FilmService service;

	@GetMapping("/api/film")
	public Iterable<Film> getAllFilm() {
		return service.getAllFilm();
	}

	@GetMapping("/api/film/{id}")
	public Film getById(@PathVariable Integer id) {
		Film film = service.getFilmById(id);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return film;
	}

	@PostMapping("/admin/api/film/save") 
	public Film save(@RequestBody Film film) {
		System.err.println(film);
		service.addFilm(film);
		return film;
	}

	@PutMapping("/admin/api/film/update/{id}")
	public Film update(@PathVariable Integer id, @RequestBody Film film) {
		Film fil = service.updateFilm(id, film);
		if (fil == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return fil;
	}

	@DeleteMapping("/admin/api/film/delete/{id}")
	public Film delete(@PathVariable Integer id) {
		Film film = service.getFilmById(id);
		if (film == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		} else {
			service.deleteFilmById(id);
			return film;
		}

	}
}

