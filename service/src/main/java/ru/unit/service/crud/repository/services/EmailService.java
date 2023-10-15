package ru.unit.service.crud.repository.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import ru.unit.service.crud.repository.repositories.EmailRepository;
import ru.unit.service.models.Email;
import ru.unit.service.utils.exceptions.authorizationException.AuthorizationСodeDoesNotMatch;
import ru.unit.service.utils.exceptions.emailException.EmailNotFound;
import ru.unit.service.utils.exceptions.emailException.EmailNotRegistration;

@Service
@Transactional(readOnly = true)
@PropertySource("classpath:application.properties")
public class EmailService{
	
	private final EmailRepository emailRepository;
	private final JavaMailSender emailSender;
	private final Environment environment;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public EmailService(EmailRepository emailRepository, JavaMailSender emailSender,
			Environment environment, PasswordEncoder passwordEncoder) {
		 this.emailRepository = emailRepository;
		 this.emailSender = emailSender;
		 this.environment = environment;
		 this.passwordEncoder = passwordEncoder;
	}
	
	public List<Email> getEmails(){
		return emailRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Email returnEmailElseReturnTrowsExceptionIsNotTheRightCodeElse(String emailAddress, String code) {
		return emailRepository.findByEmailAddressAndCode(emailAddress, code).stream()
				.findAny().orElseThrow(AuthorizationСodeDoesNotMatch::new);
	}
	
	@Transactional(readOnly = false)
	public void saveEmailAndDeleteOldEmailsByEmailAddress(Email email){
		emailRepository.deleteAllByEmailAddress(email.getEmailAddress());
		emailRepository.save(email);
		
	}
	
	@Transactional(readOnly = false)
	public void verification(Email email, String parameterText,
			String url, String parametr) {
		
		String code = getRandomString();
		email.setCode(code);
		email.setMessage(email.getMessage());
		
		url = url + "?" + parametr + "="
				+ parameterText
				+ "&code=" + code;
		
		saveEmailAndDeleteOldEmailsByEmailAddress(email);
		
		try{
			sendMessage(environment.getProperty("spring.mail.username"), email.getEmailAddress(),
					returnModelEmailMessage(
							"D:/IdeaProjects/service/"
						    + "src/main/resources/templates/modelMessageForEmail/modelMessageForUrlForGet.html",
							url, url
							)
					);
		}catch(MailSendException ex) {
			throw new EmailNotFound();
		}
	}
	
	public void join(String emailAddress, String code) throws IOException, MessagingException{
		Email email = returnEmailElseReturnTrowsExceptionIsNotTheRightCodeElse(emailAddress, code);
		
		sendMessage(environment.getProperty("spring.mail.username"), 
				environment.getProperty("spring.mail.admin.email"),
				    returnModelEmailMessage(
				    "D:/IdeaProjects/service/"
				    + "src/main/resources/templates/modelMessageForEmail/modelMessageForJoinUNIT.html",
				    		email.getEmailAddress(), email.getFullName(),
				    		email.getDateOfBirth().toString(), email.getMessage()));
		
	}
	
	public void sendMessage(String fromEmail, String toEmail, String message){
		
		MimeMessage mimeMessage =  emailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(toEmail);
			helper.setFrom(fromEmail);
			helper.setText(message, true);
			emailSender.send(helper.getMimeMessage());
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	String getRandomString() {
		long random = (long)(Math.random()*Math.pow(10, 16));
		return Long.toHexString(random);
	}
	
	public String returnModelEmailMessage(String pathFile, String... text){
		StringBuilder htmlCode = new StringBuilder();
		int stringTextCounter = 0;
		
		
		try (BufferedReader bufferForInputHtmlCode = new BufferedReader(
				new FileReader(pathFile)
				)){
			
			int integerValueFromCharacterFromFile;
			
			while((integerValueFromCharacterFromFile = bufferForInputHtmlCode.read())!=-1) {
				
				if(integerValueFromCharacterFromFile != 63) {
					htmlCode.append((char) integerValueFromCharacterFromFile);
				}else {
					htmlCode.append(text[stringTextCounter ++]);
				}
				
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return htmlCode.toString();
	}
}
