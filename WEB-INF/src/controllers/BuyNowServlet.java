package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.*;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

public class BuyNowServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			
			if(Purchase.checkPurchase(user.getUserId(),bookId)){
				String resp;
				Gson gson = new Gson();
				resp = gson.toJson("U have Already Purchased this Book");	
				response.getWriter().write(resp);
			}
			else{
				Purchase.savePurchasedBook(user.getUserId(),bookId,0);

				String resp;
				Gson gson = new Gson();
				resp = gson.toJson("You Have Sucessfully Purchased this Book");	
				response.getWriter().write(resp);
			}	
			
		}else{
			response.getWriter().write("{\"resp\":0}");
		}
	}
}