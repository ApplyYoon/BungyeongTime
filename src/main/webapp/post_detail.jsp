<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 상세 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <!-- 상단 로그아웃 영역 -->
    <div class="header-logout">
        <jsp:include page="logout_header.jsp"></jsp:include>
    </div>

    <!-- 게시글 상세 내용 -->
    <div class="index-container wide">
        <h1 class="post-title">${title}</h1>

        <div >
            <p class="post-info">작성자: ${name}, 추천: ${suggest}</p>
            <hr style="margin: 10px 0;">
            <p style="text-align: left">${content}</p>
        </div>

        <!-- 추천 / 신고 버튼 영역 -->
        <div class="post-action-buttons" style="margin-top: 20px; display: flex; gap: 10px;">
            <form action="SuggestPostServlet" method="post" style="flex: 1;">
                <input type="hidden" name="postId" value="${postId}">
                <button type="submit" class="main-btn secondary">👍 추천</button>
            </form>
            <form action="report_post.jsp" method="post" style="flex: 1;">
                <input type="hidden" name="postId" value="${postId}">
                <button type="submit" class="main-btn danger">🚨 신고</button>
            </form>	
        </div>

        <!-- 돌아가기 / 새 글 쓰기 -->
        <div class="post-list-buttons" style="margin-top: 20px;">
            <a href="PostListServlet"><button class="main-btn">⬅️ 목록으로</button></a>
        </div>
    </div>
</body>

</html>
