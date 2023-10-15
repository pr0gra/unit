package ru.unit.service.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.unit.service.crud.repository.services.ProjectService;
import ru.unit.service.dto.projectsDTO.ProjectDTO;
import ru.unit.service.dto.projectsDTO.ProjectDTOForSearch;
import ru.unit.service.securiry.PersonDetails;
import ru.unit.service.utils.converters.ProjectConverter;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonException;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonRuntimeException;
import ru.unit.service.utils.exceptions.projectExceptions.ProjectException;
import ru.unit.service.utils.exceptions.projectExceptions.ProjectRuntimeException;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private final ProjectService projectService;
	private final ProjectConverter projectConverter;
	
	@Autowired
	public ProjectController(ProjectService projectService, ProjectConverter projectConverter) {
		this.projectConverter = projectConverter;
		this.projectService = projectService;
	}
	
	@GetMapping()
	public List<ProjectDTOForSearch> getProjects(){
		return projectConverter.convertToListOfProjectsDTOForSearch(projectService.getProjects());
	}
	
	@GetMapping("/{id}")
	public ProjectDTO getProject(@PathVariable("id") int id,
			@AuthenticationPrincipal PersonDetails personDetails){
		return projectConverter.convertToProjectDTO(projectService.getProjectById(id), personDetails);
	}
	
//	@DeleteMapping("/{id}")
	@GetMapping("/{id}/delete")
	public HttpStatus delete(@PathVariable("id") int id,
			@AuthenticationPrincipal PersonDetails personDetails) {
		projectService.notThrowsIfIsAdminProjectOrAdminService(id, personDetails);
		projectService.deleteById(id);
		return HttpStatus.OK;
	}
	
	@PatchMapping("/{id}")
	public HttpStatus updateProject(@RequestBody ProjectDTO projectDTO,
			@PathVariable("id") int id,
			@AuthenticationPrincipal PersonDetails personDetails) {
//		projectService.notThrowsIfIsAdminProjectOrAdminService(id, personDetails);
		projectService.update(id,
					projectConverter.convertToProjectFromProjectDTO(projectDTO)
				);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler
	private ResponseEntity<ProjectException> handleException(ProjectRuntimeException exception){
		return new ResponseEntity<>(new ProjectException(exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
}