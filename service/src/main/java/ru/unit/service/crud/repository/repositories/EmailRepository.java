package ru.unit.service.crud.repository.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.unit.service.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{
	Optional<Email> findByEmailAddressAndCode(String email, String code);
	void deleteAllByEmailAddress(String emailAddress);
	Optional<Email> findByEmailAddress(String emailAddress);
}
