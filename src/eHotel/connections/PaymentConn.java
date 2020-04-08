package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Payment;

public class PaymentConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Payment payment;
	
	public PaymentConn(DBConnect dbConnect) {
		payment = new Payment();
		db = dbConnect.getConnection();	
	}
	
	public int insertNew(Payment payment) {
		try {
			sql = "insert into project.Payment(gid,amount,payType,status) values(?,?,?,?) returning payid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, payment.getGID());
			preparedStatement.setInt(2, payment.getAmount());
			preparedStatement.setString(3, payment.getPayType());
			preparedStatement.setString(4, payment.getStatus());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.payment = payment;
				this.payment.setPayid(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new payment.");
			e.printStackTrace();
		}
		return payment.getPayid();
	}
	
	public Payment getPayment(int payid) {
		try {
			preparedStatement = db.prepareStatement("select * from project.Payment where payid = ?");
			preparedStatement.setInt(1, payid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				payment.setPayid(resultSet.getInt(1));
				payment.setGID(resultSet.getInt(2));
				payment.setAmount(resultSet.getInt(3));
				payment.setPayType(resultSet.getString(4));
				payment.setStatus(resultSet.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Error while getting payment's info.");
			e.printStackTrace();
		}
		return payment;
	}
	
	public Boolean onPay(int payid, String payType) {
		try {
			System.out.println(payid);
			preparedStatement = db.prepareStatement("update project.Payment set status=?,payType=? where payid = ?");
			preparedStatement.setString(1, "paid");
			preparedStatement.setString(2, payType);
			preparedStatement.setInt(3, payid);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Error while updating payment.");
			e.printStackTrace();
		}
		return false;
	}
}
