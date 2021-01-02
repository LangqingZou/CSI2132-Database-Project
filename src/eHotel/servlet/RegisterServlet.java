package eHotel.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.EmployeeConn;
import eHotel.connections.GuestConn;
import eHotel.connections.PersonConn;
import eHotel.entities.Person;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String firstName = req.getParameter("firstname");
		String lastName  = req.getParameter("lastname");
		String address = req.getParameter("address");
		String phone = req.getParameter("phonenumber");
		String position = req.getParameter("position");
		String salary = req.getParameter("salary");
		String country = req.getParameter("country");
		String role = req.getParameter("role");
		
		// Establish connection
		DBConnect dbConnect = new DBConnect();
		Connection conn = dbConnect.getConnection();
		try {
			conn.setAutoCommit(false);
			
			PersonConn pconn = new PersonConn(dbConnect);

			//insert into table Person
			Person p = new Person();
			p.setEmail(email);
			p.setPassword(pwd);
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setAddress(address);
			p.setPhone(phone);
			
			if(pconn.insertNew(p)) {
				int newPID = pconn.getPID(email);
				if(role.equals("guest")) {
					GuestConn gconn = new GuestConn(dbConnect);
					if(gconn.insertNew(newPID)) {
						// register guest succeed
						resp.sendRedirect("Login.jsp");
						conn.commit();
						dbConnect.closeDB();
						return;
					}
					System.out.println("Insert guest failed in register.");
				} else {
					EmployeeConn econn = new EmployeeConn(dbConnect);
					if(econn.insertNew(newPID, position, Integer.parseInt(salary), country)) {
						// register employee succeed
						resp.sendRedirect("Login.jsp");
						conn.commit();
						dbConnect.closeDB();
						return;
					}
					System.out.println("Insert employee failed in register.");
				}
			}
			dbConnect.getConnection().rollback();
			session.setAttribute("emailAlert", "true");
			resp.sendRedirect("Register.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbConnect.closeDB();
	}
}
