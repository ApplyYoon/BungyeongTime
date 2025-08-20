<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="header-logout">
        <jsp:include page="logout_header.jsp"></jsp:include>
    </div>
    <div class="index-container wide">
        <h1 class="logo-title">✏️ 게시글 작성</h1>
        <p class="description">하고 싶은 말을 자유롭게 작성해보세요!</p>

        <form action="PostWriteServlet" method="post">
            <input type="text" name="title" placeholder="제목을 입력하세요" class="form-input" required><br>
            <textarea name="content" placeholder="내용을 입력하세요" rows="10" class="form-input" required></textarea><br>
            <button type="submit" class="main-btn">작성하기</button>
        </form>

        <div style="margin-top: 20px;">
            <a href="PostListServlet"><button class="main-btn secondary">← 돌아가기</button></a>
        </div>
    </div>
</body>
</html>
