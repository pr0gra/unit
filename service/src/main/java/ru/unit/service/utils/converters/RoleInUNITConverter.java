package ru.unit.service.utils.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.unit.service.dto.rolesInUNITDTO.RoleInUNITDTO;
import ru.unit.service.models.RoleInUNIT;

@Component
public class RoleInUNITConverter {

	private final ModelMapper modelMapper;
	
	@Autowired
	public RoleInUNITConverter (ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public RoleInUNITDTO convertToRoleInUNITDTO(RoleInUNIT roleInUNIT) {
		return modelMapper.map(roleInUNIT, RoleInUNITDTO.class);
	}
	
	public List<RoleInUNITDTO> convertToListOfRolesInUNITDTO(List<RoleInUNIT> rolesInUNIT){
		List<RoleInUNITDTO> rolesInUNITDTO = new ArrayList<>();
		
		for(RoleInUNIT roleInUNIT:
			rolesInUNIT) {
			rolesInUNITDTO.add(convertToRoleInUNITDTO(roleInUNIT));
		}
		
		return rolesInUNITDTO;
	}
}
