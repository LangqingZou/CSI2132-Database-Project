<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eHotel.entities.Person, eHotel.entities.Guest, eHotel.entities.Host, eHotel.entities.Employee,eHotel.entities.Agreement"%>
<!DOCTYPE html>
<html>
<head>
	<title>Rental Agreement</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
	</script>
</head>
	<body>
		<h1 style="text-align: center;">Rental Agreement</h1>
		<div>
		 <%
			String type = (String) session.getAttribute("roleType");
			if(type.equals("guest")){
				Guest guest = (Guest) session.getAttribute("loginRole");
				ArrayList<Agreement> hostAgreement = (ArrayList<Agreement>) session.getAttribute("rentalAgreementHost");

				out.println("Address: " + guest.getAddress() + "<br>");
			}else{
				Guest guest = (Guest) session.getAttribute("loginRole");
			}
		  %>
		</div>
			
	</body>
</html>