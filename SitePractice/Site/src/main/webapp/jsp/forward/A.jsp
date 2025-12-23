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
	<title>jsp 에서 forward 방식으로 이동</title>
</head>
<body>
	<h1>jsp 에서 forward 방식으로 이동</h1>

<jsp:forward page="B.jsp">
    <jsp:param name="name" value="김조은"/>
    <jsp:param name="age" value="20"/>
</jsp:forward>
</body>
</html>