<%-- 
    Document   : changePassword
    Created on : Mar 2, 2025, 11:00:36 PM
    Author     : phucl
--%>

<%@page import="dto.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <%@include file="nav.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đổi mật khẩu</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%            if (session.getAttribute("account") != null) {
                AccountDTO acc = (AccountDTO) session.getAttribute("account");
        %>
        <div class="container py-5">
            <h2 class="mb-4">Change Password</h2>
            <div class="card">
                <div class="card-body">

                    <form action="ProfileController" method="post" class="mb-4">
                        <input type="hidden" name="action" value="doChangePassword" />
                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label">Your Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="oldPassword" placeholder="********" />
                            </div>
                        </div>
                        <p class="text-end" style="color: red"><%=request.getAttribute("oldPasswordError") == null ? "" : request.getAttribute("oldPasswordError")%></p>

                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label">New Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="newPassword" placeholder="********" />
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-3 col-form-label">Confirm Password</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" name="confirmPassword" placeholder="********" />
                            </div>
                        </div>
                        <p class="text-end" style="color: red"><%=request.getAttribute("confirmPasswordError") == null ? "" : request.getAttribute("confirmPasswordError")%></p>


                        <div class="row justify-content-evenly">
                            <a href="ProfileController?action=infor" class="btn btn-secondary col-2">Cancel</a>
                            <button type="submit" class="btn btn-primary col-2">Save</button>
                        </div>

                    </form>

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
