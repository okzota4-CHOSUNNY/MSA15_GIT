<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h1>파일 업로드</h1>

<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" onchange="fileCheck(event)">
    <input type="text" name="title">
    <input type="submit" value="파일 업로드">
</form>

<script>
    // 파일 업로드 제한 용량 (10MB)
    const MAX_FILE_SIZE = 10 * 1024 * 1024;

    // 파일 선택 시 실행되는 함수
    function fileCheck(event) {
        const fileInput = event.target;      // 선택된 input 요소
        const file = fileInput.files[0];     // 선택된 실제 파일

        if (file && file.size > MAX_FILE_SIZE) {
            alert("파일 업로드 용량은 10MB를 넘을 수 없습니다.");
            fileInput.value = "";            // 파일 선택 초기화
        }
    }
</script>

</body>
</html>
