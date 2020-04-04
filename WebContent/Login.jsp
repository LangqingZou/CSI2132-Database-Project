<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
 		function alerts(){
 			var emailExist = '<%=session.getAttribute("emailExist")%>';
 			var pwdAlert = '<%=session.getAttribute("pwdAlert")%>';
 			if (emailExist == 'true') {
 				alert("Email not exist!");
 			}
 			if (pwdAlert == 'true') {
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
		button {background-color: #4CAF50;
				color: #ffffff;
				text-decoration: none;
				border-color: #4CAF50;
				padding: 8px 16px;
				margin:0 10 0 10;	top, right, bottom, left
				text-align: center;
				cursor: pointer;
				white-space: nowrap;}
		body {background-color: #323234}
		.loginBtn{
			float left;
		}
		.registerBtn{
			float right;
		}
		.Container(){
			margin: 30% 40% 30% 40%;
		}
	</style>
</head>
	<body>
		<h2>Login Page</h2>
		<div class="Container" style = "text-color: #ffffff">
			<!-- when we click SUBMIT, only "return validate();" is true, the form will be submited -->	
			<!--login is here -->	
			<form method="post" action="login" onSubmit="return validate();">  
				Email:<br><input type="text" id="email" name="email"><br><br>
				Password:<br><input type="password" id="pass" name="pass"><br><br>
				<hr>
				<button class="loginBtn" type="Submit" value="Login">Login</button>
			</form>
			<button class="registerBtn" type="button"  value="Register" class="register" href="Register.jsp">Register</button>
			<hr>
		</div>
	</body>
</html>