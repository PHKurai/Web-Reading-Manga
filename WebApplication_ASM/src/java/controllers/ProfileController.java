/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dto.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phucl
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {
    
    AccountDAO aDAO = new AccountDAO();
    
    private final String HOME_PAGE = "home.jsp";
    private final String INFOR_PAGE = "userInfor.jsp";
    private final String CHANGE_PASSWORD_PAGE = "changePassword.jsp";

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
        String url = INFOR_PAGE;
        
        try {
            String action = request.getParameter("action");
            if (action != null) {
                url = controllAction(action, request, response);
            }
        } catch (Exception e) {
            log("Error in MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
    
    private String controllAction(String action, HttpServletRequest request, HttpServletResponse response) {
        String url = INFOR_PAGE;
        switch (action) {
            case "infor":
                url = INFOR_PAGE;
                break;
            case "changePassword":
                url = CHANGE_PASSWORD_PAGE;
                break;
            case "editProfile":
                url = INFOR_PAGE;
                break;
            case "logout":
                url = HOME_PAGE;
                request.getSession().invalidate();
                break;
            case "doChangePassword":
                AccountDTO account = (AccountDTO) request.getSession().getAttribute("account");
                String oldPassword = request.getParameter("oldPassword");
                String newPassword = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");
                System.out.println(newPassword);
                if (oldPassword.equals(account.getPassword())) {
                    if (!newPassword.trim().isEmpty() && newPassword.equals(confirmPassword)) {
                        account.setPassword(newPassword);
                        aDAO.update(account);
                        url = INFOR_PAGE;
                    } else {
                        url = CHANGE_PASSWORD_PAGE;
                        request.setAttribute("confirmPasswordError", "Your confirm password incorrect!");
                    }
                } else {
                    url = CHANGE_PASSWORD_PAGE;
                    request.setAttribute("oldPasswordError", "Your password incorrect!");
                }
                break;
        }
        
        return url;
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
