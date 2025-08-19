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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String userId = request.getParameter("userId");
	        String userPassword = request.getParameter("userPassword");
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
				conn = DBUtil.getConnection();
		        String sql = "SELECT user_pw, user_name FROM user_tbl WHERE user_id = ?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, userId);
		        rs = pstmt.executeQuery();
		        rs.next();
		        String user_pw_db = rs.getString("user_pw");
		        String user_name = rs.getString("user_name");
		        
		        System.out.println(user_pw_db);
		        if(user_pw_db.equals(userPassword)) {
		        	System.out.println("로그인 성공");
		        	
		        	HttpSession session = request.getSession();
		            session.setAttribute("userId", userId);
		            session.setAttribute("userName", user_name);
		            response.sendRedirect("post_list.jsp");
		            return;
		        	
		        }
		        else {
		        	System.out.println("로그인 실패");
		        	request.setAttribute("message", "존재하지 않는 아이디 또는 잘못된 비밀번호입니다.");
		        }
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("로그인 실패");
				 request.setAttribute("message", "존재하지 않는 아이디 또는 잘못된 비밀번호입니다.");
			} finally {
				DBUtil.close(conn, pstmt, rs);
			}
	        System.out.println(userId);
	        System.out.println(userPassword);
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	   
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
