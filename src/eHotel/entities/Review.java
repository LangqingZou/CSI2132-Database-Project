package eHotel.entities;

public class Review {

	private int IDR;
	private int Rating;
	private int Communication;
	private int Cleanliness;
	private int ReValue;
	
	public Review(int iDR, int rating, int communication, int cleanliness, int reValue) {
		this.IDR = iDR;
		this.Rating = rating;
		this.Communication = communication;
		this.Cleanliness = cleanliness;
		this.ReValue = reValue;
	}
	
	public int getIDR() {
		return IDR;
	}
	public void setIDR(int iDR) {
		IDR = iDR;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public int getCommunication() {
		return Communication;
	}
	public void setCommunication(int communication) {
		Communication = communication;
	}
	public int getCleanliness() {
		return Cleanliness;
	}
	public void setCleanliness(int cleanliness) {
		Cleanliness = cleanliness;
	}
	public int getReValue() {
		return ReValue;
	}
	public void setReValue(int reValue) {
		ReValue = reValue;
	}

}
