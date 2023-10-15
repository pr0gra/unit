package ru.unit.service.crud.repository.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.unit.service.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
