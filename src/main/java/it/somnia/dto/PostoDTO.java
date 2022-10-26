package it.somnia.dto;

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
	private String condizione;
	private Sala sala;

}
