package eHotel.servlet;

import java.io.IOException;
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
import eHotel.entities.Person;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	//handle the http post request
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		//the lifecircle of session will be ended when user leave about 20 mins
		HttpSession session = req.getSession();
		//connect the database if there exist the action
		DBConnect dbConnect = new DBConnect();
		//everything contained in form called parameter which is not null
		//while attributes is null at the beginning until setAttribute() was called
		String email = req.getParameter("email");
		String pwd = req.getParameter("pass");
		
		Person role;
		PersonConn pConn = new PersonConn(dbConnect);
		GuestConn gConn = new GuestConn(dbConnect);
		HostConn hConn = new HostConn(dbConnect);
		EmployeeConn eConn = new EmployeeConn(dbConnect);
		
		int pid = pConn.getPID(email);
		System.out.println(pid);
		if(pid != -1) {		// if person exist
			Person person = pConn.getPerson(email);
			System.out.println(person.getPassword().equals(pwd));
			if(person.getPassword().equals(pwd)) {
				int gid = gConn.getGID(pid);
				int hid = hConn.getHID(pid);
				int eid = eConn.getEID(pid);
				if(hid != -1) {
					role = hConn.getHost(hid);
				}else if(gid != -1) {
					role = gConn.getGuest(gid);
				}else {
					role = eConn.getEmployee(eid);
				}
				session.setAttribute("loginRole", role);
				resp.sendRedirect("Menu.jsp");
			}else{
				session.setAttribute("pwdAlert", "true");
				resp.sendRedirect("Login.jsp");
			}
		}else {
			session.setAttribute("emailAlert", "true");
			//req.getRequestDispatcher(next page).forward(req, resp);  -> url unchanged
			//resp.sendRedirect("move back to the last page"); -> url change and request cannot be shared
			resp.sendRedirect("Login.jsp");
		}
		dbConnect.closeDB();
	}
}