package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Posto;
import it.somnia.repository.PostoRepository;

@Service
public class PostoService implements IPostoService {

	@Autowired
	private PostoRepository repository;

	@Override
	public Iterable<Posto> getAllPosti() {
		return repository.findAll();
	}

	@Override
	public Posto getPostoById(Integer id) {
		Optional<Posto> postoOpt = repository.findById(id);
		if (postoOpt.isEmpty() == false) {
			return postoOpt.get();
		}
		return null;
	}

	@Override
	public Posto addPosto(Posto posto) {
		return repository.save(posto);
	}

	@Override
	public Posto updatePosto(Integer id, Posto posto) {
		Optional<Posto> postoOpt = repository.findById(id);
		if (postoOpt.isEmpty() == false) {
			postoOpt.get().setNumeroPosto(posto.getNumeroPosto());
			repository.save(postoOpt.get());
			return postoOpt.get();
		}
		return null;
	}

	@Override
	public Posto deletePostoById(Integer id) {
		Optional<Posto> postoOpt = repository.findById(id);
		if (postoOpt.isEmpty() == false) {
			repository.deleteById(id);
			return postoOpt.get();
		}
		return null;
	}

}
