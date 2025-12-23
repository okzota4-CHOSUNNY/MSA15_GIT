<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<!-- 
	    파일을 서버로 전송하기 위해서는 
	    enctype="multipart/form-data" 설정을 해야한다.
	-->
<form action="/Servlet/method" 
      method="post" 
      enctype="multipart/form-data">
      
    <div>
        <label for="username">아이디</label>
        <input type="text" 
               name="username" 
               id="username" 
               placeholder="아이디를 입력하세요." />
    </div>
    
    <div>
        <label for="password">비밀번호</label>
        <input type="password" 
               name="password" 
               id="password" 
               placeholder="비밀번호를 입력하세요." />
    </div>
    
    <input type="submit" value="로그인" />
</form>
</body>
</html>