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

import eHotel.entities.Property;

public class PropertyConn {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	public PropertyConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();	
	}
	
	public int createProperty(Property property) {
		try {
			sql = "insert into property values(?,?,?,?,?)";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, property.getIDP());
			preparedStatement.setString(2, property.getAddress());
			preparedStatement.setString(3, property.getPropertyType());
			preparedStatement.setString(4, property.getTitle());
			preparedStatement.setString(5, property.getCountry());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean findProperty(Property property) {
		try {
			sql = "select * from property where IDP = ?";
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
	
	public String[] getpropertyInfo(int idpr) {
		String[] propertyInfo = new String[7];
		try {
			preparedStatement = db.prepareStatement("select * from project.property where IDH = ?");
			preparedStatement.setInt(1, idpr);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				for(int i = 0;i<propertyInfo.length;i++) {
					propertyInfo[i] = resultSet.getString(i);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyInfo;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
