package it.app.note.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {
	
	private @Id
	@GeneratedValue Long id;
	private String title;
	private String content;
	
	Note(){}

	public Note(long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
