package ru.unit.service.utils.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ru.unit.service.dto.emailsDTO.EmailDTO;
import ru.unit.service.models.Email;

@Component
public class EmailConverter {
	
	private final ModelMapper modelMapper;

	public EmailConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public Email converToEmailFromEmailDTO(EmailDTO emailDTO) {
		return modelMapper.map(emailDTO, Email.class);
	}
	
	public EmailDTO convertToEmailDTO(Email email) {
		return modelMapper.map(email, EmailDTO.class);
	}
	
	public List<EmailDTO> convertToListOfEmailsDTO(List<Email> emails){
		List<EmailDTO> emailsDTO = new ArrayList<>();
		
		for(Email email:
				emails) {
			emailsDTO.add(convertToEmailDTO(email));
		}
			
		return emailsDTO;
	}
	
}
