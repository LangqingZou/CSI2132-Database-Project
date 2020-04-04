package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.connections.DBConnect;
import eHotel.entities.Person;

public class PersonConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Person person;
	
	/*
	 * Constructor
	 */
	public PersonConn(DBConnect dbConnect) {
		person = new Person();
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get person's pid from database, return -1 if email not in person table
	 * 
	 * @param String
	 * 
	 * @return int
	 */
	public int getPID(String email) {
		try {
			System.out.println(email);
			preparedStatement = db.prepareStatement("select pid from project.person where email = ?");
			preparedStatement.setString(1, email);
	    	resultSet = preparedStatement.executeQuery();
	    	if(resultSet.next()) {
	    		person.setPID(resultSet.getInt(1));
	    	}
		} catch (SQLException e) {
			System.out.println("Error while getting PID.");
			e.printStackTrace();
		}
		return person.getPID();
	}
	
	/*
	 * @Description 
	 * 		Insert new person into database, return false if insertion failed or person already existed
	 * 
	 * @param Person
	 * 
	 * @return boolean
	 */
	public boolean insertNew(Person person) {
		try {
			if(getPID(person.getEmail()) == -1) {
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
					this.person = person;
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new person.");
			e.printStackTrace();
		}
		return false;
	}
		
	/*
	 * @Description 
	 * 		Return the a Person found by the email, return null if the email is invalid
	 * 
	 * @param String
	 * 
	 * @return Person
	 */
	public Person getPerson(String email){
        try{
        	preparedStatement = db.prepareStatement("select * from project.person where email = ?");
        	preparedStatement.setString(1, email); 
        	resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				person.setPID(resultSet.getInt(1));
				person.setEmail(resultSet.getString(2));
				person.setPassword(resultSet.getString(3));
				person.setFirstName(resultSet.getString(4));
				person.setLastName(resultSet.getString(5));
				person.setAddress(resultSet.getString(6));
				person.setPhone(resultSet.getString(7));
			}
        }catch(SQLException e){
        	System.out.println("Error while getting person.");
            e.printStackTrace();
            return null;
        }
		return person;       
    }	
}