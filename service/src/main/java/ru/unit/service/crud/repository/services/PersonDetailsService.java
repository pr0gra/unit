package ru.unit.service.crud.repository.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.unit.service.crud.repository.repositories.PersonRepository;
import ru.unit.service.models.Person;
import ru.unit.service.securiry.PersonDetails;

@Service
@Transactional(readOnly = true)
public class PersonDetailsService implements UserDetailsService{
	
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonDetailsService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person getPersonByEmail(String email) {
		return personRepository.findByEmail(email).get();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Person person = getPersonByEmail(email);
		
		if(person == null) {
			throw new UsernameNotFoundException("");
		}
		return new PersonDetails(person);
	}
}
