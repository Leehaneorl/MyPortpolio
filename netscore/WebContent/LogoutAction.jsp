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

<%session.invalidate();%>

<script>
alert('See you agin');
location.href = 'ContentControllerServlet';
</script>
	
	
</body>
</html>