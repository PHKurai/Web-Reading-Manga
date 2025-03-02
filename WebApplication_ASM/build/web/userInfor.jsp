<%-- 
    Document   : userInfor
    Created on : Mar 2, 2025, 9:32:40 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin tài khoản</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%            if (session.getAttribute("account") != null) {
                AccountDTO acc = (AccountDTO) session.getAttribute("account");
        %>
        <div class="container py-5">
            <h2 class="mb-4">User Information</h2>
            <div class="card">
                <div class="card-body">
                    <div class="text-center mb-4">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGTgDr7zVZCP1vzULDJuI4vfRxzykZ5tjnAYSAYlRq-V3T8aIafR0nLdP_z5ln7pzSYqI&usqp=CAU" alt="User Avatar" class="rounded-circle mb-2" />
                        <h5 class="mb-0"><%=acc.getName()%></h5>
                    </div>

                    <form id="mb-4">
                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label">Name</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" value="<%=acc.getName()%>" disabled />
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label">Email Address</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" value="<%=(acc.getEmail()+"").equals("null")?"":acc.getEmail()%>" disabled />
                            </div>
                        </div>
                    </form>

                    <div class="row d-flex justify-content-between px-5">
                        <a href="ProfileController?action=changePassword" class="btn btn-primary col-2">Change Password</a>
                        <a href="ProfileController?action=editProfile" class="btn btn-primary col-2">Edit Profile</a>
                        <a href="ProfileController?action=logout" class="btn btn-primary col-2">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <%
        } else {
        %>
        <p class="py-5" style="color: red">You do not have permission to access this content.</p>
        <%
            }
        %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
    <%@include file="footer.jsp" %>
</html>
