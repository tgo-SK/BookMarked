package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import models.*;

import java.io.*;
import java.util.*;


import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;


public class UpdateBookFilesServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "login.do";
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
				
				List<FileItem> fileItems = null;
				try{
					fileItems = sfu.parseRequest(request);
					fileItems.remove(fileItems.size()-1);
					Book book = (Book)session.getAttribute("etbook");
		
					String Categ = book.getCategory().returnCategory();
					String picUploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+Categ+"/"+book.getBookId()+"_"+book.getTitle());
					
					String dbPicPath = user.getUserName()+"/"+Categ+"/"+book.getBookId()+"_"+book.getTitle()+"/";
					ArrayList<String> dbPicPaths = new ArrayList<String>();
					int i=1;
					for(FileItem fileItem : fileItems){
						String fileName = fileItem.getName();
						if(fileItems.size()==i){
							book.setBookFile(dbPicPath+fileName);
							book.updateBookFile();
						}
						else{
							dbPicPaths.add(dbPicPath+fileName);						
							++i;
						}
						try{
							File file = new File(picUploadPath,fileName);
							fileItem.write(file);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					
					BookPic.updateBookPics(book.getBookId(),dbPicPaths);
					nextPage = "modify.do";
				}catch(FileUploadException e){
					e.printStackTrace();
				}
			}
		}else{
			
		}
		response.sendRedirect(nextPage);
	}
}
