package it.somnia.service;

import it.somnia.model.Prenotazione;

public interface IPrenotazioneService {
	public Iterable<Prenotazione> getAllPrenotazioni();
	public Prenotazione getPrenotazioneById(Integer id);
	public Prenotazione addPrenotazione(Prenotazione prenotazione);
	public Prenotazione updatePrenotazione(Integer id, Prenotazione prenotazione);
	public Prenotazione deletePrenotazioneById(Integer id);
}

