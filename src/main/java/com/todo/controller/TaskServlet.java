package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDAO;
import com.todo.model.TaskDTO;

public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TaskDAO taskDao = new TaskDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TaskDTO> tasks = taskDao.getAllTasks(0);
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("taskList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
