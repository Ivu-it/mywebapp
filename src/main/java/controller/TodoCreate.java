package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Service.TodoService;

/**
 * Servlet implementation class TodoCreate
 */
@WebServlet("/TodoCreate")
public class TodoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/todo_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String title = request.getParameter("title");
		String  detail= request.getParameter("detail");
		String status = request.getParameter("status");
		Date due_date = Date.valueOf(request.getParameter("due_date"));

		TodoService as = new TodoService();
		as.createTodo(title, detail, status, due_date);

		response.sendRedirect("TodoList");
	}

}
