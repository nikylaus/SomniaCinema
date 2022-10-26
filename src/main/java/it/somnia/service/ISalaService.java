package it.somnia.service;

import it.somnia.model.Sala;

public interface ISalaService{
	public Iterable<Sala> getAllSale();
	public Sala getSalaById(Integer id);
	public Sala addSala(Sala sala);
	public Sala updateSala(Integer id, Sala sala);
	public Sala deleteSalaById(Integer id);
}
