package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Ruolo;
import it.somnia.repository.RuoloRepository;

@Service
public class RuoloService implements IRuoloService{

	@Autowired
	private RuoloRepository repository;
	
	@Override
	public Iterable<Ruolo> getAllRuoli() {
		return repository.findAll();
	}

	@Override
	public Ruolo getRuoloById(Integer id) {
		Optional<Ruolo> ruoloOpt = repository.findById(id);
		if (ruoloOpt.isEmpty() == false) {
			return ruoloOpt.get();
		}
		return null;
	}

	@Override
	public Ruolo addRuolo(Ruolo ruolo) {
		return repository.save(ruolo);
	}

	@Override
	public Ruolo updateRuolo(Integer id, Ruolo ruolo) {
		Optional<Ruolo> ruoloOpt = repository.findById(id);
		if (ruoloOpt.isEmpty() == false) {
			ruoloOpt.get().setNome(ruolo.getNome());
			repository.save(ruoloOpt.get());
			return ruoloOpt.get();
		}
		return null;
	}

	@Override
	public Ruolo deleteRuoloById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ruolo> findRuoloByName(String ruolo) {
		return repository.findByNome(ruolo);
	}

}
