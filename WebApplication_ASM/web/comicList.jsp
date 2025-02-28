<%-- 
    Document   : comicList
    Created on : Feb 28, 2025, 9:15:47 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comic List</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container mb-4">
            <h3 class="mt-4 mb-4"> Add title </h3>
            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">

                <%
                    for (int i = 0; i < 18; i++) {
                %>
                <div class="col">
                    <div class="card comic-card">
                        <img src="https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg" class="card-img-top w-100 h-50" alt="<% %>" style="max-height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title"> Comic Title 1  </h5>
                            <p class="card-text">Short description or snippet about the comic.</p>
                            <a href="#" class="btn btn-primary" >Đọc ngay</a>
                        </div>
                    </div>
                </div>
                <%
                    }

                %>
            </div>
        </div>

        <!--
        IDEA PAGINATION
        - Nhận số lượng trang
        - Kiểm tra đang trang mấy. Chỉ show 3 trang trc và 3 trang sau
        -->

        <%!
            int curPage = 2;
        %>
        <nav>
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" tabindex="-1">Tới trang đầu</a>
                </li>

                <%                    for (int i = curPage - 3; i <= curPage + 3; i++) {
                        if (i > 0) {
                %>
                <li class="page-item <%=(curPage == i) ? "active" : ""%>"><a class="page-link" href="#"><%=i%></a></li>
                    <%
                            }
                        }
                    %>
                <li class="page-item">
                    <a class="page-link" href="#">Tới trang cuối</a>
                </li>
            </ul>
        </nav>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
    <%@include file="footer.jsp" %>
</html>
