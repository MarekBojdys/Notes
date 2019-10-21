package com.notes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.notes.model.User;
import com.notes.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "registerForm";
		else {
			userService.addWithDefaultRole(user);
			return "redirect:admin";
		}
	}
	@GetMapping("/delete")
	public String delete(Model model) {
		model.addAttribute("user", new User());
		return "deleteForm";
	}
	@PostMapping("/delete")
	public String deleteUser(@ModelAttribute User user,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "registerForm";
		else {
			userService.deleteUser(user.getLogin());
			return "redirect:admin";
		}
	}
	
}
