<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<c:url value="/admin/addProRegister" var="registerUrl"/>
	   <%-- <form:form action="${registerUrl}" role="form" method="post" autocomplete="off"> --%>
	   <form:form action="${registerUrl}"  method="post">


			 
			 <label for="category_id">카테고리</label>
				<select id="category_id" name="category_id" class="form-control">
					<c:forEach items="${ category }" var="category" varStatus="status">
						<option value="${ category.category_id }">
							${ category.category_name }
						</option>
					</c:forEach>
				</select>
		
	
			
			<div class="ip_box">
			 <label for="product_name">상품명</label>
			 <input type="text" id="product_name" name="product_name" />
			</div>
			
			<div class="ip_box">
			 <label for="product_price">상품가격</label>
			 <input type="text" id="product_price" name="product_price" />
			</div>
			
			<div class="ip_box"> 
			 <label for="product_stock">상품수량</label>
			 <input type="text" id="product_stock" name="product_stock" />
			</div>
			
			<div class="ip_box">
			 <label for="product_date">등록일</label>
			 <input type="date" id="product_date" name="product_date"/>
			</div>
			
			
			 <button type="submit">등록</button>
			
		
		</form:form>
			
	</body>
	
	<script>
		  document.getElementById('product_date').value = new Date().toISOString().substring(0, 10);




</script>
	
	
</html>