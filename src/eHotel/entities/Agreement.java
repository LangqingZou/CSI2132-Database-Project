package eHotel.entities;

import java.sql.Date;

public class Agreement {
	
	private int raid;
	private int proid;
	private int payid;
	private int gid;
	private int hid;
	private Date startDate;
	private Date endDate;
	private String approve;
	
	public Agreement() {
		this.raid = -1;
		this.proid = -1;
		this.payid = -1;
		this.gid = -1;
		this.hid = -1;
		this.approve = "";
	}
	
	public Agreement(int raid, int proid, int payid, int gid, int hid, Date startDate, Date endDate, String approve) {
		this.raid = raid;
		this.proid = proid;
		this.payid = payid;
		this.gid = gid;
		this.hid = hid;
		this.startDate= startDate;
		this.endDate = endDate;
		this.approve = approve;
	}
	
	public int getRaid() {
		return raid;
	}

	public void setRaid(int raid) {
		this.raid = raid;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
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

	public int getHID() {
		return hid;
	}

	public void setHID(int hid) {
		this.hid = hid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}
}
