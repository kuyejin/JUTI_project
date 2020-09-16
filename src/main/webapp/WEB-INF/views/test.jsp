<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!-- view 부분이다 -->

<!DOCTYPE html>
<html lang="ko">
<head>
    
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta property="og:image" content="/images/ico/logo.png">
	<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="/js/util.js"></script>
	<script type="text/javascript" src="/js/site.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link rel="stylesheet" href="/css/site.css">
	<link rel="shortcut icon" href="/favicon.ico">
	<title>FESTA</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div class="scrX">
			<div class="container">
				<h1>
					<a href="/"><em class="snd_only">FESTA</em></a>
				</h1>
				<form class="search_box">
					<input type="text" placeholder="캠핑장 또는 그룹을 검색해보세요!">
					<button type="submit"><img src="/images/ico/btn_search.png" alt="검색"></button>
				</form>
				<ul id="gnb">
					<li><a href="/camp/">캠핑정보</a></li>
					<li><a href="/hot/">인기피드</a></li>
					<li><a href="/news/">뉴스피드</a></li>
					<!-- <li><a href="/member/login" class="btn_pop">로그인</a></li> -->
					<li><a href="/user/">마이페이지</a></li>
				</ul>
				<div id="userMenu" class="fstLyr">
					<button class="btn_menu"><em class="snd_only">나의 메뉴 더보기</em></button>
					<dl class="menu_box" tabindex="0">
						<dt><b>조혜진님 환영합니다</b></dt>
						<dd>
							<span class="btn_mylist">나의 그룹</span>
							<div class="my_list">
								<ul>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="입돌아간다 그룹 썸네일"></span>
											<b>입돌아간다 입돌아간다 입돌아간다</b>
										</a>
									</li>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="그룹 썸네일"></span>
											<b>그룹명</b>
										</a>
									</li>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="그룹 썸네일"></span>
											<b>그룹명</b>
										</a>
									</li>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="그룹 썸네일"></span>
											<b>그룹명</b>
										</a>
									</li>
								</ul>
							</div>
						</dd>
						<dd>
							<span class="btn_mylist">나의 채팅</span>
							<div class="my_list">
								<ul>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="입돌아간다 그룹 썸네일"></span>
											<b>입돌아간다</b>
										</a>
									</li>
								</ul>
							</div>
						</dd>
						<dd>
							<span class="btn_mylist">나의 캠핑장</span>
							<div class="my_list">
								<ul>
									<li>
										<a href="">
											<span><img src="http://placehold.it/45x45" alt="캠핑장 썸네일"></span>
											<b>캠핑장명</b>
										</a>
									</li>
								</ul>
							</div>
						</dd>
						<dd class="btn_logout">
							<form>
								<a href="/member/logout" class="btn_pop">로그아웃</a>
							</form>
						</dd>
					</dl>
				</div>
				<button type="button" id="btnTop"><em class="snd_only">맨 위로</em></button>
			</div>
		</div>
	</div>
	<div id="main">
		<section class="visual_area">
			<div class="container">
				<div>
					<div class="text_box">
						<img src="/images/main/bg_copy.png" alt="솔직한 리뷰, 믿을 수 있는 캠핑! FESTA">
					</div>
					<form class="search_box">
						<input type="text" placeholder="캠핑장 또는 그룹">
						<button type="submit">검색</button>
					</form>
				</div>
			</div>
		</section>
		<section class="group_area">
			<div class="container">
				<h2 class="main_tit"><em class="snd_only">추천 그룹</em>이런 그룹은 어때요?</h2>
				<ul class="group_list">
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="입돌아간다 그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>입돌아간다</strong>
							<span>안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다. 안녕하세요 ㅇㅇㅇ입니다.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/110x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
					<li>
						<a class="gp_thumb" href="">
							<img src="http://placehold.it/210x110" alt="그룹 썸네일">
						</a>
						<a class="gp_text" href="">
							<strong>그룹</strong>
							<span>그룹 소개글을 작성해주세요.</span>
						</a>
					</li>
				</ul>
			</div>
		</section>
		<section class="camp_area">
			<div class="container">
				<h2 class="main_tit"><em class="snd_only">추천 캠핑장</em>믿고 가는 캠핑장 베스트</h2>
				<div class="slide_box">
					<div class="swiper-wrapper">
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/300x300" alt="바다애캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>바다애캠핑장</strong>
									<span>인천 강화</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
						<dl class="swiper-slide">
							<dt><span><img src="http://placehold.it/492x223" alt="캠핑장 썸네일"></span></dt>
							<dd>
								<a href="" class="txtbox">
									<strong>캠핑장명</strong>
									<span>지역</span>
									<b class="cp_liked">300</b>
								</a>
							</dd>
						</dl>
					</div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
		</section>
	</div>
	<div id="footer">
		<div class="container">
			<div class="img_box">
				<img src="/images/ico/logo_w.png" alt="FESTA">
			</div>
			<div class="text_box">
				<p>
					<span>경기도 성남시 분당구 느티로 2, AK와이즈플레이스</span>
					<span>김채찍과노예들</span>
					<span>사업자등록번호 : 123-45-67890</span>
				</p>
				<p>
					<span>통신판매신고번호 : 제 2020-서울강남-0000</span>
					<span>대표번호 : 010-3332-8616</span>
					<span>담당자 : 김덕수</span>
					<span>문의 : 010-3332-8616</span>
				</p>
				<p>&copy; DEOKSOORR. All RIGHTS RESERVED.</p>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	main();
</script>
</body>
</html>