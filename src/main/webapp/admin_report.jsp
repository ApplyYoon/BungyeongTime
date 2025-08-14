<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>신고 관리(Admin)</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>📢 신고된 게시글 목록</h2>
    <table>
        <tr>
            <th>게시글 ID</th>
            <th>신고자</th>
            <th>사유</th>
            <th>처리</th>
        </tr>
        <tr>
            <td>3</td>
            <td>user123</td>
            <td>욕설 포함</td>
            <td>
                <form action="HandleReportServlet" method="post">
                    <input type="hidden" name="postId" value="3">
                    <select name="action">
                        <option value="keep">유지</option>
                        <option value="remove">삭제</option>
                    </select>
                    <button type="submit">처리</button>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
