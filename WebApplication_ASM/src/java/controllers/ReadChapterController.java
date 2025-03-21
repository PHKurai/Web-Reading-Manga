/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ChapterDAO;
import dao.ComicDAO;
import dao.CommentDAO;
import dao.FollowDAO;
import dao.PageDAO;
import dto.AccountDTO;
import dto.ChapterDTO;
import dto.ComicDTO;
import dto.CommentDTO;
import dto.FollowDTO;
import dto.PageDTO;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtil;

/**
 *
 * @author Admin PC
 */
@WebServlet(name = "ReadChapterController", urlPatterns = {"/ReadChapterController"})
public class ReadChapterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "incorrectContent.jsp";
        if (request.getParameter("chapterId") != null && !((String) request.getParameter("chapterId")).trim().isEmpty()) {
            try {
                int chapterId = Integer.parseInt(request.getParameter("chapterId"));
                ComicDAO cDAO = new ComicDAO();
                ChapterDAO chapterDAO = new ChapterDAO();
                CommentDAO commentDAO = new CommentDAO();
                FollowDAO fDAO = new FollowDAO();
                PageDAO pDAO = new PageDAO();

                ComicDTO comic = cDAO.readByChapter(chapterId);
                ChapterDTO chapter = chapterDAO.readById(chapterId);
                List<ChapterDTO> chapters = chapterDAO.findByComicId(comic.getId());
                List<PageDTO> pages = pDAO.readByChapter(chapterId);
                HttpSession session = request.getSession();
                int commentPageTarget = -1;
                List<CommentDTO> comments = null;
                int commentPage = (commentDAO.countCommentsByChapter(chapterId) - 1) / 5 + 1;
                if (AuthUtil.isLogin(session)) {
                    if (request.getParameter("action") != null && !((String) request.getParameter("action")).trim().isEmpty()) {
                        AccountDTO acc = AuthUtil.getAccount(session);
                        try {
                            int comicId = comic.getId();
                            String action = (String) request.getParameter("action");
                            switch (action) {
                                case "follow":
                                    fDAO.create(new FollowDTO(acc.getUsername(), comicId));
                                    break;
                                case "unfollow":
                                    Map<String, Integer> followId = new HashMap<>();
                                    followId.put(acc.getUsername(), comicId);
                                    fDAO.delete(followId);
                                    break;
                                case "postComment":
                                    String commentContent = request.getParameter("comment").trim();
                                    if (!commentContent.isEmpty()) {
                                        CommentDTO comment = new CommentDTO(acc.getUsername(), chapterId, commentContent);
                                        commentDAO.create(comment);
                                    }
                                    break;
                                case "moreComments":
                                    if (request.getParameter("commentPageTarget") != null) {
                                        commentPageTarget = Integer.parseInt(request.getParameter("commentPageTarget"));
                                        comments = commentDAO.getCommentsByChapterId(chapterId, 1, 5 * commentPageTarget);
                                    } else {
                                        commentPageTarget = 1;
                                        comments = commentDAO.getCommentsByChapterId(chapterId, commentPageTarget, 5);
                                    }
                                    break;
                                case "editComment":
                                    int commentEditId = Integer.parseInt(request.getParameter("commentEditId"));
                                    CommentDTO commentEdit = commentDAO.readById(commentEditId);
                                    request.setAttribute("commentContentEdit", commentEdit.getContent());
                                    request.setAttribute("commentEditId", commentEditId);
                                    if (request.getParameter("commentPageTarget") != null) {
                                        commentPageTarget = Integer.parseInt(request.getParameter("commentPageTarget"));
                                        comments = commentDAO.getCommentsByChapterId(chapterId, 1, 5 * commentPageTarget);
                                    }
                                    break;
                                case "updateComment":
                                    String commentUpdateContent = request.getParameter("commentUpdateContent");
                                    int commentUpdateId = Integer.parseInt(request.getParameter("commentUpdateId"));
                                    CommentDTO commentUpdate = commentDAO.readById(commentUpdateId);
                                    commentUpdate.setContent(commentUpdateContent);
                                    commentDAO.update(commentUpdate);
                                    if (request.getParameter("commentPageTarget") != null) {
                                        commentPageTarget = Integer.parseInt(request.getParameter("commentPageTarget"));
                                        comments = commentDAO.getCommentsByChapterId(chapterId, 1, 5 * commentPageTarget);
                                    }
                                    break;
                            }
                        } catch (Exception e) {
                        }
                    }
                } else {
                    if (request.getParameter("action") != null && !((String) request.getParameter("action")).trim().isEmpty()) {
                        String action = (String) request.getParameter("action");
                        switch (action) {
                            case "moreComments":
                                if (request.getParameter("commentPageTarget") != null) {
                                    commentPageTarget = Integer.parseInt(request.getParameter("commentPageTarget"));
                                    comments = commentDAO.getCommentsByChapterId(chapterId, 1, 5 * commentPageTarget);
                                } else {
                                    commentPageTarget = 1;
                                    comments = commentDAO.getCommentsByChapterId(chapterId, commentPageTarget, 5);
                                }
                                break;
                        }
                    }
                }

                ChapterDTO preChapter = chapter, nextChapter = chapters.get(0);
                boolean getNextChapter = false;
                for (ChapterDTO c : chapters) {
                    if (c.equals(chapter)) {
                        getNextChapter = true;
                    }

                    if (!getNextChapter) {
                        nextChapter = c;
                    }

                    if (getNextChapter && !c.equals(chapter)) {
                        preChapter = c;
                        break;
                    }
                }

                if (AuthUtil.isLogin(session)) {
                    AccountDTO acc = AuthUtil.getAccount(session);
                    request.setAttribute("isFollowing", fDAO.isFollowing(acc.getUsername(), comic.getId()));
                }

                if (commentPageTarget == -1) {
                    commentPageTarget = 1;
                    comments = commentDAO.getCommentsByChapterId(chapterId, commentPageTarget, 5);
                }
                
                request.setAttribute("comic", comic);
                request.setAttribute("pages", pages);
                request.setAttribute("chapter", chapter);
                request.setAttribute("preChapter", preChapter);
                request.setAttribute("nextChapter", nextChapter);
                request.setAttribute("chapters", chapters);
                request.setAttribute("comments", comments);
                request.setAttribute("commentPageTarget", commentPageTarget);
                request.setAttribute("haveMoreComments", commentPage > commentPageTarget);

                url = "readChapter.jsp";
            } finally {
            }

        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }

    private void actionGetMoreComments() {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
