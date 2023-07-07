<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form action="/login" method="post">
		<!-- 정상적인 요청이라는 토큰을 보내주어야 합니다. 그러므로 모든 폼에는 hidden으로 토큰을 만듭니다. -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		아이디 : <input type="text" name="username"> <br>
		비밀번호 : <input type="password" name="password"> <br>
		<button>로그인</button>
	</form>
	<form action="/join">
		<button>회원가입</button>
	</form>
</body>
</html>