package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Film;
import it.somnia.repository.FilmRepository;

@Service
public class FilmService implements IFilmService {

	@Autowired
	private FilmRepository repository;

	@Override
	public Iterable<Film> getAllFilm() {
		return repository.findAll();
	}

	@Override
	public Film getFilmById(Integer id) {
		Optional<Film> filmOpt = repository.findById(id);
		if (filmOpt.isEmpty() == false) {
			return filmOpt.get();
		}
		return null;
	}

	@Override
	public Film addFilm(Film film) {
		return repository.save(film);
	}

	@Override
	public Film updateFilm(Integer id, Film film) {
		Optional<Film> filmOpt = repository.findById(id);
		if (filmOpt.isEmpty() == false) {
			filmOpt.get().setNome(film.getNome());
			filmOpt.get().setDurata(film.getDurata());
			filmOpt.get().setAnno(film.getAnno());
			filmOpt.get().setImg(film.getImg());
			filmOpt.get().setRegia(film.getRegia());
			filmOpt.get().setRegia(film.getRegia());
			filmOpt.get().setGenere(film.getGenere());
			filmOpt.get().setEtaMinima(film.getEtaMinima());
			filmOpt.get().setCondizione(film.getCondizione());
			filmOpt.get().setDescrizione(film.getDescrizione());
			filmOpt.get().setImgBannerUno(film.getImgBannerUno());
			filmOpt.get().setImgBannerDue(film.getImgBannerDue());
			filmOpt.get().setImgBannerTre(film.getImgBannerTre());
			filmOpt.get().setUrlTrailer(film.getUrlTrailer());
			filmOpt.get().setCast(film.getCast());
			repository.save(filmOpt.get());
			return filmOpt.get();

		}
		return null;
	}

	@Override
	public Film deleteFilmById(Integer id) {
		Optional<Film> filmOpt = repository.findById(id);
		if (filmOpt.isEmpty() == false) {
			repository.deleteById(id);
			return filmOpt.get();
		}
		return null;
	}

}
