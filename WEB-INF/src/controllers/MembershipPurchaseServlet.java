package controllers;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.*;

public class MembershipPurchaseServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null){
			if(session.getAttribute("mempurchase") != null){
				request.setAttribute("popup","U Have Already Purchased A Membership");
				request.getRequestDispatcher("home.do").forward(request,response);
			}
			if(user.getMembership().getMembershipId() == 0){
				int membership_id = Integer.parseInt(request.getParameter("memid"));
				MemPurchase memp = new MemPurchase(new Membership(membership_id));
				memp.setUser(user);
				memp.purchaseMembership(user.getUserId());
				memp.collectMemPurchase();
				user.setMembership(memp.getMembership());
				session.setAttribute("user",user);
				session.setAttribute("mempurchase",memp);
				if(membership_id==1){
					response.sendRedirect("memberships/lecturer.html");
				}else if(membership_id==2){
					response.sendRedirect("memberships/reader.html");
				}else{
					response.sendRedirect("memberships/professor.html");
				}

				//request.setAttribute("popup","Congratulations U Have Purchased Membership");
				//request.getRequestDispatcher("home.do").forward(request,response);
			}
		}else{
			response.sendRedirect("login.do");
		}
	}
}