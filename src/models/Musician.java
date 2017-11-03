package models;

public class Musician {

	int ssn;
	String name;
	int phone;
	String address;
	
	public Musician(int ssn, String name, int phone, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}

