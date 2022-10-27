package it.somnia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.somnia.dto.FilmDTOOutProiezioni;
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
	public ResponseEntity <FilmDTOOutProiezioni> update(@PathVariable Integer id, @RequestBody FilmDTOOutProiezioni film) {
		Film fil = new Film();
		fil.setAnno(film.getAnno());
		fil.setCast(film.getCast());
		fil.setCondizione(film.getCondizione());
		fil.setDescrizione(film.getDescrizione());
		fil.setDurata(film.getDurata());
		fil.setEtaMinima(film.getEtaMinima());
		fil.setGenere(film.getGenere());
		fil.setImg(film.getImg());
		fil.setImgBannerDue(film.getImgBannerDue());
		fil.setImgBannerTre(film.getImgBannerTre());
		fil.setImgBannerUno(film.getImgBannerUno());
		fil.setNome(film.getNome());
		fil.setRegia(film.getRegia());
		fil.setUrlTrailer(film.getUrlTrailer());
		service.updateFilm(id, fil);
		if (fil == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trovato");
		}
		return  new ResponseEntity<FilmDTOOutProiezioni>(film, HttpStatus.OK);
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

