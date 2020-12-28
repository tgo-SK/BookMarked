package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import utils.EmailMessageClient;
import utils.EmailSenderClient;

import models.User;

public class ContactServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
			request.getRequestDispatcher("contact.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String Clientmail = EmailMessageClient.getAccountActivationMail(name);
		String subject = "Support Team From BookMarked";

		EmailSenderClient.sendEmail(email,subject,Clientmail);
		request.getRequestDispatcher("adminmail.do").forward(request,response);
	}
}