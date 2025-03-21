<%-- 
    Document   : nav
    Created on : Feb 19, 2025, 10:10:47 PM
    Author     : phucl
--%>

<%@page import="utils.AuthUtil"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbars">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbars">
            <ul class="container d-flex align-items-center justify-content-evenly navbar-nav mb-0">

                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="typeDropdown" role="button" data-bs-toggle="dropdown">
                        Categories
                    </a>
                    <%
                        CategoryDAO categoryDAO = new CategoryDAO();
                        List<CategoryDTO> categories = categoryDAO.readAll();
                    %>
                    <ul class="dropdown-menu">
                        <%
                            for (CategoryDTO category : categories) {
                        %>
                        <li><a class="dropdown-item" href="CategoryController?categoryId=<%=category.getId()%>"><%=category.getName()%></a></li>
                            <%
                                }
                            %>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="rankingDropdown" role="button" data-bs-toggle="dropdown">
                        Ranking
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="RankingController?rankingType=LatestUpdate">Latest Update</a></li>
                        <li><a class="dropdown-item" href="RankingController?rankingType=MostViews">Most Views</a></li>
                        <li><a class="dropdown-item" href="RankingController?rankingType=MostFavorites">Most Favorites</a></li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="HistoryController">History</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="FollowController">Followed</a>
                </li>

                <%
                    if (AuthUtil.isAdmin(session)) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="ComicController?action=addComic">Add Comic</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
