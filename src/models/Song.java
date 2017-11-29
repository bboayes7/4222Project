 package models;

public class Song {
	
	int albumId;
	int songId;
	

	String title;
	String artist;

	//Musician author; make a table to combine artists with song on database
	
	public Song(String title,int albumId,int songId,String artist) {
		this.title = title;
		this.songId = songId;
		this.albumId = albumId;
		this.artist= artist;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
