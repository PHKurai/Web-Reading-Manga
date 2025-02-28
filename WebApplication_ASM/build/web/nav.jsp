<%-- 
    Document   : nav
    Created on : Feb 19, 2025, 10:10:47 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbars">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbars">
            <ul class="container d-flex align-items-center justify-content-evenly navbar-nav mb-0">

                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Trang Chủ</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="typeDropdown" role="button" data-bs-toggle="dropdown">
                        Thể Loại
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Adventure</a></li>
                        <li><a class="dropdown-item" href="#">Anime</a></li>
                        <li><a class="dropdown-item" href="#">Chuyển Sinh</a></li>
                        <li><a class="dropdown-item" href="#">Cổ Đại</a></li>
                        <li><a class="dropdown-item" href="#">Comedy</a></li>
                        <li><a class="dropdown-item" href="#">Drama</a></li>
                        <li><a class="dropdown-item" href="#">Fantasy</a></li>
                        <li><a class="dropdown-item" href="#">Manga</a></li>
                        <li><a class="dropdown-item" href="#">Manhwa</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="rankingDropdown" role="button" data-bs-toggle="dropdown">
                        Xếp Hạng
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Mới nhất</a></li>
                        <li><a class="dropdown-item" href="#">Đọc nhiều</a></li>
                        <li><a class="dropdown-item" href="#">Yêu thích</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Lịch Sử</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Theo Dõi</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>