<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.Board"%>
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
	<title>게시글 목록</title>
</head>
<body>

<%
	List<Board> boardList = new ArrayList<Board>();
	boardList.add( new Board(1, "제목1", "작성자1", "내용1") );
	boardList.add( new Board(2, "제목2", "작성자2", "내용2") );
	boardList.add( new Board(3, "제목3", "작성자3", "내용3") );
	
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd-mm:ss");
	
	pageContext.setAttribute("list", boardList);
%>

	<h1>게시글 목록</h1>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일자</th>
			</tr>
		<%-- Java(스크립틀릿)에서 선언한 변수를 JSTL 에서도 사용할 수 있도록 선언 --%>
		<%--표현문으로 boardList 가져오기 --%>
			<c:forEach var="board" items="<%= boardList %>"> 
			<tr>
					<td>${ board.no }</td>
					<td>${ board.title}</td>
					<td>${ board.writer }</td>
				<td>
					<fmt:formatDate value="${ board.createdAt }" 
										pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
			</c:forEach>
			
			<%-- 3. pageContext 영역에 list 등록한 경우 바로 EL로 접근 가능 --%>
			<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.no }</td>
					<td>${ board.title}</td>
					<td>${ board.writer }</td>
				<td>
					<fmt:formatDate value="${ board.createdAt }" 
										pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
			</c:forEach>
			
	</table>
</body>
</html>