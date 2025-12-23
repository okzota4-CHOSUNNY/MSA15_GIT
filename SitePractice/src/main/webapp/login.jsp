<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% 
   String root = request.getContextPath();
   pageContext.setAttribute("root", root);
   %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="${ root }/login" method="post">
		<p>아이디 : <input type="text" name="username" id="username" /> </p>
		<p>비밀번호 : <input type="password" name="password" id="password" /> </p>
		<p>
			<input type="submit" value="로그인" /> 
		</p>
		<c:if test="${ param.error == 0 }">
			<p style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</p>
		</c:if>
	</form>
</body>
</html>