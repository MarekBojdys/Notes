package com.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notes.model.Note;


public interface NoteService {
	public void save(Note note);
	public void delete(Note note);
	public List<Note> getUserNotes();
}
