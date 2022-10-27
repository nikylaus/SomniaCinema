package it.somnia.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private String condizione;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="id_sala")
//	@JsonBackReference
//	private Sala sala;
//	
//	@OneToMany(mappedBy = "posto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();

}
