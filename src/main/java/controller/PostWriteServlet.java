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

import dao.PostWriteDAO;
import model.UserDTO;
import util.DBUtil;

@WebServlet("/PostWriteServlet")
public class PostWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String userId = "";
	        String userName = "";
	        HttpSession session = request.getSession(false); // 기존 세션만 가져옴 (없으면 null)
	        if (session != null) {
	            userName= (String) session.getAttribute("userName");
	        }
	        
	        String title = request.getParameter("title");
	        String content= request.getParameter("content");
	        System.out.println(title);
	        System.out.println(content);
	        System.out.println(userId);
	        PostWriteDAO dao = new PostWriteDAO();
	        dao.write(userName, title, content);
	       
	        
	       
	        response.sendRedirect("PostListServlet");
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
