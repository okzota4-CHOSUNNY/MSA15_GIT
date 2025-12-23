<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    /* 간단한 디자인 설정 */
    table { width: 100%; border-collapse: collapse; } /* 테이블 선을 한 줄로 합침 */
    td { padding: 10px; border: 1px solid #ddd; } /* 칸마다 여백과 테두리 주기 */
    input, textarea { width: 98%; } /* 입력창을 꽉 차게 */
</style>

<script>
    // 2. 화면이 다 로딩되면 실행할 준비를 합니다.
    $(document).ready(function(){

        // "저장" 버튼(#btnSave)을 클릭했을 때 할 일을 정합니다.
        $("#btnSave").click(function(){
            
            // 제목 칸(#title)이 비어있는지 검사합니다.
            if($("#title").val() == ""){
                alert("제목을 입력하세요."); // 경고창 띄우기
                $("#title").focus(); // 제목 칸으로 커서 이동
                return; // 함수 종료 (더 이상 진행 안 함)
            }
            
            // 작성자 칸(#writer)이 비어있는지 검사합니다.
            if($("#writer").val() == ""){
                alert("작성자를 입력하세요.");
                $("#writer").focus();
                return;
            }
            
            // 모든 검사를 통과했으면 폼(form)을 전송합니다.
            // form 태그의 action 속성을 'writeAction.jsp'로 설정하고 제출(submit)합니다.
            $("form").attr("action", "writeAction.jsp").submit();
        });
    });
</script>
</head>
<body>

    <h2>게시글 작성</h2>
    
    <form method="post">
    
   
        <table>
            <tr>
            	<td style="text-align: center; background-color: white; font-weight: bold;">제목</td>
               <td><input type="text" name="title" id="title"></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="writer" id="writer"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="content" id="content" rows="15"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" id="btnSave">저장</button>
                    <button type="button" onclick="location.href='list.jsp'">취소</button>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>