package controllers;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.*;

public class UpdateBookDesServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
	
		HttpSession session = request.getSession();

		User usr = (User)session.getAttribute("user");
		String resp = "";
		
		if(usr!=null){
			int bookId = Integer.parseInt(request.getParameter("bookid"));
			String description = request.getParameter("desp");

			Book book = (Book)session.getAttribute("etbook");
			book.setDescription(description);
			if(book.updateDescription()){
				resp += "{\"resp\":1}";
			}else{
				resp += "{\"resp\":0}";
			}			
		}else{
			resp += "{\"resp\":-1}";
		}

		response.getWriter().write(resp);
	}
}