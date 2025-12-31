<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>뉴아즈 네일샵 - 직원 관리</title>
        <link rel="stylesheet" href="css/common.css">
        <style>
            .management-container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
            }

            .card {
                background: #fff;
                padding: 30px;
                border-radius: var(--radius-lg);
                box-shadow: var(--shadow-soft);
                margin-bottom: 30px;
            }

            .card-title {
                font-size: 20px;
                font-weight: 800;
                color: var(--dusty-rose);
                margin-bottom: 20px;
                display: flex;
                align-items: center;
                gap: 10px;
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: 600;
                font-size: 14px;
            }

            .form-control {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-sizing: border-box;
            }

            .staff-list {
                list-style: none;
                padding: 0;
            }

            .staff-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 15px;
                background: #fdfdfd;
                border: 1px solid #f0f0f0;
                border-radius: 10px;
                margin-bottom: 10px;
            }

            .staff-info {
                display: flex;
                align-items: center;
                gap: 15px;
            }

            .staff-avatar {
                width: 40px;
                height: 40px;
                background: var(--main-pink);
                border-radius: 50%;
                display: flex;
                align-items: center;
                justify-content: center;
                color: #fff;
                font-weight: 800;
            }

            .btn-delete {
                background: #ff7675;
                color: #fff;
                border: none;
                padding: 5px 10px;
                border-radius: 4px;
                cursor: pointer;
                font-size: 12px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="include/navbar.jsp" />

        <main>
            <div class="management-container">
                <h1 class="dashboard-title">👥 직원 계정 관리</h1>
                <p style="color: var(--dusty-rose); margin-bottom: 30px;">원장님께서 직접 직원의 계정을 생성하고 관리하실 수 있습니다.</p>

                <!-- 직원 등록 카드 -->
                <div class="card">
                    <div class="card-title">✨ 신규 직원 등록</div>
                    <form onsubmit="alert('직원 등록 기능은 DB 연동 후 활성화됩니다.'); return false;">
                        <div class="form-group">
                            <label>직원 아이디</label>
                            <input type="text" class="form-control" placeholder="아이디 입력">
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" placeholder="초기 비밀번호 입력">
                        </div>
                        <div class="form-group">
                            <label>직원 이름</label>
                            <input type="text" class="form-control" placeholder="이름 입력 (예: 유재인 실장)">
                        </div>
                        <button type="submit" class="btn-primary" style="width:100%; margin-top:10px;">등록하기</button>
                    </form>
                </div>

                <!-- 현재 직원 목록 -->
                <div class="card">
                    <div class="card-title">📋 현재 직원 목록</div>
                    <div class="staff-list">
                        <div class="staff-item">
                            <div class="staff-info">
                                <div class="staff-avatar">유</div>
                                <div>
                                    <div style="font-weight:700;">유재인 실장님 🌸</div>
                                    <div style="font-size:12px; color:#999;">ID: staff_jane</div>
                                </div>
                            </div>
                            <button class="btn-delete">삭제</button>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>

    </html>