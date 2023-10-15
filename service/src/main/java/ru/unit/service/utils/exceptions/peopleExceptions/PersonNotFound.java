package ru.unit.service.utils.exceptions.peopleExceptions;

public class PersonNotFound extends PersonRuntimeException{
	public PersonNotFound() {
		super("Person not found");
	}
}
