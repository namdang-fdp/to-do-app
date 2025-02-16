<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="POST">
		<div>
			<div>
			<label for="title">Title: </label>
			<input type="text" id="title" name="title" placeholder="Drink water" required="required">
		</div>
		<br>
		<div>
			<label for="description" >Description:</label>
			<textarea id="description" name="description" placeholder="Must completed" rows="4"></textarea>
		</div>
		<br>
		<div>
			<label for="dueDate">Due Date</label>
			<input type="date" id="dueDate" name="dueDate">
		</div>
		<button type="submit">Create Task</button>
		</div>
	
	
	</form>

</body>
</html>