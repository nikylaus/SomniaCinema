package it.somnia.dto;

import java.sql.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
//	private Account accountPrenotazione;
//	private Proiezione proiezione;
//	private Posto posto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_account")
	@JsonBackReference
	private Account accountPrenotazione; /* modificato */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proiezione")
	@JsonBackReference
	private Proiezione proiezione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_posto")
	@JsonBackReference
	private Posto posto;
	

}
