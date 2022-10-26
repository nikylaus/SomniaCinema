package it.somnia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.somnia.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

}
