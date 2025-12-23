<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인</title>
</head>
<body>
	<h1>메인 화면</h1>
	<c:if test="${ sessionScope.username != null }">
		<h2>${ sessionScope.username } ( ${ sessionScope.username } )</h2>
	</c:if>
	<h3>주제별 실습</h3>
	<h5>페이지 이동</h5>
	<ul>
		<li><a href="servlet/forward">servlet/forwad</a></li>
		<li><a href="servlet/redirect">servlet/redirect</a></li>
	</ul>
	<ul>
		<li><a href="jsp/forward">jsp/forwad</a></li>
		<li><a href="jsp/redirect">jsp/redirect</a></li>
	</ul>	
	
	<h5>회원가입</h5>
	<a href="signup">회원가입</a>
	<hr>
	<h5>로그인</h5>
	<a href="login">로그인</a>

</body>
</html>










