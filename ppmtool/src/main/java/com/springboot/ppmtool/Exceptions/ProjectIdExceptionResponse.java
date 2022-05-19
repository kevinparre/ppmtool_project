package com.springboot.ppmtool.Exceptions;

public class ProjectIDExceptionResponse {
	
	private String projectIdentifier;

	public ProjectIDExceptionResponse(String projectIdentifier) {
		
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
	
	
	
	
 
}
