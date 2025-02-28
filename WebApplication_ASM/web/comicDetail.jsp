<%-- 
    Document   : comicDetail
    Created on : Feb 28, 2025, 11:52:30 PM
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
        <div class="container text-dark my-4">
            <div class="row">

                <div class="col-md-3 mb-3">
                    <img src="https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg" alt="Comic Cover" class="img-fluid rounded"/>
                </div>

                <div class="col-md-9">
                    <h2 class="fw-bold">Tên truyện: Ta Là Tà Đế</h2>
                    <p><strong>Tác giả:</strong> Đông Cấp Nhất</p>
                    <p><strong>Tình trạng:</strong> Đang cập nhật</p>
                    <p>
                        <strong>Lượt thích:</strong> 123 &nbsp; | &nbsp;
                        <strong>Lượt theo dõi:</strong> 456 &nbsp; | &nbsp;
                        <strong>Lượt xem:</strong> 789
                    </p>
                    <p>
                        <strong>Thể loại:</strong>
                        <span class="badge bg-info text-dark">Supernatural</span>
                        <span class="badge bg-info text-dark">Manhua</span>
                        <span class="badge bg-info text-dark">Xuyên Không</span>
                    </p>

                    <div class="mb-3">
                        <a href="#" class="btn btn-success me-2">Đọc từ đầu</a>
                        <button class="btn btn-warning me-2">Theo dõi</button>
                        <button class="btn btn-danger">Thích</button>
                    </div>

                    <div class="mb-3">
                        <h5 class="fw-bold">Giới thiệu</h5>
                        <p>
                            Truyện Ta Là Tà Đế được cập nhật nhanh và đầy đủ nhất tại MyComicSite.
                            Đừng quên ủng hộ và bình luận để nhóm dịch có thêm động lực nhé!
                        </p>
                    </div>
                </div>
            </div>

            <hr class="my-4" />
            <h4 class="fw-bold">Danh Sách Chương</h4>

            <div class="input-group mb-3 mt-3">
                <input
                    type="text"
                    class="form-control"
                    placeholder="Tìm chương..."
                    aria-label="Search Chapter"
                    />
                <button class="btn btn-secondary" type="button">Tìm</button>
            </div>

            <div class="table-responsive" style="max-height: 600px; overflow-y: auto;">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Chương</th>
                            <th>Ngày cập nhật</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 100; i > 0; i--) {
                        %>
                        <tr>
                            <td><a href="read-comic.html">Chương <%=i%></a></td>
                            <td>28/02/2025</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    
    <%@include file="footer.jsp" %>
</html>
