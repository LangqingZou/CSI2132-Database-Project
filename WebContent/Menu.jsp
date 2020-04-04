<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form method="post" action="hostmenu">
			<div style = "">
				<p style="text-align: center;">Host Menu</p>
				<hr>
		        <%
		        	//Get user info from session
		            String[] info = (String[])session.getAttribute("accinfo");
		        	//Display info
		        	out.println("First Name: " + info[1] + "<br>");
		        	out.println("Last Name: " + info[2] + "<br>");
		        	out.println("Address: " + info[3] + "<br>");
		        	out.println("Email Address: " + info[4] + "<br>");
		        	out.println("Phone Number: " + info[5] + "<br>");
		           %>
		        <hr>
				<button type="Submit"><a href="PropertyList.jsp"></a>My Properties</button>
				<button type="Submit"><a href="RetalAgreementList.jsp">Rental Agreements</a></button>		
			</div>
		</form>>
	</body>
</html>