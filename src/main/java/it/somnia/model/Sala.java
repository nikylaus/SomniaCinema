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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sale")
public class Sala implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7230829624649295153L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "capienza_massima")
	private Integer capienzaMassima;
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference /* permette di vedere i posti di ogni sala */
	@JsonIgnore
	private Set<Posto> posti = new HashSet<Posto>();
	
	@OneToMany(mappedBy = "salaProiezione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference /* permette di vedere le sale insieme alle proiezioni */
	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();

	public Sala() {
	}

	public Sala(Integer id, Integer capienzaMassima, Set<Posto> posti, Set<Proiezione> proiezioni) {
		this.id = id;
		this.capienzaMassima = capienzaMassima;
		this.posti = posti;
		this.proiezioni = proiezioni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapienzaMassima() {
		return capienzaMassima;
	}

	public void setCapienzaMassima(Integer capienzaMassima) {
		this.capienzaMassima = capienzaMassima;
	}

	public Set<Posto> getPosti() {
		return posti;
	}

	public void setPosti(Set<Posto> posti) {
		this.posti = posti;
	}

	public Set<Proiezione> getProiezioni() {
		return proiezioni;
	}

	public void setProiezioni(Set<Proiezione> proiezioni) {
		this.proiezioni = proiezioni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", capienzaMassima=" + capienzaMassima + ", posti=" + posti + ", proiezioni="
				+ proiezioni + "]";
	}

	public void addProiezione(Proiezione proiezione) {
		proiezioni.add(proiezione);
	}
	
	public void addPosto(Posto posto) {
		posti.add(posto);
	}
	
}
 