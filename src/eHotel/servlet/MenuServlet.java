package eHotel.servlet;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PrimitiveIterator.OfDouble;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.oracle.wls.shaded.org.apache.bcel.generic.Select;
import com.oracle.wls.shaded.org.apache.xpath.operations.String;

import eHotel.connections.DBConnect;
import eHotel.connections.EmployeeConn;
import eHotel.connections.GuestConn;
import eHotel.connections.HostConn;
import eHotel.connections.PersonConn;
import eHotel.connections.PropertyConn;
import eHotel.connections.AgreementConn;
import eHotel.entities.Agreement;
import eHotel.entities.Person;
import eHotel.entities.Property;
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlAttr.Role;


public class MenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DBConnect dbConnect = new DBConnect();
		String button = req.getParameter("button");
		PersonConn pConn = new PersonConn(dbConnect);
	    Person person = new Person();
	    person = (Person) session.getAttribute("loginPerson");
		//get the login person id
		int pidDB = person.getPID();
		session.setAttribute("pidDB", pidDB);
		session.getAttribute("role");
		//get the gid
		GuestConn gConn = new GuestConn(dbConnect);
		int gidDB  = gConn.getGID(pidDB);

		//if also a host, get host id
		HostConn hConn = new HostConn(dbConnect);
		int hidDB = hConn.getHID(pidDB);
		
		//if also an employee, get the employee id
		EmployeeConn eConn = new EmployeeConn(dbConnect);
		int employDB = eConn.getEID(pidDB);
		
		if(button.value == "agreement") {
			if(hidDB != -1) {
				ArrayList<Agreement> rentalAgreeByHid = hConn.getRentalAgreementList(hidDB);
				session.setAttribute("rentalAgreementHost", rentalAgreeByHid);
				resp.sendRedirect("RentalAgreementList.jsp");
				return;
			}else {
				ArrayList<String[]> rentalAgreeByGid = gConn.getRentalAgreementList(gidDB);
				session.setAttribute("rentalAgreementGuest", rentalAgreeByGid);
				resp.sendRedirect("RentalAgreementList.jsp");
				return;
			}
		}else if(button.value == "myPropertyList") {
			ArrayList<Property> myPropertyList = hConn.getPropertyList(hidDB);
			session.setAttribute("propertyList", myPropertyList);
			resp.sendRedirect("PropertyList.jsp");
		}
		
		
		
		//2.My Property List (host only)
		if(hidDB != -1) {
			ArrayList<Property> myPropertyList = hConn.getPropertyList(hidDB);
			session.setAttribute("propertyList", myPropertyList);
			resp.sendRedirect("PropertyList.jsp");
		}
		
//		propertyConn.insertNew();
//		String[] newProperty = propertyConn.;
//		resp.sendRedirect("addProperty.jsp");
		
		
		//4. book a room
		resp.sendRedirect("PropertyList.jsp");
		
		dbConnect.closeDB();
	}
}
