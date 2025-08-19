

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session != null && session.getAttribute("userName") != null) {
        response.sendRedirect("post_list.jsp");
        return; 
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 | Bungyeong Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="index-body">
    <div class="index-container">
        <h1 class="logo-title">🔐 로그인</h1>
        <p class="description">Bungyeong Time에 오신 것을 환영합니다!</p>

        <form action="LoginServlet" method="post">
        	
            <input type="text" name="userId" placeholder="아이디" class="form-input" required><br>
            <input type="password" name="userPassword" placeholder="비밀번호" class="form-input" required><br>
            <p style="color: red; font-size: 13px;">${message}</p>
            <button type="submit" class="main-btn">로그인</button>
        </form>

        <p class="description">계정이 없으신가요? <a href="register.jsp">회원가입</a></p>
    </div>
</body>
</html>
