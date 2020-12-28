package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.Date;

import models.*;

public class EditBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getUserType().getUserTypeId() == 2){
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			Book editbook = new Book();
			editbook.getBookdetails(bookid);
			session.setAttribute("editbook",editbook);

			ArrayList<BookPoint> bookpoints = BookPoint.collectPoints(bookid);
			session.setAttribute("editbookpoints",bookpoints);			
			request.getRequestDispatcher("edit.jsp").forward(request,response);
		}
	}
}