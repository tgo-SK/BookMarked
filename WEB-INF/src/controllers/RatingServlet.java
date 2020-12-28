package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

import com.google.gson.Gson;

public class RatingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int book_Id = Integer.parseInt(request.getParameter("bookid"));

		String resp;

		String rating = Rating.collectRating(book_Id);
		request.setAttribute("rating",rating);

		Gson gson = new Gson();
		resp = gson.toJson(rating);
		response.getWriter().write(resp);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			String rat = request.getParameter("rating");
			Integer userId = user.getUserId();
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));

			Rating rating = new Rating(rat,new User(userId),new Book(bookId));
			rating.giveRating();
		}

		request.getRequestDispatcher("singlerating.do").forward(request,response);
	}
}