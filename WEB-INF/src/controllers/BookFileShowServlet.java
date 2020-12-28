package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.Book;

public class BookFileShowServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		int fileTypeId = Integer.parseInt(request.getParameter("filetype"));
		String bookfile = Book.collectBookFile(bookid);
		if(fileTypeId == 1)
			response.setContentType("application/pdf");
		else
			response.setContentType("audio/mpeg");
		InputStream is = getServletContext().getResourceAsStream("WEB-INF/uploads/"+bookfile);
		
		OutputStream os = response.getOutputStream();

		byte[] arr = new byte[1024];
		
		int cn = 0;
		while((cn=is.read(arr))!=-1){
			os.write(arr);
		}
		os.flush();
		os.close();
	}
}