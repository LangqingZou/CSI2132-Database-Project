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
import eHotel.entities.Property;

public class CommentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		
	}
}
