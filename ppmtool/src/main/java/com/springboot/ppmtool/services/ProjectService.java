package com.springboot.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ppmtool.Exceptions.ProjectIDException;
import com.springboot.ppmtool.domain.Project;
import com.springboot.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService { 
	
	@Autowired
	private ProjectRepository projectrepository;
	
	public Project saveOrUpdateProject (Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectrepository.save(project);
		}catch(Exception e){
			throw new ProjectIDException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already Exists!!");
			
		}
		
		
		
	}
	
	public Project findProjectByIdentifier(String projectID) {
		
		Project project = projectrepository.findByProjectIdentifier(projectID.toUpperCase());
		
		if(project == null) {
			throw new ProjectIDException("Project ID '" + projectID+"' does not Exists!!");
		}
		
		return project; 
	}
	
	public Iterable<Project> findAllProjects(){
		return projectrepository.findAll();
	}
	
	public void DeleteProjectByIdentifier(String projectId) {
		Project project = projectrepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			
			throw new ProjectIDException("Cannot Find Project with ID '"+projectId+"' .The Project does not Exist!!");
			
		}
		projectrepository.delete(project);
	}

}
