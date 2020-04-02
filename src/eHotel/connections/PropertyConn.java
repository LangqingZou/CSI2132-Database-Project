package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Property;

public class PropertyConn {
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	
	public PropertyConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();	
	}
	
	public int createProperty(Property property) {
		try {
			sql = "insert into property values(?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, property.getIDP());
			preparedStatement.setString(2, property.getAddress());
			preparedStatement.setString(3, property.getPropertyType());
			preparedStatement.setString(4, property.getTitle());
			preparedStatement.setString(5, property.getCountry());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean findProperty(Property property) {
		try {
			sql = "select * from property where IDP = ?";
			preparedStatement = db.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
