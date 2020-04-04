<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, eHotel.entities.Property, eHotel.entities.Guest, eHotel.entities.Host, eHotel.entities.Employee"%>
<!DOCTYPE html>
<html>
<head>
	<title>My Properties</title>
</head>
	<body>
		<div style="margin: 40% 20%">
			<%
				//Get property list info from session
				ArrayList<Property> list = (ArrayList<Property>) session.getAttribute("myPropertyList");
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