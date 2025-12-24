<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>리뷰 조회 - 망머샵 미용실</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
		<link rel="stylesheet" href="css/review_list.css">
    </head>

    <body>
	        <jsp:include page="include/header.jsp" />
        <div class="review-list-container">

            <!-- 상단 메인 탭 -->
            <div class="main-tabs">
                <div class="tab-item">가격</div>
                <div class="tab-item">예약</div>
                <div class="tab-item active">리뷰</div>
                <div class="tab-item">사진</div>
                <div class="tab-item">정보</div>
            </div>

            <!-- 서브 리뷰 유형 탭 -->
            <div class="review-type-tabs">
                <button class="type-btn visitor">방문자 리뷰</button>
                <button class="type-btn instagram" onclick="location.href='https://www.instagram.com'">인스타그램 리뷰</button>
            </div>

            <!-- 필터 섹션 -->
            <div class="filter-section">
                <select class="designer-select" id="designer-filter">
                    <option value="all">디자이너별 리뷰 보기 ▽</option>
                    <option value="김조은">김조은 원장</option>
                    <option value="박한별">박한별 디자이너</option>
                    <option value="이민지">이민지 디자이너</option>
                </select>
                <div class="receipt-info">영수증 인증 후 작성된 리뷰입니다.</div>
            </div>

            <!-- 리뷰 리스트 -->
            <div class="review-items" id="review-list">
                <!-- 리뷰 1 -->
                <div class="review-card" data-designer="김조은">
                    <div class="user-header">
                        <img src="C:/Users/TJ-BU-706-P05/.gemini/antigravity/brain/7284db52-135a-4a93-b28a-e4bbf91d4791/uploaded_image_1766546978340.jpg"
                            class="user-avatar">
                        <div class="user-meta">
                            <span class="uid">예진0928</span>
                            <span class="handle">@YJ0928</span>
                        </div>
                    </div>
                    <div class="review-content">
                        <div class="review-img-placeholder">추후입력</div>
                        <div class="review-body">
                            <div class="designer-name">김조은 원장</div>
                            <div class="review-text">단발병이 와서 과감히 잘라봤는데 너무 가볍고 맘에 들어요! 앞머리도 적당하고, 드라이 대충 해도 스타일이 살아서 편해요.
                            </div>
                            <div class="card-footer">
                                <span class="help-btn" onclick="toggleHelp(this)">👍 도움이 됐어요 <span
                                        class="count">0</span></span>
                                <span class="date">2025.11.15</span>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 리뷰 2 -->
                <div class="review-card" data-designer="박한별">
                    <div class="user-header">
                    <!-- 이미지 추후 추가 -->
                        <img src="추후추가"
                            class="user-avatar">
                        <div class="user-meta">
                            <span class="uid">석현0732</span>
                            <span class="handle">@SH0087</span>
                        </div>
                    </div>
                    <div class="review-content">
                        <div class="review-img-placeholder">추후입력</div>
                        <div class="review-body">
                            <div class="designer-name">박한별 디자이너</div>
                            <div class="review-text">옆머리가 붕 뜨는 게 고민이라 다운펌 같이 했는데, 진짜 착 붙어서 두상이 작아 보여요! ✨ 아침에 털어서 말리기만 해도
                                스타일이 잡혀서 편하네요.</div>
                            <div class="card-footer">
                                <span class="help-btn" onclick="toggleHelp(this)">👍 도움이 됐어요 <span
                                        class="count">0</span></span>
                                <span class="date">2025.11.09</span>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 리뷰 3 (초기 숨김) -->
                <div class="review-card hidden" data-designer="이민지">
                    <div class="user-header">
                    <!-- 이미지 추후 추가 -->
                        <img src="추후추가"
                            class="user-avatar">
                        <div class="user-meta">
                            <span class="uid">민지0123</span>
                            <span class="handle">@MJ0123</span>
                        </div>
                    </div>
                    <div class="review-content">
                        <div class="review-img-placeholder">추후입력</div>
                        <div class="review-body">
                            <div class="designer-name">이민지 디자이너</div>
                            <div class="review-text">친절하게 상담해주시고 딱 제가 원하는 컬로 뽑아주셨어요. 머리카락 손상도 하나도 없어서 너무 만족합니다!</div>
                            <div class="card-footer">
                                <span class="help-btn" onclick="toggleHelp(this)">👍 도움이 됐어요 <span
                                        class="count">0</span></span>
                                <span class="date">2025.10.28</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 더보기 버튼 -->
            <div class="more-btn-container">
                <button class="load-more-btn" id="load-more">리뷰 더보기 ▽</button>
            </div>
        </div>

        <script>
            const designerFilter = document.getElementById('designer-filter');
            const loadMoreBtn = document.getElementById('load-more');
            const allReviews = document.querySelectorAll('.review-card');

            // 필터 기능
            designerFilter.addEventListener('change', () => {
                const selected = designerFilter.value;
                allReviews.forEach(card => {
                    if (selected === 'all' || card.dataset.designer === selected) {
                        card.classList.remove('hidden');
                    } else {
                        card.classList.add('hidden');
                    }
                });
                // 필터링 시에는 더보기 버튼을 숨기거나 조정할 수 있음 (여기서는 단순 필터만 구현)
                loadMoreBtn.style.display = selected === 'all' ? 'flex' : 'none';
            });

            // 더보기 기능
            loadMoreBtn.addEventListener('click', () => {
                const hiddenReviews = document.querySelectorAll('.review-card.hidden');
                hiddenReviews.forEach(card => card.classList.remove('hidden'));
                loadMoreBtn.style.display = 'none'; // 모든 리뷰가 다 나오면 숨김
            });

            // 도움이 됐어요 토글 기능
            function toggleHelp(btn) {
                const countSpan = btn.querySelector('.count');
                let count = parseInt(countSpan.innerText);

                if (btn.classList.contains('active')) {
                    btn.classList.remove('active');
                    countSpan.innerText = count - 1;
                } else {
                    btn.classList.add('active');
                    countSpan.innerText = count + 1;
                }
            }
        </script>
        <jsp:include page="include/footer.jsp" />
    </body>

    </html>