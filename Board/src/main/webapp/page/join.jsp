<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>project💻 - ALOHA CLASS🌴</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />
</head>
<body>
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>
		
	<main>
		<div class="px-4 py-5 mt-5 text-center">
			<h1 class="display-5 fw-bold text-body-emphasis">회원 가입</h1>
		</div>
		
		<!-- 회원 가입 영역 -->
		<div class="container shop p-1 p-md-2 p-lg-4 mb-5" >
			<div class="row justify-content-center">
				<div class="col-12 col-md-10 col-lg-6">
					<form action="${ root }/join" name="joinForm" method="post">
						<input type="hidden" name="duplicaed" id="duplicaed" value="false" /> 
						<div class="input-group mx-0 mb-3 row">
							<label for="username" class="input-group-text col-md-4" id="lb_username">아이디</label>
							<input type="text" class="form-control col-md-6" 
								   name="username" id="username" placeholder="아이디" required>
							<button type="button" onclick="clickIdCheck()" class="btn btn-success col-md-2">중복확인</button>
						</div>
						
						<div class="input-group mx-0 mb-3 row">
							<label for="password" class="input-group-text col-md-4" id="lb_password">비밀번호</label>
							<input type="password" class="form-control col-md-8" 
								   name="password" id="password" placeholder="비밀번호" required>
						</div>
						
						<div class="input-group mx-0 mb-3 row">
							<label for="password_confirm" class="input-group-text col-md-4" id="lb_password_confirm">비밀번호 확인</label>
							<input type="password" class="form-control col-md-8" 
								   name="password_confirm" id="password_confirm" placeholder="비밀번호 확인" required>
						</div>
						
						<div class="input-group mx-0 mb-3 row">
							<label for="name" class="input-group-text col-md-4" id="lb_name">이름</label>
							<input type="text" class="form-control col-md-8" 
								   name="name" id="name" placeholder="이름" required>
						</div>
						
						<div class="input-group mx-0 mb-3 row">
							<label for="email" class="input-group-text col-md-4" id="lb_email">이메일</label>
							<input type="text" class="form-control col-md-8" 
								   name="email" id="email" placeholder="이메일">
						</div>
						
						<div class="d-grid gap-2 mt-5 mb-5">
							<input type="button" class="btn btn-lg btn-primary" value="가입" onclick="checkUser()" />
							<a href="javascript: history.back()" class="btn btn-lg btn-secondary">취소</a>
						</div>	
					</form>
					
				</div>
			</div>
		</div>
	</main>
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
	
	<script>
		async function clickIdCheck() {
			
			// 아이디 유효성 검사
			let username = document.getElementById("username").value
			let usernameCheck = /^[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]{5,20}$/
			let msg = '아이디는 한글, 영문자, 숫자 5~20 자로 입력해주세요.'
			if(!usernameCheck.test(username)) {
				alert(msg)
				return false
			}
			
			let check = await idCheck()
			if( check ) {
				alert('중복된 아이디 입니다.')
			} else {
				alert('사용 가능한 아이디 입니다.')
			}
		}
	</script>
</body>
</html>