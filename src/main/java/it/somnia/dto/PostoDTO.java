package it.somnia.dto;

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
