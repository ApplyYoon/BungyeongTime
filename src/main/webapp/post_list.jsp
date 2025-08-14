<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시판 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="header-logout">
        <jsp:include page="logout_header.jsp"></jsp:include>
    </div>

    <div class="index-container wide post-list-container">
        <h1 class="logo-title">📋 전체 게시글</h1>
        <p class="description">분경 친구들의 이야기를 모아봤어요!</p>

        <div class="post-list" id="post-list">
            <div class="post-card">
                <a href="post_detail.jsp?postId=1" class="post-title">오늘 급식 진짜 맛있었음ㅋㅋ</a>
                <p class="post-info">작성자: bkyg123 | 추천: 4 | 신고: 0</p>
            </div>
        </div>

        <div class="post-list-buttons">
            <a href="post_write.jsp"><button class="main-btn">✏️ 게시글 작성</button></a>
            <a href="best_posts.jsp"><button class="main-btn secondary">🔥 베스트 글</button></a>
        </div>
    </div>
</body>

</html>