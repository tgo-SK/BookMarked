package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import models.Category;

import utils.*;



public class AppListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent ev){
		ServletContext context = ev.getServletContext();
		EmailSender.MailPasswordAuthenticator.senderEmail 
			= context.getInitParameter("sender_email");
		
		EmailSender.MailPasswordAuthenticator.senderEmailPassword 
			= context.getInitParameter("sender_email_password");


		//-------------------------------------------------------
		//--------------Contact Info ke liye (client)--------------------

		EmailSenderClient.MailPasswordAuthenticator.senderEmailClient
			= context.getInitParameter("sender_email_client");
	
		EmailSenderClient.MailPasswordAuthenticator.senderEmailPasswordClient
			= context.getInitParameter("sender_email_password_client");
		//------------------------------------------------------------------------
		//-------------------------Conatct info (admin)-------------------
			EmailSenderAdmin.MailPasswordAuthenticator.senderEmailAdmin
			= context.getInitParameter("sender_email_client");
	
		EmailSenderAdmin.MailPasswordAuthenticator.senderEmailPasswordAdmin
			= context.getInitParameter("sender_email_password_client");

		ArrayList<Category> category = Category.collectCategory(); 
		context.setAttribute("category",category);
	}
	
	public void contextDestroyed(ServletContextEvent ev){
	
	}
}