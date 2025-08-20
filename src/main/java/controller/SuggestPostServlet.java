package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDetailDAO;
import dao.SuggestPostDAO;

/**
 * Servlet implementation class SuggestPost
 */
@WebServlet("/SuggestPostServlet")
public class SuggestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String postId = request.getParameter("postId");
	        
	        
	        SuggestPostDAO dao = new SuggestPostDAO();
	        dao.increase(postId);	        

	        request.getRequestDispatcher("PostDetailServlet?"+postId).forward(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }

}

