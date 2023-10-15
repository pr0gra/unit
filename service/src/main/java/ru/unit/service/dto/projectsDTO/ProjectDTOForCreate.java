package ru.unit.service.dto.projectsDTO;

import java.util.Set;

import ru.unit.service.dto.tasksDTO.TaskDTOForCreateProject;

public class ProjectDTOForCreate {
	
	private String name;
	private String aim;
	private String description;
	private Set<TaskDTOForCreateProject> tasks;
	
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
	
	public Set<TaskDTOForCreateProject> getTasks() {
		return tasks;
	}
	
	public void setTasks(Set<TaskDTOForCreateProject> tasks) {
		this.tasks = tasks;
	}
	
}
