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
		<%-- <link type="text/css" rel="stylesheet" href="${root}resources/css/site.css"> --%>
		<link rel="shortcut icon" href="${root }resources/favicon.ico">
		<title>JUTI</title>
		
		
		
		
		
	</head>
	
	
	<body>
	
	<!-- <label><input type="file" name="files" accept="image/*" />파일선택</label>  -->

	<%-- <section class="content_area"> --%>
	    
	    
	   
        <c:url value="/admin/addProRegister" var="registerUrl"/>	    
	    <%-- <form:form action="${registerUrl}"  method="post" class="set_form" enctype="multipart/form-data"> --%>
	     <form:form action="${registerUrl}"  method="post" enctype="multipart/form-data" value="Hello 안녕하세요">     
	         <input type="file" name="files" accept="image/*" />
	       
	       
	         <ul class="input_list"> 
							
	 			<!-- <li class="set_file1 box">
				<p>상품 이미지 등록</p>
					<div>
							<p class="txt_hf plc_holder">
							  <p class="pf_picture">
								
								<input type="file" class="fl_name" id="file1" name="files" accept="image/*">
									
										<img src="${root }resources/upload/no_profile.png" alt="">
									
							</p>
							<ul class="comm_buttons_s">
								<li><label for="file1" class="btn_hf"><i class="xi-file-upload-o"></i><em class="snd_only">등록</em></label></li>
								<li><button type="button" class="comm_btn ">삭제</button></li>
							</ul>
						</div>
				</li>    -->
				
				
			
						
			 <li class="box">
			 	<p><label for="category_id">카테고리</label></p>
			 	<div>
					<select id="category_id" name="category_id" class="form-control">
						<c:forEach items="${category }" var="category" varStatus="status">
							<option value="${category.category_id }">
								${category.category_name }
							</option>
						</c:forEach>
					</select>
				</div>
			</li>	
		    	
			
		     <li class="box">
			 	<p><label for="product_name">상품명</label></p>
			 	<div>
			 		<input type="text" id="product_name" name="product_name" required="required">
			 	</div>
			 </li> 
			
			 <li class="box">
			 	<p><label for="product_price">상품가격</label></p>
			 	<div>
			 		<input type="text" id="product_price" name="product_price" required="required">
			 	</div>
			 </li> 
			
			 <li class="box">
				<p><label for="product_stock">상품수량</label></p>
				<div>
					 <input type="text" id="product_stock" name="product_stock" required="required">
				</div>	 
			 </li>
			
			 <li class="box">
			 	<p><label for="product_date">등록일</label></p>
			 	<div>
			 		<input type="date" id="product_date" name="product_date"/>
			 	</div>	
			 </li> 
									
			</ul>  		
	
			<ul class="comm_buttons">
				<button type="reset" class="btn_close comm_btn cnc">취소</button>
				<button type="submit" id="btn_submit" name="btn_submit" class="comm_btn btn_pop sbm">저장</button>
			</ul>
	
		
	    </form:form>
<%-- 	</section>	 --%>
	</body>
	
	<script>
			setOneFile();
			fileName();
			
	
		  document.getElementById('product_date').value = new Date().toISOString().substring(0, 10);

		
		  



	</script>
	
	
</html>