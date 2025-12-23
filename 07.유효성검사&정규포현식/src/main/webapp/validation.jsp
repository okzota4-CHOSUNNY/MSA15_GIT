<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 비밀번호 유효성 검사</title>
</head>
<body>
	<h1>로그인</h1>
	<h3>유효성 검사</h3>

	<form name="loginForm"
	      action="validation_pro.jsp"
	      onsubmit="return checkLogin()"
	      method="post">

	 	<p>아이디 : <input type="text" name="id" maxlength="20"></p>
		<p>비밀번호 : <input type="password" name="pw"></p> 	
		<p><input type="submit" value="로그인"></p>
	</form>
	 
	<script>
	 // 로그인 유효성 검사
	 function checkLogin() {
		let form = document.loginForm 

		let id = form.id.value
		let pw = form.pw.value
		
		// 1. 아이디 필수 입력
		if (id == "") {
			alert("아이디를 입력해주세요")
			form.id.focus()
			return false
		}

		// 2. 아이디 글자 수 검증
		if (id.length < 6 || id.length > 20) {
			alert("아이디는 6~20자 이내로 입력 가능합니다.")
			form.id.select()
			return false
		}

		// 3. 비밀번호 필수 입력
		if (pw == "") {
			alert("비밀번호를 입력해주세요")
			form.pw.focus()
			return false
		}

		// 4. 비밀번호 글자 수 검증
		if (pw.length < 6) {
			alert("비밀번호는 6자 이상 입력해야 합니다.")
			form.pw.select()
			return false
		}

		return true; // 유효성 통과 → submit 진행됨
	 }
	</script>
	 
</body>
</html>
