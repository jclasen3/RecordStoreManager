<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="northofnola.models.User" %>
<%@ include file="header.jsp" %>

<main class="container my-5">
<%
    // Check if a User object exists in the session
    Object userObj = session.getAttribute("user");
    if (userObj != null && userObj instanceof User) {
        User user = (User) userObj;
%>
    <!-- If user is logged in, display a welcome message and logout button -->
    <div class="text-center">
        <h2>Welcome, <%= user.getFirstName() %>!</h2>
        <p><strong>Email:</strong> <%= user.getEmail() %></p>
        <a href="logout" class="btn btn-danger mt-3">Logout</a>
    </div>
<%
    } else {
%>
    <!-- If user is not logged in, display registration and login forms -->
    <h2 class="text-center mb-4">Account Access</h2>

    <div class="row">
        <!-- Registration Form -->
        <div class="col-md-6">
            <h4>Register</h4>
            <form action="register" method="post">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" name="firstName" required>
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" name="lastName" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>

        <!-- Login Form -->
        <div class="col-md-6">
            <h4>Login</h4>
            <form action="login" method="post">
                <div class="mb-3">
                    <label for="loginEmail" class="form-label">Email</label>
                    <input type="email" class="form-control" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="loginPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <button type="submit" class="btn btn-success">Login</button>

                <% if ("true".equals(request.getParameter("error"))) { %>
                    <div class="text-danger mt-2">Invalid email or password. Please try again.</div>
                <% } %>
            </form>
        </div>
    </div>
<%
    }
%>
</main>

<%@ include file="footer.jsp" %>
