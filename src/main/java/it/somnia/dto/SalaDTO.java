package it.somnia.dto;

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
	
//	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	//@JsonManagedReference /* permette di vedere i posti di ogni sala */
//	@JsonIgnore
//	private Set<Posto> posti = new HashSet<Posto>();
//	
//	@OneToMany(mappedBy = "salaProiezione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference /* permette di vedere le sale insieme alle proiezioni */
//	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();
}
