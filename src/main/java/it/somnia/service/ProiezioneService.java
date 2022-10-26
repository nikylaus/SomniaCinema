package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.model.Proiezione;
import it.somnia.repository.ProiezioneRepository;

@Service
public class ProiezioneService implements IProiezioneService {

	@Autowired 
	private ProiezioneRepository repository;
	
	@Override
	public Iterable<Proiezione> getAllProiezioni() {
		return repository.findAll();
	}

	@Override
	public Proiezione getProiezioneById(Integer id) {
		Optional<Proiezione> proiezioneOpt = repository.findById(id);
		if (proiezioneOpt.isEmpty() == false) {
			return proiezioneOpt.get();
		}
		return null;
	}

	@Override
	public Proiezione addProiezione(Proiezione proiezione) {
		return repository.save(proiezione);
	}

	@Override
	public Proiezione updateProiezione(Integer id, Proiezione proiezione) {
		Optional<Proiezione> proiezioneOpt = repository.findById(id);
		if (proiezioneOpt.isEmpty() == false) {
			proiezioneOpt.get().setData(proiezione.getData());
			proiezioneOpt.get().setOraInizio(proiezione.getOraInizio());
			proiezioneOpt.get().setSalaProiezione(proiezione.getSalaProiezione());
			repository.save(proiezioneOpt.get());
			return proiezioneOpt.get();
		}
		return null;
	}

	@Override
	public Proiezione deleteProiezioneById(Integer id) {
		Optional<Proiezione> proiezioneOpt = repository.findById(id);
		if (proiezioneOpt.isEmpty() == false) {
			repository.deleteById(id);
			return proiezioneOpt.get();
		}
		return null;
	}

}
