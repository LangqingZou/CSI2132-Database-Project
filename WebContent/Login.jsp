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
		body {
			background-color: #323234;
			color: #ffffff
		}
		.text-center{
			color:#fff;	
			text-transform:uppercase;
		    font-size: 23px;
		    margin: 0px 0 10px 0;
		    display: block;
		    text-align: center;
		}
		.loginBtn{
			float: left;
		}
		.registerBtn{
			float: right;
		}
		.container{
			position:absolute;
			left:50%;
			top:50%;
			transform: translate(-50%,-50%);
		    background-color: rgba(100, 115, 115, 0.89);
			border-radius: 5px;
			padding:80px 100px;
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
			<hr style="margin-bottom:30px">
			<!-- when we click SUBMIT, only "return validate();" is true, the form will be submited -->	
			<!--login is here -->	
			<form method="post" action="login" onSubmit="return validate();">
				<div class="input-container">
					<input type="text" id="email" name="email" required=""/>
					<label>Email</label>
				</div>
				<div class="input-container">
					<input type="password" id="pass" name="pass" required=""/>
					<label>Password</label>		
				</div>
				<button class="btn loginBtn" type="Submit" value="Login">Login</button>
			</form>
			<button class="btn regBtn" type="button" value="Register" onclick="window.location.href='Register.jsp'">Register</button>
		</div>
	</body>
</html>