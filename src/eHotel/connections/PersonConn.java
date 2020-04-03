package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.connections.DBConnect;
import eHotel.entities.Person;

public class PersonConn implements DBRequest{
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	/*
	 * Constructor
	 */
	public PersonConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get person's PID from database, return -1 if email not in person table
	 * 
	 * @param String
	 * 
	 * @return int
	 */
	public int getID(String email) {
		int pid = -1;
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
	
	/*
	 * @Description 
	 * 		Insert new person in to database, return -1 if insertion failed
	 * 
	 * @param Person
	 * 
	 * @return int
	 */
	public int insertNew(Person person) {
		try {
			if(checkExistence(person.getEmail())) {
				return -1;
			}
			sql = "insert into project.Person(email,password,firstName,lastName,address,phone) values(?,?,?,?,?,?) returning pid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, person.getEmail());
			preparedStatement.setString(2, person.getPassword());
			preparedStatement.setString(3, person.getFirstName());
			preparedStatement.setString(4, person.getLastName());
			preparedStatement.setString(5,person.getAddress());
			preparedStatement.setString(6, person.getPhone());

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				person.setPID(resultSet.getInt(1));
			}
			return person.getPID();
		} catch (SQLException e) {
			System.out.println("Error while inserting new person.");
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * @Description 
	 * 		Check the existence of the entered email in database, return false if the email already exist
	 * 
	 * @param String
	 * 
	 * @return boolean
	 */
	public boolean checkExistence(String email) {
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
			System.out.println("Error while checking person existence.");
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * @Description 
	 * 		Return the info of the entered email in database, return null if the email is invalid
	 * 
	 * @param String
	 * 
	 * @return String[]
	 */
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
        	System.out.println("Person info getting error.");
            e.printStackTrace();
        }
		return info;       
    }	
}