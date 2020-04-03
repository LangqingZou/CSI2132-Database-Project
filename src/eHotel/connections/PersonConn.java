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
	private Connection db;
	private Statement st = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public PersonConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	public int createPerson(Person person) {
		try {
			if(checkPersonExist(person.getEmail())) {
				return -1;
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
			return -1;
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
	
	public String[] getInfo(String email){
		String[] info = new String[7];

        try{
        	preparedStatement = db.prepareStatement("select * from project.person where email = ?");
        	preparedStatement.setString(1, email); 
        	resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				for (int index = 0; index < info.length; index++) {
					info[index] = resultSet.getString(index+1);
				}
			}
        }catch(SQLException e){
        	System.out.println("Info getting error.");
            e.printStackTrace();
        }
		return info;       
    }
	
	public int getPID(String email) {
		int pid = 0;
		try {
			preparedStatement = db.prepareStatement("select * from project.person where email = ?");
			preparedStatement.setString(1, email);
	    	resultSet = preparedStatement.executeQuery();
	    	pid = resultSet.getInt(1);
		} catch (SQLException e) {
			System.out.println("PID getting error.");
			e.printStackTrace();
		}
		return pid;
    	
	}
	
	public int getHID(int pid) {
		int hid = 0;
		try {
			preparedStatement = db.prepareStatement("select idh from project.host where pid = ?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			hid = resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hid;
	}
	
	
}
