package ru.unit.service.crud.repository.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import ru.unit.service.crud.repository.repositories.ProjectRepository;
import ru.unit.service.models.Project;
import ru.unit.service.securiry.PersonDetails;
import ru.unit.service.utils.exceptions.peopleExceptions.PersonDoesNotHaveTheRightToChange;
import ru.unit.service.utils.exceptions.projectExceptions.ProjectNotFound;

@Service
@Transactional(readOnly = true)
public class ProjectService {
	
	private final ProjectRepository projectRepository;
	private final EntityManager entityManager;
	
	public ProjectService(ProjectRepository projectRepository, EntityManager entityManager) {
		this.projectRepository = projectRepository;
		this.entityManager = entityManager;
	}
	
	public List<Project> getProjects(){
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT pro "
				   + "FROM Project pro "
				   + "LEFT JOIN FETCH pro.images pi ";
		
		return session.createQuery(HQL, Project.class).getResultList();
	}

	public Project getProjectById(int id){
		
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT pro "
				   + "FROM Project pro "
				   + "LEFT JOIN FETCH pro.images pi "
				   + "LEFT JOIN FETCH pro.tasks tas "
				   + "LEFT JOIN FETCH tas.images ti "
				   + "LEFT JOIN FETCH tas.people per "
				   + "WHERE pro.id = :id ";
		
		return session.createQuery(HQL, Project.class).setParameter("id", id)
				.stream().findAny().orElseThrow(ProjectNotFound::new);
	}
	
	public List<Project> getProjectsByPersonId(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT pro "
				   + "FROM Project pro "
				   + "LEFT JOIN FETCH pro.images pi "
				   + "LEFT JOIN FETCH pro.tasks tas "
				   + "LEFT JOIN FETCH tas.images ti "
				   + "LEFT JOIN tas.people p "
				   + "WHERE p.id = :id ";
		
		return  session.createQuery(HQL, Project.class).setParameter("id", id).getResultList();
	}
	private Project getProjectsByIdProjectAndIdPersonIsRoleAdmin(int idProject, int idPerson) {
		
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT pro "
				   + "FROM Project pro "
				   + "LEFT JOIN  pro.tasks tas "
				   + "LEFT JOIN tas.people p "
				   + "WHERE p.id = :idPerson AND "
				   + "pro.id = :idProject AND tas.name = 'Admin' ";
		
		return  session.createQuery(HQL, Project.class)
				.setParameter("idProject", idProject)
				.setParameter("idPerson", idPerson).stream().findAny()
				.orElse(null);
	}
	
	@Transactional(readOnly = false)
	public void update(int id, Project updatedProject) {
		
		Session session = entityManager.unwrap(Session.class);
		Project project = getProjectById(id);
			
		project.setName(updatedProject.getName());
		project.setAim(updatedProject.getAim());
		project.setDescription(updatedProject.getDescription());
		updateImageProject(session, project, updatedProject);
		updateTask(session, project, updatedProject);
		
		projectRepository.save(project);
		
	}
	
	public void updateTask(Session session, Project project, Project updatedProject) {
		if(updatedProject.getTasks() == null) return;
		
		project.getTasks().stream().forEach(task -> session.remove(task));
		updatedProject.getTasks().stream().forEach(task -> {
			task.setProject(project);
			task.getImages().stream().forEach(image -> image.setTask(task));
			});
		project.setTasks(updatedProject.getTasks());
	}
	
	public void updateImageProject(Session session,Project project, Project updatedProject) {
		if(updatedProject.getImages() == null) return;
		project.getImages().stream().forEach(image -> session.remove(image));
		updatedProject.getImages().stream().forEach(image -> image.setProject(project));
		project.setImages(updatedProject.getImages());
	}
	
	
	
	@Transactional(readOnly = false)
	public void save(Project project) {
		projectRepository.save(project);
	}
	
	@Transactional(readOnly = false)
	public void deleteById(int id) {
		projectRepository.deleteById(id);
	}
	
	public boolean haveRightsToChangeProject(int id, PersonDetails personDetails) {
		if(personDetails == null) {
			return false;
		}
		if(roleInServiceIsAdmin(personDetails)) {
			return true;
		}
		if(isAdminProject(id, personDetails)) {
			return true;
		}
		return false;
	}
	
	public boolean isAdminProject(int id, PersonDetails personDetails) {
		return getProjectsByIdProjectAndIdPersonIsRoleAdmin(id, personDetails.getPerson().getId()) != null;
	}
	
	public boolean roleInServiceIsAdmin(PersonDetails personDetails) {
		return personDetails.getPerson().getRoleInService().equals("ROLE_ADMIN");
	}
	
	public void notThrowsIfIsAdminProjectOrAdminService(int id, PersonDetails personDetails) {
		if(!(haveRightsToChangeProject(id, personDetails))) {
			throw new PersonDoesNotHaveTheRightToChange();
		}
	}
	
}
