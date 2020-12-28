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

public class RecentBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){			
			Purchase purchase = new Purchase();
			AllBooksServlet.catBooks = purchase.recentBooks(user.getUserId());
		
			request.getRequestDispatcher("RecentBook.jsp").forward(request,response);
		
		}else{
			response.sendRedirect("login.do");
		}
	}
}