package it.somnia.dto;

import java.sql.Date;

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
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_account")
//	@JsonBackReference
//	private Account accountPrenotazione; /* modificato */
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_proiezione")
//	@JsonBackReference
//	private Proiezione proiezione;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_posto")
//	@JsonBackReference
//	private Posto posto;
	

}
