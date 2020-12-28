package controllers;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.*;

import com.google.gson.Gson;

public class MembershipCreditsPurchaseServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
		String resp = "";
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		MemPurchase memp = (MemPurchase)session.getAttribute("mempurchase");
		Integer bookid = Integer.parseInt(request.getParameter("bookid"));
		if(user != null){
			if(memp.getCredits() > 0){
				if(Purchase.checkPurchase(user.getUserId(),bookid)){
					resp = gson.toJson("You Have Already Purchased This Book ");	
				}else{
					memp.decCredits();
					session.setAttribute("mempurchase",memp);
					Purchase.savePurchasedBook(user.getUserId(),bookid,1);
					resp = gson.toJson("You Have Sucessfully Purchased this Book");	
				}	
			}else{
				resp = gson.toJson("Sorry!!! You Are Out of Credits ");	
			}				
		}
		else{
			response.sendRedirect("login.do");
		}
		response.getWriter().write(resp);
	}
}