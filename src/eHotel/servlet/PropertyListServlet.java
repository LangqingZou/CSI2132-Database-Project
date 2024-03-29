package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.HostConn;
import eHotel.entities.Host;
import eHotel.entities.Property;

public class PropertyListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		int pid = (int) session.getAttribute("pid");
		Host host = (Host) session.getAttribute("loginRole");
		HostConn hConn = new HostConn(dbConnect);
		ArrayList<Property> myPropertyList = hConn.getPropertyList(host.getHID());
		session.setAttribute("myPropertyList", myPropertyList);
		dbConnect.closeDB();
	}
}
