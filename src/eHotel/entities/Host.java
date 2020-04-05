package eHotel.entities;

import java.util.ArrayList;

public class Host extends Person{
	private int pid;
	private int hid;
	private ArrayList<Agreement> agreementList;
	private ArrayList<Property> propertyList;
	
	public Host() {
		super();
		hid = -1;
	}
	
	public Host(int pid, int hid, String firstName, String lastName, String address, String email, String phone, String password) {
		super(pid, firstName, lastName, address, email, phone, password);
		this.pid = pid;
		this.hid = hid;
	}
	
	public Host(Person person) {
		super(person.getPID(), person.getFirstName(), 
				person.getLastName(), person.getAddress(), 
				person.getEmail(), person.getPhone(), person.getPassword());
		this.pid = person.getPID();
		this.hid = -1;
	}
	
	public ArrayList<Agreement> getAgreementList(){
		return agreementList;
	}
	
	public void setAgreementList(ArrayList<Agreement> agreementList) {
		this.agreementList = agreementList;
	}
	
	public ArrayList<Property> getPropertyList(){
		return propertyList;
	}
	
	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	public int getPID() {
		return pid;
	}
	
	public void setPID(int pid) {
		this.pid = pid;
	}
	
	public int getHID() {
		return hid;
	}
	
	public void setHID(int hid) {
		this.hid = hid;
	}
}