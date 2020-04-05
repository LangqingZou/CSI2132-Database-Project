<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, eHotel.entities.Property"%>
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
			ArrayList<Property> list = (ArrayList<Property>) session.getAttribute("allPropertyList");
			System.out.println("List size:" + list.size());
			if (list != null && list.size() != 0){
				//Display property info
				for (int i = 0; i < list.size(); i++){
					Property p = (Property) list.get(i);
					out.println("<hr>");
					out.println("<h2>" + p.getTitle() + "</h2>");
					out.println("<h3>" + p.getType() + "</h3>");
					out.println("<p> Country: " + p.getCountry() + "</p>");
					out.println("<p> Address: " + p.getAddress() + "</p>");
					out.println("<p> Number of room: " + p.getNumRoom() + "</p>");
					out.println("<p>Booking info (fill in if you want to book this):</p>");
					out.println("Start Date:<br><input id='startDate' name='startDate' type='date'/><br>");
					out.println("End Date:<br><input id='endDate' name='endDate' type='date'/><br><br>");
					out.println("<select id='payType' name='payType'><option value='credit'>Credit</option><option value='debit'>Debit</option></select>");
					out.println("<button id='bookBtn' name='bookBtn' type='Submit' value='book'>Book Now!</button>");
					out.println("<hr>");
				}
			}else{
				out.println("<hr>");
				out.println("<h3 style='text-align: center;'>Sorry, we don't have any property yet &#128517;</h3>");
				out.println("<hr>");
			}
		%>
		</div>
	</body>
</html>