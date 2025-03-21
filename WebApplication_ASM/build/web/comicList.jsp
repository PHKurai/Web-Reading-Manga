<%-- 
    Document   : comicList
    Created on : Feb 28, 2025, 9:15:47 PM
    Author     : phucl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${empty searchTerm and empty categoryId and empty rankingType and empty history and empty follow}">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <%@include file="incorrectContent.jsp" %>
    </c:if>


    <c:if test="${not empty searchTerm or not empty categoryId or not empty rankingType or not empty history or not empty follow}">
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

                    <c:if test="${empty account and not (empty history and empty follow)}">
                        <div class="container mb-4">
                            <p>You must login to use this content!</p>
                        </div>
                    </c:if>

                    <c:if test="${totalPages eq 0 and (empty comics or not empty account)}">
                        <div class="container mb-4">
                            <h3 class="mt-4 mb-4">${title}</h3>
                            <p>No one comic match.</p>
                        </div>
                    </c:if>

                    <c:if test="${totalPages gt 0 and not empty comics}">
                        <div class="container mb-4">
                            <h3 class="mt-4 mb-4">${title}</h3>
                            <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                                <c:forEach var="comic" items="${comics}" >
                                    <div class="col">
                                        <div class="card comic-card">
                                            <img src="${comic.coverImage}" class="card-img-top w-100" alt="${comic.coverImage}" style="height: 250px;">
                                            <div class="card-body d-flex flex-column" style="height: 150px;">
                                                <h5 class="card-title flex-grow-0"><a href="ReadComicController?comicId=${comic.id}" class="nav-link" >${comic.title}</a></h5>
                                                <p class="card-text flex-grow-1" style="max-height: 100px; overflow-y: auto;">${comic.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <%            int pageIndex = (int) request.getAttribute("pageIndex");
                            int totalPages = (int) request.getAttribute("totalPages");
                        %>
                        <nav>
                            <c:if test="${not empty searchTerm and empty categoryId and empty rankingType and empty history and empty follow}">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?searchTerm=${searchTerm}&target=1&totalPages=${totalPages}" tabindex="-1">Tới trang đầu</a>
                                    </li>

                                    <%
                                        for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                            if (i > 0 && i <= totalPages) {
                                    %>
                                    <li class="page-item <%=(pageIndex == i) ? "active" : ""%>"><a class="page-link" href="PageChangeController?searchTerm=${searchTerm}&target=<%=i%>&totalPages=${totalPages}"><%=i%></a></li>
                                        <%
                                                }
                                            }
                                        %>
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?searchTerm=${searchTerm}&target=${totalPages}&totalPages=${totalPages}">Tới trang cuối</a>
                                    </li>
                                </ul>
                            </c:if>

                            <c:if test="${not empty categoryId and empty searchTerm and empty rankingType and empty history and empty follow}">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?categoryId=${categoryId}&target=1&totalPages=${totalPages}" tabindex="-1">Tới trang đầu</a>
                                    </li>

                                    <%
                                        for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                            if (i > 0 && i <= totalPages) {
                                    %>
                                    <li class="page-item <%=(pageIndex == i) ? "active" : ""%>"><a class="page-link" href="PageChangeController?categoryId=${categoryId}&target=<%=i%>&totalPages=${totalPages}"><%=i%></a></li>
                                        <%
                                                }
                                            }
                                        %>
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?categoryId=${categoryId}&target=${totalPages}&totalPages=${totalPages}">Tới trang cuối</a>
                                    </li>
                                </ul>
                            </c:if>

                            <c:if test="${not empty rankingType and empty searchTerm and empty categoryId and empty history and empty follow}">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?rankingType=${rankingType}&target=1&totalPages=${totalPages}" tabindex="-1">Tới trang đầu</a>
                                    </li>

                                    <%
                                        for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                            if (i > 0 && i <= totalPages) {
                                    %>
                                    <li class="page-item <%=(pageIndex == i) ? "active" : ""%>"><a class="page-link" href="PageChangeController?rankingType=${rankingType}&target=<%=i%>&totalPages=${totalPages}"><%=i%></a></li>
                                        <%
                                                }
                                            }
                                        %>
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?rankingType=${rankingType}&target=${totalPages}&totalPages=${totalPages}">Tới trang cuối</a>
                                    </li>
                                </ul>
                            </c:if>

                            <c:if test="${not empty history and empty rankingType and empty searchTerm and empty categoryId and empty follow}">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?history=${history}&target=1&totalPages=${totalPages}" tabindex="-1">Tới trang đầu</a>
                                    </li>

                                    <%
                                        for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                            if (i > 0 && i <= totalPages) {
                                    %>
                                    <li class="page-item <%=(pageIndex == i) ? "active" : ""%>"><a class="page-link" href="PageChangeController?history=${history}&target=<%=i%>&totalPages=${totalPages}"><%=i%></a></li>
                                        <%
                                                }
                                            }
                                        %>
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?history=${history}&target=${totalPages}&totalPages=${totalPages}">Tới trang cuối</a>
                                    </li>
                                </ul>
                            </c:if>

                            <c:if test="${not empty follow and empty history and empty rankingType and empty searchTerm and empty categoryId}">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?follow=${follow}&target=1&totalPages=${totalPages}" tabindex="-1">Tới trang đầu</a>
                                    </li>

                                    <%
                                        for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                            if (i > 0 && i <= totalPages) {
                                    %>
                                    <li class="page-item <%=(pageIndex == i) ? "active" : ""%>"><a class="page-link" href="PageChangeController?follow=${follow}&target=<%=i%>&totalPages=${totalPages}"><%=i%></a></li>
                                        <%
                                                }
                                            }
                                        %>
                                    <li class="page-item">
                                        <a class="page-link" href="PageChangeController?follow=${follow}&target=${totalPages}&totalPages=${totalPages}">Tới trang cuối</a>
                                    </li>
                                </ul>
                            </c:if>
                        </nav>
                    </c:if>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                </c:if>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>

</html>
