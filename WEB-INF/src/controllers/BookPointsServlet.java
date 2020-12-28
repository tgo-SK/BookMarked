package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

import models.*;

import com.google.gson.Gson;

public class BookPointsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String resp;
		ArrayList<BookPoint> bookpoints = BookPoint.collectPoints(bookid);
		Gson gson = new Gson();
		resp = gson.toJson(bookpoints);
		response.getWriter().write(resp);
	}
}