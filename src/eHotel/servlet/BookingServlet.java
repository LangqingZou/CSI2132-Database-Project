package eHotel.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.AgreementConn;
import eHotel.connections.DBConnect;
import eHotel.connections.GuestConn;
import eHotel.connections.HostConn;
import eHotel.connections.PaymentConn;
import eHotel.connections.PersonConn;
import eHotel.connections.PricingConn;
import eHotel.connections.PropertyConn;
import eHotel.connections.ReviewConn;
import eHotel.entities.Agreement;
import eHotel.entities.Guest;
import eHotel.entities.Payment;
import eHotel.entities.Person;
import eHotel.entities.Property;
import eHotel.entities.Review;

@SuppressWarnings({ "serial" })
public class BookingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		PersonConn pConn = new PersonConn(dbConnect);
		GuestConn gConn = new GuestConn(dbConnect);
		HostConn hConn = new HostConn(dbConnect);
		PropertyConn proConn = new PropertyConn(dbConnect);
		PricingConn priConn = new PricingConn(dbConnect);
		PaymentConn payConn = new PaymentConn(dbConnect);
		AgreementConn aConn = new AgreementConn(dbConnect);
		
		ArrayList<Property> allPropertyList = pConn.getAllProperties();
		session.setAttribute("allPropertyList", allPropertyList);

		Person person = (Person) session.getAttribute("loginRole");
		Guest guest = new Guest(person);
		guest.setGID(gConn.getGID(person.getPID()));
		
		//get the property 
		int proid = Integer.parseInt(req.getParameter("bookBtn"));
		Property property = proConn.getProperty(proid);
		
		//create a payment
		Payment newPay = new Payment();
		newPay.setGID(gConn.getGID(person.getPID()));
		System.out.println("gid shown in the payment: " + gConn.getGID(person.getPID()));
		newPay.setAmount(priConn.getPricing(property.getPrcid()).getPrice());
		int payid = payConn.insertNew(newPay);
		
		if(payid != -1){
			//create a rental agreement
			Agreement newAgreement = new Agreement();
			
			DateTimeFormatter format = DateTimeFormatter.ofPattern( "uuuu-MM-dd" ) ;
			LocalDate startDate = LocalDate.parse(req.getParameter("startDate"),format);
			LocalDate endDate = LocalDate.parse(req.getParameter("endDate"),format);
			
			newAgreement.setProid(proid);
			newAgreement.setPayid(payid);
			newAgreement.setGID(guest.getGID());
			newAgreement.setHID(proConn.getProperty(proid).getHID());
			newAgreement.setStartDate(startDate);
			newAgreement.setEndDate(endDate);
			
			if(aConn.insertNew(newAgreement) != -1) {
				session.setAttribute("rentalAgreementGuest", gConn.getRentalAgreementList(guest.getGID()));
				if(session.getAttribute("roleType").equals("host")){
					session.setAttribute("rentalAgreementHost", hConn.getRentalAgreementList(hConn.getHID(person.getPID())));
				}
				session.setAttribute("bookSuccessfully", "true");
				session.setAttribute("agreement", newAgreement);
				resp.sendRedirect("Booking.jsp");
				dbConnect.closeDB();
				return;
			}
		}else{	
			session.setAttribute("failToBook", "true");
			resp.sendRedirect("Booking.jsp");
		}
		dbConnect.closeDB();
	}
}			