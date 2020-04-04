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
		String firstName = req.getParameter("firstname");
		String lastName  = req.getParameter("lastname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phonenumber");
		String pwd = req.getParameter("pwd");
		String pwdAgain = req.getParameter("pwdAgain");
		String position = req.getParameter("position");
		String salary = req.getParameter("salary");
		String email = req.getParameter("email");
		String propertyTitle = req.getParameter("Propertytitle");
		
		// Establish connection
		DBConnect dbConnect = new DBConnect();
	
		// Check if email already exist
		PersonConn pconn = new PersonConn(dbConnect);

		//insert into table Person
		Person p = new Person(100,email,pwd,firstName,lastName,address,phone);
		pconn.insertNew(p);
		int newPID = pconn.getPID(email);
		
		
		System.out.println("Local PID:" + p.getPID()+ "DB PID:" + newPID);
		
		if (newPID == -1) {
			session.setAttribute("emailAlert", "true");
			resp.sendRedirect("Register.jsp");
			return;
		}
		
		//every person login default as guest
		GuestConn gconn = new GuestConn(dbConnect);
		gconn.insertNew(newPID);
		
		//if the person add property, he will be regarded as a guest and host
		if(propertyTitle != "") {
			HostConn hconn = new HostConn(dbConnect);
			hconn.insertNew(newPID);
		}
		//if the person input the position and salary, he will be regarded as a guest and employee
		if(position != "" && salary != "") {
			EmployeeConn econn = new EmployeeConn(dbConnect);
			econn.insertNew(newPID);
		}
		
	}	
		
		
		
		
		
		/*
		switch (role) {
		case "host":
		    Host host = new Host(newPID,-1);
			HostConn hconn = new HostConn(dbConnect);
			hconn.createHost(host);
		case "emp":
			Employee e = new Employee(newPID, -1, position, salary);
			if((position != "") && (salary != "")) {
				EmployeeConn econn = new EmployeeConn(dbConnect);
				econn.createEmployee(e);
			}
		case "guest":
			Guest guest = new Guest(newPID,-1);
			GuestConn gconn = new GuestConn(dbConnect);
			gconn.createGuest(guest);
		}
		resp.sendRedirect("Login.jsp");
		
		// Close connection
		dbConnect.closeDB();
		return;
		*/
	

}
