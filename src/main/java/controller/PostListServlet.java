package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.PostDAO;
import model.PostDTO;
import model.UserDTO;
import util.DBUtil;

@WebServlet("/PostListServlet")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostDAO postDAO = new PostDAO();
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	        List<PostDTO> postList = postDAO.selectAllPosts();
	        request.setAttribute("postList", postList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("post_list.jsp");
	        dispatcher.forward(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
