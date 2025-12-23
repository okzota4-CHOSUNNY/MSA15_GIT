<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - forwad - B 화면</title>
</head>
<body>
	<h1>forwad B 화면</h1>
	<h3>name : <%= request.getParameter("name") %></h3>
	<h3>age : <%= request.getParameter("age") %></h3>
</body>
</html>