<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eHotel.entities.Person"%>
<!DOCTYPE html>
<html>
<head>
	<title>Booking</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
	</script>
</head>
	<body>
		<h1 style="text-align: center;">Booking</h1>
		<div>
		<%
			//Get property list info from session
			ArrayList<Property> list = (ArrayList<Property>) session.getAttribute("loginRole");
			if (list.size() != 0){
				//Display property info
				for (int i = 0; i < list.size(); i++){
					Property p = list.get(i);
					out.println("<hr>");
					out.println("<h3>" + p.getTitle() + "</h3>");
					out.println("<h5>" + p.getType() + "</h5>");
					out.println("<p> Country: " + p.getCountry() + "</p>");
					out.println("<p> Address: " + p.getAddress() + "</p>");
					out.println("<p> Number of room: " + p.getNumRoom() + "</p>");
					out.println("<hr>");
				}
			}else{
				out.println("<hr>");
				out.println("<h2>Sorry, you don't have any property yet &#128517;</h2>");
				out.println("<hr>");
			}
		%>
		</div>
		
	</body>
</html>