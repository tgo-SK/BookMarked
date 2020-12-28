package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;

import models.User;

public class SaveProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "signin.jsp";
		if(user!=null)
			nextPage = "profile.jsp";
		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String otpClient = request.getParameter("otp");
			String otpSession = (String)session.getAttribute("otp");
			//otpSession = "123456";
			if(otpSession.equals(otpClient)){
				String firstName = request.getParameter("firstName");
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String dob = request.getParameter("dob");
				String mobile = request.getParameter("mobile");

				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setDob(Date.valueOf(dob));
				user.setMobile(mobile);

				if(user.saveProfile()){
					System.out.println("sucess");
					request.setAttribute("sucess","Sucessfull");
					request.getRequestDispatcher("profile.jsp").forward(request,response);
				}else{
					System.out.println("unsucess");
					request.setAttribute("unsucess","Unsucessfull");
					request.getRequestDispatcher("profile.jsp").forward(request,response);
				}	
			}else{
				System.out.println("wrongOTP");
				request.setAttribute("wrongOTP","You Have Entered Wrong OTP");
				request.getRequestDispatcher("profile.jsp");
			}
		}else{response.sendRedirect("login.do");}
	}
}