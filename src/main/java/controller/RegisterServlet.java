package controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDTO;
import util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String userId = request.getParameter("userId");
	        String userPassword = request.getParameter("userPassword");
	        String userName = request.getParameter("userName");
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
				conn = DBUtil.getConnection();
		        String sql = "INSERT INTO user_tbl VALUES(?, ?, ?)";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, userId);
		        pstmt.setString(2, userPassword);
		        pstmt.setString(3, userName);
		        pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, pstmt, rs);
			}
	        System.out.println(userId);
	        System.out.println(userPassword);
	        System.out.println(userName);
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
