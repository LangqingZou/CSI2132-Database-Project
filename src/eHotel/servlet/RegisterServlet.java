package eHotel.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.EmployeeConn;
import eHotel.connections.GuestConn;
import eHotel.connections.HostConn;
import eHotel.connections.PersonConn;
import eHotel.entities.Employee;
import eHotel.entities.Guest;
import eHotel.entities.Host;
import eHotel.entities.Person;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String custFirstName = req.getParameter("firstname");
		String custLastName = req.getParameter("lastname");
		String custAddress = req.getParameter("address");
		String custPhoneNumber = req.getParameter("phonenumber");
		String custEmail = req.getParameter("email");
		String cusPassword = req.getParameter("password");
		String custPosition = req.getParameter("position");
		String custSalary = req.getParameter("salary");
		String custPwd = req.getParameter("custPwd");
		String roleBtn = req.getParameter("Role");
		
		// System.out.println(custEmail);
		
		// Establish connection
		DBConnect dbConnect = new DBConnect();
	
		// Check if email already exist
		PersonConn pconn = new PersonConn(dbConnect);
		if(pconn.checkPersonExist(custEmail)) {
			req.setAttribute("email", custEmail);
			req.getRequestDispatcher("register_fail.jsp").forward(req, resp);
			return;
		}
		
		//insert into table Person
		Person p = new Person(100,custFirstName,custLastName,custAddress,custPhoneNumber,custEmail,custPwd);
		int newPID = pconn.createPerson(p);

		switch (roleBtn.toString()) {
		case "host":
			Host host = new Host(newPID,-1);
			HostConn hconn = new HostConn(dbConnect);
			hconn.createHost(host);
		case "emp":
			Employee e = new Employee(newPID, -1, custPosition, custSalary);
			if((custPosition != "") && (custSalary != "")) {
				EmployeeConn econn = new EmployeeConn(dbConnect);
				econn.createEmployee(e);
			}
		case "guest":
			Guest guest = new Guest(newPID,-1);
			GuestConn gconn = new GuestConn(dbConnect);
			gconn.createGuest(guest);
		}
		
		System.out.println(p.getPID()+ " " + newPID);
		
		if (newPID != 0) {			
				System.out.println("Responsed pid: " + newPID);
//				ArrayList<Room> bookedRooms = con.getbookedRooms(custSSN);
//				
//				ArrayList<Room> allRooms = con.getAllAvailRooms();
//				
//				System.out.println(allRooms);
//				
//				req.setAttribute("CustName", custName);
//				req.setAttribute("bookedRooms", bookedRooms);
//				req.setAttribute("allRooms", allRooms);
//				req.getRequestDispatcher("register.jsp").forward(req, resp);
				resp.sendRedirect("Login.html");
				return;			
		}
		resp.sendRedirect("register_fail.jsp");
		
		// Close connection
		dbConnect.closeDB();
		return;
	}
	

}
