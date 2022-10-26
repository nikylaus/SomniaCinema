package it.somnia.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import it.somnia.model.Posto;
import it.somnia.model.Proiezione;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaDTO {
	private Integer id;
	private Integer capienzaMassima;
	
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JsonManagedReference /* permette di vedere i posti di ogni sala */
	@JsonIgnore
	private Set<Posto> posti = new HashSet<Posto>();
	
	@OneToMany(mappedBy = "salaProiezione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference /* permette di vedere le sale insieme alle proiezioni */
	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();
}
