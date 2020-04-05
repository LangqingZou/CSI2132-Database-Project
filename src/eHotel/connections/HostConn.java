package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eHotel.entities.Host;
import eHotel.entities.Property;
import eHotel.entities.Agreement;

public class HostConn extends PersonConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Host host;
	
	/*
	 * Constructor
	 */
	public HostConn(DBConnect dbConnect) {
		super(dbConnect);
		host = new Host();
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get person's HID from database, return -1 if pid not in Host table
	 * 
	 * @param int
	 * 
	 * @return int
	 */
	public int getHID(int pid) {
		try {
			preparedStatement = db.prepareStatement("select hid from project.Host where pid = ?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
	    		host.setHID(resultSet.getInt(1));
	    		host.setPID(pid);
	    		
	    	}
		} catch (SQLException e) {
			System.out.println("Error while getting hid.");
			e.printStackTrace();
		}
		return host.getHID();
	}
	
	/*
	 * @Description 
	 * 		Insert new host into database, return false if insertion failed
	 * 
	 * @param Host
	 * 
	 * @return boolean
	 */
	public boolean insertNew(int pid) {
		try {
			sql = "insert into project.Host(pid) values(?) returning hid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				host.setHID(resultSet.getInt(1));
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Error while inserting new host.");
			e.printStackTrace();
			return false;
		}	
	}
	
	/*
	 * @Description 
	 * 		Return the a Host found by the hid, return null if the hid is invalid
	 * 
	 * @param int
	 * 
	 * @return Host
	 */
	public Host getHost(int hid) {
		try {
			sql = "select * from project.Host natural join project.Person where hid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, hid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				host.setPID(resultSet.getInt(1));
				host.setHID(resultSet.getInt(2));
				host.setEmail(resultSet.getString(3));
				host.setPassword(resultSet.getString(4));
				host.setFirstName(resultSet.getString(5));
				host.setLastName(resultSet.getString(6));
				host.setAddress(resultSet.getString(7));
				host.setPhone(resultSet.getString(8));
				return host;
			}
		} catch (SQLException e) {
			System.out.println("Error while getting host's info.");
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
	public ArrayList<Agreement> getRentalAgreementList(int hid) {
		ArrayList<Agreement> agreementList = new ArrayList<Agreement>();
		try {
			preparedStatement = db.prepareStatement("select * from project.RetalAgreement where hid = ?");
			preparedStatement.setInt(1, hid);
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
			host.setAgreementList(agreementList);
		} catch (SQLException e) {
			System.out.println("Error while getting host's rental agreements list.");
			e.printStackTrace();
		}
		return agreementList; 	// length = 0; if no matched agreements
	}
	
	/*
	 * @Description 
	 * 		get property list of host with specified hid from database, 
	 * 		return ArrayList with length = 0 if fail to obtain
	 * 
	 * @param int
	 * 
	 * @return ArrayList<Property>
	 */
	public ArrayList<Property> getPropertyList(int hid) {
		ArrayList<Property> propertyList = new ArrayList<Property>();
		try {
			preparedStatement = db.prepareStatement("select * from project.Property where hid = ?");
			preparedStatement.setInt(1, hid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// [proid, hid, prcid, title, type, country, address, numRoom]
				Property property = new Property();
				property.setProid(resultSet.getInt(1));
				property.setHID(resultSet.getInt(2));
				property.setPrcid(resultSet.getInt(3));
				property.setTitle(resultSet.getString(4));
				property.setType(resultSet.getString(5));
				property.setCountry(resultSet.getString(6));
				property.setAddress(resultSet.getString(7));
				property.setNumRoom(resultSet.getInt(8));
				propertyList.add(property);
			}
			host.setPropertyList(propertyList);
		} catch (SQLException e) {
			System.out.println("Error while getting host's rental agreements list.");
			e.printStackTrace();
		}
		return propertyList;	// length = 0; if no matched properties
	}
}
