package it.somnia.dto;


import java.util.HashSet;
import java.util.Set;

import it.somnia.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RuoloDTO {
	
	private Integer id;
	private String nome;
	private Set<Account> account = new HashSet<Account>();

}
