<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵 - 원장 가입</title>
        <link rel="stylesheet" href="css/common.css">
        <style>
            .auth-container {
                max-width: 400px;
                margin: 50px auto;
                background: #fff;
                padding: 40px;
                border-radius: var(--radius-lg);
                box-shadow: var(--shadow-soft);
            }

            .auth-title {
                font-size: 24px;
                font-weight: 800;
                color: var(--dusty-rose);
                text-align: center;
                margin-bottom: 30px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            .form-group label {
                display: block;
                margin-bottom: 8px;
                font-weight: 600;
                font-size: 14px;
            }

            .form-control {
                width: 100%;
                padding: 12px;
                border: 1px solid #ddd;
                border-radius: var(--radius-md);
                box-sizing: border-box;
            }

            .btn-auth {
                width: 100%;
                padding: 14px;
                background-color: var(--dusty-rose);
                color: #fff;
                border: none;
                border-radius: var(--radius-md);
                font-size: 16px;
                font-weight: 700;
                cursor: pointer;
                margin-top: 10px;
            }

            .auth-footer {
                margin-top: 20px;
                text-align: center;
                font-size: 14px;
                color: #777;
            }

            .auth-footer a {
                color: var(--main-pink);
                text-decoration: none;
                font-weight: 600;
            }
        </style>
    </head>

    <body class="signup-main">
        <div class="auth-container">
            <h1 class="auth-title">👑 원장님 회원가입</h1>
            <form action="reservation_dashboard.jsp" method="get">
                <div class="form-group">
                    <label>아이디</label>
                    <input type="text" class="form-control" placeholder="아이디를 입력하세요" required>
                </div>
                <div class="form-group">
                    <label>비밀번호</label>
                    <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" required>
                </div>
                <div class="form-group">
                    <label>샵 이름</label>
                    <input type="text" class="form-control" value="뉴아즈 네일샵" readonly>
                </div>
                <div class="form-group">
                    <label>이름</label>
                    <input type="text" class="form-control" placeholder="원장님 성함을 입력하세요" required>
                </div>
                <button type="submit" class="btn-auth">가입하기</button>
            </form>
            <div class="auth-footer">
                이미 계정이 있으신가요? <a href="login.jsp">로그인</a>
            </div>
        </div>
    </body>

    </html>