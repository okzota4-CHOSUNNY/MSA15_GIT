<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>응답 상태 코드</title>
</head>
<body>
	<%
		// response.sendError(상태코드, "에러메시지");
		// response.sendError(404, "페이지를 찾을 수 없음ㅋㅋㅋㅋㅋㅋ");
		 response.sendError(500, "서버 내부 에러ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
	%>

</body>
</html>