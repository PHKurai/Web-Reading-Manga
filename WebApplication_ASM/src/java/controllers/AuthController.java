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
@WebServlet(name = "AuthController", urlPatterns = {"/AuthController"})
public class AuthController extends HttpServlet {
    
    private final String HOME_PAGE = "home.jsp";
    private final String AUTH_PAGE = "auth.jsp";
    private final AccountDAO aDAO = new AccountDAO();

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
        
        String url = AUTH_PAGE;
        
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
        String url = AUTH_PAGE;
        String username, password, confirmPassword;
        switch (action) {
            case "login":
                username = request.getParameter("username");
                password = request.getParameter("password");
                
                if (isValidAccount(username, password)) {
                    url = HOME_PAGE;
                    AccountDTO acc = getAccount(username);
                    request.getSession().setAttribute("account", acc);
                    
                } else {
                    url = AUTH_PAGE;
                    request.setAttribute("msgError", "Username or Password is incorrect!");
                }
                
                request.setAttribute("isLogin", true);
                break;
            case "signup":
                username = request.getParameter("username");
                password = request.getParameter("password");
                confirmPassword = request.getParameter("confirmPassword");
                
                if (password.equals(confirmPassword)) {
                    AccountDTO acc = new AccountDTO(username, password);
                    if (aDAO.create(acc)) {
                        url = HOME_PAGE;
                        acc = aDAO.readById(username);
                        request.getSession().setAttribute("account", acc);
                    } else {
                        url = AUTH_PAGE;
                        request.setAttribute("msgError", "Username is already taken!");
                    }
                } else {
                    url = AUTH_PAGE;
                    request.setAttribute("msgError", "Password must like confirm password!");
                }
                request.setAttribute("isLogin", false);
                break;
        }
        
        return url;
    }
    
    private boolean isValidAccount(String username, String password) {
        AccountDTO acc = getAccount(username);
        return acc != null && acc.getPassword().equals(password);
    }
    
    private AccountDTO getAccount(String username) {
        return aDAO.readById(username);
        
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
