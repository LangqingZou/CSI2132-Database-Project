<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, eHotel.entities.Property"%>
<!DOCTYPE html>
<html>
<head>
	<title>My Properties</title>
</head>
	<body>
		<div style="margin: 20px 20%">
			<%
				//Get property list info from session
				ArrayList<Property> list = (ArrayList<Property>) session.getAttribute("myProperties");
				if (list != null && list.size() != 0){
					//Display property info
					for (int i = 0; i < list.size(); i++){
						Property p = (Property)list.get(i);
						out.println("<hr>");
						out.println("<h2 style='text-align: center'>" + p.getTitle() + "</h2>");
						out.println("<h3 style='text-transform:uppercase'>" + p.getType() + "</h3>");
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