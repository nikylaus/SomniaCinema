package it.somnia.dto;

import java.util.HashSet;
import java.util.Set;

import it.somnia.model.Proiezione;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
	
	private Integer id;
	private String nome;
	private Integer durata;
	private Integer anno;
	private String img;
	private String descrizione;
	private String regia;
	private String cast;
	private String genere;
	private Integer etaMinima;
	private String urlTrailer;
	private String condizione;
	private String imgBannerUno;
	private String imgBannerDue;
	private String imgBannerTre;

	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();
	
	

}
