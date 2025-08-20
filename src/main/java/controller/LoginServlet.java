package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.LoginDAO;
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
	        try {
	        	LoginDAO dao = new LoginDAO();
	        	Map<String, String> map = dao.login(userId);
	        	String realPassword = map.get("user_pw");
	        			
		        if(realPassword.equals(userPassword)) {
		        	System.out.println("로그인 성공");
		        	
		        	HttpSession session = request.getSession();
		        	String user_name = map.get("user_name");
		            session.setAttribute("userId", userId);
		            session.setAttribute("userName", user_name);
		            response.sendRedirect("PostListServlet");
		            return;
		        	
		        }
		        else {
		        	System.out.println("로그인 실패");
		        	request.setAttribute("message", "존재하지 않는 아이디 또는 잘못된 비밀번호입니다.");
		        }
			} catch (Exception e) {
				System.out.println("로그인 실패");
				request.setAttribute("message", "존재하지 않는 아이디 또는 잘못된 비밀번호입니다.");
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
