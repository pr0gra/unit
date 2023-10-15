package ru.unit.service.models;

import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "id_project")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "aim")
	private String aim;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "project")
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Task> tasks;
	
	@OneToMany(mappedBy = "project")
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE})
	private Set<ImageProject> images;
	
	public Project() {}
	
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
	
	public String getAim() {
		return aim;
	}
	
	public void setAim(String aim) {
		this.aim = aim;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<ImageProject> getImages() {
		return images;
	}

	public void setImages(Set<ImageProject> images) {
		this.images = images;
	}
	
}
