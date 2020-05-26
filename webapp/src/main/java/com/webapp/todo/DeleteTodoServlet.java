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




@WebServlet(urlPatterns="/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException
	{
		
		TodoService.deleteTodo(new Todo(request.getParameter("todo")));
		response.sendRedirect("/todo.do");
		
		
		
		
	}
	

	
	
	
	

}
