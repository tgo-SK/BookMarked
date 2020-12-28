package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

import com.google.gson.Gson;

public class SingleRatingServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));

			Integer userId = user.getUserId();

			String singleRating = Rating.collectSingleRating(bookId,userId);

			String resp;
			Gson gson = new Gson();
			resp = gson.toJson(singleRating);	
			response.getWriter().write(resp);
		}
	}
}