package it.somnia.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import it.somnia.model.Prenotazione;
import it.somnia.model.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountInfoDTO {
	
	private Integer id;
	private String username;
	private String email;
	private String img;
	private String descrizioneProfilo;
	private Date dataIscrizione;
	private Date dataNascita;
	
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

	private Set<Ruolo> ruoli = new HashSet<Ruolo>();

}
