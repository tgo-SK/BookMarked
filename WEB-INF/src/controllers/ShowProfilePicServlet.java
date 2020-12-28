package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class ShowProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		OutputStream os = response.getOutputStream();

		String profpicPath = "static/images/profile/profpic.jpg";

		if(user!=null){		
			String profpic = user.getProfPic();
			if(profpic!=null){
				profpicPath = "/WEB-INF/uploads/"+profpic;
			}
		}		
		InputStream is = getServletContext().getResourceAsStream(profpicPath);
		
		byte[] arr = new byte[1024];
		int count = 0;

		while((count=is.read(arr))!=-1){
			os.write(arr);
		}

		os.flush();
		os.close();
	}
}