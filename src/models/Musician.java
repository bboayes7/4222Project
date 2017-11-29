package models;

public class Musician {

	int ssn;
	String name;
	long phone;
	String address;
	boolean ifPoor;
	
	public Musician(int ssn, String name, long phone, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ifPoor=true;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isIfPoor() {
		return ifPoor;
	}

	

	
}

