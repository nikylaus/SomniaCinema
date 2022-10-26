package it.somnia.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "prenotazioni")
/*@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,   
	    property="id"   
	)*/
public class Prenotazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7455143327143772673L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Integer valuazione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_account")
	@JsonBackReference
	private Account accountPrenotazione; /* modificato */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proiezione")
	@JsonBackReference
	private Proiezione proiezione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_posto")
	@JsonBackReference
	private Posto posto;

	public Prenotazione() {
	}

	public Prenotazione(Integer id, Date data, Integer valuazione, Account account, Proiezione proiezione,
			Posto posto) {
		this.id = id;
		this.data = data;
		this.valuazione = valuazione; 
		this.accountPrenotazione = account;
		this.proiezione = proiezione;
		this.posto = posto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getValuazione() {
		return valuazione;
	}

	public void setValuazione(Integer valuazione) {
		this.valuazione = valuazione;
	}

	public Account getAccountPrenotazione() {
		return accountPrenotazione;
	}

	public void setAccountPrenotazione(Account account) {
		this.accountPrenotazione = account;
	}

	public Proiezione getProiezione() {
		return proiezione;
	}

	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", data=" + data + ", valuazione=" + valuazione + ", account=" + accountPrenotazione
				+ ", proiezione=" + proiezione + ", posto=" + posto + "]";
	}
	
	
}
