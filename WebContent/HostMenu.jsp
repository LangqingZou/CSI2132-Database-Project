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
			<p style="text-align: center;">Host Menu</p>
			<div id="" style = "margin-left: 42%">
				<hr>
		        <%
		        	//Get user info from session
		            String[] info = (String[])session.getAttribute("accinfo");
		        	//Loop info elems
		            for(int i=0; i<info.length; i++)
		            {
		                String elem = info[i];
		                out.println(elem + "<br>");
		            }
		           %>
		        <hr>
				<button type="Submit"><a href="PropertyList.jsp"></a>My Properties</button>
				<button type="Submit"><a href="RetalAgreementList.jsp">Rental Agreements</a></button>		
			</div>
		</form>>
	</body>
</html>