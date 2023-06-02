<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>member</title>
</head>
<body>
	<div class="container pt-3">
		<h4>Web MVC FrontController Pattern 기반회원관리</h4>
<!-- 
	개발 순서
	Controller -> HandlerMapping -> FrontController
 -->
 <%-- 
	로그인한 사용자에게 보이는 정보 : 인증정보(MemberVO)는 session에 mvo name으로 저장
--%>
		<c:choose>
			<c:when test="${name!=null}">
				<a href="FrontControllerPatternTest.do">front test</a>
				<br>
				<br>
				<form action="FindMemberById.do" method="get">
					<input type="text" name="id" placeholder="회원아이디"
						required="required">
					<button type="submit">검색</button>
				</form>
				<br>
				<form action="FindMemberByAddress.do" method="get">
					<input type="text" name="address" placeholder="회원주소"
						required="required">
					<button type="submit">검색</button>
				</form>
				<br>
			${name}님 로그인 상태입니다 <br>
				<form action="Logout.do" method="post">
					<button type="submit">로그아웃</button>
				</form>
				<br>
			</c:when>
<%--
	로그인하지 않은 사용자에게 보이는 정보
--%>
			<c:otherwise>
				<form action="Login.do" method="post">
					<input type="text" name="id" required="required" placeholder="아이디">
					<input type="text" name="password" required="required" placeholder="비밀번호">
					<button type="submit">로그인</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>