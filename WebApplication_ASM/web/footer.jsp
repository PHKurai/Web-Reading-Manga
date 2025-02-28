<%-- 
    Document   : footer
    Created on : Feb 17, 2025, 2:19:30 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<style>
    /* Example for custom icons in footer-center if you have them */
    .fb::before {
        content: "FB";
        font-weight: bold;
    }
    .ig::before {
        content: "IG";
        font-weight: bold;
    }
    .gh::before {
        content: "GH";
        font-weight: bold;
    }
</style>

<footer class="bg-primary text-white">
    <div class="container py-4">
        <div class="row">
            <!-- Left Section -->
            <div class="col-md-4 mb-3">
                <p class="mb-1">Trang web đọc truyện tranh online</p>
                <h3 class="h5">TenWeb</h3>
                <p class="mb-0">Email hỗ trợ: phuclamhong05@gmail.com</p>
            </div>

            <!-- Center Section -->
            <div class="col-md-4 mb-3 d-flex align-items-center justify-content-center">
                <!-- Replace with your social icons or text -->
                <a href="#" class="text-white fs-4 mx-2"><i class="fb"></i></a>
                <a href="#" class="text-white fs-4 mx-2"><i class="ig"></i></a>
                <a href="#" class="text-white fs-4 mx-2"><i class="gh"></i></a>
            </div>

            <!-- Right Section -->
            <div class="col-md-4 mb-3 text-md-end text-center">
                <p class="mb-1">&copy; 2025</p>
                <p class="mb-0">Không sao chép</p>
            </div>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>