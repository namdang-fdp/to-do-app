<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskMaster - Your To-Do List App</title>
<link rel="stylesheet" href="login-page/loginPage.css">
</head>
<body>
	<div class="login-container">
        <h1>Login</h1>
        <form action="login" method="POST">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Log In</button>
        </form>
        <p class="signup-link">Don't have an account? <a href="/todoapp/register">Sign up</a></p>
    </div>
    <script>
    window.onload = function() {
        <% if(request.getAttribute("errorMessage") != null) { %>
            document.getElementById('errorOverlay').style.display = 'block';
            document.getElementById('errorPopup').style.display = 'block';
        <% } %>
    }

    function closeErrorPopup() {
        document.getElementById('errorOverlay').style.display = 'none';
        document.getElementById('errorPopup').style.display = 'none';
    }
	</script>
</body>
</html>