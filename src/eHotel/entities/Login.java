package eHotel.entities;

public class Login {
	
	private String email;
	private String password;
	private int PID;
	
	public Login(String email, String password,int PID) {
		this.email = email;
		this.password = password;
	}
	
	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
