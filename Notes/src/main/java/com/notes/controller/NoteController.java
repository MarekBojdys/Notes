package com.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.notes.model.Note;
import com.notes.repository.NoteRepository;
import com.notes.service.NoteService;
import com.notes.service.NoteServiceImpl;

@Controller
public class NoteController {
	
private NoteService noteService;
	
	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("/addNote")
	public String addNote(Model model) {
		model.addAttribute("note", new Note());
		return "addNote";
	}
	
	@PostMapping("/addNote")
	public String addNote(@ModelAttribute Note note,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "addNote";
		else {
			noteService.save(note);
			return "redirect:";
		}
	}
	
	@GetMapping("/deleteNote")
	public String deleteNote(Model model) {
		model.addAttribute("note", new Note());
		return "deleteNote";
	}
	
	@PostMapping("/deleteNote")
	public String deleteNote(@ModelAttribute Note note,
			BindingResult bindResult) {
		if(bindResult.hasErrors())
			return "deleteNote";
		else {
			noteService.delete(note);
			return "redirect:";
		}
	}
}
