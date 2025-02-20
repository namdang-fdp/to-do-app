<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskMaster - Your To-Do List App</title>
<link rel="stylesheet" href="register-page/registerPage.css">
</head>
<body>
	<div class="container">
        <h1>Register</h1>
        <form action="register" method="POST">
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="confirm-password">Confirm Password</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            <button type="submit">Register</button>
        </form>
        <p class="login-link">Already have an account? <a href="/todoapp/login">Log in</a></p>
        <div class="error-popup-overlay" id="errorOverlay"></div>
		<div class="error-popup" id="errorPopup">
		    <div class="error-popup-content">
		        <div id="errorMessage">
		            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
		        </div>
		        <button class="close-button" onclick="closeErrorPopup()">OK</button>
		    </div>
		</div>
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