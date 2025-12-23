<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>액션 태그 - include</title>
</head>
<body>

<%
    String menu1 = "Home";
    String menu2 = "Board";
    String menu3 = "Galllery";
%>
<%-- 액션태그 include --%>
<jsp:include page="header.jsp">
    <jsp:param name="menu1" value="menu1" />
    <jsp:param name="menu2" value="menu2" />
    <jsp:param name="menu3" value="menu3" />
</jsp:include>
<main>
    <div class="contaienr">
        <h1>메인 영역</h1>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</main>

</body>
</html>