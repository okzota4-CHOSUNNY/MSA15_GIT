<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 스타일 회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    /* 1. 전체 페이지 배경 및 폰트 설정 */
    body {
        background-color: #f5f6f7; /* 네이버 배경색(연한 회색) */
        font-family: 'Dotum', sans-serif; /* 폰트 설정 */
        margin: 0; padding: 0; /* 기본 여백 제거 */
    }

    /* 2. 전체 내용을 감싸는 컨테이너 (가운데 정렬) */
    .container {
        width: 460px; /* 가로 너비 고정 */
        margin: 0 auto; /* 화면 중앙에 배치 */
        padding-top: 50px; /* 위쪽 여백 */
    }

    /* 3. 로고 영역 스타일 */
    .logo {
        text-align: center; /* 로고 가운데 정렬 */
        margin-bottom: 20px; /* 아래쪽 여백 */
        font-size: 40px; /* 글자 크기 */
        font-weight: bold; /* 굵게 */
        color: #03c75a; /* 네이버 초록색 */
        cursor: pointer; /* 마우스 올리면 손가락 모양 */
    }

    /* 4. 입력창들을 감싸는 박스 스타일 */
    .input-group {
        background: white; /* 배경 흰색 */
        border: 1px solid #dadada; /* 테두리 연한 회색 */
        padding: 10px 15px; /* 안쪽 여백 */
        margin-bottom: 2px;  박스 간 간격 */
        display: flex; /* 내부 요소들을 가로로 배치 */
        align-items: center; /* 세로 중앙 정렬 */
		  border-radius: 10px;/
    }
    
    /* [추가] 첫 번째 박스: 위쪽 모서리만 둥글게 */
    .input-group:first-child {
 		border-radius: 10px;       
    }

    .input-group:last-child {
	 border-radius: 10px;
    }

    /* [추가] 중간 박스들: 위쪽 테두리를 없애서 선이 두꺼워지는 걸 방지 */
    .input-group + .input-group {
        border-top: none;
    }
    

    /* 5. 실제 글자를 입력하는 input 태그 스타일 */
    .input-group input {
      border: none; /* 테두리 없앰 (박스에 테두리가 있으므로) */
      outline: none; /* 클릭했을 때 파란 테두리 제거 */
      width: 100%; /* 너비 꽉 차게 */
      font-size: 15px; /* 글자 크기 */
      padding: 5px; /* 안쪽 여백 */
 	   border-radius: 10px;
    }

    /* 6. 생년월일 같은 3칸짜리 입력창 스타일 */
    .birth-group {
        display: flex; /* 가로 배치 */
        justify-content: space-between; /* 간격 균등 분배 */
        margin-bottom: 10px; /* 아래 여백 */
    }
    
    .birth-box {
        width: 32%; /* 3개니까 약 33%씩 차지 */
        background: white;
        border: 1px solid #dadada;
        padding: 10px;
        box-sizing: border-box; /* 테두리 포함 크기 계산 */
        border-radius: 6px; /* 모서리 둥글게 (숫자가 클수록 더 둥글어짐) */
    }
    .birth-box input {
        width: 100%;
        border: none;
        outline: none;
    }
    
     /* [추가] 첫 번째 박스: 위쪽 모서리만 둥글게 */
	.birth-box {
    border-top-left-radius: 10px;  /* 왼쪽 위 10px 둥글게 */
    border-top-right-radius: 10px; /* 오른쪽 위 10px 둥글게 */
    }
    

   /* 7. 성별/국적 선택 버튼 (라디오 버튼 꾸미기) */
	/* 4개의 버튼을 감싸는 둥근 박스 */
.choice-group {
    display: flex;             /* 가로로 나란히 배치 */
    width: 100%;               /* 너비 꽉 차게 */
    border: 1px solid #dadada; /* 회색 테두리 */
    border-radius: 6px;        /* ★모서리 둥글게★ */
    overflow: hidden;          /* ★중요: 네모난 버튼이 둥근 모서리를 뚫고 나오지 않게 숨김★ */
    background: white;
    margin-bottom: 10px;
    
}

