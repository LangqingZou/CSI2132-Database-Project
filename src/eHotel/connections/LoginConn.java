package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eHotel.connections.DBConnect;
import eHotel.entities.Login;

public class LoginConn{

	private String sql;
	private Statement st = null;
	private Connection db;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	//private boolean connected = false;
	
	public LoginConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	public int insertLoginInfo(Login login) {
		try {
			//connectDB();
			sql = "insert into project.login(email,password) values(?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			// String resultpassword == preparedStatement.executeQuery();
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Obtain password error.");
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	public int createLogin(Login login) {
		try {
			sql = "insert into project.Login(email,password) values(?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
				
	}
	
	public ResultSet checkLoginPassword(String email) {
		try {
			sql = "select password from project.login where email = ?";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, email);
			//String resultpassword = = preparedStatement.executeQuery();
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String[] getuserinforbycustSSN(String param){
		String[] pwd = new String[2];
		
        try{
        	preparedStatement = db.prepareStatement("select * from ehotel.customer where customer_ssn=?");
            
        	preparedStatement.setString(1, param);	               
        	resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				pwd[0] = resultSet.getString(2);
				pwd[1] = resultSet.getString(3);
			}
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
        	closeDB();
        }
		return pwd;       
    }*/
    
}
