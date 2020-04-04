package eHotel.entities;

public class Pricing {

	private int prcid;
	private int price;
	private String rule;
	private String amenity;
	
	public Pricing() {
		this.prcid = -1;
		this.price = -1;
		this.rule = "";
		this.amenity = "";
	}
	
	public Pricing(int prcid, int price, String rule, String amenity) {
		this.prcid = prcid;
		this.price = price;
		this.rule = rule;
		this.amenity = amenity;
	}

	public int getPrcid() {
		return prcid;
	}

	public void setPrcid(int prcid) {
		this.prcid = prcid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
}
