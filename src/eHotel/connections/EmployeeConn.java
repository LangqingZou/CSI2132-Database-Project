package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Employee;
import eHotel.connections.DBConnect;

public class EmployeeConn extends DBConnect{
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private String sql;
	private ResultSet resultSet = null;
	//private boolean connected = false;
	
	public EmployeeConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();	
	}
	
	public int createEmployee(Employee employee) {
		try {
			//connectDB();
			sql = "insert into project.Employee values(?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getPID());
			//preparedStatement.setInt(2, employee.getEmployID());
			preparedStatement.setString(2, employee.getPosition());
			preparedStatement.setString(3, employee.getSalary());
			ResultSet eidResult = preparedStatement.executeQuery();
			if(eidResult.next()) {
				employee.setPID(eidResult.getInt(1));
			}
			//closeDB();
			return employee.getEmployID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			closeDB();
			return 0;
		}
	}
	
	public boolean findEmployee(Employee employee) {
		try {
			//connectDB();
			sql = "select * from Employee where EmployID = ?";
			preparedStatement = db.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				//closeDB();
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//closeDB();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
