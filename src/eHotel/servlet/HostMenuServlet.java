package eHotel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import eHotel.connections.DBConnect;
import eHotel.connections.HostConn;
import eHotel.connections.PersonConn;
import eHotel.connections.PropertyConn;
import eHotel.entities.Room;

public class HostMenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		String role = req.getParameter("");
		
	    HostConn hConn = new HostConn(dbConnect);
	    PropertyConn propertyConn = new PropertyConn(dbConnect);
		String[] info = (String[]) session.getAttribute("accinfo");
		int pidDB = Integer.parseInt(info[0]);
		int hidDB = hConn.getHID(pidDB);
		
		//My Property List
		ArrayList<String[]> myPropertyList = hConn.getPropertyList(hidDB);
		session.setAttribute("propertyList", myPropertyList);
		System.out.print(myPropertyList);
		
		
		resp.sendRedirect("PropertyList.jsp");
		
		//My retal Agreement
		int idraDB = hConn.getIdraFromRetalAgreement(hidDB);
		int idprDB = hConn.getIdprFromRetalAgreement(idraDB);
		String[] propertyInfo = propertyConn.getpropertyInfo(idprDB);
		
		
		
		
		
		
		
	}
}
