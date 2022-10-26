package it.somnia.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
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
	private Date dataIscrizione;
	private Date dataNascita;

}
