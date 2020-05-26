package com.webapp.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.TodoService;




@WebServlet(urlPatterns="/todo.do")
public class TodoServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException
	{
		
		
		
		request.setAttribute("todos", TodoService.retrieveTodos());
		
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request,response); 
		
		
	}
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException
	{
		
		String newTodo = request.getParameter("todo");
		TodoService.addTodo(new Todo(newTodo));
		
		
		response.sendRedirect("/todo.do");
		
		
	}
	
	
	
	
	

}
