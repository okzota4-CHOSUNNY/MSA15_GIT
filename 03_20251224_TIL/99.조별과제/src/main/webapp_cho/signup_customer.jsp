<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/signup_customer.css">
    </head>

    <body>
        <jsp:include page="include/header.jsp" />

        <main class="signup-main">
            <div class="wrapper">
                <div class="title">회원가입</div>

                <form id="signupForm" action="signupAction.jsp" method="post">
                    <div class="input-group">
                        <input type="text" name="id" placeholder="아이디" required>
                    </div>

                    <div class="input-group">
                        <input type="password" name="pw" placeholder="비밀번호" required>
                    </div>

                    <div class="input-group">
                        <input type="email" name="email" placeholder="이메일 주소">
                    </div>

                    <div class="input-group">
                        <input type="text" name="name" placeholder="이름" required>
                    </div>

                    <div class="input-group">
                        <input type="tel" name="phone" placeholder="휴대전화번호">
                    </div>

                    <div class="birth-group">
                        <input type="text" name="birthYear" placeholder="년(4자)" maxlength="4">
                        <input type="text" name="birthMonth" placeholder="월">
                        <input type="text" name="birthDay" placeholder="일">
                    </div>

                    <div class="select-group">
                        <label>
                            <input type="radio" name="gender" value="M">
                            <div class="radio-box">남자</div>
                        </label>
                        <label>
                            <input type="radio" name="gender" value="F">
                            <div class="radio-box">여자</div>
                        </label>

                        <label style="width: 50%;">
                            <input type="radio" name="nation" value="local" checked>
                            <div class="radio-box">내국인</div>
                        </label>
                        <label style="width: 50%;">
                            <input type="radio" name="nation" value="foreign">
                            <div class="radio-box">외국인</div>
                        </label>
                    </div>

                    <button type="submit" class="btn-submit">회 원 가 입</button>
                </form>
            </div>
        </main>

        <script>
            $(document).ready(function () {
                $("#signupForm").submit(function (e) {
                    console.log("가입 버튼 클릭됨");
                });
            });
        </script>
        <jsp:include page="include/footer.jsp" />
    </body>

    </html>