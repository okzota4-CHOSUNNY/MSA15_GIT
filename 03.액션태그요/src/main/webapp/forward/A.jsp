<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - forward - A 화면</title>
</head>
<body>
<h1>forward A화면</h1>
<jsp:forward page="B.jsp">
	<jsp:param value="name" name="김조은"/>
	<jsp:param value="age" name="20"/>
</jsp:forward>
<p>---------------</p>
</body>
</html>