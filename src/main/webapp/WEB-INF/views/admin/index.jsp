<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	
	<li><a href="${root}admin/proRegister">상품등록</a></li>
	<li><a href="${root}admin/proList/">상품목록</a></li>
	<li><a href="${root}product/">상품보기</a></li>
	
	
	</body>
</html>