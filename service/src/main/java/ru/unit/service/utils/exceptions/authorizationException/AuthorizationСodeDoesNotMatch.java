package ru.unit.service.utils.exceptions.authorizationException;

public class AuthorizationСodeDoesNotMatch extends AuthorizationRuntimeException{

	public AuthorizationСodeDoesNotMatch() {
		super("Сode does't match");
	}
	
}
