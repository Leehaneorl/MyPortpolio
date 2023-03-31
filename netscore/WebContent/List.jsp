<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import = "java.util.*, com.web.jdbc.*" %>    
<!DOCTYPE html>
<html>
<head>
<title>NETSCORE</title>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link type="text/css" rel="stylesheet" href="css/Main.css">
    <title>NETSCORE</title>
<meta charset="UTF-8">
</head>
<body>
    <!-- Headline -->
	<%@ include file="Headline.jsp" %>
	
	<% if(request.getAttribute("contents_list") == "no_result"){ %>
		<div class = "container">
			<h1 style="color:white; text-align:center"> 찾으시는 결과가 없습니다.</h1>
		</div>
	<% }else{ %>
	<div class = "container">
	     <table class="table table-hover" style="text-align:center;">
	        <thead class="thead-black">
		        <tr>
		            <th style = "color:white;">Number</th>
		            <th style = "color:white;">Image</th>
		            <th style = "color:white;">Title</th>
		            <th style = "color:white;">Score</th>      
		            <th style = "color:white;">Year</th>
		            <th style = "color:white; width: 10%">Category</th>
		            <th style = "color:white; width: 8%">Genre</th>
		            <th style = "color:white;">Country</th>
		            <th style = "color:white;">Runtime</th>
		         </tr>
	        </thead>
	      <tbody>
	      
	        <c:forEach var= "list" items="${contents_list}" varStatus="status">
				<c:url var="review" value="/ContentControllerServlet">
					<c:param name="command" value="LOAD"/>
					<c:param name="content_id" value="${list.content_id}"/>
	        	</c:url>    
	            <tr style = "color:white;">
	              <td>${status.count}</td> 
	              <td><a href="${review}"><img src = "${list.img_path}" height = "150" width = "150"></a></td>
	              <td style="text-align:left;">
	              <h5><b>${list.title}</b></h5>
	              <br>
	              <c:choose>
	              	<c:when test="${fn:length(list.describtion)>100}">        <!-- limit text length < 100 -->
	              		<c:out value="${fn:substring(list.describtion,0,99)}"/>...
	              	</c:when>
	              	<c:otherwise>
	              		<c:out value="${list.describtion}"/>
	              	</c:otherwise>
	              </c:choose>
	              </td>
	              <td>${list.avg_score}</td>            
	              <td>${list.year}</td>
	              <td>
					<c:choose>
					   <c:when test="${list.category_id eq '1'}">
					     영화
					   </c:when>
					   <c:when test="${list.category_id eq '2'}">
					     시리즈
					   </c:when>
					   <c:when test="${list.category_id eq '3'}">
					     버라이어티
					   </c:when>					   
					</c:choose>	              
	              </td>
	              <td>
	              	<c:choose>
					   <c:when test="${list.genre_id eq '1'}">
					     액션
					   </c:when>
					   <c:when test="${list.genre_id eq '2'}">
					     드라마
					   </c:when>
					   <c:when test="${list.genre_id eq '3'}">
					     코미디
					   </c:when>					   
					</c:choose>	  
	              </td>
	              <td>
	              	<c:choose>
					   <c:when test="${list.country_id eq '1'}">
					     한국
					   </c:when>
					   <c:when test="${list.country_id eq '2'}">
					     미국
					   </c:when>
					   <c:when test="${list.country_id eq '3'}">
					     일본
					   </c:when>
					   <c:when test="${list.country_id eq '4'}">
					     중국
					   </c:when>					   
					</c:choose>	 
	              </td>
	              <td>${list.run_time}분</td>            
	            </tr>
	         </c:forEach>
	         </tbody>                               
	     </table>
	</div>
	<%} %>
</body>
</html>