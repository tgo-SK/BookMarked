package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import utils.GoogleReCaptcha;

import models.User;
import models.MemPurchase;


public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/signin.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		String ukey = request.getParameter("unm_email");
		String password = request.getParameter("password");
		String captchaResponse = request.getParameter("g-recaptcha-response");
		String errmsg = "";

		boolean flag = GoogleReCaptcha.signUpCaptcha(captchaResponse);

		Pattern penm,peml;
		Matcher menm,meml;

		if(flag){
			penm = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{4,29}$");
			menm = penm.matcher(ukey);
			peml = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
			meml = penm.matcher(ukey);
			
			if(password == ""){
				flag = false;
				errmsg += "Password field is Empty";
			}

			if(ukey == ""){
				flag = false;
				errmsg += "Name field is Empty";
			}else if((!meml.matches()) && (!menm.matches())){
				flag = false;
				errmsg += "Invalid Name or Email";
			}

			if(flag){
				User user = User.loginUser(ukey,password);
				
				if(user != null){
					MemPurchase mpur = new MemPurchase();
					mpur.setUser(user);
					mpur.collectMemPurchase();
					if(mpur.getMembership().getMembershipId() != 0)
						session.setAttribute("mempurchase",mpur);
					session.setAttribute("user",mpur.getUser());
					if(user.getUserType().getUserTypeId()==1)
						response.sendRedirect("home.do");
					else if(user.getUserType().getUserTypeId()==2)
						response.sendRedirect("adminhome.do");
				}else{
					request.setAttribute("errmsg","Please check Name or Email And Password");
					request.getRequestDispatcher("/signin.jsp").forward(request,response);
				}			
			}else{
				request.setAttribute("errmsg",errmsg);
				request.getRequestDispatcher("/signin.jsp").forward(request,response);
			}
		}
	}
}