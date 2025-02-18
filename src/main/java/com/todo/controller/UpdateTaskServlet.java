package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDAO;
import com.todo.model.TaskDTO;

public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateTaskServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("taskId");
		int id = Integer.parseInt(idParam);
		TaskDAO taskDao = new TaskDAO();
		TaskDTO task = taskDao.getTaskById(id);
		request.setAttribute("task", task);
		request.getRequestDispatcher("updateTask.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
