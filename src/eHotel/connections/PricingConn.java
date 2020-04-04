package eHotel.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.classfmt.NonNullDefaultAwareTypeAnnotationWalker;

import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;

import eHotel.entities.Pricing;
import eHotel.entities.Property;

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
			sql = "insert into project.Pricing values(?,?,?,?,?) returning prcid";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, property.getHID());
			preparedStatement.setInt(2, property.getPrcid());
			preparedStatement.setString(3, property.getTitle());
			preparedStatement.setString(4, property.getType());
			preparedStatement.setString(5, property.getCountry());
			preparedStatement.setString(6, property.getAddress());
			preparedStatement.setInt(7, property.getNumRoom());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				this.property = property;
				this.property.setProid(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting new property.");
			e.printStackTrace();
		}
		return property.getProid();
	}
	
	public Property getProperty(int proid) {
		try {
			preparedStatement = db.prepareStatement("select * from project.property where proid = ?");
			preparedStatement.setInt(1, proid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				property.setProid(resultSet.getInt(1));
				property.setHID(resultSet.getInt(2));
				property.setPrcid(resultSet.getInt(3));
				property.setTitle(resultSet.getString(4));
				property.setType(resultSet.getString(5));
				property.setCountry(resultSet.getString(6));
				property.setAddress(resultSet.getString(7));
				property.setNumRoom(resultSet.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println("Error while getting property's info.");
			e.printStackTrace();
		}
		return property;
	}
}
