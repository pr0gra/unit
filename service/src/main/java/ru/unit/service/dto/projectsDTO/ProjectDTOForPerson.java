package ru.unit.service.dto.projectsDTO;

import java.util.List;
import java.util.Set;

import ru.unit.service.dto.imagesDTO.ImageDTO;
import ru.unit.service.dto.tasksDTO.TaskDTOForPerson;

public class ProjectDTOForPerson {

	private int id;
	private String name;
	private String aim;
	private String description;
	private Set<ImageDTO> images;
	private List<TaskDTOForPerson> tasks;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAim() {
		return aim;
	}
	
	public void setAim(String aim) {
		this.aim = aim;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<TaskDTOForPerson> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<TaskDTOForPerson> tasks) {
		this.tasks = tasks;
	}

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}
	
}
