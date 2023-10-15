package ru.unit.service.conrollers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import ru.unit.service.crud.repository.services.EmailService;
import ru.unit.service.crud.repository.services.PersonService;
import ru.unit.service.crud.repository.services.ProjectService;
import ru.unit.service.crud.repository.services.RoleInUNITService;
import ru.unit.service.dto.peopleDTO.PersonDTO;
import ru.unit.service.dto.peopleDTO.PersonDTOForUpdateLoginAndPassword;
import ru.unit.service.dto.projectsDTO.ProjectDTOForCreate;
import ru.unit.service.dto.rolesInUNITDTO.RoleInUNITDTO;
import ru.unit.service.securiry.PersonDetails;
import ru.unit.service.utils.converters.PersonConverter;
import ru.unit.service.utils.converters.ProjectConverter;
import ru.unit.service.utils.converters.RoleInUNITConverter;
import ru.unit.service.utils.exceptions.authorizationException.AuthorizationRuntimeException;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonException;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonRuntimeException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private ProjectService projectService;
	private PersonService personService;
	private PersonConverter personConverter;
	private RoleInUNITService roleInUNITService;
	private RoleInUNITConverter roleInUNITConverter;
	private EmailService emailService;
	private ProjectConverter projectConverter;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserController(PersonService personService, PersonConverter personConverter, 
			ProjectService projectService, RoleInUNITService roleInUNITService,
			RoleInUNITConverter roleInUNITConverter, EmailService emailService,
			ProjectConverter projectConverter, PasswordEncoder passwordEncoder) {
		this.personService = personService;
		this.personConverter = personConverter;
		this.projectService = projectService;
		this.roleInUNITService = roleInUNITService;
		this.roleInUNITConverter = roleInUNITConverter;
		this.emailService = emailService;
		this.projectConverter = projectConverter;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping()
	public List<RoleInUNITDTO> returnPeople(){
		return roleInUNITConverter.convertToListOfRolesInUNITDTO(roleInUNITService.getRolesInUNITWithPeople());
	}
	
	@GetMapping("/{id}")
	public PersonDTO returnPerson(@PathVariable("id") int id,
			@AuthenticationPrincipal PersonDetails personDetails){
		return personConverter.convertToPersonDTO(personService.getPersonById(id),
				projectService.getProjectsByPersonId(id), personDetails);
	}
	
//	@DeleteMapping("/{id}") 
	//Для показа
	@GetMapping("/{id}/delete") 
	public HttpStatus delete(@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails){
		personService.notThrowsExceptionIfIsPersonalPageOrRoleAdmin(id, personDetails);
		personService.deleteById(id);
		return HttpStatus.OK;
	}
	
	@PatchMapping("/{id}")
	public HttpStatus update(@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails,
			@RequestBody PersonDTO personDTO){
//		personService.notThrowsExceptionIfIsPersonalPageOrRoleAdmin(id, personDetails);
		personService.update(id, personConverter.convertToPersonFromPersonDTO(personDTO));
		return HttpStatus.OK;
	}
	
	@PatchMapping("/{id}/login")
	public HttpStatus updateLogin(@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails,
			@RequestBody PersonDTOForUpdateLoginAndPassword personDTOForUpdateLoginAndPassword) {
		personService.throwsIfIsNotTheRightEnteredPassword(personDTOForUpdateLoginAndPassword.getEnteredPassword(),
				id);
		personService.updateLogin(id, personDTOForUpdateLoginAndPassword.getEnteredLogin(),
				personDTOForUpdateLoginAndPassword.getEnteredLogin());
		return HttpStatus.OK;
	}
	
	@PatchMapping("/{id}/password")
	public HttpStatus verificationForUpdatePassword(@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails,
			@RequestBody PersonDTOForUpdateLoginAndPassword personDTOForUpdateLoginAndPassword) throws MessagingException, IOException {
		emailService.verification(personConverter.convrtToEmailFromPersonDTO(personDTOForUpdateLoginAndPassword),
				passwordEncoder.encode(personDTOForUpdateLoginAndPassword.getNewPassword()),
				"http://localhost:8080/user/" + id + "/updatePassword",
				"password");
		return HttpStatus.OK;
	}
	
	@GetMapping("/{id}/updatePassword")
	public HttpStatus updatePassword(@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails,
			@RequestParam(value = "password",required = false) String password,
			@RequestParam(value = "code",required = false) String code){
		personService.notThrowsExceptionIfIsPersonalPageOrRoleAdmin(id, personDetails);
		personService.updatePassword(id, password, code);
		return HttpStatus.OK;
	}
	
	@PostMapping("/{id}/createProject")
	public void createProject(@RequestBody ProjectDTOForCreate projectDTOForCreate,
			HttpServletResponse httpResponse,
			@PathVariable("id") int id, 
			@AuthenticationPrincipal PersonDetails personDetails) throws IOException {
//		personService.notThrowsExceptionIfIsPersonalPage(id, personDetails);
		personService.createProject(projectConverter.convertToProjectDTOFromProjectDTOForCreate(projectDTOForCreate),
				id);
		httpResponse.sendRedirect("/");
	}
	
	@ExceptionHandler
	private ResponseEntity<PersonException> handleException(PersonRuntimeException exception){
		return new ResponseEntity<>(new PersonException(exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	private ResponseEntity<PersonException> handleException(AuthorizationRuntimeException exception){
		return new ResponseEntity<>(new PersonException(exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
}
