package eHotel.entities;

public class Employee extends Person {
	private int pid;
	private int eid;
	private int salary;
	private String position;
	
	public Employee(int pid, int eid, String firstName, String lastName, String address, String email, String phone, String password, String position, int salary) {
		super(pid, firstName, lastName, address, email, phone, password);
		this.pid = pid;
		this.eid = eid;
		this.salary = salary;
		this.position = position;
	}
	
	public int getPID() {
		return pid;
	}
	
	public void setPID(int pid) {
		this.pid = pid;
	}
	
	public int getEID() {
		return eid;
	}
	
	public void setEID(int eid) {
		this.eid = eid;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
}
