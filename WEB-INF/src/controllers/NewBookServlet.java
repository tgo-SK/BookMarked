package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

public class NewBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(user.getUserType().getUserTypeId() == 2){
				ArrayList<Category> category = Category.collectCategory(); 
				request.setAttribute("category",category);
				request.getRequestDispatcher("add_new_book.jsp").forward(request,response);	
			}
		}
		else{
			response.sendRedirect("login.do");
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String resp = null;

		if(user != null){
			String bookName = request.getParameter("p_name");

			if(bookName != null){
				int categoryId = Integer.parseInt(request.getParameter("p_option"));	
				Integer price = Integer.parseInt(request.getParameter("p_price"));
				String author = String.valueOf(request.getParameter("p_author"));
				String description = String.valueOf(request.getParameter("p_desc"));
				
				int book_type = 0;
				String p_type = request.getParameter("p_type");
				switch(p_type){
					case "e-book": book_type = 1;break;
					case "Audio Book": book_type = 2;break;
				}

				String payment = request.getParameter("p_payment");

				Book book = new Book(new Category(categoryId),bookName,price,author,description,new FileType(book_type),payment);
				if(book.saveBook()){

					String bookPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());
					File file = new File(bookPath,String.valueOf(book.getCategory().returnCategory()));
					file.mkdir();
					
					file = new File(bookPath+"/"+String.valueOf(book.getCategory().returnCategory()),String.valueOf(book.getBookId()+"_"+book.getTitle()));
					file.mkdir();

					session.setAttribute("book",book);
				}

				String[] pointTitels = request.getParameterValues("point_title");
				String[] pointValues = request.getParameterValues("product_point");

				if(book!=null){
					if(BookPoint.saveBookPoints(book.getBookId(),pointTitels,pointValues)){
						resp = "{\"resp\":1}";
					}
				}else{
					resp = "{\"resp\":-1}";
				}

			}
		}else{
			request.getRequestDispatcher("/signin.jsp").forward(request,response);
		}
		response.getWriter().write(resp);
	}
}