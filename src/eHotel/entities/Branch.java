package eHotel.entities;

public class Branch {
	
	private String country;
	
	public Branch() {
		this.country = "";
	}
	
	public Branch(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
