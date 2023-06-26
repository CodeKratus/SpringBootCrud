package it.app.note.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.app.note.model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long>{

}
