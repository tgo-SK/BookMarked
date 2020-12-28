package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class SignoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		session.invalidate();

		request.getRequestDispatcher("login.do").forward(request,response);
	}
}