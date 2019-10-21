package com.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}
