<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eHotel.entities.Person, eHotel.entities.Guest, eHotel.entities.Host, eHotel.entities.Employee"%>
<!DOCTYPE html>
<html>
<head>
	<title>Main Menu</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
		function DisplayHostBtn() {
			var type = '<%=session.getAttribute("roleType")%>';
		    var btn = document.getElementById("addPropBtn");
		    if (type == "host") {
		        btn.style.display = "block";
		    }
		}
		window.onload = DisplayHostBtn
	</script>
</head>
	<body>
		<div style="margin: 0 40% 0 40%; text-align: center;">
			<h1 style="text-align: center;"> Main Menu </h1>
			<hr>
			<div>
		        <%
		        	//Get user info from session
		        	String type = (String) session.getAttribute("roleType");
		        	if (type.equals("guest")){
		        		Guest guest = (Guest) session.getAttribute("loginRole");
		        		//Display guest info
		        		out.println("<h2> WELCOME " + guest.getFirstName() + " " + guest.getLastName() + "!</h2>");
		        		out.println("<hr>");
			        	out.println("Address: " + guest.getAddress() + "<br>");
			        	out.println("Email Address: " + guest.getEmail() + "<br>");
			        	out.println("Phone Number: " + guest.getPhone() + "<br>");
		        	}else if (type.equals("host")){
		        		Host host = (Host) session.getAttribute("loginRole");
		        		//Display host info
		        		out.println("<h2> WELCOME " + host.getFirstName() + " " + host.getLastName() + "!</h2>");
		        		out.println("<hr>");
			        	out.println("Address: " + host.getAddress() + "<br>");
			        	out.println("Email Address: " + host.getEmail() + "<br>");
			        	out.println("Phone Number: " + host.getPhone() + "<br>");
			        	out.println("<hr>");
			        	out.println("<h3> Currently you have " + host.getPropertyList().size() + " properties registered.</h3>");
		        	}else{
		        		Employee employee = (Employee) session.getAttribute("loginRole");
		        		out.println("<h2> WELCOME " + employee.getFirstName() + " " + employee.getLastName() + "!</h2>");
		        		out.println("<hr>");
			        	out.println("Address: " + employee.getAddress() + "<br>");
			        	out.println("Email Address: " + employee.getEmail() + "<br>");
			        	out.println("Phone Number: " + employee.getPhone() + "<br>");
			        	out.println("<hr>");
			        	out.println("<h3> You can manage your branch right here!</h3>");
		        	}
		           %>
			</div>
			<hr>
        </div>
		<form method="post" action="myproperties">
			<button id="addPropBtn" type="Submit" onclick="window.location.href='PropertyList.jsp'">My Properties</button>
		</form>
		<form method="post" action="rentals">
			<button type="Submit" onclick="window.location.href='AgreementList.jsp'">Rental Agreements</button>
		</form>
		<form method="post" action="addproperty">
			<button type="Submit" onclick="window.location.href='AddProperty.jsp'">Add Property</button>
		</form>
		<form method="post" action="booking">
			<button type="Submit" onclick="window.location.href='Booking.jsp'">Book Now</button>
		</form>
	</body>
</html>