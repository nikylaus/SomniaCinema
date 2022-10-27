package it.somnia.service;

import java.util.Optional;

import it.somnia.model.Ruolo;

public interface IRuoloService {
	public Iterable<Ruolo> getAllRuoli();
	public Ruolo getRuoloById(Integer id);
	public Ruolo addRuolo(Ruolo ruolo);
	public Ruolo updateRuolo(Integer id, Ruolo ruolo);
	public Ruolo deleteRuoloById(Integer id);
	public Optional<Ruolo> findRuoloByName(String ruolo);
}
