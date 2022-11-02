package it.somnia.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "ruolo")
public class Ruolo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1976474545841056565L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nome", unique = true, nullable = false)
	private String nome;
	//@JsonBackReference /* visualizza solo i ruoli */
	@ManyToMany(mappedBy = "ruoli")
	@JsonManagedReference
	private Set<Account> account = new HashSet<Account>();

	public Ruolo() {
	}

	public Ruolo(String nome, Set<Account> account) {
		this.nome = nome;
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", nome=" + nome + ", account=" + account + "]";
	}

	public void addAccount(Account account) {
		this.account.add(account);
		}
}
