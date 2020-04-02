package eHotel.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eHotel.connections.DBConnect;
import eHotel.connections.LoginConn;
import eHotel.connections.PersonConn;
import eHotel.entities.Login;


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
		String email = req.getParameter("Email");
		String pwd = req.getParameter("pwd");
		
		PersonConn pconn = new PersonConn(dbConnect);
		String[] infoDB = pconn.getInfo(email);
		String pwdDB = infoDB[6];
		
		// Check password
		if(pwdDB.equals(pwd)) {
			//req.setAttribute(Tagname,Value) 
			//session.setAttribute(Tagname,Value) wrong: we want to carry the req to the next page, while 
			//session will finish in the current page
			session.setAttribute("accinfo", infoDB);
			
			resp.sendRedirect("HostMenu.jsp");
		}else {
			session.setAttribute("pwdAlert", "true");
			//req.getRequestDispatcher(next page).forward(req, resp);  -> url unchanged
			//resp.sendRedirect("move back to the last page"); -> url change and request cannot be shared
			resp.sendRedirect("Login.jsp");
		}
		dbConnect.closeDB();
		
	}
}