<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	   <c:url value="/" var="root" /> 
	    <link type="text/css" rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        <link type="text/css" rel="stylesheet" href="${root}resources/css/site.css">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <title>로그인 페이지</title>
	    

	</head>
	
	<body>
	    <!-- #1단계팝업 로그인 -->
		<div class="login_wrap pop_wrap">
			<h2>
				<img src="${root }resources/images/test/보석.png" alt="JUTI">
			</h2>
			<!-- 로그인 { -->
			<section id="log1" class="login_area act">
				<div>
					<h3 class="snd_only">로그인</h3>
				  
				    <c:url value="/login" var="loginUrl" />  
					<form:form action="${loginUrl}" method="post" id="loginForm" name="loginForm"  class="comm_form">				
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	
					
					
					     <c:if test="${param.error != null}">
					        <p>아이디와 비밀번호가 잘못되었습니다.</p>
					    </c:if>

				
						<div class="ip_box">
							<input id="id" name="id" type="text" placeholder="아이디">
						</div>
						<div class="ip_box">
							<input id="pw" name="pw" type="password" placeholder="password">
						</div>
						
						<p id="check" hidden="hidden" class="f_message rst">아이디 혹은 비밀번호를 다시 확인해주세요.</p>
						<button type="submit" name="btn_submit2" id="btn_submit2"
							class="comm_btn sbm">로그인</button>
					</form:form>
				
					
					<ul class="lg_find">
						<li><a href="${root }member/join">회원가입</a></li>
						<li>
							<button type="button" class="btn_move" data-layer="log2">아이디</button>
							/
							<button type="button" class="btn_move" data-layer="log3">비밀번호</button>
							찾기
						</li>
					</ul>
				</div>
			</section>
		</div>
	
				
				
		<!-- } #3단계팝업 처리완료 -->
		<script type="text/javascript">
			loginMove();
			btnPop('btn_pop2');
			formTagCss();
		</script>

	</body>
</html>