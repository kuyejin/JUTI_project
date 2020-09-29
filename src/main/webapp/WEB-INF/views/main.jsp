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
<script type="text/javascript">
	$(document).ready(function(){
		
		//로그인하기 내부팝업->로그인버튼 클릭시 로그인외부팝업생성
		$('#btnLogin').on('click', function() {
			$('#login').bPopup().close();
			openLayer('none', '${root}/login');
		});
		var loginCheck = '${login.logincheck}';
		
		//로그인이아닐때 프로필사진,이름,뉴스피드 눌렀을경우
		$(document).on('click','#mainMenu li a:eq(2)',function(){
			if(loginCheck==''){
				openPop('login');
				return false;
			}
		});
		
		var cookie = '${cookie.loginCookie.value}';
		var login = '${login ne null}';

		if(cookie!=''&&login=='false'){
			openPop('loginCookie',none,btn_close);
		}
		
		setInterval(function(){
			$.post('${root}member/loginSession','',function(data){
				if(data==''&&document.cookie!=''){
					clearInterval();
					openPop('loginCookie',none,btn_close);
				}
			});
		},1000*60*10);
		
		$('#btnCookie').on('click',function(){
			$.post('${root}member/loginCookie','id='+cookie,function(data){
				if (data.prorn == '0') {
					location.reload();
				} else if (data.prorn == '1') {
					location.href = "${root}member/stop";
				} else if (data.prorn == '2') {
					location.href = "${root}member/kick";
				} else if (data.prorn == '3') {
					location.reload();
				} else if (data.prorn == '4') {
					location.href = "${root}";
				}
			});
		});
	}); 
	function btn_close(){
        document.cookie = 'loginCookie' + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;path=/';
        var url = window.location.href;
    	if(url.indexOf('group')>0||url.indexOf('news')>0||url.indexOf('user')>0||url.indexOf('admin')>0||url.indexOf('empty')>0){
    		window.location.href='${root}';
    	}
	}
		  

</script>
</head>





<body>

<%-- <c:if test="${sessionScope.user_id ne null }">
	<c:if test="${sessionScope.user_id eq 'admin' }">
		<c:redirect url="${root}ad/"/>
	</c:if>
</c:if>  --%>

