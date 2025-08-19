<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="index-container">
        <h1 class="logo-title">📝 회원가입</h1>
        <p class="description">분경고 커뮤니티에 가입하세요!</p>

        <form action="RegisterServlet" method="post">
            <input type="text" name="userId" placeholder="아이디" class="form-input" required><br>
            <input type="password" name="userPassword" placeholder="비밀번호" class="form-input" required><br>
            <input type="text" name="userName" placeholder="닉네임" class="form-input" required><br>
            <button type="submit" class="main-btn">가입하기</button>
        </form>

        <p class="description"><a href="login.jsp">이미 계정이 있으신가요?</a></p>
    </div>
</body>
</html>
