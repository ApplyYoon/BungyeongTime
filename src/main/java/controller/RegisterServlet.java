package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        String userId = request.getParameter("userId");
	        String userPassword = request.getParameter("userPassword");
	        String userName = request.getParameter("userName");
	        System.out.println(userId);
	        System.out.println(userPassword);
	        System.out.println(userName);
	        
	        RegisterDAO dao = new RegisterDAO();
	        dao.regist(userId, userPassword, userName);
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doPost(request, response);
	    }
}
