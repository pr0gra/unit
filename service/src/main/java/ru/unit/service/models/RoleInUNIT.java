package ru.unit.service.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_in_unit")
public class RoleInUNIT {
	
	@Id
	@Column(name = "id_role_in_unit")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "roleInUNIT")
	private Set<Person> people;
	
	public RoleInUNIT() {}
	
	public RoleInUNIT(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Person> getPeople() {
		return people;
	}
	
	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
}
