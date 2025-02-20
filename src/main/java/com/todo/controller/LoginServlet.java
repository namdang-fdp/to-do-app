package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDAO;
import com.todo.dao.UserDAO;
import com.todo.model.TaskDTO;
import com.todo.model.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login-page/loginPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		TaskDAO taskDao = new TaskDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDTO user = new UserDTO();
		user.setUsername(username);
		user.setPassword(password);
		int userID = userDao.userLogin(user);
		if(userID >= 1) {
			List<TaskDTO> tasks = taskDao.getAllTasks(userID);
			request.setAttribute("tasks", tasks);
			request.getRequestDispatcher("taskList.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Your account hasn't existed. Please register or check your username and password");
			request.getRequestDispatcher("login-page/loginPage.jsp").forward(request, response);
		}
	}

}
