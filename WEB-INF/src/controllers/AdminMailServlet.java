package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import utils.EmailMessageAdmin;
import utils.EmailSenderAdmin;

public class AdminMailServlet extends HttpServlet{
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		String name = request.getParameter("name");
		String email ="bookmarked.ags@gmail.com";
		String msg = request.getParameter("message");
		String Adminmail = EmailMessageAdmin.getAccountActivationMail(name,msg);
		String subject = "Supprot Team From BookMarked";
	    EmailSenderAdmin.sendEmail(email,subject,Adminmail);
		response.sendRedirect("contact.jsp");
	}
}