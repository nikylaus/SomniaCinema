package it.somnia.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProiezioneDTO {
	
	private Integer id;
	private Time oraInizio;
	private Date data;
	private double prezzo;
//	private Sala salaProiezione;
//	private Film film;

}
