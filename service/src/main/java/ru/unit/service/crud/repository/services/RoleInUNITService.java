package ru.unit.service.crud.repository.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import ru.unit.service.crud.repository.repositories.RoleInUNITRepository;
import ru.unit.service.models.RoleInUNIT;

@Service
@Transactional(readOnly = true)
public class RoleInUNITService {

	private final RoleInUNITRepository roleInUNITRepository;
	private final EntityManager entityManager;
	
	@Autowired
	public RoleInUNITService(RoleInUNITRepository roleInUNITRepository, EntityManager entityManager) {
		this.roleInUNITRepository = roleInUNITRepository;
		this.entityManager = entityManager;
	}
	
	
	public List<RoleInUNIT> getRolesInUNITWithPeople(){
		Session session = entityManager.unwrap(Session.class);
		
		String HQL = "SELECT rol "
				   + "FROM RoleInUNIT rol "
				   + "LEFT JOIN FETCH rol.people peop";
		
		return session.createQuery(HQL, RoleInUNIT.class).getResultList();
	}
	
}
