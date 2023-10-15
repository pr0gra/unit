package ru.unit.service.utils.exceptions.peopleExceptions;

public class PersonDoesNotHaveTheRightToChange extends PersonRuntimeException{

	public PersonDoesNotHaveTheRightToChange() {
		super("This person doesn't have the right to change");
	}

}
