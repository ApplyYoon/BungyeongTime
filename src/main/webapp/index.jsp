<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userId = (String) session.getAttribute("userId");
    if (userId != null) {
        response.sendRedirect("post_list.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="index-container">
        <h1 class="logo-title">📚 Bungyeong Time</h1>
        <p class="description">분당경영고 학생들을 위한 커뮤니티</p>

        <div class="button-group">
            <a href="login.jsp"><button class="main-btn">로그인</button></a>
            <a href="register.jsp"><button class="main-btn">회원가입</button></a>
            <a href="best_posts.jsp"><button class="main-btn secondary">베스트 게시글 보기</button></a>
        </div>
    </div>
</body>
</html>