/* 각 버튼(라벨)의 모양 */
.choice-group label {
    flex: 1;                   /* 4개 버튼이 공간을 똑같이 1/4씩 차지 */
    text-align: center;        /* 글자 가운데 정렬 */
    padding: 12px 0;           /* 위아래 여백 */
    cursor: pointer;           /* 마우스 손가락 모양 */
    border-right: 1px solid #dadada; /* 오른쪽 칸막이 선 */
    font-size: 14px;
    background: white;         /* 기본 배경색 */
    color: #333;               /* 기본 글자색 */
	}
	
	/* 마지막 '외국인' 버튼은 오른쪽 선 없애기 */
	.choice-group label:last-child {
    border-right: none;
	}
	
	/* 라디오 버튼 자체는 화면에서 숨김 */
	.choice-group input[type="radio"] {
    display: none;
	}
	
	/* ★선택되었을 때 디자인 변경★ */
	/* 체크된 라디오 버튼 바로 뒤에 있는 라벨(+)을 찾아서 스타일을 바꿈 */
	.choice-group input[type="radio"]:checked + label {
    background-color: #e8f0fe; /* 연한 초록/파랑 배경 */
    color: #03c75a;            /* 네이버 초록색 글씨 */
    font-weight: bold;         /* 글씨 굵게 */
	}
    
    /* 라디오 버튼을 감싸는 라벨 스타일 */
    .gender-label {
       flex: 1; /* 공간을 1:1로 나눠가짐 */
       text-align: center; /* 글자 가운데 */
       line-height: 45px; /* 세로 가운데 정렬 효과 */
       cursor: pointer; /* 손가락 모양 */
       border-right: 1px solid #dadada; /* 오른쪽 구분선 */
       font-size: 14px;
    }
    .gender-label:last-child {
        border-right: none; /* 마지막 칸은 구분선 제거 */
    }
    
    /* 실제 라디오 버튼은 숨김 (모양만 라벨로 잡음) */
    .gender-group input[type="radio"] {
        display: none;
    }
    
    /* 라디오 버튼이 체크되었을 때 라벨의 색상 변경 (중요!) */
    .gender-group input[type="radio"]:checked + .gender-label {
        background-color: #e8f0fe; /* 선택된 배경색 */
        color: #03c75a; /* 선택된 글자색 (초록) */
        font-weight: bold;
    }

    /* 8. 가입하기 버튼 스타일 */
    .btn-join {
        width: 100%; /* 너비 꽉 차게 */
        background-color: #03c75a; /* 네이버 초록색 */
        color: white; /* 글자 흰색 */
        border: none; /* 테두리 없음 */
        padding: 15px; /* 버튼 높이 */
        font-size: 18px; /* 글자 크기 */
        font-weight: bold; /* 굵게 */
        cursor: pointer; /* 손가락 모양 */
        margin-top: 15px; /* 위쪽 여백 */
        border-radius: 10px;
    }

    /* 9. 소제목 스타일 (아이디, 비밀번호 글자 등은 placeholder로 대체하여 생략 가능하지만 필요시 사용) */
    h3 {
        font-size: 14px;
        margin: 5px 0;
	    }
	</style>
	
	<script>
    $(document).ready(function(){
        
        // 가입하기 버튼 클릭 시 실행
        $("#btnJoin").click(function(){
            
          // 1. 아이디 입력 확인
          if($("#id").val() == "") {
              alert("아이디를 입력해주세요.");
              $("#id").focus();
              return;
          }
          
          // 2. 비밀번호 입력 확인
          if($("#pw").val() == "") {
              alert("비밀번호를 입력해주세요.");
              $("#pw").focus();
              return;
          }
          
          // 3. 이름 입력 확인
          if($("#name").val() == "") {
              alert("이름을 입력해주세요.");
              $("#name").focus();
              return;
          }

          // 모든 검사 통과 시 폼 전송 (DB 저장용 페이지로 이동)
          // 아직 joinAction.jsp는 안 만들었으므로 지금은 alert만 띄웁니다.
          alert("회원가입 요청을 보냅니다!");
          // $("form").attr("action", "joinAction.jsp").submit(); 
        });

        // 성별 버튼 클릭 시 디자인 효과 주기 (jQuery로 클래스 제어 대신 CSS :checked 활용함)
        // 직접 클릭 효과를 위해 라벨을 클릭하면 연결된 라디오버튼이 체크됩니다.
    });
</script>
</head>
<body>

    <div class="container">
        <div class="logo">회원가입</div>

        <form method="post">
            
            <div class="input-group">
                <input type="text" id="id" name="id" placeholder="아이디">
            </div>

            <div class="input-group">
                <input type="password" id="pw" name="pw" placeholder="비밀번호">
            </div>

            <div class="input-group">
                <input type="email" name="email" placeholder="[선택] 이메일주소">
            </div>

            <div class="input-group">
                <input type="text" id="name" name="name" placeholder="이름">
            </div>

            <div class="birth-group">
                <div class="birth-box">
                    <input type="text" name="birth_year" placeholder="년(4자)">
                </div>
                <div class="birth-box">
                    <input type="text" name="birth_month" placeholder="월">
                </div>
                <div class="birth-box">
                    <input type="text" name="birth_day" placeholder="일">
                </div>
            </div>

            <div class="choice-group">
				    <input type="radio" id="g-male" name="gender" value="M">
				    <label for="g-male">남자</label>
				    
				    <input type="radio" id="g-female" name="gender" value="F">
				    <label for="g-female">여자</label>
				    
				    <input type="radio" id="n-local" name="nation" value="L" checked>
				    <label for="n-local">내국인</label>
				    
				    <input type="radio" id="n-foreign" name="nation" value="F">
				    <label for="n-foreign">외국인</label>
				</div>

            <div class="input-group">
                <input type="text" name="phone" placeholder="휴대전화번호">
            </div>

            <button type="button" id="btnJoin" class="btn-join">가입하기</button>

        </form>
    </div>

</body>
</html>