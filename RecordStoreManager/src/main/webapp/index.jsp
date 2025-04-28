<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!-- Bootstrap CDN (only include if not already in header.jsp) -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- All Content used is strictly for educational purposes -->

<main class="container my-5">
     <!-- Welcome message -->
    <h2 class="text-center mb-4">Welcome to North of New Orleans Records!</h2>
    <p class="text-center mb-5">Your destination for a massive selection of vinyl records, CDs, and Cassettes. Browse our collection and find your next favorite album.</p>

    <h3 class="text-center mb-4">🔥 What's Hot?</h3>
    
     <!-- Bootstrap Carousel showcasing popular albums -->
    <div id="hotCarousel" class="carousel slide mx-auto" data-bs-ride="carousel" style="width: 500px;">
        <div class="carousel-inner">
            <!-- Album 1 -->
            <div class="carousel-item active">
                <img src="Images/F-1Trillion.jpg" class="d-block w-100" alt="Album 1" style="max-height: 400px; object-fit: cover;">
                <div class="carousel-caption d-none d-md-block bg-dark bg-opacity-50 rounded">
                    <h5>F-1 Trillion</h5>
                    <p>Post Malone</p>
                </div>
            </div>

            <!-- Album 2 -->
            <div class="carousel-item">
                <img src="Images/HurryUpTomorrow.jpg" class="d-block w-100" alt="Album 2" style="max-height: 400px; object-fit: cover;">
                <div class="carousel-caption d-none d-md-block bg-dark bg-opacity-50 rounded">
                    <h5>Hurry Up Tomorrow</h5>
                    <p>The Weeknd</p>
                </div>
            </div>

            <!-- Album 3 -->
            <div class="carousel-item">
                <img src="Images/MidwestPrincess.jpg" class="d-block w-100" alt="Album 3" style="max-height: 400px; object-fit: cover;">
                <div class="carousel-caption d-none d-md-block bg-dark bg-opacity-50 rounded">
                    <h5>The Rise and Fall of a Midwest Princess</h5>
                    <p>Chappell Roan</p>
                </div>
            </div>

            <!-- Album 4 -->
            <div class="carousel-item">
                <img src="Images/IAmMusic.jpg" class="d-block w-100" alt="Album 4" style="max-height: 400px; object-fit: cover;">
                <div class="carousel-caption d-none d-md-block bg-dark bg-opacity-50 rounded">
                    <h5>I Am Music</h5>
                    <p>Playboi Carti</p>
                </div>
            </div>

            <!-- Album 5 -->
            <div class="carousel-item">
                <img src="Images/Automatic.jpg" class="d-block w-100" alt="Album 5" style="max-height: 400px; object-fit: cover;">
                <div class="carousel-caption d-none d-md-block bg-dark bg-opacity-50 rounded">
                    <h5>Automatic</h5>
                    <p>The Lumineers</p>
                </div>
            </div>
        </div>

        <!-- Carousel controls -->
        <button class="carousel-control-prev" type="button" data-bs-target="#hotCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#hotCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</main>

<%@ include file="footer.jsp" %>

