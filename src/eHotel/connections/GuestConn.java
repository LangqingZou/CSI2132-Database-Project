package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Guest;

public class GuestConn{
	private Connection db;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	public GuestConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	public int createGuest(Guest guest) {
		try {
			sql = "insert into project.Guest(PID) values(?) returning IDG";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, guest.getPID());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				guest.setIDG(resultSet.getInt(1));
			}
			return guest.getIDG();
		} catch (SQLException e) {
			System.out.println("Guest creation error.");
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean findGuest(Guest guest) {
		try {
			sql = "select * from project.Guest where IDG = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, guest.getIDG());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
