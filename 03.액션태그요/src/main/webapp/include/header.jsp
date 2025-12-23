<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 설정: 자바 사용 / HTML 출력 / UTF-8 인코딩 지정 -->

<!DOCTYPE html>
<!-- HTML5 문서 타입 선언 -->

<html>
<!-- HTML 문서 시작 -->

<head>
<!-- 문서 head 영역 시작 -->

<meta charset="UTF-8">
<!-- 브라우저가 이 문서를 UTF-8로 해석하도록 지정 -->

<title>Insert title here</title>
<!-- 브라우저 탭 제목 -->

</head>
<!-- head 영역 끝 -->

<body>
<!-- body 시작 -->

<%
String menu1 = request.getParameter("menu1");
%>
<!-- 요청 파라미터 menu1 값을 가져와 menu1 변수에 저장 -->

<%
String menu2 = request.getParameter("menu2");
%>
<!-- 요청 파라미터 menu2 값을 가져와 menu2 변수에 저장 -->

<%
String menu3 = request.getParameter("menu3");
%>
<!-- 요청 파라미터 menu3 값을 가져와 menu3 변수에 저장 -->

<header>
<!-- 페이지 상단 헤더 시작 -->

<h1>헤더 영역</h1>
<!-- 단순 텍스트 출력 -->

<!-- include 액션태그 설명용 JSP 주석(클라이언트에게 보이지 않음) -->

<ul>
<!-- 메뉴를 보여줄 리스트 시작 -->

<li><%= menu1 %></li>
<!-- menu1 변수 값을 HTML에 출력 -->

<li><%= menu2 %></li>
<!-- menu2 변수 값을 HTML에 출력 -->

<li><%= menu3 %></li>
<!-- menu3 변수 값을 HTML에 출력 -->

</ul>
<!-- 리스트 끝 -->

</header>
<!-- header 종료 -->

</body>
<!-- body 종료 -->

</html>
<!-- HTML 문서 끝 -->
