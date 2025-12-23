<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>세션 정보 삭제</title>
</head>
<body>
	<h4>-------세션 속성 삭제하기 전 ------</h4>
	<%
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	out.println("username : " + username);
	out.println("password : " + password);
	// 세션 속성 제거
	session.removeAttribute("username");
	session.removeAttribute("password");
	%>
	<h4>-------세션 속성 삭제 한 후 ------</h4>
	<%	
	username = (String) session.getAttribute("username");
	password = (String) session.getAttribute("password");
	out.println("username : " + username);
	out.println("password : " + password);
	%>
</body>
</html>