<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add Property</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="ch-cn">
	<script type="text/javascript">
	
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
	</script>
</head>
	<body>
		<h2>Add Property</h2>
		<div>		
			<form method="post" action="addProperty" onSubmit="return validate();">
				Title:<input type="text" id="title" name="title"><br><br>
				Type:<input type="text" id="type" name="type"><br><br>
				Address:<input type="text" id="address" name="address"><br><br>
				NumRoom:<input type="text" id="numRoom" name="numRoom"><br><br>
				Country:<input type="text" id="country" name="country"><br><br>
				Price:<input type="text" id="price" name="price"><br><br>
				<button type="Submit" value="Login" id="confirm">Confirm</button>
			</form>
		</div>
	</body>
</html>