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
public class AccountDTO {
	
	private Integer id;
	private String username;
	private String email;
	private String pass;
	private String img;
	private String descrizioneProfilo;
	private Date dataIscrizione;
	private Date dataNascita;
	
//	@OneToMany(mappedBy = "accountPrenotazione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference /* consente di vedere l'account insieme alle prenotazioni */
	private Set<Prenotazione> prenotazioni = new HashSet<Prenotazione>();
//	
//	@ManyToMany(mappedBy = "account")
//	@JsonManagedReference /* consente di vedere l'account insieme ai ruoli */
	private Set<Ruolo> ruoli = new HashSet<Ruolo>();

}
