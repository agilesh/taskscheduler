package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.TodoService;




@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter writer= response.getWriter();
		
		
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response); 
		
		
	}
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException
	
	{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		LoginService UserValidationservice = new LoginService();
		TodoService todoService = new TodoService();
		
		
		
		boolean isUservalid=UserValidationservice.isUservalid(name, password);
		
		if(isUservalid)
		{
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/todo.do");
		}
		
		else
		{
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response); 

		}
	}
	
	
	
	

}
