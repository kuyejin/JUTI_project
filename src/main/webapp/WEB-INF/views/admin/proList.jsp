<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/" var="root"></c:url>
<c:url value="/resources/upload" var="upload"></c:url>
<!DOCTYPE html>
<html lang="ko">


	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta property="og:image" content="${root }resources/images/ico/logo.png">
		<script type="text/javascript" src="${root }resources/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${root }resources/js/util.js"></script>
		<script type="text/javascript" src="${root }resources/js/site.js"></script>
		<link type="text/css" rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
		<link type="text/css" rel="stylesheet" href="${root}resources/css/site.css">
		<link rel="shortcut icon" href="${root }resources/favicon.ico">
		<title>JUTI</title>
	</head>
	
	
	<body>
	    <div>
		 	 <table>
				 <thead>
				  <tr>
				   <th>번호</th>
				   <th>이름</th>
				   <th>카테고리</th>
				   <th>가격</th>
				   <th>수량</th>
				   <th>등록날짜</th>
				   <th>이미지</th>
				  </tr>
				 </thead>
				 <tbody>
				  <c:forEach items="${prolist}" var="prolist">
				  <tr>
				   <td>${prolist.product_id}</td>
				   <td>${prolist.product_name}</td>				   
				   <td>${prolist.category_id}</td>
				   <td>${prolist.product_price}</td>
				   <td>${prolist.product_stock}</td>
				   <td>${prolist.product_date}</td>
				   <td>${prolist.product_image}</td>
				   
				   
				  </tr>   
				  </c:forEach>
				 </tbody>
			 </table>  
        </div>
	
	
	</body>
</html>