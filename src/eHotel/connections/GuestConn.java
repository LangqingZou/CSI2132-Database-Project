package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eHotel.entities.Agreement;
import eHotel.entities.Guest;

public class GuestConn extends PersonConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Guest guest;
	
	/*
	 * Constructor
	 */
	public GuestConn(DBConnect dbConnect) {
		super(dbConnect);
		guest = new Guest();
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get guest's gid from database, return -1 if gid not in guest table
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
			sql = "select * from project.Guest natural join project.Person where gid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, gid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {				
				guest.setPID(resultSet.getInt(1));
				guest.setGID(resultSet.getInt(2));
				guest.setEmail(resultSet.getString(3));
				guest.setPassword(resultSet.getString(4));
				guest.setFirstName(resultSet.getString(5));
				guest.setLastName(resultSet.getString(6));
				guest.setAddress(resultSet.getString(7));
				guest.setPhone(resultSet.getString(8));
				return guest;
			}
		} catch (SQLException e) {
			System.out.println("Error while getting guest's info.");
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * @Description 
	 * 		get agreement list of host with specified hid from database, 
	 * 		return ArrayList with length = 0 if fail to obtain
	 * 
	 * @param int
	 * 
	 * @return ArrayList<RentalAgreement>
	 */
	public ArrayList<Agreement> getRentalAgreementList(int gid) {
		ArrayList<Agreement> agreementList = new ArrayList<Agreement>();
		try {
			preparedStatement = db.prepareStatement("select * from project.RetalAgreement where gid = ?");
			preparedStatement.setInt(1, gid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// [raid, proid, payid, gid, hid, startDate, endDate, approve]
				Agreement agreement = new Agreement();
				if(resultSet.next()) {
					agreement.setRaid(resultSet.getInt(1));
					agreement.setProid(resultSet.getInt(2));
					agreement.setPayid(resultSet.getInt(3));
					agreement.setGID(resultSet.getInt(4));
					agreement.setHID(resultSet.getInt(5));
					agreement.setStartDate(resultSet.getDate(6));
					agreement.setEndDate(resultSet.getDate(7));
					agreement.setApprove(resultSet.getString(8));
				}
				agreementList.add(agreement);
			}
			guest.setAgreementList(agreementList);
		} catch (SQLException e) {
			System.out.println("Error while getting host's rental agreements list.");
			e.printStackTrace();
		}
		return agreementList; 	// length = 0; if no matched agreements
	}
}
