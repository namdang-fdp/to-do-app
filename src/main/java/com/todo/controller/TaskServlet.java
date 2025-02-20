package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.dao.TaskDAO;
import com.todo.model.TaskDTO;
import com.todo.model.UserDTO;

public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TaskDAO taskDao = new TaskDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("users");
		List<TaskDTO> tasks = taskDao.getAllTasks(user.getId());
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("taskList.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
