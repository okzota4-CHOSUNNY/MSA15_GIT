<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵 - 로그인</title>
        <link rel="stylesheet" href="css/common.css">
        <style>
            .auth-container {
                max-width: 400px;
                margin: 80px auto;
                background: #fff;
                padding: 40px;
                border-radius: var(--radius-lg);
                box-shadow: var(--shadow-soft);
            }

            .auth-title {
                font-size: 28px;
                font-weight: 800;
                color: var(--dusty-rose);
                text-align: center;
                margin-bottom: 10px;
            }

            .auth-subtitle {
                text-align: center;
                color: #999;
                font-size: 14px;
                margin-bottom: 40px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            .form-control {
                width: 100%;
                padding: 15px;
                border: 1px solid #eee;
                background-color: #fbfbfb;
                border-radius: var(--radius-md);
                box-sizing: border-box;
                font-size: 15px;
            }

            .btn-auth {
                width: 100%;
                padding: 15px;
                background-color: var(--dusty-rose);
                color: #fff;
                border: none;
                border-radius: var(--radius-md);
                font-size: 16px;
                font-weight: 700;
                cursor: pointer;
                margin-top: 10px;
                box-shadow: 0 4px 10px rgba(220, 174, 150, 0.3);
            }

            .auth-footer {
                margin-top: 30px;
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
            <h1 class="auth-title">Nuage Nail</h1>
            <p class="auth-subtitle">뉴아즈 네일샵 관리 시스템</p>
            <form action="reservation_dashboard.jsp" method="get">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="아이디" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="비밀번호" required>
                </div>
                <button type="submit" class="btn-auth">로그인</button>
            </form>
            <div class="auth-footer">
                원장님이신가요? <a href="signup.jsp">계정 생성하기</a>
            </div>
        </div>
    </body>

    </html>