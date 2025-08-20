package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDetailDAO;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String postId = request.getParameter("postId");
	        
	        
	        PostDetailDAO dao = new PostDetailDAO();
	        Map<String, String> map = dao.get(postId);	        
	       
	        String title = map.get("title");
	        String content = map.get("content");
	        String suggest = map.get("suggest");
	        String name = map.get("name");
	        
	        request.setAttribute("title", title);
	        request.setAttribute("content", content);
	        request.setAttribute("suggest", suggest);
	        request.setAttribute("name", name);
	        request.setAttribute("postId", postId);
	        
	        System.out.println(title);
	        System.out.println(content);
	        System.out.println(suggest);
	        System.out.println(name);
	        System.out.println(postId);
	        
	        request.getRequestDispatcher("post_detail.jsp").forward(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
