package it.somnia.model;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "account")
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7682160851797764594L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String pass;
	private String img;
	
	@Column(name = "descrizione_profilo", length= 1000)
	private String descrizioneProfilo;
	@Column(name = "data_iscrizione")
	private Date dataIscrizione;
	
	@Column(name = "data_nascita")
	private Date dataNascita;
	
	@OneToMany(mappedBy = "accountPrenotazione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference /* consente di vedere l'account insieme alle prenotazioni */
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
	

	@ManyToMany(fetch = FetchType.LAZY,  
			cascade = CascadeType.MERGE) 
	@JoinTable(name = "ruoli_account",
	joinColumns = {  
			@JoinColumn(name = "id_account",   
					referencedColumnName = "id") 
	},  
	inverseJoinColumns = {  
			@JoinColumn(name = "id_ruolo",   
					referencedColumnName = "id") 
	})
	@JsonBackReference
	//@JsonManagedReference /* consente di vedere l'account insieme ai ruoli */
	private Set<Ruolo> ruoli = new HashSet<Ruolo>();
	
	

	public Account() {
	}


	public Account(String username, String email, String pass, String img, String descrizioneProfilo,
			Date dataIscrizione, Date dataNascita, Set<Prenotazione> prenotazioni, Set<Ruolo> ruoli) {
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.img = img;
		this.descrizioneProfilo = descrizioneProfilo;
		this.dataIscrizione = dataIscrizione;
		this.dataNascita = dataNascita;
		this.prenotazioni = prenotazioni;
		this.ruoli = ruoli;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getDescrizioneProfilo() {
		return descrizioneProfilo;
	}



	public void setDescrizioneProfilo(String descrizioneProfilo) {
		this.descrizioneProfilo = descrizioneProfilo;
	}



	public Date getDataIscrizione() {
		return dataIscrizione;
	}



	public void setDataIscrizione(Date dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}



	public Date getDataNascita() {
		return dataNascita;
	}



	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}



	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}



	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}



	public Set<Ruolo> getRuoli() {
		return ruoli;
	}



	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", email=" + email + ", pass=" + pass + ", img=" + img
				+ ", descrizioneProfilo=" + descrizioneProfilo + ", dataIscrizione=" + dataIscrizione + ", dataNascita="
				+ dataNascita + ", prenotazioni=" + prenotazioni + ", ruoli=" + ruoli + "]";
	}

	public void addRuolo(Ruolo ruolo){
		this.ruoli.add(ruolo);
	}

	
	
}
