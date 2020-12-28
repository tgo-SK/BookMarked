package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import models.*;

import com.google.gson.Gson;

public class UpdateBookServlet extends HttpServlet{
	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		String nextPage = "signin.jsp";
		
		if((user!=null)&&(user.getUserType().getUserTypeId()==2)){
			nextPage = "edit.jsp";
			session.setAttribute("categories",SubCategory.collectSubCategory());
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}*/

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
			
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");

		String nextPage = "signin.jsp";

		if(user!=null){			
			try{
				int bookid = Integer.parseInt(request.getParameter("bookid"));
				Integer categoryId = Integer.parseInt(request.getParameter("p_option1"));
				String bookName = request.getParameter("p_name1");
				Integer price= Integer.parseInt(request.getParameter("p_price1"));
				String author = request.getParameter("p_author");
				Book book = new Book(new Category(categoryId),bookName,author,price);

				if(book.updateBook(bookid)){
					session.setAttribute("etbook",book);

					Gson gson = new Gson();
					String resp = gson.toJson(book);

					response.getWriter().write(resp);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			response.getWriter().write("{\"resp\":0}");
		}
	}
}