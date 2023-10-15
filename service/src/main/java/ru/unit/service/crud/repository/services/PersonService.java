package ru.unit.service.crud.repository.services;

import java.util.Collections;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSendException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import ru.unit.service.crud.repository.repositories.EmailRepository;
import ru.unit.service.crud.repository.repositories.PersonRepository;
import ru.unit.service.crud.repository.repositories.ProjectRepository;
import ru.unit.service.crud.repository.repositories.RoleInUNITRepository;
import ru.unit.service.models.Email;
import ru.unit.service.models.Person;
import ru.unit.service.models.Project;
import ru.unit.service.models.RoleInUNIT;
import ru.unit.service.models.Task;
import ru.unit.service.securiry.PersonDetails;
import ru.unit.service.utils.exceptions.authorizationException.AuthorizationPasswordIsNotRight;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonDoesNotHaveTheRightToChange;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonNotFound;

@Service
@Transactional(readOnly = true)
@PropertySource("classpath:application.properties")
public class PersonService {

	private final PersonRepository personRepository;
	private final EntityManager entityManager;
	private final PasswordEncoder passwordEncoder;
	private final RoleInUNITRepository roleInUNITRepository;
	private final EmailService emailService;
	private final EmailRepository emailRepository;
	private final ProjectRepository projectRepository;
	private final Environment environment;
	
	@Autowired
	public PersonService(PersonRepository personRepository,
			EntityManager entityManager, PasswordEncoder passwordEncoder,
			RoleInUNITRepository roleInUNITRepository, EmailService emailService,
			EmailRepository emailRepository, ProjectRepository projectRepository,
			Environment environment) {
		this.personRepository = personRepository;
		this.entityManager = entityManager;
		this.passwordEncoder = passwordEncoder;
		this.roleInUNITRepository = roleInUNITRepository;
		this.emailService = emailService;
		this.emailRepository = emailRepository;
		this.projectRepository = projectRepository;
		this.environment = environment;
	}
	
	public Person getPersonById(int id){
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT per "
				   + "FROM Person per "
				   + "LEFT JOIN FETCH per.roleInUNIT "
				   + "WHERE per.id = :id ";
		
		return session.createQuery(HQL, Person.class).setParameter("id", id)
				.stream().findAny().orElseThrow(PersonNotFound::new);
	}
	
	public Optional<Person> getPersonByEmail(String email) {
		return personRepository.findByEmail(email);
	}
	
	@Transactional(readOnly = false)
	public void register(Person newPerson) {
		Person person = new Person();
		String password = emailService.getRandomString();
		
		person.setFullName(newPerson.getFullName());
		person.setEmail(newPerson.getEmail());
		person.setDateOfBirth(newPerson.getDateOfBirth());
		person.setPassword(passwordEncoder.encode(password));
		person.setRoleInService("ROLE_USER");
		emailService.sendMessage(environment.getProperty("spring.mail.username"),
			newPerson.getEmail(), emailService.returnModelEmailMessage(
					"D:/IdeaProjects/service/"
					+ "src/main/resources/templates/modelMessageForEmail/modelMessgeForRegistration.html",
					newPerson.getEmail(), password));
	
		personRepository.save(person);
	}
	
	@Transactional(readOnly = false)
	public void deleteById(int id) {
		personRepository.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void update(int id, Person updatedPerson) {
		
		Person person = getPersonById(id);
		
		person.setUrlProfile(updatedPerson.getUrlProfile());
		person.setFullName(updatedPerson.getFullName());
		person.setDateOfBirth(updatedPerson.getDateOfBirth());
		person.setEducationalInstitution(updatedPerson.getEducationalInstitution());
		person.setCourse(updatedPerson.getCourse());
		updateRoleInUNIT(person, updatedPerson);
		
		personRepository.save(person);
		
	}
	
	
	public void updateRoleInUNIT(Person person, Person updatePerson) {
		
//		person.getRoleInUNIT().getPeople().removeIf(personFromRole -> personFromRole.getId() == person.getId());
		
		Optional<RoleInUNIT> optinalRoleInUNIT = roleInUNITRepository.findByName(updatePerson.getRoleInUNIT().getName());
		
		if(optinalRoleInUNIT.isEmpty()) {
			return;
		}
		
		person.setRoleInUNIT(optinalRoleInUNIT.get());
		person.getRoleInUNIT().getPeople().add(person);
		
		
	}
	
	@Transactional(readOnly = false)
	public void updateLogin(int id, String enteredlogin, String login) {
		
		Person person = personRepository.findById(id).stream().findAny().orElseThrow(PersonNotFound::new);
		person.setEmail(enteredlogin);
		personRepository.save(person);
		
	}
	
	@Transactional(readOnly = false)
	public void updatePassword(int id, String newPassword, String code) {
		Person person = personRepository.findById(id).get();
		Email email = emailService.returnEmailElseReturnTrowsExceptionIsNotTheRightCodeElse(person.getEmail(), code);
		person.setPassword(newPassword);
		personRepository.save(person);
		emailRepository.delete(email);
	}
	
	@Transactional(readOnly = false)
	public void createProject(Project project, int id) {
		Person person = getPersonById(id);
		
		Task task = new Task();
		task.setName("Admin");
		task.setPeople(Collections.singleton(person));
		task.setProject(project);
		
		person.getTasks().add(task);
		
		project.setTasks(Collections.singleton(task));
		projectRepository.save(project);
	}

	public void notThrowsExceptionIfIsPersonalPageOrRoleAdmin(int id, PersonDetails personDetails) {
		notThrowsExceptionIfIsPersonalPage(id, personDetails);
		notThrowsExceptionIfRoleInServiceIsAdmin(personDetails);
	}
	
	public void throwsIfIsNotTheRightEnteredPassword(String enteredPassword, int id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isEmpty()) {
			throw new PersonNotFound();
		}
		if(!(passwordEncoder.matches(enteredPassword, optionalPerson.get().getPassword()))) {
			throw new AuthorizationPasswordIsNotRight();
		}
	}
	
	public void notThrowsExceptionIfIsPersonalPage(int id, PersonDetails personDetails) {
		if(!(isPersonalPage(id, personDetails))) {
			throw new PersonDoesNotHaveTheRightToChange();
		}
	}
	
	public boolean isPersonalPage(int id, PersonDetails personDetails) {
		if(personDetails == null) {
			return false;
		}
		return personDetails.getPerson().getId() == id;
	}
	
	public void notThrowsExceptionIfRoleInServiceIsAdmin(PersonDetails personDetails) {
		if((personDetails == null) && !(roleInServiceIsAdmin(personDetails))) {
			throw new PersonDoesNotHaveTheRightToChange();
		}
	}
	
	public boolean roleInServiceIsAdmin(PersonDetails personDetails) {
		return personDetails.getPerson().getRoleInService().equals("ROLE_ADMIN");
	}
}
