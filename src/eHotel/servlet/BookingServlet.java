package eHotel.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.GuestConn;
import eHotel.connections.PropertyConn;
import eHotel.connections.ReviewConn;
import eHotel.entities.Agreement;
import eHotel.entities.Payment;
import eHotel.entities.Pricing;
import eHotel.entities.Property;
import eHotel.entities.Review;

public class BookingServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		int proid = (int) session.getAttribute("propertyID");
		int pid = (int) session.getAttribute("pid");
		Date startDate = req.getParameter("startDate");
		Date endSDate = req.getParameter("endDate");
		String approve = session.getAttribute("approve");
		GuestConn gConn = new GuestConn(dbConnect);
		PropertyConn pConn = new PropertyConn(dbConnect);
		
		
		Payment newPay = new Payment();
		int payid = newPay.getID();
		int gid = gConn.getGID(pid);
		Property property = pConn.getProperty(proid);
		int hid = property.getHID();
		
		//create a rental Agreement
		Agreement newAgreement = new Agreement();
		newAgreement.setProid(proid);
		newAgreement.setPayid(payid);
		newAgreement.setGID(gid);
		newAgreement.setHID(hid);
		newAgreement.setStartDate(startDate);
		newAgreement.setEndDate(endDate);
		newAgreement.setApprove(approve);
		session.setAttribute("Agreement", newAgreement);
		
		//create a payment
		PricingConn priConn = new PricingConn();
		int amount = (int) session.getAttribute("price");
		String payType = session.getAttribute("payType");
		String status = session.getAttribute("status");
		Payment newPay = new Payment();
		newPay.setGid(gid);
		newPay.setAmount(amount);
		newPay.setPayType(payType);
		newPay.setStatus(status);
		session.setAttribute("payment", newPay);
		
		//create a review
		ReviewConn rConn = new ReviewConn(dbConnect);
		Review newReview = new Review();
		newReview.setProid(proid);
		newReview.setGid(gid);
//		newReview.setRating(rating);
//		newReview.setCommunication(communication);
//		newReview.setCleaniliness(cleaniliness);
//		newReview.setValue(value);
		session.setAttribute("review", newReview);
		dbConnect.closeDB();
	}
	
}
