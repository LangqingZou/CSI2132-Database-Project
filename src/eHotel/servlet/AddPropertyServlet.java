package eHotel.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.HostConn;
import eHotel.connections.PricingConn;
import eHotel.connections.PropertyConn;
import eHotel.entities.Host;
import eHotel.entities.Person;
import eHotel.entities.Pricing;
import eHotel.entities.Property;

public class AddPropertyServlet extends HttpServlet{
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
		String rule = req.getParameter("rule");
		String amenity = req.getParameter("amenity");
		
		//create new property
		PropertyConn proConn = new PropertyConn(dbConnect);
		Property newProperty = new Property();
		newProperty.setTitle(title);
		newProperty.setAddress(address);
		newProperty.setType(type);
		newProperty.setNumRoom(Integer.parseInt(numRoom));
		newProperty.setCountry(country);
		
		//create new pricing
		PricingConn priConn = new PricingConn(dbConnect);
		Pricing newPricing = new Pricing();
		newPricing.setPrice(Integer.parseInt(price));
		newPricing.setRule(rule);
		newPricing.setAmenity(amenity);
		
		int prcid = priConn.insertNew(newPricing);
		if(prcid != -1) {
			//add prcid to the new property
			newProperty.setPrcid(prcid);
			// check login role type
			String roleType = (String) session.getAttribute("roleType");
			if(roleType.equals("host")) {
				Host host = (Host) session.getAttribute("loginRole");
				newProperty.setHID(host.getHID());
			}else{
				HostConn hConn  = new HostConn(dbConnect);
				Person person = (Person) session.getAttribute("loginRole");
				Host newHost = new Host(person);
				if(hConn.insertNew(newHost.getPID())) {
					newHost.setHID(hConn.getHID(newHost.getPID()));
					newProperty.setHID(newHost.getHID());
					session.setAttribute("roleType", "host");
				}
			}
			int proid = proConn.insertNew(newProperty);
			if(proid != -1) {
				session.setAttribute("addSuccessfully", "true");
				resp.sendRedirect("Booking.jsp");
				dbConnect.closeDB();
				return;
			}
		}
		session.setAttribute("PropertyFail", "true");
		resp.sendRedirect("AddProperty.jsp");
		dbConnect.closeDB();
	}

}
