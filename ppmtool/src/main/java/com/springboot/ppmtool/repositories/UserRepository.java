package com.springboot.ppmtool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ppmtool.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);
}
