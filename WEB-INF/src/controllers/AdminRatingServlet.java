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

public class AdminRatingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){		
			String rat = String.valueOf(new Random().nextInt(5)+1);
			Integer userId = user.getUserId();
			
			Book book = (Book)session.getAttribute("book");
			Integer bookId = book.getBookId();

			Rating rating = new Rating(rat,new User(userId),new Book(bookId));
			rating.giveRating();

			response.sendRedirect("home.jsp");
		
		}else{
			response.sendRedirect("login.do");
		}
	}
}