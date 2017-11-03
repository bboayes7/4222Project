package models;

public class Song {
	
	String title;
	Musician author;
	
	public Song(String title, Musician author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Musician getAuthor() {
		return author;
	}

	public void setAuthor(Musician author) {
		this.author = author;
	}
	
	
}
