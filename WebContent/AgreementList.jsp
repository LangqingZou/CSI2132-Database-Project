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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		.checked {
		  color: orange;
		}
		.star-rating {
		  font-size: 0;
		  white-space: nowrap;
		  display: inline-block;
		  width: 50px;
		  height: 10px;
		  overflow: hidden;
		  position: relative;
		  background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjREREREREIiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
		  background-size: contain;
		}
		.star-rating i {
		  opacity: 0;
		  position: absolute;
		  left: 0;
		  top: 0;
		  height: 100%;
		  width: 20%;
		  z-index: 1;
		  background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjRkZERjg4IiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
		  background-size: contain;
		}
		.star-rating input {
		  -moz-appearance: none;
		  -webkit-appearance: none;
		  opacity: 0;
		  display: inline-block;
		  width: 20%;
		  height: 100%;
		  margin: 0;
		  padding: 0;
		  z-index: 2;
		  position: relative;
		}
		.star-rating input:hover + i,
		.star-rating input:checked + i {
		  opacity: 1;
		}
		.star-rating i ~ i {
		  width: 40%;
		}
		.star-rating i ~ i ~ i {
		  width: 60%;
		}
		.star-rating i ~ i ~ i ~ i {
		  width: 80%;
		}
		.star-rating i ~ i ~ i ~ i ~ i {
		  width: 100%;
		}
		::after,
		::before {
		  height: 100%;
		  padding: 0;
		  margin: 0;
		  box-sizing: border-box;
		  text-align: center;
		  vertical-align: middle;
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
					out.println("<form method='post' action='rentals'>");
					out.println("<select id='payType' name='payType'><option value='credit'>Credit</option><option value='debit'>Debit</option></select>");
					out.println("<p>Card Number: </p><input type='tel' id='card' name='card' required=''/>");
					out.println("<button id='payBtn' name='payBtn' type='Submit' value='" + a.getPayid() + "'>Pay</button>");
					out.println("</form>");
					
					if (reviewState) {
						out.println("<form method='post' action='postcomment'>");
						out.print("<p>Communication </p>");
						out.print("<span class='star-rating'>");
						out.print("<input type='radio' name='commRating' value='1'><i></i>");
						out.print("<input type='radio' name='commRating' value='2'><i></i>");
						out.print("<input type='radio' name='commRating' value='3'><i></i>");
						out.print("<input type='radio' name='commRating' value='4'><i></i>");
						out.print("<input type='radio' name='commRating' value='5'><i></i>");
						out.println("</span>");
						out.print("<p>Cleaniliness </p>");
						out.print("<span class='star-rating'>");
						out.print("<input type='radio' name='cleanRating' value='1'><i></i>");
						out.print("<input type='radio' name='cleanRating' value='2'><i></i>");
						out.print("<input type='radio' name='cleanRating' value='3'><i></i>");
						out.print("<input type='radio' name='cleanRating' value='4'><i></i>");
						out.print("<input type='radio' name='cleanRating' value='5'><i></i>");
						out.println("</span>");
						out.print("<p>Value </p>");
						out.print("<span class='star-rating'>");
						out.print("<input type='radio' name='valueRating' value='1'><i></i>");
						out.print("<input type='radio' name='valueRating' value='2'><i></i>");
						out.print("<input type='radio' name='valueRating' value='3'><i></i>");
						out.print("<input type='radio' name='valueRating' value='4'><i></i>");
						out.print("<input type='radio' name='valueRating' value='5'><i></i>");
						out.println("</span>");
						out.println("<textarea id='comment' name='comment' cols=30 rows=10 aria-required='true'></textarea>");
						out.println("<button id='revBtn' name='revBtn' type='Submit value='" + p.getProid() + "'>Post Comment</button>");
						out.println("</form>");
					}
					out.println("<hr>");
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