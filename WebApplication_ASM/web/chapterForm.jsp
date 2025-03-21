<%-- 
    Document   : chapterForm
    Created on : Mar 19, 2025, 12:49:44 AM
    Author     : Admin PC
--%>

<%@page import="utils.AuthUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <meta charset="UTF-8">
        <title><c:choose>
                <c:when test="${action eq 'updateChapter'}">Update Chapter</c:when>
                <c:otherwise>Add New Chapter</c:otherwise>
            </c:choose></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <style>
            .page-block {
                margin-bottom: 15px;
            }
            .page-block .card-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .remove-page {
                cursor: pointer;
                color: #dc3545;
                font-size: 1.5rem;
                line-height: 1;
            }
            .image-preview img {
                max-width: 100%;
                max-height: 200px;
                border: 1px solid #ddd;
                border-radius: 4px;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div style="position: relative; min-height: 100vh;">
            <div style="padding-bottom: 10rem;">
                <div class="container my-5">
                    <div class="card">
                        <div class="card-header">
                            <h3>
                                <c:choose>
                                    <c:when test="${action eq 'updateChapter'}">Update Chapter</c:when>
                                    <c:otherwise>Add New Chapter</c:otherwise>
                                </c:choose>
                            </h3>
                        </div>
                        <div class="card-body">

                            <c:if test="${not empty errorPages}">
                                <div class="alert alert-danger" role="alert">
                                    ${errorPages}
                                </div>
                            </c:if>
                            <form action="ChapterController" method="post">
                                <!-- Hidden fields -->
                                <input type="hidden" name="action" value="${action}" />
                                <input type="hidden" name="comicId" value="${comic.id}" />
                                <c:if test="${action eq 'updateChapter' and not empty chapter.id}">
                                    <input type="hidden" name="chapterId" value="${chapter.id}" />
                                </c:if>

                                <div class="mb-3">
                                    <label for="chapterNumber" class="form-label">Chapter Number</label>
                                    <input type="number" class="form-control" id="chapterNumber" name="chapterNumber" value="${chapter.chapterNumber}${chaptersCount}" required <c:if test="${isDone}">disabled="disabled"</c:if>>
                                    </div>

                                    <div class="mb-3">
                                        <label for="chapterTitle" class="form-label">Chapter Title</label>
                                        <input type="text" class="form-control" id="chapterTitle" name="chapterTitle" value="${chapter.title}" placeholder="Enter chapter title" required <c:if test="${isDone}">disabled="disabled"</c:if>>
                                    </div>

                                    <div class="mb-3">
                                        <label for="chapterActive" class="form-label">Active</label>
                                        <select class="form-select" id="chapterActive" name="chapterActive" required <c:if test="${isDone}">disabled="disabled"</c:if>>
                                        <option value="true" ${chapter.isActive eq true ? 'selected' : ''}>True</option>
                                        <option value="false" ${chapter.isActive eq false ? 'selected' : ''}>False</option>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Pages</label>
                                    <div id="pagesContainer">
                                        <c:if test="${not empty pageDataList}">
                                            <c:forEach var="page" items="${pageDataList}" varStatus="status">
                                                <div class="card page-block" data-page-number="${status.index + 1}">
                                                    <div class="card-header d-flex justify-content-between align-items-center">
                                                        <span>Page <span class="page-number-display">${status.index + 1}</span></span>
                                                            <c:if test="${not isDone}">
                                                            <button type="button" class="btn-close remove-page" aria-label="Remove"></button>
                                                        </c:if>

                                                    </div>
                                                    <div class="card-body">
                                                        <input type="hidden" name="pageNumber" class="page-number" value="${status.index + 1}" />
                                                        <input type="hidden" name="pageData" class="page-data" value="${page}" />
                                                        <div class="upload-container">
                                                            <button type="button" class="btn btn-outline-primary choosePageBtn" <c:if test="${isDone}">disabled="disabled"</c:if>>Choose Page Image</button>
                                                                <input type="file" class="form-control pageUpload" accept="image/*" style="display: none;">
                                                                <div class="file-info mt-2">File loaded</div>
                                                            </div>
                                                            <div class="image-preview mt-2">
                                                                <img src="${page}" alt="Page Preview" class="img-fluid" onerror="this.src='assets/images/placeholder.png';">
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </div>
                                    <button type="button" class="btn btn-outline-secondary" id="addPageBtn" <c:if test="${isDone}">disabled="disabled"</c:if>>Add Page</button>
                                    </div>

                                <c:if test="${not isDone}">
                                    <div class="text-end">
                                        <button type="submit" class="btn btn-primary">
                                            <c:choose>
                                                <c:when test="${action eq 'updateChapter'}">Update Chapter</c:when>
                                                <c:otherwise>Add Chapter</c:otherwise>
                                            </c:choose>
                                        </button>
                                    </div>
                                </c:if>

                                <c:if test="${isDone}">
                                    <div class="d-flex justify-content-between">
                                        <a href="home.jsp" class="btn btn-primary">Return Home</a>
                                        <a href="ChapterController?action=editChapter&comicId=${comic.id}&chapterId=${chapter.id}" class="btn btn-primary">Edit Chapter</a>
                                        <a href="ReadChapterController?chapterId=${chapter.id}" class="btn btn-primary">View Chapter</a>
                                    </div>
                                </c:if>

                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <%@include file="footer.jsp" %>
        </div>

        <script>
            $(document).ready(function () {
                var pageCount = 0;

            <c:if test="${not empty pageDataList}">
                pageCount = ${fn:length(pageDataList)};
            </c:if>

                function addPageBlock() {
                    pageCount++;
                    var pageBlock =
                            '<div class="card page-block" data-page-number="' + pageCount + '">' +
                            '<div class="card-header d-flex justify-content-between align-items-center">' +
                            '<span>Page <span class="page-number-display">' + pageCount + '</span></span>' +
                            '<button type="button" class="btn-close remove-page" aria-label="Remove"></button>' +
                            '</div>' +
                            '<div class="card-body">' +
                            '<input type="hidden" name="pageNumber" class="page-number" value="' + pageCount + '" />' +
                            '<input type="hidden" name="pageData" class="page-data" value="" />' +
                            '<div class="upload-container">' +
                            '<button type="button" class="btn btn-outline-primary choosePageBtn">Choose Page Image</button>' +
                            '<input type="file" class="form-control pageUpload" accept="image/*" style="display: none;" />' +
                            '<div class="file-info mt-2">No file selected</div>' +
                            '</div>' +
                            '<div class="image-preview mt-2"></div>' +
                            '</div>' +
                            '</div>';
                    $('#pagesContainer').append(pageBlock);
                }


                $('#addPageBtn').click(function () {
                    addPageBlock();
                });

                $('#pagesContainer').on('click', '.choosePageBtn', function () {
                    $(this).siblings('.pageUpload').click();
                });

                $('#pagesContainer').on('change', '.pageUpload', function () {
                    var file = this.files[0];
                    var pageBlock = $(this).closest('.page-block');
                    var fileInfo = pageBlock.find('.file-info');
                    var preview = pageBlock.find('.image-preview');
                    var hiddenInput = pageBlock.find('.page-data');

                    if (file) {
                        if (!file.type.match('image.*')) {
                            alert('Please select a valid image file.');
                            this.value = '';
                            fileInfo.text('No file selected');
                            return;
                        }

                        var fileSize = (file.size / 1024).toFixed(2) + ' KB';
                        fileInfo.text(file.name + ' (' + fileSize + ')');

                        var reader = new FileReader();
                        reader.onload = function (e) {
                            var base64String = e.target.result;
                            hiddenInput.val(base64String);
                            preview.html('<img src="' + base64String + '" alt="Page Preview" class="img-fluid">');
                        };
                        reader.readAsDataURL(file);
                    } else {
                        fileInfo.text('No file selected');
                    }
                });

                $('#pagesContainer').on('click', '.remove-page', function () {
                    $(this).closest('.page-block').remove();
                });
            });
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    <%}%>
</html>
