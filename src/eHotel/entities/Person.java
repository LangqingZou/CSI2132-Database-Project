package eHotel.entities;

public class Person {
	private int PID;
	private String FirstName;
	private String LastName;
	private String Address;
	private String Email;
	private String PhoneNumber;
	private String password;
	
	
	public Person(int PID, String FirstName, String LastName, String Address, String Email,String PhoneNumber,String password) {
		this.PID = PID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Address = Address;
		this.Email = Email;
		this.PhoneNumber = PhoneNumber;
		this.password = password;
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	

}
