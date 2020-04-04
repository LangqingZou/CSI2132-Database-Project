package eHotel.servlet;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.oracle.wls.shaded.org.apache.xpath.operations.String;

import eHotel.connections.DBConnect;
import eHotel.connections.EmployeeConn;
import eHotel.connections.GuestConn;
import eHotel.connections.HostConn;
import eHotel.connections.PersonConn;
import eHotel.connections.PropertyConn;
import eHotel.connections.RetalAgreementConn;
import eHotel.entities.Person;


public class MenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		
		PersonConn pConn = new PersonConn(dbConnect);
	    Person person = new Person();
	    person = (Person) session.getAttribute("loginPerson");
		//get the login person id
		int pidDB = person.getPID();
		session.setAttribute("pidDB", pidDB);
		//get the gid
		GuestConn gConn = new GuestConn(dbConnect);
		int gidDB  = gConn.getGID(pidDB);
		
		//if also a host, get host id
		HostConn hConn = new HostConn(dbConnect);
		int hidDB = hConn.getHID(pidDB);
		
		//if also an employee, get the employee id
		EmployeeConn eConn = new EmployeeConn(dbConnect);
		int employDB = eConn.
		
		
		//1.My retal Agreement
		RentalAgreementConn rentalAgreementConn = new RentalAgreementConn(dbConnect);
		
		//get retalAgreementList by gid
			ArrayList<String[]> rentalAgreeByGid = 
			session.setAttribute("rentalAgreementGuest", rentalAgreeByGid);
		//get retalAgreementList by hid
		if(hidDB != -1 ) {
			ArrayList<String[]> rentalAgreeByHid = 
			session.setAttribute("rentalAgreementHost", rentalAgreeByHid);
		}
		resp.sendRedirect("RentalAgreementList.jsp");
		
		
		//2.My Property List (host only)
		if(hidDB != -1) {
			ArrayList<String[]> myPropertyList = hConn.getPropertyList(hidDB);
			session.setAttribute("propertyList", myPropertyList);
			resp.sendRedirect("myPropertyList.jsp");
		}
		
		//3.add property
		PropertyConn propertyConn = new PropertyConn(dbConnect);
		propertyConn.insertNew();
		String[] newProperty = propertyConn.;
		resp.sendRedirect("addProperty.jsp");
		
		
		//4. book a room
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
