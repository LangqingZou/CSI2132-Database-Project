package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Guest;

public class GuestConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Guest guest;
	
	/*
	 * Constructor
	 */
	public GuestConn(DBConnect dbConnect) {
		guest = new Guest();
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get guest's GID from database, return -1 if email not in guest table
	 * 
	 * @param int
	 * 
	 * @return int
	 */
	public int getGID(int pid) {
		try {
			preparedStatement = db.prepareStatement("select gid from project.guest where pid = ?");
			preparedStatement.setInt(1, pid);
	    	resultSet = preparedStatement.executeQuery();
	    	if (resultSet.next()) {
	    		guest.setGID(resultSet.getInt(1));
	    		guest.setPID(pid);
	    	}
		} catch (SQLException e) {
			System.out.println("Error while getting GID.");
			e.printStackTrace();
		}
		return guest.getGID();
	}
	
	/*
	 * @Description 
	 * 		Insert new guest into database, return false if insertion failed
	 * 
	 * @param Guest
	 * 
	 * @return boolean
	 */
	public boolean insertNew(int pid) {
		try {
			sql = "insert into project.Guest(pid) values(?) returning gid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				guest.setGID(resultSet.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new guest.");
			e.printStackTrace();
		}	
		return false;
	}
	
	/*
	 * @Description 
	 * 		Return the a Guest found by the gid, return null if the gid is invalid
	 * 
	 * @param int
	 * 
	 * @return Guest
	 */
	public Guest getGuest(int gid) {
		try {
			sql = "select * from project.Guest where gid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, gid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {				
				guest.setPID(resultSet.getInt(1));
				guest.setGID(resultSet.getInt(2));
				guest.setEmail(resultSet.getString(3));
				guest.setFirstName(resultSet.getString(4));
				guest.setLastName(resultSet.getString(5));
				guest.setAddress(resultSet.getString(6));
				guest.setPhone(resultSet.getString(7));
				return guest;
			}
		} catch (SQLException e) {
			System.out.println("Error while getting guest's info.");
			e.printStackTrace();
		}
		return null;
	}
}
