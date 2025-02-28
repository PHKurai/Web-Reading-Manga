<%-- 
    Document   : home
    Created on : Feb 19, 2025, 10:13:06 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="popular-comic shadow-lg text-white p-4 mb-4 position-relative" 
             style="background-image: url('https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg'); background-size: cover; background-position: center;">

            <div class="position-absolute top-0 start-0 w-100 h-100 bg-dark opacity-50"></div>

            <div class="container position-relative">
                <div class="row align-items-center">
                    <div class="col-md-4">
                        <img src="https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg" alt="Comic Cover"
                             class="img-fluid border border-white rounded shadow">
                    </div>

                    <div class="col-md-8">
                        <div class="mt-3 mt-md-0">
                            <h2 class="fs-2 mb-3">Akumade Taidana Akuyaku Kizoku</h2>

                            <div class="mb-3">
                                <span class="badge bg-warning text-dark">Action</span>
                                <span class="badge bg-warning text-dark">Adventure</span>
                                <span class="badge bg-warning text-dark">Fantasy</span>
                                <span class="badge bg-warning text-dark">Seinen</span>
                            </div>

                            <p class="mb-3">
                                Luke is the only 3rd son of a villainous duke. By some unexpected instance he comes to know
                                of his own fate and attempts to avoid it. He works hard at finding a peaceful family to
                                marry into and researching magic. All his hard work is to live a peaceful and slothful
                                life... And yet he gets involved in one plan after another!
                            </p>

                            <div class="fw-light fst-italic">By Serota, Izo</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="container">
            <div class="d-flex justify-content-between"><h3>Top Read This Week</h3> <a href="comicList.jsp" class="arrow-link">→</a></div>
            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                <%
                    for (int i = 0; i < 6; i++) {
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

            <div class="d-flex justify-content-between"><h3>Top Read This Month</h3> <a href="#" class="arrow-link">→</a></div>
            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                <%                    for (int i = 0; i < 6; i++) {
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

            <div class="d-flex justify-content-between"><h3>Top Read This Year</h3> <a href="#" class="arrow-link">→</a></div>
            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                <%                    for (int i = 0; i < 6; i++) {
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

            <div class="d-flex justify-content-between"><h3>Recently Added</h3> <a href="#" class="arrow-link">→</a></div>
            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                <%                    for (int i = 0; i < 6; i++) {
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
            
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
    <%@include file="footer.jsp" %>
</html>
