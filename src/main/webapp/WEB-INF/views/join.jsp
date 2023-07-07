<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="join" method="post">
		<!-- 토큰을 전달하기 위하여 작성합니다. -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		아이디 : <input type="text" name="id"> <br>
		암호 : <input type="password" name="pwd"> <br>
		이름 : <input type="text" name="name"> <br>
		<!-- 역할은 hidden으로 우선 value = user로 전달합니다. -->
		<input type="hidden" name="role" value="user"> 
		<input type="submit" value="가입">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>