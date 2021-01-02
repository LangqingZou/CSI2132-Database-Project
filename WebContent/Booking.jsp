<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, eHotel.entities.Property"%>
<!DOCTYPE html>
<html>
<head>
	<title>Booking</title>
	<meta charset=UTF-8">
	<script type="text/javascript">
		function alerts(){
			var bookSuccessfully = '<%=session.getAttribute("bookSuccessfully")%>';
			var bookFail = '<%=session.getAttribute("failToBook")%>';
			if (bookSuccessfully == 'true') {
				alert("Booking succeed! Go check your rental agreement!");
			}
			if (bookFail == 'true') {
				alert("Fail to book. Try again.");
			}
	
		}
		window.onload = alerts;
	</script>
	<style type="text/css">
		body{
			background-color: #323234;
			color: #fff;
		}
	</style>
</head>
	<body>
		<h1 style="text-align: center;">Booking</h1>
		<div style="margin: 20px 20%">
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
					out.println("<form method='post' action='booking'>");
					out.println("Start Date:<br><input id='startDate' name='startDate' type='date'/><br>");
					out.println("End Date:<br><input id='endDate' name='endDate' type='date'/><br><br>");
					out.println("<button id='bookBtn' name='bookBtn' type='Submit' value='" + p.getProid() + "'>Book Now!</button>");
					out.println("</form>");
					out.println("<hr>");
				}
			}else{
				out.println("<hr>");
				out.println("<h3 style='text-align: center;'>Sorry, we don't have any property yet &#128517;</h3>");
				out.println("<hr>");
			}
		%>
		<a href = Menu.jsp><button class="btn retBtn" type="button" value="Return">Return</button></a>
		</div>
	</body>
</html>