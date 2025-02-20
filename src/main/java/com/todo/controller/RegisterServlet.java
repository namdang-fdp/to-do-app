package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.UserDAO;
import com.todo.model.UserDTO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register-page/registerPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserDTO user = new UserDTO();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		boolean success = userDao.createUser(user);
		if(success) {
			response.sendRedirect("login");
		} else {
			request.setAttribute("errorMessage", "Your username has existed. Please choose another one");
			request.getRequestDispatcher("register-page/registerPage.jsp").forward(request, response);
		}
	}
}
