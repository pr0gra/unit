package ru.unit.service.models;

import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "id_task")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_project", referencedColumnName = "id_project")
	private Project project;
	
	@ManyToMany()
	@JoinTable(name = "task_person",
			   joinColumns = @JoinColumn(name = "id_task"),
			   inverseJoinColumns = @JoinColumn(name = "id_person"))
	private Set<Person> people;
	
	@OneToMany(mappedBy = "task")
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE})
	private Set<ImageTask> images;
	
	public Task() {}
	
	public Task(String name, String description, Project project, Set<Person> people) {
		this.name = name;
		this.description = description;
		this.project = project;
		this.people = people;
	}



	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Person> getPeople() {
		return people;
	}
	
	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<ImageTask> getImages() {
		return images;
	}

	public void setImages(Set<ImageTask> images) {
		this.images = images;
	}	
	
}
