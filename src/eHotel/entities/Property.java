package eHotel.entities;

public class Property {

	private int proid;
	private int hid;
	private int prcid;
	private String title;
	private String type;
	private String country;
	private String address;
	private int numRoom;
	
	public Property() {
		this.proid = -1;
		this.hid = -1;
		this.prcid = -1;
		this.title = "";
		this.type = "";
		this.country = "";
		this.address = "";
		this.numRoom = -1;
	}
	
	public Property(int proid, int hid, int prcid, String title, String type, String country, String address, int numRoom) {
		this.proid = proid;
		this.hid = hid;
		this.prcid = prcid;
		this.title = title;
		this.type = type;
		this.country = country;
		this.address = address;
		this.numRoom = numRoom;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public int getHID() {
		return hid;
	}

	public void setHID(int hid) {
		this.hid = hid;
	}

	public int getPrcid() {
		return prcid;
	}

	public void setPrcid(int prcid) {
		this.prcid = prcid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumRoom() {
		return numRoom;
	}

	public void setNumRoom(int numRoom) {
		this.numRoom = numRoom;
	}

}
