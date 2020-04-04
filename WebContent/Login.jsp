<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
 		function alerts(){
 			var emailAlert ='<%=session.getAttribute("emailAlert")%>';
 			var pwdAlert ='<%=session.getAttribute("pwdAlert")%>';
 			if (!isNaN(emailAlert)) {
 				alert("Email not exist!");
 			}
 			if (!isNaN(pwdAlert)) {
 				alert("Password incorrect!");
 			}
 		}	 

		function validate() {
			var email = document.getElementById("email");
			var pass = document.getElementById("pass");
			if(email.value == ""){
				alert("Email can't be null");
				return false;
			} else if(pass.value == "") {
				alert("Password can't be null");
				return false;
			}else return true;
		}
		
		window.onload = alerts; 
	</script>
	
	<style type="text/css">
		button {margin:0 10 0 10}
		register {margin: 10 10}
	</style>
</head>
	<body>
		<h2>Login Page</h2>
		<div>
			<!-- when we click SUBMIT, only "return validate();" is true, the form will be submited -->		
			<form method="post" action="login" onSubmit="return validate();">  <!--cuslogin is here -->
				Email:<input type="text" id="email" name="email"><br><br>
				Password:<input type="password" id="pass" name="pass"><br><br>
				<button type="Submit" value="Login">Login</button>
			</form>
			<button type="button"  value="Register" class="register"><a href="Register.jsp">Register</a></button>
		</div>
	</body>
</html>