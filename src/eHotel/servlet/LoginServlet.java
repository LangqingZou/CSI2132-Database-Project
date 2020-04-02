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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		HttpSession session = req.getSession();
		
		DBConnect dbConnect = new DBConnect();
		String email = req.getParameter("Email");
		String pwd = req.getParameter("pwd");
		
		PersonConn pconn = new PersonConn(dbConnect);
		
		// Check password
		if(pconn.checkPwd(email, pwd)) {
			req.getRequestDispatcher("login_success.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("login_failure.jsp");
		}
		dbConnect.closeDB();
		
//		try {
//			lconn = new LoginConn();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(lconn.checkLoginPassword(email, pwd)) {
//			Login login = new Login(email,pwd);
//			int row  = lconn.insertLoginInfo(login);
//			resp.sendRedirect("login_success.jsp");
//		} 
//		else resp.sendRedirect("login_failure.jsp");
		
//		employee account = new employee();
//		String userSSN = req.getParameter("userSSN");
//		[0]:name,[1]:pwd
//		PostgreSqlConn con = new PostgreSqlConn();
//		String[] pwdfromdb = con.getuserinforbycustSSN(email);
//		
//		if (pwd.equals(pwdfromdb[1])) {			
//			
//			ArrayList<Room> bookedRooms = con.getbookedRooms(userSSN);
//			
//			ArrayList<Room> allRooms = con.getAllAvailRooms();
//			
//			
//			req.setAttribute("CustName", pwdfromdb[0]);
//			req.setAttribute("bookedRooms", bookedRooms);
//			req.setAttribute("allRooms", allRooms);
//
//			req.getRequestDispatcher("booking.jsp").forward(req, resp);
//			return;	
//		}
//		resp.sendRedirect("login_failure.jsp");
//		return;
	}
}