package eHotel.entities;

import java.sql.Date;

public class RetalAgreement {
	
	private int IDRA;
	private Date StartDate;
	private Date EndDate;
	private int IDG;
	private int IDH;
	private int IDP;
	
	public RetalAgreement(int iDRA, Date startDate, Date endDate, int iDG, int iDH, int iDP) {
		this.IDRA = iDRA;
		this.StartDate = startDate;
		this.EndDate = endDate;
		this.IDG = iDG;
		this.IDH = iDH;
		this.IDP = iDP;
	}
	
	public int getIDRA() {
		return IDRA;
	}
	public void setIDRA(int iDRA) {
		IDRA = iDRA;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public int getIDG() {
		return IDG;
	}
	public void setIDG(int iDG) {
		IDG = iDG;
	}
	public int getIDH() {
		return IDH;
	}
	public void setIDH(int iDH) {
		IDH = iDH;
	}
	public int getIDP() {
		return IDP;
	}
	public void setIDP(int iDP) {
		IDP = iDP;
	}
	
	

}
