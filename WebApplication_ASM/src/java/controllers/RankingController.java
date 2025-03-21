/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ComicDAO;
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
import utils.ConstantUtils;

/**
 *
 * @author Admin PC
 */
@WebServlet(name = "RankingController", urlPatterns = {"/RankingController"})
public class RankingController extends HttpServlet {

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
        try {
            if (request.getParameter("rankingType") != null && !((String) request.getParameter("rankingType")).trim().isEmpty()) {
                String rankingType = request.getParameter("rankingType");
                ComicDAO cDAO = new ComicDAO();
                List<ComicDTO> comics = new ArrayList<>();
                String type = "";
                switch (rankingType) {
                    case "LatestUpdate":
                        comics = cDAO.findByLatestUpdate(1, ConstantUtils.getPagination());
                        type = "Latest Update";
                        break;
                    case "MostViews":
                        comics = cDAO.findByMostViews(1, ConstantUtils.getPagination());
                        type = "Most Views";
                        break;
                    case "MostFavorites":
                        comics = cDAO.findByMostFavorites(1, ConstantUtils.getPagination());
                        type = "Most Favorites";
                        break;
                    default:
                        throw new IOException();
                }
                
                int totalComics = cDAO.countComics();

                int totalPages = totalComics == 0 ? 0 : (totalComics - 1) / ConstantUtils.getPagination() + 1;

                request.setAttribute("pageIndex", 1);
                request.setAttribute("rankingType", rankingType);
                request.setAttribute("comics", comics);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("title", "Ranking - " + type);

                url = "comicList.jsp";
            }
        } finally {

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
