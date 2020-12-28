package controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;


public class CheckUniqueServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String key = request.getParameter("key");
		boolean flag = User.CheckUniqueKey(key);
		response.getWriter().write(Boolean.toString(flag));
	}
}