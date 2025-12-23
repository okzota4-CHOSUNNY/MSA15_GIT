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
	<title>JSTL - function</title>
</head>
<body>

	<h1>contains() 함수</h1>
	
	<p>
		문자열 포함 여부
		: ${ fn:contains("Hello JSTL~!", "JSTL") }
	<p>
	
	<p>
		문자열 포함 여부(대소문자 구분X)
		: ${ fn:containsIgnoreCase("Hello JSTL~!", "JSTL") }
	<p>
	
	<p>
		문자열 포함 여부
		: ${ fn:contains("Hello JSTL~!", "JSTL") }
	<p>
	
	<h1>toUpperCase(), toLowerCase</h1>
	<p>
		hello jstl~!
		: ${ fn:toUpperCase("hello jstl" ) }
	<p>
	
	<p>
		hello jstl~!
	: ${ fn:toUpperCase("hello jstl~!" ) }
	<p>	
	
	<p>
		hello jstl~!
		: ${ fn:toUpperCase("HELLO JSTL!~") }
	<p>	
	<h1> length() 함수</h1>
	글자수 : Hello JSTL~! ( ${fn:length("Hello JSTL!~!")} )

	
		<h1>split() 함수</h1>
		<c:set var="texts" value="${fn:split('Hello JSTL!', ' ')}" />
		<c:forEach var="i" begin="0" end="${fn:length(texts)-1}">
		    <p>texts[${i}] : ${texts[i]}</p>
		</c:forEach>
		
		<h1>join() 함수</h1>
		<p>
		    <c:out value="${fn:join(texts, ',')}" />
		</p>
		<div style="height: 500px"></div>
</body>
</html>