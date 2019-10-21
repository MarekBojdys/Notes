package com.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);
}
