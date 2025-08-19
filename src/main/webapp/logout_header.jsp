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
	<%
    	String name;
    	if(session.getAttribute("userName") != null){
	    	name = session.getAttribute("userName") + "님";
    	} else {
	    	name = "손님";
	   	}
   	%>
    <span>환영합니다, <%= name %></span>
 
    <form action="LogoutServlet" method="post" style="display:inline;">
        <button type="submit" class="logout-btn">로그아웃</button>
    </form>
</div>

</body>
</html>
