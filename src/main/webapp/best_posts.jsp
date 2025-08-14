<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>베스트 게시글 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="header-logout">
        <jsp:include page="logout_header.jsp"></jsp:include>
    </div>

    <div class="index-container wide">
        <h1 class="logo-title">🔥 베스트 게시글</h1>
        <p class="description">추천을 가장 많이 받은 인기 글들을 모았어요!</p>

        <div class="post-list">
            <div class="post-card">
                <a href="post_detail.jsp?postId=1" class="post-title">[1등] 자소서 팁 공유합니다!</a>
                <p class="post-info">작성자: user123 | 추천: 15</p>
            </div>
            <div class="post-card">
                <a href="post_detail.jsp?postId=2" class="post-title">[2등] 수능 전날 꿀팁 정리</a>
                <p class="post-info">작성자: smartguy | 추천: 12</p>
            </div>
        </div>
        
        <a href="post_list.jsp"><button class="main-btn">전체 게시글 보기</button></a>
    </div>
</body>
</html>
