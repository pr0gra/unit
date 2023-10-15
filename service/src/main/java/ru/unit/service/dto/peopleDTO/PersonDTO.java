package ru.unit.service.dto.peopleDTO;

import java.util.Date;
import java.util.List;

import ru.unit.service.dto.projectsDTO.ProjectDTOForPerson;

public class PersonDTO {
	
	private boolean isPersonalPage;
	private String urlProfile;
	private String fullName;
	private Date dateOfBirth;
	private String role;
	private String educationalInstitution;
	private int course;
	private String email;
	private List<ProjectDTOForPerson> projects;
	
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
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
	
	public List<ProjectDTOForPerson> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ProjectDTOForPerson> projects) {
		this.projects = projects;
	}

	public boolean getIsPersonalPage() {
		return isPersonalPage;
	}

	public void setIsPersonalPage(boolean isPersonalPage) {
		this.isPersonalPage = isPersonalPage;
	}
	
}
