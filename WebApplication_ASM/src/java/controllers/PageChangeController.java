/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dao.ComicDAO;
import dto.AccountDTO;
import dto.CategoryDTO;
import dto.ComicDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtil;
import utils.ConstantUtils;

/**
 *
 * @author Admin PC
 */
@WebServlet(name = "PageChangeController", urlPatterns = {"/PageChangeController"})
public class PageChangeController extends HttpServlet {

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
        
        if (request.getParameter("target") != null && request.getParameter("totalPages") != null) {

            ComicDAO cDAO = new ComicDAO();
            int pageIndex = Integer.parseInt(request.getParameter("target"));
            int totalPages = Integer.parseInt(request.getParameter("totalPages"));

            List<ComicDTO> comics = new ArrayList<>();

            if (request.getParameter("searchTerm") != null && !((String) request.getParameter("searchTerm")).trim().isEmpty()) {
                String searchTerm = request.getParameter("searchTerm");

                comics = cDAO.searchComics(searchTerm, pageIndex, ConstantUtils.getPagination());

                request.setAttribute("searchTerm", searchTerm);
                request.setAttribute("title", "Search - " + searchTerm);

                url = "comicList.jsp";
            } else if (request.getParameter("categoryId") != null && !((String) request.getParameter("categoryId")).trim().isEmpty()) {

                try {
                    byte categoryId = Byte.parseByte(request.getParameter("categoryId"));
                    CategoryDAO categoryDAO = new CategoryDAO();
                    CategoryDTO category = categoryDAO.readById(categoryId);

                    comics = cDAO.findByCategoryId(categoryId, pageIndex, ConstantUtils.getPagination());

                    request.setAttribute("categoryId", categoryId);
                    request.setAttribute("title", "Category - " + category.getName());

                    url = "comicList.jsp";
                } finally {

                }
            } else if (request.getParameter("rankingType") != null && !((String) request.getParameter("rankingType")).trim().isEmpty()) {
                try {
                    String rankingType = request.getParameter("rankingType");
                    String type = "";
                    switch (rankingType) {
                        case "LatestUpdate":
                            comics = cDAO.findByLatestUpdate(pageIndex, ConstantUtils.getPagination());
                            type = "Latest Update";
                            break;
                        case "MostViews":
                            comics = cDAO.findByMostViews(pageIndex, ConstantUtils.getPagination());
                            type = "Most Views";
                            break;
                        case "MostFavorites":
                            comics = cDAO.findByMostFavorites(pageIndex, ConstantUtils.getPagination());
                            type = "Most Favorites";
                            break;
                        default:
                            throw new IOException();
                    }

                    request.setAttribute("rankingType", rankingType);
                    request.setAttribute("title", "Ranking - " + type);

                    url = "comicList.jsp";
                } finally {

                }
            } else if (request.getParameter("history") != null && AuthUtil.isLogin(request.getSession())) {
                HttpSession session = request.getSession();
                AccountDTO acc = AuthUtil.getAccount(session);
                
                comics = cDAO.findByHistory(acc.getUsername(), pageIndex, ConstantUtils.getPagination());

                request.setAttribute("history", "history");
                request.setAttribute("title", "History");
                
                url = "comicList.jsp";
            } else if (request.getParameter("follow") != null && AuthUtil.isLogin(request.getSession())) {
                HttpSession session = request.getSession();
                AccountDTO acc = AuthUtil.getAccount(session);
                
                comics = cDAO.findByFollowed(acc.getUsername(), pageIndex, ConstantUtils.getPagination());

                request.setAttribute("follow", "follow");
                request.setAttribute("title", "History");
                
                url = "comicList.jsp";
            }

            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("comics", comics);
            request.setAttribute("totalPages", totalPages);
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
