package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.entities.Room;

public class HostMenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		String firstName = "";
		String lastName = "";
		String address = "";
		String phoneNumber = "";
		String email = "";
		
		String[] info = (String[]) req.getAttribute("accinfo");
		System.out.println(info);
	}
}
