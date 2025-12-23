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
	<title>Servlet forward 방식으로 이동</title>
</head>
<body>
	<h1>Sevlet forward 방식으로 이동</h1>
	<h2>servlet/forward/detail.jsp</h2>
	<h3>${ msg }</h3>
	<ul>
		<li>name : ${ param.name }</li>
		<li>age : ${ param.age }</li>
	</ul>
</body>
</html>







