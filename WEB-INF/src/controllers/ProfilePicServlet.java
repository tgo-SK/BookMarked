package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import models.User;

public class ProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		
		String nextPage = "signin.jsp";
		if(user!=null)
			nextPage = "profile.jsp";
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				ServletFileUpload sfu = new ServletFileUpload(dfif);
			
				List<FileItem> fileItems = null;

				try{
					fileItems = sfu.parseRequest(request);
				}catch(FileUploadException e){e.printStackTrace();}

				FileItem fileItem = fileItems.get(0);
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());

				String fileName = fileItem.getName();
				
				if(user.getProfPic()!=null){
					File file2 = new File(uploadPath);
					File[] li = file2.listFiles();
					String str = user.getProfPic().replaceFirst(user.getUserName()+"/","");
					for(File f : li){
						if(f.toString().contains(str))
							f.delete();
					}
				}

				File file = new File(uploadPath,fileName);

				try{
					fileItem.write(file);
					user.setProfPic(user.getUserName()+"/"+fileName);
					user.saveProfPic();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			response.sendRedirect("profile.do");
		}else{
			response.sendRedirect("login.do");
		}
	}
}
