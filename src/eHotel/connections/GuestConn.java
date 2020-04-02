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
	
	//private boolean connected = false;
	
	public GuestConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
//	public void closeDB() {
//		try {
//			if(resultSet != null){
//				resultSet.close();
//			}
//			if(preparedStatement!=null){
//				preparedStatement.close();
//			}
//			if(st!=null){
//				st.close();
//			}
//			if(db!=null){
//				db.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public int createGuest(Guest guest) {
		try {
			//connectDB();
			sql = "insert into project.Guest(PID) values(?) returning IDG";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, guest.getPID());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				guest.setIDG(resultSet.getInt(1));
				// System.out.println(guest.getIDG() + " " + guest.getPID());
			}
			//closeDB();
			return guest.getIDG();
		} catch (SQLException e) {
			System.out.println("Guest creation error.");
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean findGuest(Guest guest) {
		try {
			//connectDB();
			sql = "select * from project.Guest where IDG = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, guest.getIDG());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				//closeDB();
				return true;
			}
			//closeDB();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		GuestConn guestconn = new GuestConn();
//		Guest g = new Guest (10,1000000);
//		System.out.println(guestconn.createGuest(g));
//		guestconn.closeDB();
//	}
}
