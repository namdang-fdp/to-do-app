package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDAO;
import com.todo.model.TaskDTO;

/**
 * Servlet implementation class DeleteTaskServlet
 */
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskDAO taskDao = new TaskDAO();
    public DeleteTaskServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String deleteId = request.getParameter("taskId");
			taskDao.deleteTask(deleteId);
		} catch(Exception e) {
			System.out.println("Something error in delete task servlet!");
			e.printStackTrace();
		}
		List<TaskDTO> tasks = taskDao.getAllTasks();
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("taskList.jsp").forward(request, response);
	}

}
