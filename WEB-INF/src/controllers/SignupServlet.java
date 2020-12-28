package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import utils.ActivationCodeGenrator;
import models.User;
import utils.GoogleReCaptcha;
import utils.EmailMessages;
import utils.EmailSender;
import java.io.File;



public class SignupServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException , ServletException{
		request.getRequestDispatcher("/signup.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
	
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String gReCaptcha = request.getParameter("g-recaptcha-response");
		String errorMessage = "";
		
		boolean flag = GoogleReCaptcha.signUpCaptcha(gReCaptcha);
		//----------------------Validation---------------------------
		
		Pattern p = null;
		Matcher m = null;			
		
		if(flag){
			p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{4,29}$");
			m = p.matcher(userName);
			if(userName == ""){
				errorMessage += "Name field cannot be empty \n\n";
				flag = false;
			}
			else if(!m.matches()){
				flag = false;
				errorMessage += "Only alphabet and numeric characters allowed...! \n\n";
			}

			p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
			m = p.matcher(email);
			if(email == ""){
				errorMessage += "Email field cannot be empty \n\n";
				flag = false;
			}
			else if(!m.matches()){
				flag = false;
				errorMessage += "Wrong format of email \n\n";
			}
			
			int passwordLength = password.length();
			
			if(password == ""){
				errorMessage += "Password field cannot be empty \n\n";
				flag = false;
			}
			else if(passwordLength<6||passwordLength>12){
				flag = false;
				errorMessage += "Password must be at least 6 and at max 12 characters length \n\n"; 
			}

			if(!password.equals(repassword)){
				flag = false;
				errorMessage += "Confirmation password does not match..!! \n\n";
			}
			
			if(flag){
				String activationCode = ActivationCodeGenrator.getActivationCode();
				User usr = new User(userName,email,password,activationCode);
				
				if(!usr.saveUser()){
					request.setAttribute("errmsg","Duplicate User Name or email \n");
					request.getRequestDispatcher("/signup.jsp").forward(request,response);
				}
				else{
					String mailInfo = EmailMessages.getAccountActivationMail(userName,activationCode);
					String subject = "Verification mail from BookMarked";
					EmailSender.sendEmail(email,subject,mailInfo);
					String uploadsPath = getServletContext().getRealPath("/WEB-INF/uploads");
					File file = new File(uploadsPath,userName);
					file.mkdir();
					request.getRequestDispatcher("wait.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("errmsg",errorMessage);
				request.getRequestDispatcher("/signup.jsp").forward(request,response);
			}
		}else{
			request.setAttribute("errmsg","ReCaptcha failed");
			request.getRequestDispatcher("/signup.jsp").forward(request,response);
		}		
	}
}