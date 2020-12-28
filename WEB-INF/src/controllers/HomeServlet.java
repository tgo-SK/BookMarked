package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import models.User;
public class HomeServlet extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "signin.jsp";
		if(user!=null)
			nextPage = "home.jsp";
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}