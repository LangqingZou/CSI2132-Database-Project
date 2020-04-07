package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Review;

public class ReviewConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Review review;
	
	public ReviewConn(DBConnect dbConnect) {
		review = new Review();
		db = dbConnect.getConnection();	
	}
	
	public int insertNew(Review review) {
		try {
			sql = "insert into project.Review values(?,?,?,?,?,?) returning reid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, review.getProid());
			preparedStatement.setInt(2, review.getGID());
			preparedStatement.setInt(3, review.getRating());
			preparedStatement.setInt(4, review.getCommunication());
			preparedStatement.setInt(5, review.getCleaniliness());
			preparedStatement.setInt(6, review.getValue());
			preparedStatement.setString(7, review.getComment());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.review = review;
				this.review.setReid(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new review.");
			e.printStackTrace();
		}
		return review.getReid();
	}
	
	public Review getReview(int reid) {
		try {
			preparedStatement = db.prepareStatement("select * from project.Review where reid = ?");
			preparedStatement.setInt(1, reid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				review.setReid(resultSet.getInt(1));
				review.setGID(resultSet.getInt(2));
				review.setRating(resultSet.getInt(3));
				review.setCommunication(resultSet.getInt(4));
				review.setCleaniliness(resultSet.getInt(5));
				review.setValue(resultSet.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("Error while getting review's info.");
			e.printStackTrace();
		}
		return review;
	}
}
