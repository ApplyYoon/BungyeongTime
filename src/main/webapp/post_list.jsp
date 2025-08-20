<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    	<c:forEach var="post" items="${postList}">
	            <div class="post-card" onclick="location.href = 'PostDetailServlet?postId=${post.postId}'">
	                <a class="post-title">${post.title}</a>
	                <p class="post-info">작성자: ${post.userName}<br>추천: ${post.suggest}</p>
	            </div>
	    	</c:forEach>
	    </div>
        <div class="post-list-buttons">
            <a href="post_write.jsp"><button class="main-btn">✏️ 게시글 작성</button></a>
            <a href="best_posts.jsp"><button class="main-btn secondary">🔥 베스트 글</button></a>
        </div>
    </div>
</body>

</html>