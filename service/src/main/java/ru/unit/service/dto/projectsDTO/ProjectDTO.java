package ru.unit.service.dto.projectsDTO;

import java.util.Set;

import ru.unit.service.dto.imagesDTO.ImageDTO;
import ru.unit.service.dto.tasksDTO.TaskDTOForProject;

public class ProjectDTO {

	private boolean haveRightsToChange;
	private String name;
	private String aim;
	private String description;
	private Set<ImageDTO> images;
	private Set<TaskDTOForProject> tasks;
	
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
	
	public Set<TaskDTOForProject> getTasks() {
		return tasks;
	}
	
	public void setTasks(Set<TaskDTOForProject> tasks) {
		this.tasks = tasks;
	}

	public Set<ImageDTO> getImages() {
		return images;
	}

	public void setImages(Set<ImageDTO> images) {
		this.images = images;
	}

	public boolean getHaveRightsToChange() {
		return haveRightsToChange;
	}

	public void setHaveRightsToChange(boolean haveRightsToChange) {
		this.haveRightsToChange = haveRightsToChange;
	}
	
}
