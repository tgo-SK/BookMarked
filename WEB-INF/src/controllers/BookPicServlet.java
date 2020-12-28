package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.*;

public class BookPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		OutputStream os = response.getOutputStream();

		String bookpic = BookPic.collectPic(bookId);
		String bookpicPath = "/WEB-INF/uploads/"+bookpic;

		InputStream is = getServletContext().getResourceAsStream(bookpicPath);
		
		byte[] arr = new byte[1024];
		int count = 0;

		while((count=is.read(arr))!=-1){
			os.write(arr);
		}

		os.flush();
		os.close();
	}
}