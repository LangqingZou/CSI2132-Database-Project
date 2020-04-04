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
		String roleType = (String) session.getAttribute("roleType");
		int pid = (int) session.getAttribute("pid");
		
		String title = req.getParameter("title");
		String address = req.getParameter("address");
		String type = req.getParameter("type");
		String numRoom = req.getParameter("numRoom");
		String country = req.getParameter("country");
		String price = req.getParameter("price");
		String rule = req.getParameter("rule");
		String amenity = req.getParameter("amenity");
		
		Property newProperty = new Property();
		PropertyConn prConn = new PropertyConn(dbConnect);

		newProperty.setTitle(title);
		newProperty.setAddress(address);
		newProperty.setType(type);
		newProperty.setNumRoom(Integer.parseInt(numRoom));
		newProperty.setCountry(country);
		
		//create a property
		if(prConn.insertNew(newProperty)!= -1) {
			HostConn hConn  = new HostConn(dbConnect);
			if(roleType == "host") {
				Host host = (Host) session.getAttribute("loginRole");
				newProperty.setHID(host.getHID());
			}else{
				Host newHost = new Host();
				if(hConn.insertNew(pid)) {
					newHost = hConn.getHost(hConn.getHID(pid));
					newProperty.setHID(newHost.getHID());
				}else {
					session.setAttribute("PrpertyFail", "true");
					resp.sendRedirect("add.jsp");
				}
			}
			session.setAttribute("price", price);
			//create a pricing
			Pricing newPricing = new Pricing();
			PricingConn priConn = new PricingConn(dbConnect);
			int prcid = priConn.insertNew(newPricing);
			//add prcid to the new property
			newProperty.setPrcid(prcid);
			
			newPricing.setPrice(Integer.parseInt(price));
			newPricing.setRule(rule);
			newPricing.setAmenity(amenity);
			if(priConn.insertNew(newPricing)!=-1) {
				session.setAttribute("addSuccessfully", "true");
			}
			
		}else {
			session.setAttribute("PrpertyFail", "true");
			resp.sendRedirect("add.jsp");
		}
		
		dbConnect.closeDB();
	}

}
