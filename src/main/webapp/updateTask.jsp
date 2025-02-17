<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.todo.model.TaskDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], textarea, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Update Task</h1>
    
    <% TaskDTO task = (TaskDTO) request.getAttribute("task"); %>
    
    <form action="UpdateTaskServlet" method="POST">
        <input type="hidden" name="taskId" value="<%= task.getId() %>">
        
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= task.getTitle() %>" required>
        </div>
        
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4"><%= task.getDescription() %></textarea>
        </div>
        
        <div class="form-group">
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" value="<%= task.getDueDate() %>" required>
        </div>
        
        
        <button type="submit">Update Task</button>
    </form>
    
    <p><a href="taskList.jsp">Back to Task List</a></p>
</body>
</html>