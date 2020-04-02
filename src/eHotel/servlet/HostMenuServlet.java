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
		
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String address = req.getParameter("address");
		String phoneNumber = req.getParameter("phonenumber");
		String email = req.getParameter("email");
		
		String[] info = new String[5];
		ps = db.prepareStatement("select * from project.Person where email = email");
		rs = ps.executeQuery();
		while(rs.next()){
			String room_no = rs.getString("room_no");
			String room_status = rs.getString("room_status");
			Room room = new Room(room_no, room_status);
			Rooms.add(room);
		}
		
	}
	
}
