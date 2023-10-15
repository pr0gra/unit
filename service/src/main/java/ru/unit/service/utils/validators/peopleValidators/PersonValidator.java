package ru.unit.service.utils.validators.peopleValidators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ru.unit.service.crud.repository.services.PersonService;
import ru.unit.service.models.Person;

@Component
public class PersonValidator implements Validator{
	
	private final PersonService personService;
	
	@Autowired
	public PersonValidator(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		Optional<Person> optionalPerson = personService.getPersonByEmail(person.getEmail());
		if(optionalPerson.isPresent()) {
			errors.rejectValue("email", "404", "This email is used");
		}
	}

}
