package it.somnia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.somnia.dto.ValutazioneDTO;
import it.somnia.model.Prenotazione;
import it.somnia.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService implements IPrenotazioneService {

	@Autowired
	private PrenotazioneRepository repository;

	@Override
	public Iterable<Prenotazione> getAllPrenotazioni() {
		return repository.findAll();
	}

	@Override
	public Prenotazione getPrenotazioneById(Integer id) {
		Optional<Prenotazione> prenotazioneOpt = repository.findById(id);
		if (prenotazioneOpt.isEmpty() == false) {
			return prenotazioneOpt.get();
		}
		return null;
	}

	@Override
	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		return repository.save(prenotazione);
	}

	@Override
	public Prenotazione updatePrenotazione(Integer id, ValutazioneDTO valutazione) {
		Optional<Prenotazione> prenotazioneOpt = repository.findById(id);
		if (prenotazioneOpt.isEmpty() == false) {
			prenotazioneOpt.get().setValutazione(valutazione.getValutazione());
			repository.save(prenotazioneOpt.get());
			return prenotazioneOpt.get();
		}
		return null;
	}
	
	

	@Override
	public Prenotazione deletePrenotazioneById(Integer id) {
		Optional<Prenotazione> prenotazioneOpt = repository.findById(id);
		if (prenotazioneOpt.isEmpty() == false) {
			repository.deleteById(id);
			return prenotazioneOpt.get();
		}
		return null;
	}

}
