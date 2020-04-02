package eHotel.entities;

public class Guest {
	private int PID;
	private int IDG;
	
	public Guest(int PID, int IDG) {
		this.PID = PID;
		this.IDG = IDG;
	}
	
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public int getIDG() {
		return IDG;
	}
	public void setIDG(int iDG) {
		IDG = iDG;
	}
	

}
