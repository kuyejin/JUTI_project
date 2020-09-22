<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	    <link type="text/css" rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        <link type="text/css" rel="stylesheet" href="${root}resources/css/site.css">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <title>로그인 페이지</title>
	  
	    
	</head>
	
	<body>
	
			<c:url value ="/login" var="loginUrl"/>	
			<form:form name="login" action="${loginUrl}" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	
			
				<c:if test="${param.error != null}">
			        <p>아이디와 비밀번호가 잘못되었습니다.</p>
			    </c:if>
		    	<c:if test="${param.logout != null}">
			        <p>로그아웃 하였습니다.</p>
			    </c:if>
			    
			
	 		 		   
			    <p>
			        <label for="user_id">아이디</label>
			        <input type="text" id="user_id" name="user_id" />
			    </p>
			    <p>
			        <label for="user_password">비밀번호</label>
			        <input type="password" id="user_password" name="user_password"/>
			    </p>
			   
		    
			   <li><button type="submit" class="btn_close comm_btn cnc">로그인</button></li>
			   <li><a href="${root }join">회원가입</a></li>
				<!-- <li><button type="button" id="btnLogin" class="ok comm_btn cfm">회원가입</button></li> -->
			
			
					
		
		 </form:form>
		 
	
	</body>
</html>