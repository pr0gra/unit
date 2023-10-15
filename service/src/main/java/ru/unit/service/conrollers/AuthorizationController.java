package ru.unit.service.conrollers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import ru.unit.service.crud.repository.services.EmailService;
import ru.unit.service.crud.repository.services.PersonService;
import ru.unit.service.dto.emailsDTO.EmailDTO;
import ru.unit.service.utils.converters.EmailConverter;
import ru.unit.service.utils.exceptions.authorizationException.AuthorizationException;
import ru.unit.service.utils.exceptions.authorizationException.AuthorizationRuntimeException;
import ru.unit.service.utils.exceptions.emailException.EmailException;
import ru.unit.service.utils.exceptions.emailException.EmailRuntimeException;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
	
	private final PersonService personService;
	private final EmailConverter emailConverter;
	private final EmailService emailService;
	
	@Autowired
	public AuthorizationController(PersonService personService, EmailService emailService,
			EmailConverter emailConverter) {
		this.personService = personService;
		this.emailService = emailService;
		this.emailConverter = emailConverter;
	}
	
	@PostMapping("/verification")
	public HttpStatus verification(@RequestBody EmailDTO emailDTO){
		emailService.verification(emailConverter.converToEmailFromEmailDTO(emailDTO), emailDTO.getEmailAddress(),
				"https://unit-usue.ru", "login");
		return HttpStatus.OK;
	}
	
	@GetMapping("/message")
	public HttpStatus sendMessage(@RequestParam(value = "login",required = false) String email,
			@RequestParam(value = "code",required = false) String code) throws IOException, MessagingException{
		emailService.join(email, code);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler
	public ResponseEntity<AuthorizationException> exceptionHandler(AuthorizationRuntimeException exception) {
		return new ResponseEntity<>(new AuthorizationException(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	private ResponseEntity<EmailException> handleException(EmailRuntimeException exception){
		return new ResponseEntity<>(new EmailException(exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
}
