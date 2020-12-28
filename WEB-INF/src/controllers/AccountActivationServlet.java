package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.io.IOException;
import models.User;

public class AccountActivationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("enter");
		String userName = request.getParameter("ukey");
		String activationCode = request.getParameter("actCode");
		
		if(User.activationAccount(userName,activationCode)){
			request.setAttribute("success","Account Activated Successfully...");
			response.sendRedirect("login.do");
		}else{
			request.setAttribute("fail","Account Activativation Failed...");
			request.getRequestDispatcher("/signup.do").forward(request,response);
		}
	}
}