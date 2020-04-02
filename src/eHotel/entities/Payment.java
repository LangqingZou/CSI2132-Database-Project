package eHotel.entities;

public class Payment {
	
	private int IDRA;
	private int IDPAY;
	private int Amount;
	private String PaymentType;
	private String Status;
	private String Approve;
	
	public Payment(int iDRA, int iDPAY, int amount, String paymentType, String status, String approve) {
		this.IDRA = iDRA;
		this.IDPAY = iDPAY;
		this.Amount = amount;
		this.PaymentType = paymentType;
		this.Status = status;
		this.Approve = approve;
	}
	
	public int getIDRA() {
		return IDRA;
	}
	public void setIDRA(int iDRA) {
		IDRA = iDRA;
	}
	public int getIDPAY() {
		return IDPAY;
	}
	public void setIDPAY(int iDPAY) {
		IDPAY = iDPAY;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getApprove() {
		return Approve;
	}
	public void setApprove(String approve) {
		Approve = approve;
	}
	

}
