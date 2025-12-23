<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP 파일 업로드</title>
</head>
<body>
	<!-- JSP 파일 업로드 요청 -->
	<form action="<%= request.getContextPath() %> /fileupload_pro.jsp"
		method="post" enctype="multipart/form-data">
		<div>
			이름 : <input type="text" name="name"> 
		</div>
		<div>
			제목 : <input type="text" name="title"> 
		</div>
		<div>
			파일 : <input type="file" name="file1"> 
			파일 : <input type="file" name="file2"> 
		</div>
		<div>
			<input type="submit" value="업로드">
		</div>
	</form>
</body>
</html>