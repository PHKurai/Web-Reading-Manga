<%-- 
    Document   : header
    Created on : Feb 17, 2025, 2:18:54 PM
    Author     : phucl
--%>

<%@page import="dto.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<header class="bg-primary text-white py-3">
    <div class="container-fluid bg-primary text-white py-2">
        <div class="container">
            <div class="d-flex align-items-center justify-content-between">

                <div class="d-flex align-items-center">
                    <!-- If you have a logo image, use: 
                         <img src="logo.png" alt="Logo" class="me-2" style="width: 40px; height: 40px;"> -->
                    <span class="fs-4 fw-bold">TENWEB</span>
                </div>

                <form class="d-flex w-50 mx-3" role="search">
                    <input 
                        class="form-control me-2" 
                        type="search" 
                        placeholder="Bạn muốn tìm truyện gì" 
                        aria-label="Search">
                    <button class="btn btn-light" type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </form>

                <%
                    if (session.getAttribute("account") != null) {
                        AccountDTO acc = (AccountDTO) session.getAttribute("account");
                %>
                <a href="ProfileController?action=infor" class="d-flex align-items-center">
                    <span class="me-2 text-white"><%=acc.getName()%></span>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGTgDr7zVZCP1vzULDJuI4vfRxzykZ5tjnAYSAYlRq-V3T8aIafR0nLdP_z5ln7pzSYqI&usqp=CAU" alt="Avatar" class="rounded-circle" style="width: 40px; height: 40px;">
                </a>
                <%
                } else {
                %>
                <div>
                    <a href="MainController?action=sign_up" class="btn btn-light me-2">Đăng ký</a>
                    <a href="MainController?action=login" class="btn btn-light">Đăng nhập</a>
                </div>
                <%
                    }
                %>

            </div>
        </div>
    </div>
</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>