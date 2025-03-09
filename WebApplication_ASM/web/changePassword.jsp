<%-- 
    Document   : changePassword
    Created on : Mar 2, 2025, 11:00:36 PM
    Author     : phucl
--%>

<%@page import="dto.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${not empty sessionScope.account}">
            <div class="container py-5">
                <h2 class="mb-4">Change Password</h2>
                <div class="card">
                    <div class="card-body">

                        <form action="ProfileController" method="post" class="mb-4">
                            <input type="hidden" name="action" value="doChangePassword" />
                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">Your Password</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="oldPassword" placeholder="********"
                                           value="<c:if test="${not empty requestScope.oldPassword}">${requestScope.oldPassword}</c:if>"/>
                                </div>
                            </div>
                            <c:if test="${not empty requestScope.msgOldPasswordError}">
                                <p class="text-end text-danger">${requestScope.msgOldPasswordError}</p>
                            </c:if>

                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">New Password</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="newPassword" placeholder="********"
                                           value="<c:if test="${not empty requestScope.newPassword}">${requestScope.newPassword}</c:if>"/>
                                </div>
                            </div>
                            <c:if test="${not empty requestScope.msgNewPwError}">
                                <p class="text-end text-danger">${requestScope.msgNewPwError}</p>
                            </c:if>

                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">Confirm Password</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" name="confirmPassword" placeholder="********"
                                           value="<c:if test="${not empty requestScope.confirmPassword}">${requestScope.confirmPassword}</c:if>"/>
                                </div>
                            </div>
                            <c:if test="${not empty requestScope.msgConfirmPwError}">
                                <p class="text-end text-danger">${requestScope.msgConfirmPwError}</p>
                            </c:if>

                            <div class="row justify-content-evenly">
                                <a href="ProfileController?action=infor" class="btn btn-secondary col-2">Cancel</a>
                                <button type="submit" class="btn btn-primary col-2">Save</button>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${empty sessionScope.account}">
            <p class="py-5" style="color: red">You do not have permission to access this content.</p>
        </c:if>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
    <%@include file="footer.jsp" %>
</html>
