package com.notes.service;

import org.springframework.stereotype.Service;

import com.notes.model.User;


public interface UserService {
	public void addWithDefaultRole(User user);
	public void deleteUser(String login);
}
