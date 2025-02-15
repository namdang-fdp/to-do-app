<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List,com.todo.model.TaskDTO" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<html>
<head>
    <title>To-Do List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>To-Do List</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Due Date</th>
            <th>Option</th>
        </tr>
        <%
        	List<TaskDTO> tasks = (List<TaskDTO>) request.getAttribute("tasks");
                    if (tasks != null) {
                        for (TaskDTO task : tasks) {
        %>
        <tr>
            <td><%= task.getTitle() %></td>
            <td><%= task.getDescription() %></td>
            <td><%= task.isStatus() ? "Completed" : "Pending" %></td>
            <td><%= task.getDueDate() %></td>
            <td>
				<form action="delete" method="POST">
					<input type="hidden" name="taskId" value=<%= task.getId() %>>
					<button type="submit">
						Delete
					</button>
				</form>
				<form action="update" method="POST">
					<input type="hidden" name="taskId" value=<%= task.getId() %>>
					<button type="submit">
						Update
					</button>
				</form>
			</td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>