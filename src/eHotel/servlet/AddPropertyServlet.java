package eHotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.HostConn;
import eHotel.connections.PropertyConn;
import eHotel.entities.Property;

public class AddPropertyServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	//handle the http post request
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		String title = req.getParameter("title");
		String address = req.getParameter("address");
		String type = req.getParameter("type");
		String numRoom = req.getParameter("numRoom");
		String country = req.getParameter("country");
		String price = req.getParameter("price");
		
		Property newProperty = new Property(100,);
		if(PropertyConn.insertNew(Property property)) {
			HostConn hConn  = new HostConn(dbConnect);
			PricingConn priConn = new PricingConn(dbConnect);
		}
		PropertyConn propertyConn = new PropertyConn(dbConnect);
		
		
	}
	

}
