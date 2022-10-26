package it.somnia.dto;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import it.somnia.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuoloDTO {
	
	private Integer id;
	private String nome;
	
	@ManyToMany(fetch = FetchType.LAZY,  
			cascade = CascadeType.MERGE) 
	@JoinTable(name = "ruoli_account",
	joinColumns = {  
			@JoinColumn(name = "id_ruolo",   
					referencedColumnName = "id") 
	},  
	inverseJoinColumns = {  
			@JoinColumn(name = "id_account",   
					referencedColumnName = "id") 
	}) 
	@JsonBackReference /* visualizza solo i ruoli */
	//@JsonManagedReference
	private Set<Account> account = new HashSet<Account>();

}
