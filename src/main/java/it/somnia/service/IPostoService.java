package it.somnia.service;

import it.somnia.model.Posto;

public interface IPostoService {
	public Iterable<Posto> getAllPosti();
	public Posto getPostoById(Integer id);
	public Posto addPosto(Posto posto);
	public Posto updatePosto(Integer id, Posto posto);
	public Posto deletePostoById(Integer id);
}
