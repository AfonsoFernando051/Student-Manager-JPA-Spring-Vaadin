package com.globalsoftwaresupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globalsoftwaresupport.model.User;

public interface SecurityRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.username=:username")
	User findByUsername(String username);
}
