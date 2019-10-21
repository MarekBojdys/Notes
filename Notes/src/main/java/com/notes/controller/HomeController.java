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

@Controller
public class HomeController {

private NoteService noteService;
	
	@Autowired
	public HomeController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("notes", noteService.getUserNotes());
		return "index";
	}
}