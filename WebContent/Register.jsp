<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
 		function emailAlert(){
 			var emailAlert = '<%=session.getAttribute("emailAlert")%>';
 			if (!isNaN(emailAlert)) {
 				alert("Email has been registered!");
 			}
 		}

		function validate() {
			var firstName = document.getElementById("firstname");
			var lastName  = document.getElementById("lastname");
			var address = document.getElementById("address");
			var phone = document.getElementById("phonenumber");
			var pwd = document.getElementById("pwd");
			var pwdAgain = document.getElementById("pwdAgain");
			var position = document.getElementById("position");
			var salary = document.getElementById("salary");
			var email = document.getElementById("email");
			var role = document.getElementById("role");
			
			if(firstName.value == "" 
				|| lastName.value == "" 
				|| address.value == "" 
				|| phone.value == "" 
				|| pwd.value == "" 
				|| pwdAgain.value == "" ){
				alert("You need to fill in all the information");
				return false;
			}
			if (role.value == "emp" && (position.value == "" || salary.value == "")){
				alert("You need to fill in employee's information");
				return false
			}
			if(pwd.value != pwdAgain.value){
				alert("Please confirm your password");
				return false;
			}
			return true;
		}
		//once refresh the page, EMAILALERT is called
		window.onload = emailAlert;
</script>
</head>
<body>
	<form method = "post" action="register" onSubmit="return validate();">
		FirstName:<br><input type="text" id="firstname" name="firstname"><br><br>
		LastName:<br><input type="text" id="lastname" name="lastname"><br><br>
		Email:<br><input type="text" id="email" name="email"><br><br>
		Address:<br><input type="text" id="address" name="address"><br><br>
		PhoneNumber:<br><input type="text" id="phonenumber" name="phonenumber"><br><br>
		Password:<br><input type="password" id="pwd" name="pwd"><br><br>
		Confirm Password:<br><input type="password" id="pwdAgain" name="pwdAgain"><br><br>
		Position: <br><input type="text" id="position" name="position"> (For Employee)<br><br> 
		Salary: <br><input type="text" id="salary" name="salary"> (For Employee)<br><br>
		
		<select id="role" name="role">
			<option value="guest">Guest</option>
			<option value="host">Host</option>
			<option value="emp">Employee</option>
		</select>
		
		<button type="Submit" value="register">Register</button>
	</form>
</body>
</html>