package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;

import models.Book;
import models.User;

public class DeleteBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getUserType().getUserTypeId() ==  2){
			int bookid = Integer.parseInt(request.getParameter("bookid"));		
			Book.deleteBook(bookid);
			response.sendRedirect("modify.do");
		}
	}
}