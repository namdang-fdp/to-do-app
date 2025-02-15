package com.todo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDAO;
import com.todo.model.TaskDTO;

public class CreateNewTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateNewTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("createTask.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TaskDAO taskDAO = new TaskDAO();
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String dueDateStr = request.getParameter("dueDate");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dueDate = simpleDateFormat.parse(dueDateStr);
			
			TaskDTO newTask = new TaskDTO();
			newTask.setTitle(title);
			newTask.setDescription(description);
			newTask.setDueDate(dueDate);
			
			boolean success = taskDAO.createNewTask(newTask);
			if(success) {
				response.sendRedirect("tasks");
			} else {
				request.setAttribute("error", "Fail to create new Task");
				request.getRequestDispatcher("createTask.jsp").forward(request, response);
			}	
		} catch(ParseException e) {
			System.out.println("Something error when parsing date " + e.getMessage());
			request.setAttribute("error", "Fail to parse date format");
			request.getRequestDispatcher("createTask.jsp").forward(request, response);
		}
	}

}
