<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.web.jdbc.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/Main.css">
    <title>NETSCORE</title>
</head>
<body>
    <!-- Headline -->
    <div class="head-line">
    	<!-- Go main page btn-->
    	<a href="ContentControllerServlet"><img class="logo_main" src="images/samples/logo_main.png"></a>
    	
    	<!-- User's btn -->
	    
	    <% if(session.getAttribute("userInfo") == null){
	    	%>
	    	<div class="btn-group" style="float:right;">
				<a href="JoinForm.jsp"><button type="button" class="btn btn-dark">Sign In</button></a>
				<a href="LoginForm.jsp"><button type="button" class="btn btn-dark">Login</button></a>
			</div>	 
	    <% }else if(session.getAttribute("userInfo") != null){
	    	%>
	    	<div class="btn-group" style="float:right;">
	    		<a href="LogoutAction.jsp"><button type="button" class="btn btn-dark">Logout</button></a>
				<div class="btn-group">		
				    <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown">
				       MY
				    </button>
				    <div class="dropdown-menu">
				      <a class="dropdown-item" href="LogoutAction.jsp">Logout</a>
				    </div>
				</div>
			</div>		      	
	   	<% }%> 


		  
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="margin:20px 0;">
        <div class="collapse navbar-collapse" id="navb">
          <ul class="navbar-nav mr-auto">
			<c:url var="movie" value="/ContentControllerServlet">
				<c:param name="command" value="LIST"/>
				<c:param name="category_id" value="1"/>
	        </c:url>
	        <c:url var="series" value="/ContentControllerServlet">
				<c:param name="command" value="LIST"/>
				<c:param name="category_id" value="2"/>
	        </c:url>
	        <c:url var="variety" value="/ContentControllerServlet">
				<c:param name="command" value="LIST"/>
				<c:param name="category_id" value="3"/>
	        </c:url>
            <li class="nav-item active">
              <a class="nav-link" href="${movie}">MOVIE</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="${series}">TV SHOWS</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="${variety}">VARIETY SHOWS</a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0" action="ContentControllerServlet" method="GET">
          	<input type="hidden" name="command" value="SEARCH">
            <input class="form-control mr-sm-2" name="search" type="text" placeholder="Search" required>
            <button class="btn btn-success my-2 my-sm-0" type="submit"><img src="images/samples/searchIcon.png"></button>
          </form>
        </div>
      </nav>
    </div>
</body>
</html>