package controllers;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.Book;
import models.User;
import models.FileType;

public class UpdateBookPayServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
	
		HttpSession session = request.getSession();

		User usr = (User)session.getAttribute("user");
		String resp = "";

		if(usr!=null){
			int fileType = Integer.parseInt(request.getParameter("fileType"));
			String payment = request.getParameter("pay");
			Book book = (Book)session.getAttribute("etbook");
			book.setPayment(payment);
			book.setFileType(new FileType(fileType));
			if(book.updatePayment()){
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