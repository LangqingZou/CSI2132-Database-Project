package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.RentalAgreement;

public class AgreementConn {
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	
	public AgreementConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();			
	}

	public int createRetalAgreement(RentalAgreement ra) {
		try {
			sql = "insert into RetalAgreement values(?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, ra.getIDRA());
			preparedStatement.setDate(2, ra.getStartDate());
			preparedStatement.setDate(3, ra.getEndDate());
			preparedStatement.setInt(4, ra.getIDG());
			preparedStatement.setInt(5, ra.getIDH());
			preparedStatement.setInt(6, ra.getIDP());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean findRetalAgreement(RentalAgreement ra) {
		try {
			sql = "select * from RetalAgreement where IDRA = ?";
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
