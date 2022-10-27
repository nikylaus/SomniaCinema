package it.somnia.dto;

import java.sql.Date;

import it.somnia.model.Account;
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
public class PrenotazioneDTO {

	private Integer id;
	private Date data;
	private Integer valuazione;
	private Account accountPrenotazione;
	private Proiezione proiezione;
	private Posto posto;

}
