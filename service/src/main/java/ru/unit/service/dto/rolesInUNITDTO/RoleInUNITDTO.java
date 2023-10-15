package ru.unit.service.dto.rolesInUNITDTO;

import java.util.Set;

import ru.unit.service.dto.peopleDTO.PersonDTOForSearch;

public class RoleInUNITDTO {
	
	private String name;
	private Set<PersonDTOForSearch> people;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<PersonDTOForSearch> getPeople() {
		return people;
	}
	
	public void setPeople(Set<PersonDTOForSearch> people) {
		this.people = people;
	}
	
}
