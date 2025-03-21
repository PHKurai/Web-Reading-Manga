<%-- 
    Document   : userInfor
    Created on : Mar 2, 2025, 9:32:40 PM
    Author     : phucl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <c:if test="${empty sessionScope.account}">
        <%@include file="incorrectContent.jsp" %>
    </c:if>

    <c:if test="${not empty sessionScope.account}">
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>User Information</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </head>
        <body>

            <div class="container py-5">
                <h2 class="mb-4">User Information</h2>
                <div class="card">
                    <div class="card-body">
                        <form id="mb-4" action="ProfileController" method="post">
                            <div class="text-center mb-4">
                                <img src="${account.avatar}<c:if test="${empty account.avatar}">assets/images/avatarDefault.jpg</c:if>" alt="User Avatar" id="avatarReview" class="rounded-circle mb-2 w-25" />

                                <c:if test="${requestScope.isChange}">
                                    <input type="hidden" id="txtAvatar" name="avatar" value="${sessionScope.account.avatar}">

                                    <div class="mb-3">
                                        <button type="button" class="btn btn-outline-primary col-2" id="chooseAvatarBtn">Choose New Avatar</button>
                                        <input type="file" id="avatarUpload" class="form-control" accept="image/*" style="display: none;">
                                    </div>
                                </c:if>

                                <h5 class="mb-0">${sessionScope.account.name}</h5>
                            </div>


                            <input type="hidden" name="action" value="updateProfile" />
                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="name"
                                           value="<c:if test="${not empty requestScope.name}">${requestScope.name}</c:if><c:if test="${empty requestScope.name}">${sessionScope.account.name}</c:if>"
                                           ${requestScope.isChange?"":"disabled"} />
                                </div>
                                <c:if test="${not empty requestScope.msgNameError}">
                                    <span class="text-danger"> ${requestScope.msgNameError} </span>
                                </c:if>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-3 col-form-label">Email Address</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" name="email"
                                           value="<c:if test="${not empty requestScope.email}">${requestScope.email}</c:if><c:if test="${empty requestScope.email}">${sessionScope.account.email}</c:if>"
                                           ${requestScope.isChange?"":"disabled"} />
                                </div>
                                <c:if test="${not empty requestScope.msgEmailError}">
                                    <span class="text-danger"> ${requestScope.msgEmailError} </span>
                                </c:if>
                            </div>

                            <div class="row col-mb-6 d-flex justify-content-evenly px-5">
                                <c:if test="${not requestScope.isChange}">
                                    <a href="ProfileController?action=changePassword" class="btn btn-primary col-2">Change Password</a>
                                    <a href="ProfileController?action=editProfile" class="btn btn-primary col-2">Edit Profile</a>
                                    <a href="ProfileController?action=logout" class="btn btn-primary col-2">Logout</a>
                                </c:if>
                                <c:if test="${requestScope.isChange}">
                                    <a href="ProfileController?action=infor" class="btn btn-primary col-2">Back</a>
                                    <button type="submit" class="btn btn-primary col-2">Save</button>
                                </c:if>
                            </div>
                        </form>


                    </div>
                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

            <script>
                $(document).ready(function () {
                    // Trigger file input when the "Choose New Avatar" button is clicked
                    $('#chooseAvatarBtn').click(function () {
                        $('#avatarUpload').click();
                    });
                    // When a new file is selected
                    $('#avatarUpload').change(function () {
                        var file = this.files[0];
                        if (file) {
                            if (!file.type.match('image.*')) {
                                alert('Please select a valid image file.');
                                this.value = '';
                                $('#avatarFileInfo').text('No file selected');
                                return;
                            }
                            var fileSize = (file.size / 1024).toFixed(2) + ' KB';
                            $('#avatarFileInfo').text(file.name + ' (' + fileSize + ')');

                            var reader = new FileReader();
                            reader.onload = function (e) {
                                var base64String = e.target.result;
                                $('#txtAvatar').val(base64String);
                                $('#avatarReview').attr('src', base64String);
                            };
                            reader.readAsDataURL(file);
                        } else {
                            $('#avatarFileInfo').text('No file selected');
                        }
                    });
                });
            </script>

        </body>
        <%@include file="footer.jsp" %>
    </c:if>
</html>