<!-- 그룹 -->
	<div id="wrap">
		<div id="header">
			<div class="scrX">
				<div class="container">
					<h1>
						<a href="${root }"><em class="snd_only">JUTI</em></a>
					</h1>
					<form class="search_box" action="${root }search/">
						<input type="text" name="keyword" placeholder="도안을 검색해보세요!" required="required">
						<button type="submit">
							<img src="${root }resources/images/ico/btn_search.png" alt="검색">
						</button>
					</form>
					
					<!-- 모든  사람 볼 수 있음-->
					<sec:authorize access="isAnonymous()"> 
					   		<ul id="fixMenu">	
						   		<li><a href="${root}member/loginForm" class="btn_pop">로그인</a></li>
								<li><a href="${root}member/join">회원가입</a></li>
								<li><a href="${root}cart/">장바구니</a></li>
								<li><a href="${root}mypage/">고객센터</a></li>
						    </ul><br>
					</sec:authorize>
					
					<!-- 로그인한 사람만 보임 -->
					<%-- <sec:authorize access="isAuthenticated()">	 --%>
					<sec:authorize access="hasRole('USER')">																			   		
					   		<ul id="fixMenu">
						   		<li><a href="${root}member/logout" class="btn_pop">로그아웃</a></li>
								<li><a href="${root}mypage/">마이페이지</a></li>
								<li><a href="${root}cart/">장바구니</a></li>
								<li><a href="${root}mypage/">고객센터</a></li>
							</ul><br>
																									
						<sec:authentication var="principal" property="principal"/>
			            <p>${principal.user.user_name} 님 환영합니다</p>																   									   				   
				    </sec:authorize>
				    
				    
				    <!-- 관리자만 보임 -->
				    <sec:authorize access="hasRole('ADMIN')">	
					    <ul id="fixMenu">
					    <li><a href="${root}member/logout" class="btn_pop">로그아웃</a></li>
					    <li><a href="${root}admin/index">관리자페이지</a></li>
					    </ul><br>
				    </sec:authorize>
				    
				    
					
																																	
					<ul id="mainMenu">
						<li><a href="${root}product/">상품보기</a></li>
						<li><a href="${root}order_product/">주문제작</a></li>
						<li><a href="${root}review/">마이도안</a></li>										
					</ul> 
					
					
				
					<button type="button" id="btnTop">
						<em class="snd_only">맨 위로</em>
					</button>
				</div>
			</div>
		</div>
		<div id="main">
			<section class="visual_area">
				<div class="container">
					<div>
						<div class="text_box">
							<img src="resources/images/test/보석.png"
								alt="보석십자수 JUTI">
						</div>
						<form class="search_box" action="${root }search/">
							<input type="text" name="keyword" placeholder="도안을 검색해보세요!" required="required">
							<button type="submit">검색</button>
						</form>
					</div>
				</div>
			</section>
			<section class="group_area">
				<div class="container">
					<h2 class="main_tit">
						<em class="snd_only">추천 그룹</em>이런 도안은 어때요?
					</h2>
					<ul class="group_list">
						<c:forEach items="${grouplist }" var="grouplist">
							<c:if test="${login ne null }">
								<li>
									<a class="gp_thumb" href="${root }group/?grnum=${grouplist.grnum}&pronum=${login.pronum}"> 
									<c:if test="${empty grouplist.grphoto }">
										<img src="${root}resources/images/test/빨간색.jpg" alt="${grouplist.grname } 그룹 썸네일">
									</c:if>
									<c:if test="${!empty grouplist.grphoto }">
										<img src="${upload }/${grouplist.grphoto}" alt="${grouplist.grname } 그룹 썸네일">
									</c:if>
									</a> 
									<a class="gp_text" href="${root }group/?grnum=${grouplist.grnum}&pronum=${login.pronum}"> <strong>${grouplist.grname }</strong> <span>${grouplist.grintro }</span>
									</a>
								</li>
							</c:if>
							
							<c:if test="${login eq null }">
								<li><a class="gp_thumb" href="${root }group/?grnum=${grouplist.grnum}"> 
								<c:if test="${empty grouplist.grphoto }">
									<img src="${root}resources/images/test/주황색.png" alt="${grouplist.grname } 그룹 썸네일">
								</c:if>
								<c:if test="${!empty grouplist.grphoto }">
									<img src="${upload }/${grouplist.grphoto}" alt="${grouplist.grname } 그룹 썸네일">
								</c:if>
								</a> <a class="gp_text" href="${root }group/?grnum=${grouplist.grnum}"> <strong>${grouplist.grname }</strong> <span>${grouplist.grintro }</span>
								</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</section>
			<section class="camp_area">
				<div class="container">
					<h2 class="main_tit">
						<em class="snd_only">추천 캠핑장</em>인기있는 도안
					</h2>
					<div class="slide_box">
						<div class="swiper-wrapper">
							<c:forEach items="${camplist }" var="camplist">
								<dl class="swiper-slide">
									<dt>
									<c:if test="${!empty camplist.caphoto }">
										<c:set var="image1" value="${fn:split(camplist.caphoto,',') }" />
										<c:if test="${fn:length(image1) gt 1 }">
											<c:set var="image"
												value="${fn:substringBefore(camplist.caphoto,',') }" />
										</c:if>
										<c:if test="${fn:length(image1) eq 1 }">
											<c:set var="image" value="${camplist.caphoto }" />
										</c:if>
										<span><img src="${upload }/${image}"
											alt="${camplist.caname } 썸네일"></span>
									</c:if>
									<c:if test="${empty camplist.caphoto }">
										<span><img src="${root }resources/images/test/보라색.PNG"
												alt="${camplist.caname } 썸네일"></span>
									</c:if>
									</dt>
									<dd>
										<a href="${root }camp/detail?canum=${camplist.canum}&caaddrsel=${camplist.caaddrsel}"
											class="txtbox"> <strong>${camplist.caname }</strong> <span>${camplist.caaddrsel }</span>
											<b class="cp_liked">${camplist.cagood }</b>
										</a>
									</dd>
								</dl>
							</c:forEach>
						</div>
						<div class="swiper-pagination"></div>
					</div>
				</div>
			</section>
		</div>
		<div id="footer">
			<div class="container">
				<div class="img_box">
					<img src="resources/images/ico/logo_w.png" alt="FESTA">
				</div>
				<div class="text_box">
					<p>
						<span>JUTI</span>
						<span>서울특별시 마포구 비트캠프</span>
					</p>
					<p>
						<span>사업자등록번호 : 123-45-67890</span>
						<span>대표번호 : 000-0000-00000</span>
						<span>담당자 : 구예진</span>
					</p>
					<p>&copy; FESTA. All RIGHTS RESERVED.</p>
				</div>
			</div>
		</div>
	</div>


<!-- #팝업 처리완료 { -->
<div id="login" class="fstPop">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit">로그인이 필요한 서비스입니다.</p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close comm_btn cnc">닫기</button></li>
			<li><button type="button" id="btnLogin" class="ok comm_btn cfm">로그인</button></li>
		</ul>
	</div>
</div>
<!-- #팝업 처리완료 { -->
<div id="loginCookie" class="fstPop">
	<div class="confirm_wrap pop_wrap">
		<p class="pop_tit">기존 정보로 로그인 하시겠습니까?</p>
		<ul class="comm_buttons">
			<li><button type="button" class="btn_close btnCookieClose comm_btn cnc">로그아웃</button></li>
			<li><button type="button" id="btnCookie" class="ok comm_btn cfm">로그인</button></li>
		</ul>
	</div>
</div>
	<script type="text/javascript">
		main();
	</script>
</body>
</html>