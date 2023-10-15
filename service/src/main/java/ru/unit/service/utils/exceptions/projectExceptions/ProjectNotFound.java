package ru.unit.service.utils.exceptions.projectExceptions;

public class ProjectNotFound extends ProjectRuntimeException{

	public ProjectNotFound() {
		super("Project not found");
	}

}
