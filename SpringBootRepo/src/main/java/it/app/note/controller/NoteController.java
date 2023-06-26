package it.app.note.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.app.note.model.Note;
import it.app.note.repository.NoteRepository;

@RestController
public class NoteController {

	
	private final NoteRepository noteRepository;
	
	NoteController(NoteRepository repository){
		noteRepository = repository;
	}
	
	@GetMapping("/notes")
	public Iterable<Note> getNotes(){
	  return noteRepository.findAll();
	}
	
	
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note note) {
		return noteRepository.save(note);
	}	
	
	
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable Long id) {
		return noteRepository.findById(id).orElseThrow();
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable Long id,@RequestBody Note noteObj){
	Note n = noteRepository.findById(id).orElseThrow();
	n.setTitle(noteObj.getTitle());
	n.setContent(noteObj.getContent());
	return noteRepository.save(n);

	}
	
	@DeleteMapping("notes/{id}")
	public void deleteNote(@PathVariable Long id) {
		Note n = noteRepository.findById(id).orElseThrow();
		 noteRepository.delete(n);
	}
	
	
}
