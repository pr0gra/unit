package ru.unit.service.dto.tasksDTO;

import java.util.Set;

import ru.unit.service.dto.imagesDTO.ImageDTO;


public class TaskDTOForPerson {
	
	private String name;
	private String description;
	private Set<ImageDTO> images;
	
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

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}
	
}
