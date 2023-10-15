package ru.unit.service.crud.repository.services;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import ru.unit.service.crud.repository.repositories.TaskRepository;
import ru.unit.service.models.Task;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	private final EntityManager entityManager;
	
	@Autowired
	public TaskService(TaskRepository taskRepository, EntityManager entityManager) {
		this.taskRepository = taskRepository;
		this.entityManager = entityManager;
	}
	
	@Transactional(readOnly = false)
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	public List<Task> getTasksWithPersonByProjectId(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT tas "
				   + "FROM Task tas "
				   + "LEFT JOIN FETCH tas.images "
				   + "LEFT JOIN FETCH tas.project pro "
				   + "LEFT JOIN tas.people peo "
				   + "WHERE pro.id = :id ";
		
		return  session.createQuery(HQL, Task.class).setParameter("id", id).getResultList();
	}
	
}
