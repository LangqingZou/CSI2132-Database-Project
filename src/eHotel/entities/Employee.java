package eHotel.entities;

public class Employee {
	private int PID;
	private int EmployID;
	private String Position;
	private String Salary;
	
	public Employee(int PID, int EmployID, String Position, String Salary) {
		this.PID = PID;
		this.EmployID = EmployID;
		this.Position = Position;
		this.Salary = Salary;
	}
	
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public int getEmployID() {
		return EmployID;
	}
	public void setEmployID(int employID) {
		EmployID = employID;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}


}
