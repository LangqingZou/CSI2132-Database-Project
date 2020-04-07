package eHotel.entities;

public class Payment {
	
	private int payid;
	private int gid;
	private int amount;
	private String payType;
	private String status;
	
	public Payment() {
		this.payid = -1;
		this.gid = -1;
		this.amount = -1;
		this.payType = "";
		this.status = "unpaid";
	}
	
	public Payment(int payid, int gid, int amount, String payType, String status) {
		this.payid = payid;
		this.gid = gid;
		this.amount = amount;
		this.payType = payType;
		this.status = status;
	}

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public int getGID() {
		return gid;
	}

	public void setGID(int gid) {
		this.gid = gid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
