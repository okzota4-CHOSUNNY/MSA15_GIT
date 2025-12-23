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
	<title>jsp 에서 redirect 방식으로 이동</title>
</head>
<body>
<h1>jsp 에서 redirect 방식으로 이동</h1>
<c:set var="root" value="${ request.getContextPath() }" />
<c:redirect url="${ root }/jsp/redirect/B.jsp" />
</body>
</html>