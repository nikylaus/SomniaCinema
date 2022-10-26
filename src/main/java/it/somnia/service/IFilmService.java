package it.somnia.service;

import it.somnia.model.Film;

public interface IFilmService {
	public Iterable<Film> getAllFilm();
	public Film getFilmById(Integer id);
	public Film addFilm(Film film);
	public Film updateFilm(Integer id, Film film);
	public Film deleteFilmById(Integer id);
}
