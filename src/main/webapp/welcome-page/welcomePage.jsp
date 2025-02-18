<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskMaster - Your To-Do List App</title>
<link rel="stylesheet" href="welcome-page/welcomePage.css">
</head>
<body>
	<div class="container">
        <header>
            <nav>
                <h1 class="logo">TaskMaster</h1>
                <div class="nav-links">
                    <a href="#" class="nav-button">Login</a>
                    <a href="#" class="nav-button register">Register</a>
                </div>
            </nav>
        </header>

        <main>
            <h2>Welcome to TaskMaster</h2>
            <p class="intro">
                Organize your life, boost your productivity, and achieve your goals with our powerful to-do list app.
            </p>
            <img src="/todoapp/resources/images/HardWorking-removebg-preview.png" alt="TaskMaster Image">

            <div class="cta-buttons">
                <a href="#" class="button primary">Get Started</a>
                <a href="#" class="button secondary">Learn More</a>
            </div>
        </main>

        <section class="join-section">
            <div class="join-card">
                <h3>Join TaskMaster Today</h3>
                <a href="#" class="button primary full-width">Create an Account</a>
                <p class="login-prompt">
                    Already have an account? <a href="#" class="text-link">Log in</a>
                </p>
            </div>
        </section>
    </div>
</body>
</html>