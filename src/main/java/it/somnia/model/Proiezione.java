package it.somnia.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "proiezioni")
public class Proiezione implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6721267108068255770L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ora_inizio")
	private Time oraInizio;
	
	private Date data;
	private double prezzo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "id_sala")
	@JsonBackReference
	private Sala salaProiezione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_film")
	@JsonBackReference /* consente di vedere il film con tutte le proiezioni */
	private Film film;
	
	@OneToMany(mappedBy = "proiezione", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	@JsonManagedReference
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

	
	public Proiezione() {
	}

	public Proiezione(Time oraInizio, Date data, double prezzo, Sala salaProiezione, Film film,
			Set<Prenotazione> prenotazioni) {
		this.oraInizio = oraInizio;
		this.data = data;
		this.prezzo = prezzo;
		this.salaProiezione = salaProiezione;
		this.film = film;
		this.prenotazioni = prenotazioni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(Time oraInizio) {
		this.oraInizio = oraInizio;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Sala getSalaProiezione() {
		return salaProiezione;
	}

	public void setSalaProiezione(Sala salaProiezione) {
		this.salaProiezione = salaProiezione;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	/** NON SERVE**/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Proiezione [id=" + id + ", oraInizio=" + oraInizio + ", data=" + data + ", prezzo=" + prezzo
				+ ", salaProiezione=" + salaProiezione + ", film=" + film + ", prenotazioni=" + prenotazioni + "]";
	}
	
	public void addPrenotazione(Prenotazione prenotazione ) {
		prenotazioni.add(prenotazione);
	}

	
}
