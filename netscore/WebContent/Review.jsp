<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<%@ include file="Headline.jsp" %>
	
	<div class="container">
		<h2>${content_info.get(0).title}</h2>
		<p>(${content_info.get(0).year}) </p>
		<div>
			<table class="table table-dark">
				<tbody>
					<tr style = "color:white;">
						<td><img src = "${content_info.get(0).img_path}" height = "400" width = "400"></td>
						<td>
							분류  :  
			              	<c:choose> 
							   <c:when test="${content_info.get(0).country_id eq '1'}">
							     한국  
							   </c:when>
							   <c:when test="${content_info.get(0).country_id eq '2'}">
							     미국  
							   </c:when>
							   <c:when test="${content_info.get(0).country_id eq '3'}">
							     일본  
							   </c:when>
							   <c:when test="${content_info.get(0).country_id eq '4'}">
							     중국  
							   </c:when>					   
							</c:choose>	
							<c:choose> 
							   <c:when test="${content_info.get(0).category_id eq '1'}">
							     영화
							   </c:when>
							   <c:when test="${content_info.get(0).category_id eq '2'}">
							     시리즈
							   </c:when>
							   <c:when test="${content_info.get(0).category_id eq '3'}">
							     버라이어티
							   </c:when>					   
							</c:choose>	 							
							<br/><br/>
							장르  :  
			              	<c:choose>
							   <c:when test="${content_info.get(0).genre_id eq '1'}">
							     액션
							   </c:when>
							   <c:when test="${content_info.get(0).genre_id eq '2'}">
							     드라마
							   </c:when>
							   <c:when test="${content_info.get(0).genre_id eq '3'}">
							     코미디
							   </c:when>					   
							</c:choose>	  							
							<br/><br/>
							런닝타임  :  ${content_info.get(0).run_time}분
							<br/><br/><br/><br/>
							<p>${content_info.get(0).describtion}</p>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;">
							<div style="margin:30px auto 30px auto"><h1>${content_info.get(0).avg_score}</h1></div>
						</td>
						<td>
							<!-- show star emoji by score -->
							<div style="margin:30px auto 30px auto; color:yellow;">      
				              	<c:choose>
								   <c:when test="${content_info.get(0).avg_score < '1'}">
								     <h1>ㅠㅠ</h1>
								   </c:when>
								   <c:when test="${content_info.get(0).avg_score < '2'}">
								     <h1>⭐</h1>
								   </c:when>
								   <c:when test="${content_info.get(0).avg_score < '3'}">
								     <h1>⭐⭐</h1>
								   </c:when>
								   <c:when test="${content_info.get(0).avg_score < '4'}">
								     <h1>⭐⭐⭐</h1>
								   </c:when>
								   <c:when test="${content_info.get(0).avg_score < '5'}">
								     <h1>⭐⭐⭐⭐</h1>
								   </c:when>
								   <c:when test="${content_info.get(0).avg_score == '5'}">
								     <h1>⭐⭐⭐⭐⭐</h1>
								   </c:when>					   
								</c:choose>
							</div>							
						</td>	
					</tr>
				</tbody>	
			</table>
		</div>

	</div>
	<br><br>
	
	<div class="container">
		<h2> 리뷰</h2>
		<table class="table table-hover" style="text-align:center;">
			<thead class="thead-black">
		        <tr>
		            <th style = "color:white;">No.</th>
		            <th style = "color:white;">Nick</th>
		            <th style = "color:white;">Review</th>      
		            <th style = "color:white;">Score</th>
		            <th style = "color:white;">Date</th>
		            <th style = "color:white;"></th>
		         </tr>
			</thead>
			<tbody>
				<c:forEach var="reviews" items="${content_reviews}" varStatus="status">
					<c:url var="delete" value="/ContentControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="review_id" value="${reviews.review_id}"/>
						<c:param name="content_id" value="${content_info.get(0).content_id}"/>
			        </c:url>				
					<tr style = "color:white;">
						<td>${status.count}</td>
						<td>${reviews.userNick}</td>
						<td style="text-align:left;">${reviews.review}</td>
						<td>${reviews.score}</td>
						<td>${reviews.review_at}</td>
						<td><a href="${delete}"><button class="btn btn-dark" <c:if test="${reviews.user_id != userInfo.get(0).user_id}"><c:out value="style=display:none;"/></c:if>>delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<hr>
		<h5>리뷰작성하기</h5>
		<form action="ContentControllerServlet" method="POST">
			<input type="hidden" name="command" value="REVIEW">
			<input type="hidden" name="content_id" value="${content_info.get(0).content_id}">
			<input type="hidden" name="user_id" value="${userInfo.get(0).user_id}">
		    <div class="form-group">
		      <!-- <label for="comment">Comment:</label> -->
		      <textarea class="form-control" rows="5" id="comment" name="review" placeholder="리뷰를 작성해주세요" required></textarea>
		    </div>
			<div class="form-group">
				<!-- <label for="sel1">Score:</label> -->
				<select class="form-control" id="sel1" name = "score" required>
					<option value="" selected disabled hidden="">평점을 선택해주세요</option>
					<option value="0.0">0.0</option>
					<option value="0.5">0.5</option>
					<option value="1.0">1.0</option>
					<option value="1.5">1.5</option>
					<option value="2.0">2.0</option>
					<option value="2.5">2.5</option>
					<option value="3.0">3.0</option>
					<option value="3.5">3.5</option>
					<option value="4.0">4.0</option>
					<option value="4.5">4.5</option>
					<option value="5.0">5.0</option>
				</select>
			</div>
			<button type="submit" class="btn btn-secondary" <c:if test="${empty userInfo}"><c:out value="disabled='disabled'"/></c:if>>write</button>
		</form>
	</div>
</body>
</html>