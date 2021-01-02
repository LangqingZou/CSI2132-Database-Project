package eHotel.entities;

import java.util.ArrayList;

public class Guest extends Person{
	private int pid;
	private int gid;
	private ArrayList<Agreement> agreementList;
	
	public Guest() {
		super();
		gid = -1;
	}
	
	public Guest(int pid, int gid, String firstName, String lastName, String address, String email, String phone, String password) {
		super(pid, firstName, lastName, address, email, phone, password);
		this.pid = pid;
		this.gid = gid;
	}
	
	public Guest(Person person) {
		super(person.getPID(), person.getFirstName(), 
				person.getLastName(), person.getAddress(), 
				person.getEmail(), person.getPhone(), person.getPassword());
		this.pid = person.getPID();
		this.gid = -1;
	}
	
	public ArrayList<Agreement> getAgreementList(){
		return agreementList;
	}
	
	public void setAgreementList(ArrayList<Agreement> agreementList) {
		this.agreementList = agreementList;
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
