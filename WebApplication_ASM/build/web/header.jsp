<%-- 
    Document   : header
    Created on : Feb 17, 2025, 2:18:54 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<header class="bg-primary text-white py-3">
    <div class="container d-flex align-items-center justify-content-between">
        <!-- Logo -->
        <div class="d-flex align-items-center">
            <!-- If you have a logo image, place it here:
                 <img src="logo.png" alt="Logo" width="40" height="40" class="me-2">
            -->
            <span class="fs-4 fw-bold">TENWEB</span>
        </div>

        <form class="d-flex w-50" role="search">
            <input class="form-control me-2" type="search" placeholder="Bạn muốn tìm truyện gì">
                <button class="btn btn-light" type="submit">
                    <!-- Example search icon (Bootstrap Icons) -->
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" 
                         class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11 6a5 5 0 1 1-9.999.001A5 5 0 0 1 11 6zm-1.017 
                              3.314a6 6 0 1 0-1.414 1.414l3.85 3.85a1 1 
                              0 0 0 1.414-1.414l-3.85-3.85z"/>
                    </svg>
                </button>
        </form>

        <div>
            <a href="auth.jsp?action=sign_up" class="btn btn-light me-2">Đăng ký</a>
            <a href="auth.jsp?action=login" class="btn btn-light">Đăng nhập</a>
        </div>
    </div>
</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>