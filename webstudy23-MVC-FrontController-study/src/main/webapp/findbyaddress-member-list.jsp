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
<title>member list</title>
</head>
<body>
	<div class="container pt-3">
		${param.address} 주소에 사는 회원 명단
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>아이디</th>
					<th>회원명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memList}" var="mem">
					<tr>
						<td>${mem.id}</td>
						<td>${mem.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>