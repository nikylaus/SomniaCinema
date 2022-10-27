package it.somnia.dto;

import java.util.HashSet;
import java.util.Set;

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
	
	private Set<Posto> posti = new HashSet<Posto>();

	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();
}
