package ru.unit.service.utils.exceptions.emailException;

public class EmailNotFound extends EmailRuntimeException{

	public EmailNotFound() {
		super("Email not found");
	}

}
