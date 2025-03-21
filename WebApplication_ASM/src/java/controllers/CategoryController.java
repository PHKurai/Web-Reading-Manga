/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dao.ComicDAO;
import dto.CategoryDTO;
import dto.ComicDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin PC
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

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
            if (request.getParameter("categoryId") != null && !((String) request.getParameter("categoryId")).trim().isEmpty()) {
                byte categoryId = Byte.parseByte(request.getParameter("categoryId"));
                CategoryDAO categoryDAO = new CategoryDAO();
                CategoryDTO category = categoryDAO.readById(categoryId);
                
                ComicDAO cDAO = new ComicDAO();
                List<ComicDTO> comics = cDAO.findByCategoryId(categoryId, 1, 18);

                int totalComics = cDAO.countCategorieshComics(categoryId);

                int totalPages = totalComics == 0 ? 0 : (totalComics - 1) / 18 + 1;

                request.setAttribute("pageIndex", 1);
                request.setAttribute("categoryId", categoryId);
                request.setAttribute("comics", comics);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("title", "Category - " + category.getName());

                url = "comicList.jsp";
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
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
