package com.springboot.ppmtool.repositories;

import com.springboot.ppmtool.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String Identifier);
}
