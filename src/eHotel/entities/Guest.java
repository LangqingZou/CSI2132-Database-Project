package eHotel.entities;

public class Guest extends Person{
	private int pid;
	private int gid;
	
	public Guest() {
		super();
		gid = -1;
	}
	
	public Guest(int pid, int gid, String firstName, String lastName, String address, String email, String phone, String password) {
		super(pid, firstName, lastName, address, email, phone, password);
		this.pid = pid;
		this.gid = gid;
	}
	
	public int getPID() {
		return pid;
	}
	public void setPID(int pid) {
		this.pid = pid;
	}
	public int getGID() {
		return gid;
	}
	public void setGID(int gid) {
		this.gid = gid;
	}
	

}
