package eHotel.entities;

public class Host extends Person{
	private int pid;
	private int hid;
	
	public Host() {
		super();
		hid = -1;
	}
	
	public Host(int pid, int hid, String firstName, String lastName, String address, String email, String phone, String password) {
		super(pid, firstName, lastName, address, email, phone, password);
		this.pid = pid;
		this.hid = hid;
	}
	
	public int getPID() {
		return pid;
	}
	public void setPID(int pid) {
		this.pid = pid;
	}
	public int getIDH() {
		return hid;
	}
	public void setIDH(int hid) {
		this.hid = hid;
	}
}