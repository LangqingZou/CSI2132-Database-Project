package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.GuestConn;
import eHotel.connections.HostConn;
import eHotel.connections.ReviewConn;
import eHotel.entities.Guest;
import eHotel.entities.Person;
import eHotel.entities.Property;
import eHotel.entities.Review;

public class CommentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		ReviewConn revConn = new ReviewConn(dbConnect);
		GuestConn gConn = new GuestConn(dbConnect);
		
		Person person = (Person) session.getAttribute("loginRole");
		
		int proid = Integer.parseInt(req.getParameter("revBtn"));
		int commRating = Integer.parseInt(req.getParameter("commRating"));
		int cleanRating = Integer.parseInt(req.getParameter("cleanRating"));
		int valueRating = Integer.parseInt(req.getParameter("valueRating"));
		String comment = req.getParameter("comment");
		
		Review newReview = new Review();
		
		newReview.setProid(proid);
		newReview.setGID(gConn.getGID(person.getPID()));
		newReview.setCleaniliness(cleanRating);
		newReview.setCommunication(commRating);
		newReview.setValue(valueRating);
		newReview.setComment(comment);
		
		if(revConn.insertNew(newReview) != -1) {
			session.setAttribute("reviewState", true);
			session.setAttribute("commentScucceed", true);
			resp.sendRedirect("AgreementList.jsp");
		}else {
			session.setAttribute("reviewState", false);
			resp.sendRedirect("AgreementList.jsp");
		}
	}
}
