package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Sala;
import it.somnia.repository.SalaRepository;

@Service
public class SalaService implements ISalaService {

	@Autowired
	private SalaRepository repository;

	@Override
	public Iterable<Sala> getAllSale() {
		return repository.findAll();
	}

	@Override
	public Sala getSalaById(Integer id) {
		Optional<Sala> salaOpt = repository.findById(id);
		if (salaOpt.isEmpty() == false) {
			return salaOpt.get();
		}
		return null;
	}

	@Override
	public Sala addSala(Sala sala) {
		return repository.save(sala);
	}

	@Override
	public Sala updateSala(Integer id, Sala sala) {
		Optional<Sala> salaOpt = repository.findById(id);
		if (salaOpt.isEmpty() == false) {
			salaOpt.get().setPosti(sala.getPosti());
			salaOpt.get().setProiezioni(sala.getProiezioni());
			repository.save(salaOpt.get());
			return salaOpt.get();
		}
		return null;
	}

	@Override
	public Sala deleteSalaById(Integer id) {
		Optional<Sala> salaOpt = repository.findById(id);
		if (salaOpt.isEmpty() == false) {
			repository.deleteById(id);
			return salaOpt.get();
		}
		return null;
	}

}
