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

import com.google.gson.Gson;


public class AllBooksServlet extends HttpServlet{
	static ArrayList<Book> catBooks = Book.allBooks() ;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String resp;
		Gson gson = new Gson();
		resp = gson.toJson(catBooks);	
		catBooks = Book.allBooks();
		response.getWriter().write(resp);
	}
}