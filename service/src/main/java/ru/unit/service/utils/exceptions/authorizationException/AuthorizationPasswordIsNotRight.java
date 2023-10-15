package ru.unit.service.utils.exceptions.authorizationException;

public class AuthorizationPasswordIsNotRight extends AuthorizationRuntimeException{

	public AuthorizationPasswordIsNotRight() {
		super("Password isn't right");
	}

}
