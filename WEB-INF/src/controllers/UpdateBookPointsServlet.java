package controllers;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.User;
import models.Book;
import models.BookPoint;

public class UpdateBookPointsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response ) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String resp = null;
		if(user!=null){
			String[] pnames = request.getParameterValues("pname");
			String[] pvalues = request.getParameterValues("pvalue");
			Book book = (Book)session.getAttribute("etbook");
					
			BookPoint.updateBookPoints(book.getBookId(),pnames,pvalues);

			resp = "{\"resp\": 1}";
		}else{
			resp = "{\"resp\": -1}";
		}
		response.getWriter().write(resp);
	}
}