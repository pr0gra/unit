package ru.unit.service.crud.repository.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.unit.service.models.RoleInUNIT;

@Repository
public interface RoleInUNITRepository extends JpaRepository<RoleInUNIT, Integer>{
	Optional<RoleInUNIT> findByName(String name);
}
