package ru.unit.service.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "url_profile")
	private String urlProfile;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role_in_unit", referencedColumnName = "id_role_in_unit")
	private RoleInUNIT roleInUNIT;
	
	@Column(name = "educational_institution")
	private String educationalInstitution;
	
	@Column(name = "course")
	private int course;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role_in_service")
	private String roleInService;
	
	@ManyToMany(mappedBy = "people")
	private List<Task> tasks;
	
	public Person() {}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrlProfile() {
		return urlProfile;
	}
	
	public void setUrlProfile(String urlProfile) {
		this.urlProfile = urlProfile;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEducationalInstitution() {
		return educationalInstitution;
	}
	
	public void setEducationalInstitution(String educationalInstitution) {
		this.educationalInstitution = educationalInstitution;
	}
	
	public int getCourse() {
		return course;
	}
	
	public void setCourse(int course) {
		this.course = course;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleInUNIT getRoleInUNIT() {
		return roleInUNIT;
	}

	public void setRoleInUNIT(RoleInUNIT roleInUNIT) {
		this.roleInUNIT = roleInUNIT;
	}

	public String getRoleInService() {
		return roleInService;
	}

	public void setRoleInService(String roleINService) {
		this.roleInService = roleINService;
	}
	
}
