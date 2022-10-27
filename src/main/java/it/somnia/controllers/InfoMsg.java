package it.somnia.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@CrossOrigin
@AllArgsConstructor
@Getter
@Setter
public class InfoMsg 
{
	public LocalDate data;
	
	public String message;
}
