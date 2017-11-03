package models;

public class Instrument {

	int id;
	String name;
	String musicalKey;
	
	public Instrument(int id, String name, String musicalKey) {
		super();
		this.id = id;
		this.name = name;
		this.musicalKey = musicalKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMusicalKey() {
		return musicalKey;
	}

	public void setMusicalKey(String musicalKey) {
		this.musicalKey = musicalKey;
	}
	
	
}
