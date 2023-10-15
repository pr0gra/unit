package ru.unit.service.utils.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.unit.service.crud.repository.services.PersonService;
import ru.unit.service.dto.peopleDTO.PersonDTO;
import ru.unit.service.dto.peopleDTO.PersonDTOForRegistration;
import ru.unit.service.dto.peopleDTO.PersonDTOForSearch;
import ru.unit.service.dto.peopleDTO.PersonDTOForUpdateLoginAndPassword;
import ru.unit.service.models.Email;
import ru.unit.service.models.Person;
import ru.unit.service.models.Project;
import ru.unit.service.models.RoleInUNIT;
import ru.unit.service.securiry.PersonDetails;

@Component
public class PersonConverter {
 	
	private final ModelMapper modelMapper;
	private final ProjectConverter projectConverter;
	private final PersonService personService;
	
	@Autowired
	public PersonConverter(ModelMapper modelMapper, ProjectConverter projectConverter,
			PersonService personService){
		this.modelMapper = modelMapper;
		this.projectConverter = projectConverter;
		this.personService = personService;
	}
	
	public Person convertToPersonFromPersonDTO(PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);	
		person.setRoleInUNIT(new RoleInUNIT(personDTO.getRole()));
		return person;				
	}
	
	public Person convertToPersonFromPersonDTOForRegistration(PersonDTOForRegistration personDTOForRegistration) {
		return modelMapper.map(personDTOForRegistration, Person.class);
	}
	
	public PersonDTOForSearch convertToPersonDTOForSearch(Person person) {
		PersonDTOForSearch personDTOForSearch = modelMapper.map(person, PersonDTOForSearch.class);
		return personDTOForSearch;	
	}
	
	public PersonDTO convertToPersonDTO(Person person, List<Project> projects,
			PersonDetails personDetails) {
		PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
		personDTO.setProjects(projectConverter.convertToListOfProjectsDTOForPerson(projects));
		personDTO.setRole(person.getRoleInUNIT() != null ? 
				(person.getRoleInUNIT().getName()) : (""));
		personDTO.setIsPersonalPage(personService.isPersonalPage(person.getId(), personDetails));
		return personDTO;
	}
	
	public List<PersonDTOForSearch> convertToListOfPeopleDTOForSearch(List<Person> people) {
		List<PersonDTOForSearch> peopleDTOForSearch = new ArrayList<>();
		for(Person person:
			people) {
			peopleDTOForSearch.add(convertToPersonDTOForSearch(person));
		}
		return peopleDTOForSearch;	
	}
	
	public Email convrtToEmailFromPersonDTO(PersonDTOForUpdateLoginAndPassword personDTOForUpdateLoginAndPassword) {
		Email email = new Email();
		email.setEmailAddress(personDTOForUpdateLoginAndPassword.getEmail());
		email.setMessage(personDTOForUpdateLoginAndPassword.getEnteredPassword());
		return email;
	}

}
