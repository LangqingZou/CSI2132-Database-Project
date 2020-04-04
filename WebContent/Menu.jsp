<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eHotel.entities.Person, eHotel.entities.Guest, eHotel.entities.Host, eHotel.entities.Employee"%>
<!DOCTYPE html>
<html>
<head>
	<title>HostMenu</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
		
	</script>
</head>
	<body>
		<div>
			<p style="text-align: center;">Host Menu</p>
			<hr>
			<div style="margin: 50px 50px 50px 50px; text-align: center;">
		        <%
		        	//Get user info from session
		        	if (session.getAttribute("role") instanceof Guest){
		        		Guest guest = (Guest) session.getAttribute("role");
		        		//Display guest info
		        		out.println("<h2> WELCOME " + guest.getFirstName() + " " + guest.getLastName() + "!</h2>");
		        		out.println("<hr>");
			        	out.println("Address: " + guest.getAddress() + "<br>");
			        	out.println("Email Address: " + guest.getEmail() + "<br>");
			        	out.println("Phone Number: " + guest.getPhone() + "<br>");
		        	}else if (session.getAttribute("role") instanceof Host){
		        		Host host = (Host) session.getAttribute("role");
		        		//Display host info
		        		out.println("<h2> WELCOME " + host.getFirstName() + " " + host.getLastName() + "!</h2>");
		        		out.println("<hr>");
			        	out.println("Address: " + host.getAddress() + "<br>");
			        	out.println("Email Address: " + host.getEmail() + "<br>");
			        	out.println("Phone Number: " + host.getPhone() + "<br>");
			        	out.println("<hr>");
			        	out.println("<h3> Currently you have " + host.getPropertyList().size() + " properties registered.</h3>");
		        	}else{
		        		Employee employee = (Employee) session.getAttribute("role");
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
		<form method="post" action="menu">
			<button type="Submit"><a href="PropertyList.jsp"></a>My Properties</button>
			<button type="Submit"><a href="RetalAgreementList.jsp">Rental Agreements</a></button>
			<button type="Submit"><a href="RetalAgreementList.jsp">Add Property</a></button>
		</form>>
	</body>
</html>