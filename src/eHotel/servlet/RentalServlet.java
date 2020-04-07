package eHotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.PaymentConn;

@SuppressWarnings("serial")
public class RentalServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		PaymentConn payConn = new PaymentConn(dbConnect);
		
		int payid = Integer.parseInt(req.getParameter("payBtn"));
		String payType = req.getParameter("payType");
		
		if(payConn.onPay(payid, payType)) {
			session.setAttribute("reviewState", true);
		}else {
			session.setAttribute("reviewState", false);
		}
	}
}
