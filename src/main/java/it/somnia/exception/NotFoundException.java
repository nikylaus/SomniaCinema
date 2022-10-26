package it.somnia.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException  extends Exception {
	
	private static final long serialVersionUID = -8729169303699924451L;
	private String message;
	
	public NotFoundException() {
		
	}
	
	public NotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
