package com.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notes.model.Note;
import com.notes.model.User;

public interface NoteRepository extends JpaRepository<Note, Long>{

}
