package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import eHotel.entities.Agreement;

public class AgreementConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Agreement agreement;
	
	public AgreementConn(DBConnect dbConnect) {
		agreement = new Agreement();
		db = dbConnect.getConnection();	
	}
	
	public int insertNew(Agreement agreement) {
		try {
			sql = "insert into project.RentalAgreement(proid,payid,gid,hid,startDate,endDate,approve) values(?,?,?,?,?,?,?) returning raid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, agreement.getProid());
			preparedStatement.setInt(2, agreement.getPayid());
			preparedStatement.setInt(3, agreement.getGID());
			preparedStatement.setInt(4, agreement.getHID());
			preparedStatement.setObject(5, agreement.getStartDate());
			preparedStatement.setObject(6, agreement.getEndDate());
			preparedStatement.setString(7, agreement.getApprove());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.agreement = agreement;
				this.agreement.setRaid(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new agreement.");
			e.printStackTrace();
		}
		return agreement.getRaid();
	}
	
	public Agreement getAgreement(int raid) {
		try {
			preparedStatement = db.prepareStatement("select * from project.RentalAgreement where raid = ?");
			preparedStatement.setInt(1, raid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				agreement.setRaid(resultSet.getInt(1));
				agreement.setProid(resultSet.getInt(2));
				agreement.setPayid(resultSet.getInt(3));
				agreement.setGID(resultSet.getInt(4));
				agreement.setHID(resultSet.getInt(5));
				agreement.setStartDate(resultSet.getObject(6, LocalDate.class));
				agreement.setEndDate(resultSet.getObject(7, LocalDate.class));
				agreement.setApprove(resultSet.getString(8));
			}
		} catch (SQLException e) {
			System.out.println("Error while getting agreement's info.");
			e.printStackTrace();
		}
		return agreement;
	}
}
