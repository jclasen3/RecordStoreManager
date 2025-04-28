<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
 <!-- Main container for the contact form -->
<div class="container mt-5">
    <h2 class="mb-4 text-center">Contact Us</h2>
    <!-- Contact form that submits to a servlet mapped to "submitContact" -->
    <form action="submitContact" method="post" class="shadow p-4 rounded bg-light">
        
        <!-- Name input -->
        <div class="mb-3">
            <label for="name" class="form-label">Full Name:</label>
            <input type="text" class="form-control" id="name" name="name" required placeholder="John Doe">
        </div>
        
        <!-- Phone number input -->
        <div class="mb-3">
            <label for="phone" class="form-label">Phone Number:</label>
            <input type="tel" class="form-control" id="phone" name="phone" required placeholder="(555) 123-4567">
        </div>
        
        <!-- Email input -->
        <div class="mb-3">
            <label for="email" class="form-label">Email Address:</label>
            <input type="email" class="form-control" id="email" name="email" required placeholder="you@example.com">
        </div>
        
        <!-- Dropdown to select the reason for contacting -->
        <div class="mb-3">
            <label for="helpTopic" class="form-label">What do you need help with?</label>
            <select class="form-select" id="helpTopic" name="helpTopic" required>
                <option value="">-- Select an Option --</option>
                <option value="order">Order Assistance</option>
                <option value="account">Account Issues</option>
                <option value="technical">Media Information</option>
                <option value="feedback">Feedback / Suggestions</option>
                <option value="other">Other</option>
            </select>
        </div>
        
         <!-- Text area for additional user input -->
        <div class="mb-3">
            <label for="message" class="form-label">Additional Information:</label>
            <textarea class="form-control" id="message" name="message" rows="4" placeholder="Enter your message here..."></textarea>
        </div>
         
         <!-- Submit button -->
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>

    </form>
</div>


</body>
</html>


<%@ include file="footer.jsp" %>