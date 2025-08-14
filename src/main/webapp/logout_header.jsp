<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header-logout">
    <span>환영합니다, <%= session.getAttribute("userId") != null ? session.getAttribute("userId") : "손님" %>님</span>
    <form action="LogoutServlet" method="post" style="display:inline;">
        <button type="submit" class="logout-btn">로그아웃</button>
    </form>
</div>

</body>
</html>