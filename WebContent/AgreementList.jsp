<%@page import="eHotel.connections.DBConnect"%>
<%@page import="eHotel.connections.PropertyConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="eHotel.connections.DBConnect, eHotel.connections.PropertyConn, 
				eHotel.entities.Guest, eHotel.entities.Host, eHotel.entities.Agreement"%>
<%@ page import="java.util.ArrayList, eHotel.entities.Property"%>
<!DOCTYPE html>
<html>
<head>
	<title>Rental Agreement</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
		function alerts(){
			var bookSuccessfully = '<%=session.getAttribute("bookSuccessfully")%>';
			if (bookSuccessfully == 'true') {
				alert("Book successfully! Go to check your rental agreement.");
			}
		}
		
		window.onload = emailAlert;
	</script>
	<style type="text/css">
		body {
			background-color: #323234;
			color: #fff;
		}
		textarea {
			width: 100%;
			background: #f2f2f2;
			border-radius: 0px;
			height: 150px;
			resize: none;
			margin-bottom: 20px;
			border: 1px solid #cbd0d2;
			padding: 10px;
			clear: both;
			box-sizing: border-box;
			outline: 0;
			color: #444;
			transition: border-color 0.4s ease;
		}
	</style>
</head>
	<body>
		<h1 style="text-align: center;">Rental Agreement</h1>
		<div>
		 <%
			String type = (String) session.getAttribute("roleType");
		 	Boolean reviewState = (Boolean) session.getAttribute("reviewState");
		 	ArrayList<Agreement> guestAgreements = new ArrayList<Agreement>();
		 	ArrayList<Agreement> hostAgreements = new ArrayList<Agreement>();
		 	guestAgreements = (ArrayList<Agreement>) session.getAttribute("rentalAgreementGuest");
		 	hostAgreements = (ArrayList<Agreement>) session.getAttribute("rentalAgreementHost");
		 	PropertyConn proConn = new PropertyConn(new DBConnect());
			if(type.equals("guest")){
				Guest guest = (Guest) session.getAttribute("loginRole");
				
			}else{
				Host guest = (Host) session.getAttribute("loginRole");
				
			}
			if (guestAgreements != null && guestAgreements.size() != 0){
				//Display guest agreements info
				for (int i = 0; i < guestAgreements.size(); i++){
					Agreement a = (Agreement)guestAgreements.get(i);
					Property p = proConn.getProperty(a.getProid());
					out.println("<hr>");
					//out.println("<h2 style='text-align: center'>" + a.getStartDate() + "</h2>");
					out.println("<h3 style='text-transform:uppercase'>" + p.getTitle() + "</h3>");
					out.println("<p> Rental start Date: " + a.getStartDate() + "</p>");
					out.println("<p> Rental end Date: " + a.getEndDate() + "</p>");
					out.println("<p> Approval status: " + a.getApprove() + "</p>");
					out.println("<select id='payType' name='payType'><option value='credit'>Credit</option><option value='debit'>Debit</option></select>");
					out.println("<p>Card Number: </p><input type='card' id='card' name='card' required=''/>");
					out.println("<button id='payBtn' name='payBtn' type='Submit' value='" + p.getProid() + "'>Pay</button>");
					out.println("<hr>");
					if (reviewState) {
						out.println("<textarea id='comment' name='comment' cols=30 rows=10 aria-required='true'/>");
						out.println("<button id='revBtn' name='revBtn' type='Submit>Post Comment</button>");
					}
				}
			}else{
				out.println("<hr>");
				out.println("<h2>Sorry, you don't have any guest rental agreement yet &#128517;</h2>");
				out.println("<hr>");
			}
			if (hostAgreements != null && hostAgreements.size() != 0){
				//Display host agreements info
				for (int i = 0; i < hostAgreements.size(); i++){
					Agreement a = (Agreement)hostAgreements.get(i);
					Property p = proConn.getProperty(a.getProid());
					out.println("<hr>");
					//out.println("<h2 style='text-align: center'>" + a.getStartDate() + "</h2>");
					out.println("<h3 style='text-transform:uppercase'>" + p.getTitle() + "</h3>");
					out.println("<p> Rental start Date: " + a.getStartDate() + "</p>");
					out.println("<p> Rental end Date: " + a.getEndDate() + "</p>");
					out.println("<p> Approval status: " + a.getApprove() + "</p>");
					out.println("<hr>");
				}
			}else{
				out.println("<hr>");
				out.println("<h2>Sorry, you don't have any host rental agreement yet &#128517;</h2>");
				out.println("<hr>");
			}
		  %>
		</div>
			
	</body>
</html>