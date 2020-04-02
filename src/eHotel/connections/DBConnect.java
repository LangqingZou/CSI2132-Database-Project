package eHotel.connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	private Connection db;
	private PreparedStatement preparedStatement = null;
	private Statement st = null;
	private ResultSet resultSet = null;
	
	public DBConnect() {
		try {
			Class.forName("org.postgresql.Driver"); 
			db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/lzou041" , "lzou041", "N6ryg6rfgz");
			// System.out.println("Server connected!");											
		}catch(Exception e) {
			System.out.println("Server connection error.");
			e.printStackTrace();
			closeDB();
		}
	}
	
	public Connection getConnection() {return db;}
	
	public void closeDB() {
		try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement!=null) preparedStatement.close();
			if(st!=null) st.close();
			if(db!=null) db.close();
		} catch (SQLException e) {
			System.out.println("Server closing error.");
			e.printStackTrace();
		}
	}
}
