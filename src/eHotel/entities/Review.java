package eHotel.entities;

public class Review {

	private int reid;
	private int proid;
	private int gid;
	private int rating;
	private int communication;
	private int cleaniliness;
	private int value;
	private String comment;
	
	public Review() {
		this.reid = -1;
		this.proid = -1;
		this.gid = -1;
		this.rating = -1;
		this.communication = -1;
		this.cleaniliness = -1;
		this.value = -1;
		this.comment = "";
	}
	
	public Review(int reid, int proid, int gid, int rating, int communication, int cleaniliness, int value, String comment) {
		this.reid = reid;
		this.proid = proid;
		this.gid = gid;
		this.rating = rating;
		this.communication = communication;
		this.cleaniliness = cleaniliness;
		this.value = value;
		this.comment = comment;
	}

	public int getReid() {
		return reid;
	}

	public void setReid(int reid) {
		this.reid = reid;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public int getGID() {
		return gid;
	}

	public void setGID(int gid) {
		this.gid = gid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getCleaniliness() {
		return cleaniliness;
	}

	public void setCleaniliness(int cleaniliness) {
		this.cleaniliness = cleaniliness;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
