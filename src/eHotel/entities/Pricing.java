package eHotel.entities;

public class Pricing {

	private int IDPricing;
	private int Price;
	private String RoomRule;
	private String Amenity;
	
	public Pricing(int iDPricing, int price, String roomRule, String amenity) {
		this.IDPricing = iDPricing;
		this.Price = price;
		this.RoomRule = roomRule;
		this.Amenity = amenity;
	}
	
	public int getIDPricing() {
		return IDPricing;
	}
	public void setIDPricing(int iDPricing) {
		IDPricing = iDPricing;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getRoomRule() {
		return RoomRule;
	}
	public void setRoomRule(String roomRule) {
		RoomRule = roomRule;
	}
	public String getAmenity() {
		return Amenity;
	}
	public void setAmenity(String amenity) {
		Amenity = amenity;
	}
	
	

}
