<%-- 
    Document   : comicDetail
    Created on : Feb 28, 2025, 11:52:30 PM
    Author     : phucl
--%>

<%@page import="dto.ChapterDTO"%>
<%@page import="dto.HistoryDTO"%>
<%@page import="dao.HistoryDAO"%>
<%@page import="dto.ComicDTO"%>
<%@page import="utils.AuthUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <c:if test="${empty comic}">
        <%@include file="incorrectContent.jsp" %>
    </c:if>

    <c:if test="${not empty comic}">

        <%
            if (AuthUtil.isLogin(session)) {
                AccountDTO acc = AuthUtil.getAccount(session);
                ComicDTO comic = (ComicDTO) request.getAttribute("comic");

                HistoryDAO historyDAO = new HistoryDAO();
                historyDAO.changeHistory(new HistoryDTO(acc.getUsername(), comic.getId()));
            }
        %>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>${title}</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        </head>
        <body>
            <%@include file="header.jsp" %>
            <%@include file="nav.jsp" %>
            <div style="position: relative; min-height: 100vh;">
                <div style="padding-bottom: 10rem;">
                    <div class="container text-dark my-4">
                        <div class="row">

                            <div class="col-md-3 mb-3">
                                <img src="${comic.coverImage}" alt="${comic.title}" class="img-fluid rounded"/>
                            </div>

                            <div class="col-md-9">
                                <div class="d-flex justify-content-between">
                                    <h2 class="fw-bold">${comic.title}</h2>
                                    <%if (AuthUtil.isAdmin(session)) {%>
                                    <a class="btn btn-outline-primary" href="ComicController?action=editComic&comicId=${comic.id}">Edit Comic</a>
                                    <%}%>
                                </div>

                                <p><strong>Author:</strong> ${comic.author}</p>
                                <p><strong>Status:</strong> ${comic.status}</p>
                                <p>
                                    <strong>Likes:</strong> ${comic.likes} &nbsp; | &nbsp;
                                    <strong>Follows:</strong> ${comic.favorites} &nbsp; | &nbsp;
                                    <strong>Views:</strong> ${comic.views}
                                </p>
                                <p>
                                    <strong>Categories:</strong>
                                    <c:if test="${not empty categoriesOfComic}">
                                        <c:forEach var="category" items="${categoriesOfComic}">
                                            <a class="btn badge bg-info text-dark" href="CategoryController?categoryId=${category.id}">${category.name}</a>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${empty categoriesOfComic}">
                                        <span>Not have category</span>
                                    </c:if>
                                </p>

                                <c:if test="${not empty chapters}">
                                    <div class="mb-3">
                                        <%                                List<ChapterDTO> chapters = (List<ChapterDTO>) request.getAttribute("chapters");
                                            ChapterDTO firstChap = chapters.get(chapters.size() - 1);
                                        %>
                                        <a href="ReadChapterController?chapterId=<%=firstChap.getId()%>" class="btn btn-outline-primary me-2">Read at first</a>
                                        <c:if test="${not empty account}">
                                            <c:if test="${isFollowing}">
                                                <a href="ReadComicController?comicId=${comic.id}&action=unfollow" class="btn btn-outline-warning me-2">Unfollow</a>
                                            </c:if>
                                            <c:if test="${not isFollowing}">
                                                <a href="ReadComicController?comicId=${comic.id}&action=follow" class="btn btn-outline-success me-2">Follow</a>
                                            </c:if>

                                            <c:if test="${isLiked}">
                                                <a href="ReadComicController?comicId=${comic.id}&action=unlike" class="btn btn-outline-warning me-2">Unlike</a>
                                            </c:if>
                                            <c:if test="${not isLiked}">
                                                <a href="ReadComicController?comicId=${comic.id}&action=like" class="btn btn-outline-danger me-2">Like</a>
                                            </c:if>
                                        </c:if>
                                    </div>
                                </c:if>
                                <div class="mb-3">
                                    <h5 class="fw-bold">Description</h5>
                                    <p>
                                        ${comic.description}
                                    </p>
                                </div>
                            </div>

                            <c:if test="${not empty chapters}">
                                <hr class="my-4" />
                                <div class="d-flex d-flex justify-content-between">
                                    <h4 class="fw-bold">Chapters</h4>
                                    <%if (AuthUtil.isAdmin(session)) {%>
                                    <a class="btn btn-outline-primary" href="ChapterController?action=addChapter&comicId=${comic.id}">Add Chapter</a>
                                    <%}%>
                                </div>

                                <div class="input-group mb-3 mt-3">
                                    <form class="d-flex w-100" action="ReadComicController" method="get">
                                        <input name="comicId" value="${comic.id}" type="hidden"/>
                                        <input name="searchChapter" type="text" class="form-control" placeholder="Search Chapter" value="${searchChapter}" />
                                        <button class="btn btn-secondary" type="submit">Search</button>
                                    </form>
                                </div>

                                <div class="table-responsive" style="max-height: 600px; overflow-y: auto;">
                                    <table class="table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Chapter</th>
                                                <th>Name</th>
                                                <th>Date Add</th>
                                                    <%if (AuthUtil.isAdmin(session)) {%>
                                                <th>Edit Chapter</th>
                                                    <%}%>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="chapter" items="${chapters}">
                                                <tr>
                                                    <td>${chapter.chapterNumber}</td>
                                                    <td><a href="ReadChapterController?chapterId=${chapter.id}">${chapter.title}<c:if test="${empty chapter.title}">Chapter ${chapter.chapterNumber}</c:if></a></td>
                                                    <td>${chapter.createdDate}</td>
                                                    <%if (AuthUtil.isAdmin(session)) {%>
                                                    <td><a class="btn btn-outline-primary" href="ChapterController?action=editChapter&comicId=${comic.id}&chapterId=${chapter.id}">Edit Chapter</a></td>
                                                    <%}%>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                            </c:if>

                            <c:if test="${empty chapters}">
                                <p>Not have chapter</p>
                                <%if (AuthUtil.isAdmin(session)) {%>
                                <a class="btn btn-outline-primary" href="ChapterController?action=addChapter&comicId=${comic.id}">Add Chapter</a>
                                <%}%>
                            </c:if>

                        </div>

                    </div>

                </div>
                <%@include file="footer.jsp" %>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        </body>

    </c:if>

</html>
