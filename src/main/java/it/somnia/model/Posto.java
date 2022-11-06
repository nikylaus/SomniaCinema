package it.somnia.model;

import java.io.Serializable;
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
@Table(name = "posti")
public class Posto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5456983518972846495L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_posto")
	private Integer numeroPosto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sala")
	@JsonBackReference
	private Sala sala;

	@OneToMany(mappedBy = "posto",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	//@JsonBackReference
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

	public Posto() {
	}

	public Posto(Integer id, Integer numeroPosto, Sala sala, Set<Prenotazione> prenotazioni) {
		this.id = id;
		this.numeroPosto = numeroPosto;
		this.sala = sala;
		this.prenotazioni = prenotazioni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPosto() {
		return numeroPosto;
	}

	public void setNumeroPosto(Integer numeroPosto) {
		this.numeroPosto = numeroPosto;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Posto [id=" + id + ", numeroPosto=" + numeroPosto + ", condizione=" + ", sala=" + sala
				+ ", prenotazioni=" + prenotazioni + "]";
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		prenotazioni.add(prenotazione);
	}

}
