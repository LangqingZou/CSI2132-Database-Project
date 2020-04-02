package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Review;

public class ReviewConn {
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	
	public ReviewConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();			
	}
	
	public int createReview(Review review) {
		try {
			sql = "insert into review values(?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, review.getIDR());
			preparedStatement.setInt(2, review.getRating());
			preparedStatement.setInt(3, review.getCommunication());
			preparedStatement.setInt(4, review.getCleanliness());
			preparedStatement.setInt(5, review.getReValue());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean findReview(Review review) {
		try {
			sql = "select * from review where IDR = ?";
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
