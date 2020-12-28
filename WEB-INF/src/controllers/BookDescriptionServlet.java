package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.Book;

public class BookDescriptionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int book_Id = Integer.parseInt(request.getParameter("bookid"));

		Book book = new Book(book_Id);
		book.getBookDescription();

		request.setAttribute("bookdesc",book);

		request.getRequestDispatcher("ProductDescription.jsp").forward(request,response);		
	}
}