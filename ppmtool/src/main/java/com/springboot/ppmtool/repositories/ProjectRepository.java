package com.springboot.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository< Project , Long > {
	
	
	Project findByProjectIdentifier(String projectId);

	@Override
	default Iterable<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
//	@Override
//	default Iterable<Project> findAllById(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
