<%-- 
    Document   : read
    Created on : Mar 1, 2025, 12:07:29 AM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container my-4">
            <!-- Comic title and chapter info -->
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4 class="mb-0">Ta Là Tà Đế - Chapter 548</h4>
                <!-- Next/Prev Buttons -->
                <div>
                    <a href="#" class="btn btn-outline-secondary me-2">Chap Trước</a>
                    <a href="#" class="btn btn-outline-secondary">Chap Sau</a>
                </div>
            </div>

            <hr />

            <!-- Comic Images -->
            <div class="mb-5">
                <img
                    src="https://via.placeholder.com/600x800?text=Page+1"
                    alt="Page 1"
                    class="img-fluid d-block mx-auto"
                    />
                <img
                    src="https://via.placeholder.com/600x800?text=Page+2"
                    alt="Page 2"
                    class="img-fluid d-block mx-auto"
                    />
                <img
                    src="https://via.placeholder.com/600x800?text=Page+3"
                    alt="Page 3"
                    class="img-fluid d-block mx-auto"
                    />
            </div>

            <!-- Next/Prev Buttons at bottom -->
            <div class="d-flex justify-content-between my-3">
                <a href="#" class="btn btn-outline-secondary">Chap Trước</a>
                <a href="#" class="btn btn-outline-secondary">Chap Sau</a>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    <%@include file="footer.jsp" %>

</html>
