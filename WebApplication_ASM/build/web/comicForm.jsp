<%-- 
    Document   : comicForm
    Created on : Mar 17, 2025, 9:31:50 PM
    Author     : Admin PC
--%>

<%@page import="utils.AuthUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        if (!AuthUtil.isAdmin(session)) {
    %>
    <%@include file="incorrectContent.jsp" %>
    <%
    } else {
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/styles/comicForm.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="assets/scripts/comicForm.js"></script>
    </head>

    <body>
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div style="position: relative; min-height: 100vh;">
            <div style="padding-bottom: 10rem;">
                <div class="container my-5">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title mb-0">${action == 'update' ? 'Update Comic' : 'Add New Comic'}</h3>
                        </div>
                        <div class="card-body">
                            <form action="ComicController" method="post">
                                <input type="hidden" name="action" value="${action}" />
                                <c:if test="${action eq 'updateComic' and not empty comic.id}">
                                    <input type="hidden" name="comicId" value="${comic.id}" />
                                </c:if>

                                <div class="mb-3">
                                    <label for="comicTitle" class="form-label">Title</label>
                                    <input type="text" class="form-control" name="title" placeholder="Enter comic title" value="${comic.title}" required <c:if test="${isDone}">disabled="disabled"</c:if> />
                                    <span class="text-danger">${errorTitle}</span>
                                </div>

                                <div class="mb-3">
                                    <label for="comicAuthor" class="form-label">Author</label>
                                    <input type="text" class="form-control" name="author" placeholder="Enter author name" value="${comic.author}" required <c:if test="${isDone}">disabled="disabled"</c:if> />
                                    <span class="text-danger">${errorAuthor}</span>
                                </div>

                                <div class="mb-3">
                                    <label for="comicDescription" class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="4" placeholder="Enter comic description" style="resize: none" <c:if test="${isDone}">disabled="disabled"</c:if> >${comic.description}</textarea>
                                    <span class="text-danger">${errorDescription}</span>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Categories</label>
                                    <div id="categoryContainer">
                                        <c:if test="${not empty categories}">
                                            <c:forEach var="category" items="${categories}">
                                                <span class="btn btn-primary category-chip" id="categoryChip_${category.id}">
                                                    ${category.name}
                                                    <c:if test="${not isDone}"><span class="remove-category">&times;</span></c:if>
                                                    <input type="hidden" name="categories" value="${category.id}"/>
                                                </span>
                                            </c:forEach>
                                        </c:if>
                                    </div>

                                    <div class="dropdown">
                                        <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="categoryDropdownButton" data-bs-toggle="dropdown" <c:if test="${isDone}">disabled="disabled"</c:if> >
                                                Add Category
                                            </button>
                                            <ul class="dropdown-menu" id="categoryDropdown">
                                            <c:forEach var="category" items="${categoriesChoose}">
                                                <li><a class="dropdown-item" href="#" data-id="${category.id}">${category.name}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="comicCover" class="form-label">Cover Image</label>
                                    <input type="hidden" id="txtImage" name="coverImage" value="${comic.coverImage}" />

                                    <div class="upload-container">
                                        <div class="file-upload-wrapper">
                                            <button type="button" class="btn btn-outline-primary w-100" id="chooseImageBtn" <c:if test="${isDone}">disabled="disabled"</c:if> >Choose an Image</button>
                                                <input type="file" id="imageUpload" class="form-control" accept="image/*" style="display: none;" />
                                            </div>
                                            <div class="file-info mt-2" id="fileInfo"><c:if test="${not empty comic.coverImage}">${comic.title}</c:if><c:if test="${empty comic.coverImage}">No file selected</c:if></div>
                                        </div>

                                        <div class="image-preview" id="imagePreview">
                                        <c:if test="${not empty comic.coverImage}">
                                            <img src="${comic.coverImage}" alt="${comic.title} Cover">
                                        </c:if>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label for="comicStatus" class="form-label">Status</label>
                                    <select class="form-select" name="status" required <c:if test="${isDone}">disabled="disabled"</c:if> >
                                        <option value="ongoing" ${comic.status eq 'ongoing' ? 'selected' : ''}>Ongoing</option>
                                        <option value="completed" ${comic.status eq 'completed' ? 'selected' : ''}>Completed</option>
                                        <option value="hiatus" ${comic.status eq 'hiatus' ? 'selected' : ''}>Hiatus</option>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label for="comicActive" class="form-label">Active</label>
                                    <select class="form-select" name="active" required <c:if test="${isDone}">disabled="disabled"</c:if> >
                                        <option value="true" ${comic.active eq true ? 'selected' : ''}>True</option>
                                        <option value="false" ${comic.active eq false ? 'selected' : ''}>False</option>
                                    </select>
                                </div>

                                <c:if test="${not isDone}">
                                    <div class="text-end">
                                        <button type="submit" class="btn btn-primary" >${action == 'updateComic' ? 'Update Comic' : 'Add Comic'}</button>
                                    </div>
                                </c:if>

                                <c:if test="${isDone}">
                                    <div class="d-flex justify-content-between">
                                        <a href="home.jsp" class="btn btn-primary">Return Home</a>
                                        <a href="ComicController?action=editComic&comicId=${comic.id}" class="btn btn-primary">Edit Comic</a>
                                        <a href="ReadComicController?comicId=${comic.id}" class="btn btn-primary">View Comic</a>
                                    </div>
                                </c:if>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $('#categoryDropdown a').on('click', function (e) {
                    e.preventDefault();
                    var categoryId = $(this).data('id');
                    var categoryName = $(this).text();

                    if ($('#categoryChip_' + categoryId).length === 0) {
                        var chip = $(
                                '<span class="btn btn-primary category-chip" id="categoryChip_' + categoryId + '">' +
                                categoryName +
                                '<span class="remove-category">&times;</span>' +
                                '<input type="hidden" name="categories" value="' + categoryId + '"/>' +
                                '</span>'
                                );
                        $('#categoryContainer').append(chip);
                    }
                });

                $('#categoryContainer').on('click', '.remove-category', function () {
                    $(this).closest('.category-chip').remove();
                });
            });
        </script>

        <script src="assets/scripts/comicForm.js"></script>


    </body>

    <%        }
    %>

</html>
