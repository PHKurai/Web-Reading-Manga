/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dao.ChapterDAO;
import dao.ComicDAO;
import dao.ComicLikeDAO;
import dao.FollowDAO;
import dto.AccountDTO;
import dto.CategoryDTO;
import dto.ChapterDTO;
import dto.ComicDTO;
import dto.ComicLikeDTO;
import dto.FollowDTO;
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
@WebServlet(name = "ReadComicController", urlPatterns = {"/ReadComicController"})
public class ReadComicController extends HttpServlet {

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

        HttpSession session = request.getSession();
        FollowDAO fDAO = new FollowDAO();
        ComicLikeDAO clDAO = new ComicLikeDAO();

        if (AuthUtil.isLogin(session)) {
            if (request.getParameter("action") != null && !((String) request.getParameter("action")).trim().isEmpty()) {
                AccountDTO acc = AuthUtil.getAccount(session);
                try {
                    int comicId = Integer.parseInt(request.getParameter("comicId"));
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
                        case "like":
                            clDAO.create(new ComicLikeDTO(acc.getUsername(), comicId));
                            break;
                        case "unlike":
                            Map<String, Integer> comicLikeId = new HashMap<>();
                            comicLikeId.put(acc.getUsername(), comicId);
                            clDAO.delete(comicLikeId);
                            break;
                    }
                    url = "comicDetail.jsp";
                } catch (Exception e) {
                    url = "incorrectContent.jsp";
                }
            }
        }

        if (request.getParameter("comicId") != null && !((String) request.getParameter("comicId")).trim().isEmpty()) {
            try {
                int comicId = Integer.parseInt(request.getParameter("comicId"));
                ComicDAO cDAO = new ComicDAO();
                ComicDTO comic = cDAO.readById(comicId);

                CategoryDAO categoryDAO = new CategoryDAO();
                List<CategoryDTO> categoriesOfComic = categoryDAO.findByComicId(comic.getId());

                List<ChapterDTO> chapters;
                ChapterDAO chapterDAO = new ChapterDAO();

                if (request.getParameter("searchChapter") != null) {
                    String searchChapter = request.getParameter("searchChapter");
                    chapters = chapterDAO.findByComicIdAndSearch(comicId, searchChapter);
                    request.setAttribute("searchChapter", searchChapter);
                } else {
                    chapters = chapterDAO.findByComicId(comicId);
                }
                if (AuthUtil.isLogin(session)) {
                    AccountDTO acc = AuthUtil.getAccount(session);
                    request.setAttribute("isFollowing", fDAO.isFollowing(acc.getUsername(), comicId));
                    request.setAttribute("isLiked", clDAO.isLiked(acc.getUsername(), comicId));
                }

                request.setAttribute("comic", comic);
                request.setAttribute("title", comic.getTitle());

                request.setAttribute("categoriesOfComic", categoriesOfComic);

                request.setAttribute("chapters", chapters);

                url = "comicDetail.jsp";
            } finally {
            }

        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
