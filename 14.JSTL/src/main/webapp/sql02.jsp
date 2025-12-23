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
	<title>JSTL - sql</title>
</head>
<body>

	<h1>게시글 목록</h1>
	<!-- 데이터 소스 -->
	<sql:setDataSource var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>

<%-- <sql:query var="결과객체" dataSource="${dataSource}"> SQL문 </sql:query> --%>
<sql:query var="list" dataSource="${dataSource}">
	SELECT * FROM board
</sql:query>

<table border="1">
    <tr>
    	<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일자</th>
	</tr>
	<c:forEach var="row" items="${ list.rows }">
	    <tr>
	        <td>${ row.no }</td>
	        <td>
		        <a href="sql03.jsp?id=${ row.id }">
		       	 	${ row.title }
		     	  </a>
	        ${ row.title }</td>
	        <td>${ row.writer }</td>
	        <td>
	            <fmt:formatDate value="${ row.created_at }"
	                            pattern="yyyy-MM-dd HH:mm:ss" />
	        </td>
	    </tr>
	</c:forEach>
</table>

</body>
</html>