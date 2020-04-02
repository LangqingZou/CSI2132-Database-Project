package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Guest;
import eHotel.entities.Host;

public class HostConn extends DBConnect{
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	
	
	//private boolean connected = false;
	
	public HostConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	public int createHost(Host host) {
		try {
			//connectDB();
			sql = "insert into project.host(PID) values(?) returning IDH";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, host.getPID());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				host.setIDH(resultSet.getInt(1));
			}
			//closeDB();
			return host.getIDH();
		} catch (SQLException e) {
			System.out.println("Host creation error.");
			e.printStackTrace();
			return 0;
		}
		
	}
	
//	public boolean findHost(Host host) {
//		try {
//			connectDB();
//			sql = "select * from host where IDH = ?";
//			preparedStatement = getDB().prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				closeDB();
//				return true;
//			}
//			closeDB();
//			return false;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	public static void main(String[] args) {
//		HostConn hostconn = new HostConn();
//		Host h = new Host (20, 1000);
//		System.out.println(hostconn.createHost(h));
//		hostconn.closeDB();
//	}
}
