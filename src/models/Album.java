package models;

import java.util.Date;

public class Album {

	int id;
	Date copyrightDate;
	String title;
	String format;
	int albumId;
	int pSSN; // each album has one artist as producer, no need to make another table!!!!!!
	
	public Album(int id, Date copyrightDate, String title, String format, int albumId,int pSSN) {
		super();
		this.id = id;
		this.copyrightDate = copyrightDate;
		this.title = title;
		this.format = format;
		this.albumId = albumId;
		this.pSSN = pSSN;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCopyrightDate() {
		return copyrightDate;
	}

	public void setCopyrightDate(Date copyrightDate) {
		this.copyrightDate = copyrightDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getpSSN() {
		return pSSN;
	}

	public void setpSSN(int pSSN) {
		this.pSSN = pSSN;
	}
	
	
}
