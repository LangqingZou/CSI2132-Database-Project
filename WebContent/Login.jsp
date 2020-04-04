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
		body {
			background-color: #323234;
			color: #bebebe
		}
		.loginBtn{
			float left;
		}
		.registerBtn{
			float right;
		}
		.container{
			position:absolute;
			left:50%;
			top:50%;
			transform: translate(-50%,-50%);
		    background-color: rgba(101, 32, 115, 0.89);
			border-radius:3px;
			padding:70px 100px;
		}
		.input-container{
			position:relative;
			margin-bottom:25px;
		}
		.input-container label{
			position:absolute;
			top:0px;
			left:0px;
			font-size:16px;
			color:#fff;	
		    pointer-event:none;
			transition: all 0.5s ease-in-out;
		}
		.input-container input{ 
		  border:0;
		  border-bottom:1px solid #555;  
		  background:transparent;
		  width:100%;
		  padding:8px 0 5px 0;
		  font-size:16px;
		  color:#fff;
		}
		.input-container input:focus{ 
		 border:none;	
		 outline:none;
		 border-bottom:1px solid #e74c3c;	
		}
		.btn{
			color:#fff;
			background-color:#e74c3c;
			outline: none;
		    border: 0;
		    color: #fff;
			padding:10px 20px;
			text-transform:uppercase;
			margin-top:50px;
			border-radius:2px;
			cursor:pointer;
			position:relative;
		}
		.btn:after{
			content:"";
			position:absolute;
			background:rgba(0,0,0,0.50);
			top:0;
			right:0;
			width:100%;
			height:100%;
		}
		.input-container input:focus ~ label,
		.input-container input:valid ~ label{
			top:-12px;
			font-size:12px;
		}
	</style>
</head>
	<body>
		<div class="container">
			<span class="text-center">LOGIN</span>
			<!-- when we click SUBMIT, only "return validate();" is true, the form will be submited -->	
			<!--login is here -->	
			<form method="post" action="login" onSubmit="return validate();">
				<div class="input-container">
					<input type="text" required=""/>
					<label>Email</label>		
				</div>
				<div class="input-container">
					<input type="text" required=""/>
					<label>Password</label>		
				</div>
				<hr>
				<button class="btn loginBtn" type="submit" value="login">Login</button>
			</form>
			<button class="btn regBtn" type="button"  value="register" href="Register.jsp">Register</button>
			<hr>
		</div>
	</body>
</html>