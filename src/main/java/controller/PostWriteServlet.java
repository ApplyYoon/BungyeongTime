package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.UserDTO;
import util.DBUtil;

@WebServlet("/PostWriteServlet")
public class PostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String userId = "";
	        HttpSession session = request.getSession(false); // 기존 세션만 가져옴 (없으면 null)
	        if (session != null) {
	            userId= (String) session.getAttribute("userId");
	        }
	        
	        String title = request.getParameter("title");
	        String content= request.getParameter("content");
	        
	        System.out.println(title);
	        System.out.println(content);
	        System.out.println(userId);
	       
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try {
				conn = DBUtil.getConnection();
				
		        String sql = "SELECT max(post_id)+1 as next_post_id FROM post_tbl";
		        pstmt = conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        rs.next();
		        String post_id = rs.getString("next_post_id");
		        System.out.println(post_id);
		        sql = "INSERT INTO post_tbl VALUES(?, ?, ?, ?, 0, 0)";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, post_id);
		        pstmt.setString(2, userId);
		        pstmt.setString(3, title);
		        pstmt.setString(4, content);
		        pstmt.executeQuery();
		        
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				DBUtil.close(conn, pstmt, rs);
			}
	        
	        response.sendRedirect("PostListServlet");
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
