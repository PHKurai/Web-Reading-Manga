<%-- 
    Document   : home
    Created on : Feb 19, 2025, 10:13:06 PM
    Author     : phucl
--%>

<%@page import="dao.ComicDAO"%>
<%@page import="dto.ComicDTO"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="dto.CategoryDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            .ellipsis {
                white-space: nowrap;
                overflow: hidden;
            }

            .ellipsis.multiline {
                white-space: normal;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="nav.jsp" %>
        <div style="position: relative; min-height: 100vh;">
            <div style="padding-bottom: 10rem;">
                <%            ComicDAO cDAO = new ComicDAO();
                    List<ComicDTO> mostestViewComics = cDAO.findByMostViews(1, 1);
                    ComicDTO mostestViewComic = mostestViewComics.get(0);

                    List<CategoryDTO> categoriesOfComic = categoryDAO.findByComicId(mostestViewComic.getId());
                %>
                <div class="popular-comic shadow-lg text-white p-4 mb-4 position-relative" 
                     style="background-image: url('<%=mostestViewComic.getCoverImage()%>'); background-size: cover; background-position: center;">

                    <div class="position-absolute top-0 start-0 w-100 h-100 bg-dark opacity-50"></div>

                    <div class="container position-relative">
                        <div class="row align-items-center">
                            <div class="col-md-4">
                                <img src="<%=mostestViewComic.getCoverImage()%>" alt="<%=mostestViewComic.getTitle()%>"
                                     class="img-fluid border border-white rounded shadow w-75">
                            </div>

                            <div class="col-md-8">
                                <div class="mt-3 mt-md-0">
                                    <h2 class="fs-2 mb-3"><%=mostestViewComic.getTitle()%></h2>

                                    <div class="mb-3">
                                        <%
                                            for (CategoryDTO category : categoriesOfComic) {
                                        %>
                                        <span class="badge bg-warning text-dark"><%=category.getName()%></span>
                                        <%
                                            }
                                        %>
                                    </div>

                                    <p class="mb-3">
                                        <%=mostestViewComic.getDescription()%>
                                    </p>

                                    <div class="fw-light fst-italic"><%=mostestViewComic.getAuthor()%></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="container">
                    <div class="d-flex justify-content-between"><h3>Top Read</h3> <a href="RankingController?rankingType=MostViews" class="arrow-link">→</a></div>
                    <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                        <%
                            List<ComicDTO> comics = cDAO.findByMostViews(1, 6);
                            for (ComicDTO comic : comics) {
                        %>
                        <div class="col">
                            <div class="card comic-card">
                                <img src="<%=comic.getCoverImage()%>" class="card-img-top w-100" alt="<%=comic.getTitle()%>" style="height: 250px;">
                                <div class="card-body d-flex flex-column" style="height: 150px;">
                                    <h5 class="card-title flex-grow-0"><a href="ReadComicController?comicId=<%=comic.getId()%>" class="nav-link" ><%=comic.getTitle()%></a></h5>
                                    <p class="card-text flex-grow-1" style="max-height: 100px; overflow-y: auto;"><%=comic.getDescription()%></p>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>

                    <div class="d-flex justify-content-between"><h3>Latest Update</h3> <a href="RankingController?rankingType=LatestUpdate" class="arrow-link">→</a></div>
                    <div class="row row-cols-3 row-cols-md-6 g-4 mb-4">
                        <%                    List<ComicDTO> latestUpdateComics = cDAO.findByLatestUpdate(1, 18);
                            for (ComicDTO comic : latestUpdateComics) {
                        %>
                        <div class="col">
                            <div class="card comic-card">
                                <img src="<%=comic.getCoverImage()%>" class="card-img-top w-100" alt="<%=comic.getTitle()%>" style="height: 250px;">
                                <div class="card-body d-flex flex-column" style="height: 150px;">
                                    <h5 class="card-title flex-grow-0"><a href="ReadComicController?comicId=<%=comic.getId()%>" class="nav-link" ><%=comic.getTitle()%></a></h5>
                                    <p class="card-text flex-grow-1" style="max-height: 100px; overflow-y: auto;"><%=comic.getDescription()%></p>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>

</html>
