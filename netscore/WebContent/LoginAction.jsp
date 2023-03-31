<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.PrintWriter, com.web.jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<title>NETSCORE</title>
</head>
<body>

<%
	PrintWriter script = response.getWriter();
	if(request.getAttribute("loginCheck") == "wrong_email"){
		script.println("<script>");
		script.println("alert('THERE IS NO MATCHING EMAIL')");
		script.println("history.back()");
		script.println("</script>");
	}else if(request.getAttribute("loginCheck") == "wrong_password"){
		script.println("<script>");
		script.println("alert('MIGHT BE WRONG PASSWORD')");
		script.println("history.back()");
		script.println("</script>");
	}else if(request.getAttribute("loginCheck") == "wrong_something"){
		script.println("<script>");
		script.println("alert('TRY AGAIN')");
		script.println("history.back()");
		script.println("</script>");
	}else if(request.getAttribute("loginCheck") == "same_email"){
		script.println("<script>");
		script.println("alert('The email is already exists')");
		script.println("history.back()");
		script.println("</script>");
	}else{
		script.println("<script>");
		session.setAttribute("userInfo", request.getAttribute("loginCheck"));      //save user in session 
		script.println("alert('Welcome')");
		script.println("location.href = 'ContentControllerServlet'");
		script.println("</script>");
	}
%>
</body>
</html>