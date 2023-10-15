package ru.unit.service.utils.exceptions.authorizationException;

public class AuthorizationException {
	
	private String message;
	private long timeException;
	
	public AuthorizationException(String message) {
		this.message = message;
		this.timeException = System.currentTimeMillis();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeException() {
		return timeException;
	}

	public void setTimeException(long timeException) {
		this.timeException = timeException;
	}
	
}
