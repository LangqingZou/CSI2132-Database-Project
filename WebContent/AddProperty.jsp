<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add Property</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
		function alerts(){
			var PropertyFail = '<%=session.getAttribute("PropertyFail")%>';
			var addSuccessfully = '<%=session.getAttribute("addSuccessfully")%>';
			if (PropertyFail == 'true') {
				alert("Fail to add property");
				<%session.setAttribute("PropertyFail", "false");%>
			}
			if (addSuccessfully == 'true') {
				alert("Add property successfully!");
				<%session.setAttribute("addSuccessfully", "false");%>
			}
	
		}	 
		function validate(){
			var title = document.getElementById("title");
			var type = document.getElementById("type");
			var address = document.getElementById("address");
			var numRoom = document.getElementById("numRoom");
			var country = document.getElementById("country");
			var price = document.getElementById("price");
			
			if(title.value == "" 
				|| type.value == "" 
				|| address.value == "" 
				|| numRoom.value == "" 
				|| country.value == "" 
				|| price.value ==""){
				alert("You need to fill in all the information");
				return false;
			}
			return true;
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
		<h2 style="text-align:center;">Add Property</h2>
		<div style="margin: 20px 20%">		
			<form method="post" action="addproperty" onSubmit="return validate();">
				Title:<br><input type="text" id="title" name="title"><br><br>
				Type:<br><input type="text" id="type" name="type"><br><br>
				Address:<br><input type="text" id="address" name="address"><br><br>
				NumRoom:<br><input type="number" id="numRoom" name="numRoom"><br><br>
				Country:<br><input type="text" id="country" name="country"><br><br>
				Price:<br><input type="number" id="price" name="price"><br><br>
				<button type="Submit" value="Login" id="confirm">Confirm</button><br><br>
			</form>
			<a href="Menu.jsp"><button type="button" value="Login" id="confirm">Return</button></a>
		</div>
	</body>
</html>