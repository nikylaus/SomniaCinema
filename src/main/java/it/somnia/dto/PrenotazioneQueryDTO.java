package it.somnia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneQueryDTO {

	private Integer idAccount;
	private Integer idProiezione;
	private Integer idPosto;

}
