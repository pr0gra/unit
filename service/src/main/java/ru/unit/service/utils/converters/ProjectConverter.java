package ru.unit.service.utils.converters;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.unit.service.crud.repository.services.ProjectService;
import ru.unit.service.dto.projectsDTO.ProjectDTO;
import ru.unit.service.dto.projectsDTO.ProjectDTOForCreate;
import ru.unit.service.dto.projectsDTO.ProjectDTOForPerson;
import ru.unit.service.dto.projectsDTO.ProjectDTOForSearch;
import ru.unit.service.models.Project;
import ru.unit.service.securiry.PersonDetails;

@Component
public class ProjectConverter {

	private final ModelMapper modelMapper;
	private final ProjectService projectService;
	
	@Autowired
	public ProjectConverter(ModelMapper modelMapper, ProjectService projectService) {
		this.modelMapper = modelMapper;
		this.projectService = projectService;
	}
	
	public Project convertToProjectFromProjectDTO(ProjectDTO projectDTO){
		return modelMapper.map(projectDTO, Project.class);
	}
	public ProjectDTO convertToProjectDTO(Project project, PersonDetails personDetails) {
		ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
		projectDTO.setHaveRightsToChange(
				projectService.haveRightsToChangeProject(
						project.getId(), personDetails
						)
				);
		return projectDTO;
	}
	
	public ProjectDTOForPerson convertToProjectDTOForPerson(Project project) {
		return modelMapper.map(project, ProjectDTOForPerson.class);
	}
	
	public ProjectDTOForSearch convertToProjectDTOForSearch(Project project) {
		return modelMapper.map(project, ProjectDTOForSearch.class);
	}
	
	public Project convertToProjectDTOFromProjectDTOForCreate(ProjectDTOForCreate projectDTOForCreate) {
		return modelMapper.map(projectDTOForCreate, Project.class);
	}
	
	public List<ProjectDTOForPerson> convertToListOfProjectsDTOForPerson(List<Project> projects){
		List<ProjectDTOForPerson> projectsDTOForPerson = new ArrayList<>();
		
		for(Project project:
			projects) {
			projectsDTOForPerson.add(convertToProjectDTOForPerson(project));
		}
		
		return projectsDTOForPerson;
	}
	
	public List<ProjectDTOForSearch> convertToListOfProjectsDTOForSearch(List<Project> projects){
		List<ProjectDTOForSearch> projectsDTOForSearch = new ArrayList<>();
		
		for(Project project:
			projects) {
			projectsDTOForSearch.add(convertToProjectDTOForSearch(project));
		}
		
		return projectsDTOForSearch;
	}
	
}
