package it.somnia.dto;

import java.util.HashSet;
import java.util.Set;

import it.somnia.model.Prenotazione;
import it.somnia.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostoDTO {
	private Integer id;
	private Integer numeroPosto;

	private Sala sala;

	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

}
