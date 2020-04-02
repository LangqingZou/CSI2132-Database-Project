package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Payment;

public class PaymentConn {
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private String sql;
	private ResultSet resultSet = null;
	
	public PaymentConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();		
	}
	
	public int createPayment(Payment pay) {
		try {
			sql = "insert into payment values(?,?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, pay.getIDRA());
			preparedStatement.setInt(2, pay.getIDPAY());
			preparedStatement.setInt(3, pay.getAmount());
			preparedStatement.setString(4, pay.getPaymentType());
			preparedStatement.setString(5, pay.getStatus());
			preparedStatement.setString(6, pay.getApprove());
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean findPayment(Payment pay) {
		try {
			sql = "select * from payment where IDPAY = ?";
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
