package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eHotel.entities.Employee;
import eHotel.connections.DBConnect;

public class EmployeeConn extends PersonConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	private Employee employee;
	
	/*
	 * Constructor
	 */
	public EmployeeConn(DBConnect dbConnect) {
		super(dbConnect);
		employee = new Employee();
	}
	
	/*
	 * @Description 
	 * 		Get person's EID from database, return -1 if pid not in Employee table
	 * 
	 * @param int
	 * 
	 * @return int
	 */
	public int getEID(int pid) {
		try {
			preparedStatement = db.prepareStatement("select eid from project.Employee where pid = ?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
	    		employee.setEID(resultSet.getInt(1));
	    		employee.setPID(pid);
	    	}
		} catch (SQLException e) {
			System.out.println("Error while getting eid.");
			e.printStackTrace();
		}
		return employee.getEID();
	}
	
	/*
	 * @Description 
	 * 		Insert new employee into database, return false if insertion failed
	 * 
	 * @param int
	 * 
	 * @return boolean
	 */
	public boolean insertNew(int pid, String position, int salary, String country) {
		try {
			sql = "insert into project.Employee(pid,position,salary,country) values(?,?,?,?) returning eid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			preparedStatement.setString(2, position);
			preparedStatement.setInt(1, salary);
			preparedStatement.setString(1, country);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee.setEID(resultSet.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new employee.");
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * @Description 
	 * 		Return the an Employee found by the eid, return null if the eid is invalid
	 * 
	 * @param String
	 * 
	 * @return Employee
	 */
	public Employee getEmployee(int eid) {
		try {
			sql = "select * from project.employee natural join project.Person where eid = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, eid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				employee.setPID(resultSet.getInt(1));
				employee.setEID(resultSet.getInt(2));
				employee.setPosition(resultSet.getString(3));
				employee.setSalary(resultSet.getInt(4));
				employee.setEmail(resultSet.getString(3));
				employee.setPassword(resultSet.getString(4));
				employee.setFirstName(resultSet.getString(5));
				employee.setLastName(resultSet.getString(6));
				employee.setAddress(resultSet.getString(7));
				employee.setPhone(resultSet.getString(8));
				return employee;
			}
		} catch (SQLException e) {
			System.out.println("Error while getting guest's info.");
			e.printStackTrace();
		}
		return null;
	}
}
