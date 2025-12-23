<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
</head>
<body>
	<h1>파일</h1>
	
	<form action="/Servlet/method" method="post"
			enctype="Multipart/form-data">
		<div>
			<label for="username">아이디</label>
			<input type="text" name="username" id="username"
					placeholder="아이디를 입력하세요.">
		</div>
		<div>
			<label for="file">파일</label>
			<input type="file" name="file" id="file" />
		</div>
		<input type="submit" value="로그인"> 
		
	</form>
</body>
</html>