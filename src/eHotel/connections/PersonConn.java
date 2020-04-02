package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.connections.DBConnect;
import eHotel.entities.Person;

public class PersonConn{

	private String sql;
	private Statement st = null;
	private Connection db;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public PersonConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	public int createPerson(Person person) {
		try {
			if(checkPersonExist(person.getEmail())) {
				return 0;
			}
			sql = "insert into project.Person(FirstName,LastName,Address,Email,PhoneNumber,password) values(?,?,?,?,?,?) returning PID";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3,person.getAddress());
			preparedStatement.setString(4, person.getEmail());
			preparedStatement.setString(5, person.getPhoneNumber());
			preparedStatement.setString(6, person.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				person.setPID(resultSet.getInt(1));
			}
			return person.getPID();
		} catch (SQLException e) {
			System.out.println("Person creation error.");
			e.printStackTrace();
			return 0;
		}
				
	}
	
	//return false if no exist
	public boolean checkPersonExist(String email) {
		try {
			sql = "select pid from project.person where email = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				return false;
			}
			return true;
		}catch (SQLException e) {
			System.out.println("Person checking error.");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean checkPwd(String email, String pwdEntered){
		String pwdDB = "";
        try{
        	preparedStatement = db.prepareStatement("select password from project.person where email = ?");
        	preparedStatement.setString(1, email);              
        	resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				pwdDB = resultSet.getString(1);
			}
			System.out.println("Pwd from DB:" + pwdDB + " : " + "Pwd from user:" + pwdEntered);
        }catch(SQLException e){
        	System.out.println("Password checking error.");
            e.printStackTrace();
        }
		return pwdDB.equals(pwdEntered);       
    }
	
//	public boolean findPerson(Person person) {
//		try {
//			sql = "select * from person where PID = ?";
//			preparedStatement = db.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				return true;
//			}
//			return false;
//		} catch (SQLException e) {
//			// Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}s
//	}
}
