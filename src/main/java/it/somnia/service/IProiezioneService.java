package it.somnia.service;

import it.somnia.model.Proiezione;

public interface IProiezioneService {
	public Iterable<Proiezione> getAllProiezioni();
	public Proiezione getProiezioneById(Integer id);
	public Proiezione addProiezione(Proiezione proiezione);
	public Proiezione updateProiezione(Integer id, Proiezione proiezione);
	public Proiezione deleteProiezioneById(Integer id);
}
