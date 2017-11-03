package models;

import java.util.Date;

public class Album {

	int id;
	Date copyrightDate;
	String title;
	String format;
	int albumId;
	
	public Album(int id, Date copyrightDate, String title, String format, int albumId) {
		super();
		this.id = id;
		this.copyrightDate = copyrightDate;
		this.title = title;
		this.format = format;
		this.albumId = albumId;
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
	
	
}
