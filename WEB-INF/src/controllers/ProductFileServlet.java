package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

import models.*;

public class ProductFileServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		boolean flag1 = false;
		boolean flag2 = false;

		String resp = null;
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				
				List<FileItem> fileItems = null;
				try{
					fileItems = sfu.parseRequest(request);
					
					Book book = (Book)session.getAttribute("book");

					String fileUploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+book.getCategory().returnCategory()+"/"+book.getBookId()+"_"+book.getTitle());
					
					FileItem fileItem = fileItems.get(0);
					String fileName = fileItem.getName();

					try{							
						File file = new File(fileUploadPath,fileName);

						fileItem.write(file);
					}catch(Exception e){
						e.printStackTrace();
					}
					flag1 = Book.saveBookFile(book.getBookId(),user.getUserName()+"/"+book.getCategory().returnCategory()+"/"+book.getBookId()+"_"+book.getTitle()+"/"+fileName);

					
					fileItems.remove(0);

					String picUploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+book.getCategory().returnCategory()+"/"+book.getBookId()+"_"+book.getTitle());
					
					String dbPicPath = user.getUserName()+"/"+String.valueOf(book.getCategory().returnCategory())+"/"+book.getBookId()+"_"+book.getTitle()+"/";
					ArrayList<String> dbPicPaths = new ArrayList<String>();	

					for(FileItem fileItem1 : fileItems){
						String fileName1 = fileItem1.getName();
						dbPicPaths.add(dbPicPath+fileName1);

						try{							
							File file = new File(picUploadPath,fileName1);

							fileItem1.write(file);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					flag2 = BookPic.saveBookPics(book.getBookId(),dbPicPaths);
					
				}catch(FileUploadException e){
					e.printStackTrace();
				}
			}
			if(flag1==true && flag2==true){	
				response.sendRedirect("adminrating.do");
			}
		}else{
			response.sendRedirect("login.do");
		}
	}
}