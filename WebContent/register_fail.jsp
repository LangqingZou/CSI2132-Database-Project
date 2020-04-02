<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<p><%=request.getAttribute("email")%> have been registered</p>
		<button type="button">
			<a href="Register.html">Return to register</a>
		</button>
	</div>		
</body>
</html>