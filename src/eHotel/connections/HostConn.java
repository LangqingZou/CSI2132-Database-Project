package eHotel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import eHotel.entities.Guest;
import eHotel.entities.Host;

public class HostConn implements DBRequest {
	
	private String sql;
	private Connection db;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	/*
	 * Constructor
	 */
	public HostConn(DBConnect dbConnect) {
		db = dbConnect.getConnection();
	}
	
	/*
	 * @Description 
	 * 		Get person's PID from database, return -1 if email not in person table
	 * 
	 * @param String
	 * 
	 * @return int
	 */
	public int getID(int pid) {
		int hid = -1;
		try {
			preparedStatement = db.prepareStatement("select hid from project.host where pid = ?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			hid = resultSet.getInt(1);
		} catch (SQLException e) {
			System.out.println("Error while getting hid.");
			e.printStackTrace();
		}
		return hid;
	}
	
	public int createHost(Host host) {
		try {
			sql = "insert into project.host(PID) values(?) returning IDH";
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, host.getPID());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				host.setIDH(resultSet.getInt(1));
			}
			return host.getIDH();
		} catch (SQLException e) {
			System.out.println("Error while inserting new host.");
			e.printStackTrace();
			return 0;
		}
		
	}
	

	public ArrayList<String[]> getPropertyList(int hid) {
		ArrayList<String[]> propertyList = new ArrayList<String[]>();
		try {
			preparedStatement = db.prepareStatement("select * from project.property where IDH = ?");
			preparedStatement.setInt(1, hid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String[] property = new String[7];
				for(int i=0;i<property.length;i++) {
					property[i] = resultSet.getString(i);
				}
				propertyList.add(property);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return propertyList;
	}
	
	public int getHID(int pid) {
		int hid = 0;
		try {
			preparedStatement = db.prepareStatement("select idh from project.host where pid = ?");
			preparedStatement.setInt(1, pid);
			resultSet = preparedStatement.executeQuery();
			hid = resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hid;
	}
	
	public int getIdraFromRetalAgreement(int hid) {
		int idra = 0;
		try {
			preparedStatement = db.prepareStatement("select idra from project.retalAgreement where hid = ?");
			preparedStatement.setInt(1, hid);
			resultSet = preparedStatement.executeQuery();
			idra = resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idra;
	}
	
	public int getIdprFromRetalAgreement(int idra) {
		int idpr = 0;
		try {
			preparedStatement = db.prepareStatement("select idra from project.retalAgreement where hid = ?");
			preparedStatement.setInt(1, idra);
			resultSet = preparedStatement.executeQuery();
			idra = resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idpr;
	}
}
