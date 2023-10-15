package ru.unit.service.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.unit.service.crud.repository.services.EmailService;
import ru.unit.service.crud.repository.services.PersonService;
import ru.unit.service.dto.emailsDTO.EmailDTO;
import ru.unit.service.dto.peopleDTO.PersonDTOForRegistration;
import ru.unit.service.utils.converters.EmailConverter;
import ru.unit.service.utils.converters.PersonConverter;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonException;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonRuntimeException;
import ru.unit.service.utils.validators.peopleValidators.PersonValidator;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final PersonService personService;
	private final PersonConverter personConverter;
	private final PersonValidator personValidator;
	private final EmailService emailService;
	private final EmailConverter emailConverter;
	
	@Autowired
	public AdminController(PersonService personService, PersonConverter personConverter,
			PersonValidator personValidator,  EmailService emailService,
			EmailConverter emailConverter) {
		this.personService = personService;
		this.personConverter = personConverter;
		this.personValidator = personValidator;
		this.emailService = emailService;
		this.emailConverter = emailConverter;
	}
	
	@GetMapping("/registration")
	public List<EmailDTO> registration(){
		return emailConverter.convertToListOfEmailsDTO(emailService.getEmails());
	}
	
	@PostMapping("/registration")
	public HttpStatus registration(@RequestBody PersonDTOForRegistration personDTOForRegistration){
		personService.register(personConverter.convertToPersonFromPersonDTOForRegistration(personDTOForRegistration));
		return HttpStatus.OK;
	}
	
	@ExceptionHandler
	public ResponseEntity<PersonException> exceptionHandler(PersonRuntimeException exception){
		return new ResponseEntity<PersonException>(new PersonException(exception.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
}
