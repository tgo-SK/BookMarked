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

public class AudioBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		AllBooksServlet.catBooks = Book.getAudioBooks();
	
		request.getRequestDispatcher("audiobooks.jsp").forward(request,response);
	}
}