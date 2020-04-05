package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Pricing;

public class PricingConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Pricing pricing;
	
	public PricingConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();	
	}
	
	public int insertNew(Pricing pricing) {
		try {
			sql = "insert into project.Pricing(price,rule,amenity) values(?,?,?) returning prcid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, pricing.getPrice());
			preparedStatement.setString(2, pricing.getRule());
			preparedStatement.setString(3, pricing.getAmenity());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.pricing = pricing;
				this.pricing.setPrcid(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new pricing.");
			e.printStackTrace();
		}
		return pricing.getPrcid();
	}
	
	public Pricing getPricing(int prcid) {
		try {
			preparedStatement = db.prepareStatement("select * from project.Pricing where prcid = ?");
			preparedStatement.setInt(1, prcid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				pricing.setPrcid(resultSet.getInt(1));
				pricing.setPrice(resultSet.getInt(2));
				pricing.setRule(resultSet.getString(3));
				pricing.setAmenity(resultSet.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Error while getting pricing's info.");
			e.printStackTrace();
		}
		return pricing;
	}
}
