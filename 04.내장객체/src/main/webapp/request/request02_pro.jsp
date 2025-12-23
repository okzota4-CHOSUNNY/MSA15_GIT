<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

<%
	// * 첫 번째 값만 가져온다(getParameter)
	String hobby = request.getParameter("hobby");
	String[] hobbies = request.getParameterValues("hobby");
	
	for( int i = 0 ; i < hobbies.length ; i++ ) {
	%>
		<h5><%= hobbies[i] %></h5>
	<%
	}
	%>
	<hr>
	<%= hobby %>
</body>
</html>