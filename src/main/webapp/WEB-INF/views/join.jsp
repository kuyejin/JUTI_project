<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>회원가입</title>
		<script type="text/javascript">		 
		function checkfield(){
		 document.addjoin.submit();		 
		}
		</script>
	</head>
	
	<body>
		<center>
		<h1> 회원가입</h1>
		 		   
		    <c:url value ="/user/addUser" var="addUserUrl" />
			<form:form name="join" action="${addUserUrl}"  method="POST">
			
			<label for="juti1" class="comm_label">아이디 </label>
			<input type="text" id="user_id" name="user_id" required> 
			<button type="button" id="email_check" class="btn_id">중복확인</button></br>
			
			<label for="juti2" id="juti2" class="comm_label">비밀번호</label>
			<input type="password" id="user_password" name="user_password" required>
			</br>      
			
			<label for="juti3" id="juti3" class="comm_label">비밀번호 확인</label>
			<input type="password" id="user_passwordCheck" name="user_passwordCheck" required>
			</br>   
	                              
		
			<label for="juti4" class="comm_label">이름</label>
			<input type="text" id="user_name" name="user_name" required> 
			</br>   
			
			<label for="juti5" class="comm_label">생년월일</label>
			<select name="year">
			<%for(int i=2020; i>1949; i--){ %>
			<option value="<%=i%>"><%=i %>년</option>
			<%} %>
			</select>
			 
			<select name="month">
			<%for(int i=1; i<13; i++){ %>
			<option value="<%=i%>"><%=i %>월</option>
			<%} %>
			</select>
			 
			<select name="day">			 
			<%for(int i=1; i<31; i++){ %>
			<option value="<%=i%>"><%=i %>일</option>
			<%} %>
			</select>
			</br>  
			
			<label for="juti6" class="comm_label">핸드폰번호</label>
			<input type="text" id="user_phonenumber" name="user_phonenumber" required> 
			</br>   
			
			<label for="juti8" class="comm_label">이메일</label>
			<input type="text" id="user_email" name="user_email" required> 
			</br>  			    			   		    
		
			
			<label for="juti7" class="comm_label">주소</label>
			<input type="text" id="user_addressr" name="user_address" required> 
			</br>   
			
			

	
			<button type="submit" id="joinBtn" class="comm_btn sbm">가입하기</button>
			<input type="reset" value="새로작성">
			 
			</form:form>

		 
		
		</center>
	</body>
</html>