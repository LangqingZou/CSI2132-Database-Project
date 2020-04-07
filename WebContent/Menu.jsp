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
		    var btn = document.getElementById("myPropBtn");
		    if (type == 'host') {
		        btn.style.display = 'block';
		    }else{
		    	btn.style.display = 'none';
		    }
		}
		function alerts(){
			var addSuccessfully = '<%=session.getAttribute("addSuccessfully")%>';
			if (addSuccessfully == 'true') {
				alert("Add Property Successfully");
			}
		}	
		window.onload = alerts;
		window.onload = DisplayHostBtn;
	</script>
	<style type="text/css">
		body{
			background-color: #323234;
			color: #fff;
		}
		p{
			text-align:left;
		}
		.btn{
			color:#fff;
			background-color:#e74c3c;
			outline: none;
			border: 0;
			padding:10px 20px;
			text-transform:uppercase;
			cursor:pointer;
			position:relative;
		}
		.btn:after{
			content:"";
			position:absolute;
			top:0;
			right:0;
			width:100%;
			height:100%;
		}
		.container{
			position:static;
			margin: 10% 20% 10% 20%;
		    background-color: rgba(100, 115, 115, 0.89);
			border-radius: 5px;
			padding:80px 100px;
			text-align: center;
		}
	</style>
</head>
	<body onload = 'alerts()'>
		<div class='container'>
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
			        	out.println("<p>Address: " + guest.getAddress() + "</p><br>");
			        	out.println("<p>Email Address: " + guest.getEmail() + "</p><br>");
			        	out.println("<p>Phone Number: " + guest.getPhone() + "</p><br>");
		        	}else if (type.equals("host")){
		        		Host host = (Host) session.getAttribute("loginRole");
		        		//Display host info
		        		out.println("<h2> WELCOME " + host.getFirstName() + " " + host.getLastName() + "!</h2>");
			        	out.println("<p>Address: " + host.getAddress() + "</p><br>");
			        	out.println("<p>Email Address: " + host.getEmail() + "</p><br>");
			        	out.println("<p>Phone Number: " + host.getPhone() + "</p><br>");
			        	out.println("<hr>");
			        	// out.println("<h3> Currently you have " + host.getPropertyList().size() + " properties registered.</h3>");
		        	}else{
		        		Employee employee = (Employee) session.getAttribute("loginRole");
		        		out.println("<h2> WELCOME " + employee.getFirstName() + " " + employee.getLastName() + "!</h2>");
			        	out.println("<p>Address: " + employee.getAddress() + "</p><br>");
			        	out.println("<p>Email Address: " + employee.getEmail() + "</p><br>");
			        	out.println("<p>Phone Number: " + employee.getPhone() + "</p><br>");
			        	out.println("<hr>");
			        	out.println("<h3> You can manage your branch right here!</h3>");
		        	}
		           %>
			</div>
			<a href="PropertyList.jsp"><button id="myPropBtn" type="Submit" class="btn" style="float:left">My Properties</button></a>
			<div style="float:right">
				<a href="AgreementList.jsp"><button type="Submit" class="btn">Rental Agreements</button></a>
				<a href="AddProperty.jsp"><button type="Submit" class="btn">Add Property</button></a>
				<a href="Booking.jsp"><button type="Submit" class="btn">Book Now</button></a>
			</div>
        </div>
	</body>
</html>