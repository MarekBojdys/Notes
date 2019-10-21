package com.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.notes.model.Note;
import com.notes.model.User;
import com.notes.repository.NoteRepository;
import com.notes.repository.UserRepository;

@Service
public class NoteServiceImpl implements NoteService {

	private NoteRepository noteRepository;
	private UserRepository userRepository;
	
	
	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void save(Note note) {
		note.setUser(userRepository.findByLogin(getCurrentUser()));
		noteRepository.save(note);
	}
	
	public void delete(Note note) {
		List<Note> notes= userRepository.findByLogin(getCurrentUser()).getNotes();
		for(Note loopNote : notes) {
			if(loopNote.getId().equals(note.getId())) {
				noteRepository.deleteById(note.getId());
				break;
			}
		}
	}
		
	public List<Note> getUserNotes(){
		return userRepository.findByLogin(getCurrentUser()).getNotes();
	}
	
	private String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
