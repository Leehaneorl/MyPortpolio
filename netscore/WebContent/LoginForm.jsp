<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link type="text/css" rel="stylesheet" href="css/Main.css">
<style>
	.container{
		width: 40%;
		background: #343a40;
		margin: 60px auto auto auto;
		padding: 30px 20px 30px 20px;
	}
</style>

<title>Login</title>
</head>
<body>

	<!-- Headline -->
	<%@ include file="Headline.jsp" %>
	
	
	<!-- input -->
	<div class="container">
		<form action="ContentControllerServlet" method="POST">
			<h1 style = "text-align:center; color:white;">Login</h1>
			<input type="hidden" name="command" value="LOGIN"/>
			<p><input type="email" name="userEmail" placeholder="Email" required /></p>
			<p><input type="password" name="userPassword" placeholder="PASSWORD" required /></p>
			<p><input type="submit" value="Login"/></p>
		</form>
	</div>
</body>
</html>