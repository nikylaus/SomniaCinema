package it.somnia.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 111160366641107323L;
	private String message = "Un utente con questa email è già presente";
	
	public UserAlreadyExistsException() {
	}

	public UserAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}