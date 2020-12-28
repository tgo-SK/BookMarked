package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;

import models.User;

public class ModifyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getUserType().getUserTypeId() ==  2)
			request.getRequestDispatcher("modify.jsp").forward(request,response);
		else
			request.getRequestDispatcher("login.do").forward(request,response);
	}
}

