package ru.unit.service.utils.exceptions.authorizationException;

public class AuthorizationEmailIsNotRight extends AuthorizationRuntimeException{

	public AuthorizationEmailIsNotRight() {
		super("Email isn't right");
	}

}
