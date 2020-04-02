package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.entities.Branch;

public class BranchConn {
	
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private String sql;
	private ResultSet resultSet = null;
	private Statement st = null;
	
	public BranchConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();		
	}
	
	public int createBranch(Branch branch) {
		try {
			sql = "insert into Branch values(?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, branch.getCountry());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean findBranch(Branch branch) {
		try {
			sql = "select * from Branch where country = ?";
			preparedStatement = db.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
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
