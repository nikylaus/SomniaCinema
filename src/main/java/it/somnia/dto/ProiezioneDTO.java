package it.somnia.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import it.somnia.model.Film;
import it.somnia.model.Prenotazione;
import it.somnia.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProiezioneDTO {
	
	private Integer id;
	private Time oraInizio;
	private Date data;
	private double prezzo;
//	private Sala salaProiezione;
//	private Film film;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn (name = "id_sala")
//	@JsonBackReference
//	private Sala salaProiezione;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_film")
//	@JsonBackReference /* consente di vedere il film con tutte le proiezioni */
//	private Film film;
//	
//	@OneToMany(mappedBy = "proiezione", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
//	@JsonManagedReference
//	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
}
