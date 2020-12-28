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

public class SessionBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int category = Integer.parseInt(request.getParameter("caterory"));
		AllBooksServlet.catBooks = Book.categoryBooks(category);
		
		request.getRequestDispatcher("showBooks.jsp").forward(request,response);
	}
}