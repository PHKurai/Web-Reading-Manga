<%-- 
    Document   : read
    Created on : Mar 1, 2025, 12:07:29 AM
    Author     : phucl
--%>

<%@page import="utils.TimeUtils"%>
<%@page import="dao.AccountDAO"%>
<%@page import="dto.CommentDTO"%>
<%@page import="utils.AuthUtil"%>
<%@page import="dto.ComicDTO"%>
<%@page import="dao.HistoryDAO"%>
<%@page import="dto.HistoryDTO"%>
<%@page import="dto.ChapterDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <c:if test="${empty comic or empty chapter}">
        <%@include file="incorrectContent.jsp" %>
    </c:if>

    <c:if test="${not empty comic and not empty chapter}">
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
            <title>${comic.title} - ${chapter.title}<c:if test="${empty chapter.title}">Chapter ${chapter.chapterNumber}</c:if></title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                <link rel="stylesheet" href="assets/styles/readChapter.css">
            </head>
            <body>
            <%@include file="header.jsp" %>
            <%@include file="nav.jsp" %>
            <div style="position: relative; min-height: 100vh;">
                <div style="padding-bottom: 10rem;">
                    <div class="container my-4">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="mb-0"><a href="ReadComicController?comicId=${comic.id}">${comic.title}</a> - ${chapter.title}<c:if test="${empty chapter.title}">Chapter ${chapter.chapterNumber}</c:if></h4>
                                <div>
                                <%                        ChapterDTO curChapter = (ChapterDTO) request.getAttribute("chapter");
                                    List<ChapterDTO> chapters = (List<ChapterDTO>) request.getAttribute("chapters");
                                    if (!chapters.get(chapters.size() - 1).equals(curChapter)) {
                                %>
                                <a href="ReadChapterController?chapterId=${preChapter.id}" class="btn btn-outline-secondary me-2">Chap Trước</a>
                                <%
                                    }
                                    if (!chapters.get(0).equals(curChapter)) {
                                %>
                                <a href="ReadChapterController?chapterId=${nextChapter.id}" class="btn btn-outline-secondary">Chap Sau</a>
                                <%
                                    }
                                %>

                            </div>
                        </div>

                        <hr />

                        <div class="mb-5">
                            <c:forEach var="page" items="${pages}">
                                <img
                                    src="${page.imageText}"
                                    alt="Page ${page.pageNumber}"
                                    class="img-fluid d-block mx-auto"
                                    />
                            </c:forEach>
                        </div>

                        <div class="d-flex justify-content-between my-3">

                        </div>
                    </div>

                    <div class="container mt-5 pb-5">
                        <hr>
                        <h5 class="mb-3 text-muted">
                            Comments
                        </h5>


                        <c:if test="${not empty account}">
                            <form action="ReadChapterController" method="post" class="mb-3">
                                <input type="hidden" name="chapterId" value="${chapter.id}"/>
                                <input type="hidden" name="action" value="postComment"/>
                                <textarea name="comment" class="form-control mb-2" placeholder="Write comments here" rows="3" style="resize: none" required="true"></textarea>

                                <div class="text-end">
                                    <button class="btn btn-primary mb-4" type="submit">Send</button>
                                </div>

                            </form>
                        </c:if>
                        <c:if test="${empty account}">
                            <textarea class="form-control mb-2" placeholder="You need login to use this content" rows="3" disabled="true" style="resize: none"></textarea>
                            <div class="text-end">
                                <button class="btn btn-primary mb-4" disabled="true">Send</button>
                            </div>

                        </c:if>

                        <%
                            List<CommentDTO> comments = (List<CommentDTO>) request.getAttribute("comments");

                            for (CommentDTO comment : comments) {
                                AccountDAO aDAO = new AccountDAO();
                                AccountDTO acc = aDAO.readById(comment.getUserId());

                                if (request.getAttribute("commentEditId") != null) {
                                    int commentEditId = (int) request.getAttribute("commentEditId");
                                    if (comment.getId() == commentEditId && acc.equals(aDAO.readById(comment.getUserId()))) {
                        %>

                        <form action="ReadChapterController" method="get" class="mb-3">
                            <input type="hidden" name="chapterId" value="${chapter.id}"/>
                            <input type="hidden" name="action" value="updateComment"/>
                            <input type="hidden" name="commentUpdateId" value="<%=commentEditId%>"/>
                            <input type="hidden" name="commentPageTarget" value="${commentPageTarget}"/>
                            <textarea name="commentUpdateContent" class="form-control mb-2" placeholder="Write comments here" rows="3" style="resize: none" required="true">${commentContentEdit}</textarea>

                            <div class="text-end">
                                <button class="btn btn-primary mb-4" type="submit">Update</button>
                            </div>
                        </form>

                        <%
                        } else {
                        %>
                        <div class="card p-3 mb-3">
                            <div class="d-flex justify-content-between mb-2">
                                <div class="d-flex align-items-center">
                                    <img
                                        src="<%=acc.getAvatar()%>"
                                        alt="avatar"
                                        class="rounded-circle me-2"
                                        style="width: 40px; height: 40px;"
                                        >
                                    <div>
                                        <span><strong><%=acc.getName()%></strong></span>
                                    </div>
                                </div>

                                <div>
                                    <c:if test="${not empty account}">
                                        <%
                                            AccountDTO account = AuthUtil.getAccount(session);
                                            if (acc.equals(account)) {
                                        %>
                                        <a href="ReadChapterController?chapterId=${chapter.id}&action=editComment&commentEditId=<%=comment.getId()%>&commentPageTarget=${commentPageTarget}">Edit</a>
                                        <%
                                            }
                                        %>
                                    </c:if>
                                </div>

                            </div>

                            <div>
                                <span class="me-2"><%=comment.getContent()%></span>
                            </div>

                            <div class="mt-2">
                                <small class="text-muted"><%=TimeUtils.timeAgo(comment.getCreatedAt())%></small>
                            </div>
                        </div>
                        <%
                            }
                        } else {
                        %>
                        <div class="card p-3 mb-3">
                            <div class="d-flex justify-content-between mb-2">
                                <div class="d-flex align-items-center">
                                    <img
                                        src="<%=acc.getAvatar() == null ? "assets/images/avatarDefault.jpg" : acc.getAvatar()%>"
                                        alt="avatar"
                                        class="rounded-circle me-2"
                                        style="width: 40px; height: 40px;"
                                        >
                                    <div>
                                        <span><strong><%=acc.getName()%></strong></span>
                                    </div>
                                </div>

                                <div>
                                    <c:if test="${not empty account}">
                                        <%
                                            AccountDTO account = AuthUtil.getAccount(session);
                                            if (acc.equals(account)) {
                                        %>
                                        <a href="ReadChapterController?chapterId=${chapter.id}&action=editComment&commentEditId=<%=comment.getId()%>&commentPageTarget=${commentPageTarget}">Edit</a>
                                        <%
                                            }
                                        %>
                                    </c:if>
                                </div>

                            </div>

                            <div>
                                <span class="me-2"><%=comment.getContent()%></span>
                            </div>

                            <div class="mt-2">
                                <small class="text-muted"><%=TimeUtils.timeAgo(comment.getCreatedAt())%></small>
                            </div>
                        </div>
                        <%
                            }
                        %>

                        <%
                            }
                        %>

                        <c:if test="${haveMoreComments}">
                            <form class="text-center text-muted" method="get" action="ReadChapterController">
                                <input type="hidden" name="chapterId" value="${chapter.id}"/>
                                <input type="hidden" name="action" value="moreComments"/>
                                <input type="hidden" name="commentPageTarget" value="${commentPageTarget+1}"/>

                                <button type="submit" class="btn btn-outline-primary text-decoration-none">Read more comments</a>
                            </form>
                        </c:if>

                    </div>

                    <nav id="scrollNav" class="bg-light shadow p-2 d-flex justify-content-center align-items-center">
                        <c:if test="${not empty account}">
                            <a href="ReportController?chapterId=${chapter.id}" class="btn btn-outline-danger me-2">Report</a>
                        </c:if>

                        <%
                            if (!chapters.get(chapters.size() - 1).equals(curChapter)) {
                        %>
                        <a href="ReadChapterController?chapterId=${preChapter.id}" class="btn btn-outline-secondary me-2">Prev Chapter</a>
                        <%
                            }
                        %>

                        <button class="btn btn-outline-primary me-2" id="navChooseChapter" data-bs-toggle="modal" data-bs-target="#chapterModal">
                            Chapters
                        </button>

                        <%
                            if (!chapters.get(0).equals(curChapter)) {
                        %>
                        <a href="ReadChapterController?chapterId=${nextChapter.id}" class="btn btn-outline-secondary">Next Chapter</a>
                        <%
                            }
                        %>

                        <c:if test="${not empty account}">
                            <c:if test="${isFollowing}">
                                <a href="ReadChapterController?chapterId=${chapter.id}&action=unfollow" class="btn btn-outline-warning ms-2 me-2">Unfollow</a>
                            </c:if>

                            <c:if test="${not isFollowing}">
                                <a href="ReadChapterController?chapterId=${chapter.id}&action=follow" class="btn btn-outline-success ms-2 me-2">Follow</a>
                            </c:if>

                        </c:if>
                    </nav>

                    <div class="modal fade" id="chapterModal" tabindex="-1" data-bs-backdrop="false">
                        <div class="modal-dialog modal-dialog-scrollable">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="chapterModalLabel">Select a Chapter</h5>
                                    <button class="btn-close" data-bs-dismiss="modal"></button>
                                </div>
                                <div class="modal-body">

                                    <ul class="list-group">
                                        <c:forEach var="chapter" items="${chapters}">
                                            <li class="list-group-item">
                                                <a href="ReadChapterController?chapterId=${chapter.id}" class="text-decoration-none">${chapter.title}<c:if test="${empty chapter.title}">Chapter ${chapter.chapterNumber}</c:if></a>
                                                </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="modal-footer">
                                    <button 
                                        type="button" 
                                        class="btn btn-secondary" 
                                        data-bs-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                    <script src="assets/scripts/chapterScroll.js"></script>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </body>

    </c:if>

</html>
