package com.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notes.model.User;
import com.notes.repository.UserRepository;
import com.notes.service.UserServiceImpl;

@Controller
public class AdminController {
	
	private UserRepository userRepository;
	
	@Autowired
	public AdminController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "admin";
	}
}
