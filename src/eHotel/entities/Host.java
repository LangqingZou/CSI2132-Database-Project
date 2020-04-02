package eHotel.entities;

public class Host {
	private int PID;
	private int IDH;
	
	public Host(int PID, int IDH) {
		this.PID = PID;
		this.IDH = IDH;
	}
	
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public int getIDH() {
		return IDH;
	}
	public void setIDH(int iDH) {
		IDH = iDH;
	}
	

}