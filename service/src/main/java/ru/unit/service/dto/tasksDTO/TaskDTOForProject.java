package ru.unit.service.dto.tasksDTO;

import java.util.List;
import java.util.Set;

import ru.unit.service.dto.imagesDTO.ImageDTO;
import ru.unit.service.dto.peopleDTO.PersonDTOForProject;

public class TaskDTOForProject {

	private String name;
	private String description;
	private Set<ImageDTO> images;
	private List<PersonDTOForProject> people;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<PersonDTOForProject> getPeople() {
		return people;
	}
	
	public void setPeople(List<PersonDTOForProject> people) {
		this.people = people;
	}

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}
	
}
