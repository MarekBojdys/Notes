package com.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notes.model.Note;
import com.notes.repository.UserRepository;
import com.notes.service.NoteService;
import com.notes.service.NoteServiceImpl;
import com.notes.service.UserService;

@Controller
public class HomeController {

private NoteService noteService;
private UserService userService;

	@Autowired
	public HomeController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("notes", noteService.getUserNotes());
		model.addAttribute("loginPassword", userService.getCurrentUser());
		return "index";
	}
}