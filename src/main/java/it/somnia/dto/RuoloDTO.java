package it.somnia.dto;


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
	
//	@ManyToMany(fetch = FetchType.LAZY,  
//			cascade = CascadeType.MERGE) 
//	@JoinTable(name = "ruoli_account",
//	joinColumns = {  
//			@JoinColumn(name = "id_ruolo",   
//					referencedColumnName = "id") 
//	},  
//	inverseJoinColumns = {  
//			@JoinColumn(name = "id_account",   
//					referencedColumnName = "id") 
//	}) 
//	@JsonBackReference /* visualizza solo i ruoli */
//	//@JsonManagedReference
//	private Set<Account> account = new HashSet<Account>();

}
