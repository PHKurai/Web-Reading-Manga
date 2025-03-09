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
import utils.AuthUtil;

/**
 *
 * @author phucl
 */
@WebServlet(name = "AuthController", urlPatterns = {"/AuthController"})
public class AuthController extends HttpServlet {

    private final String HOME_PAGE = "home.jsp";
    private final String AUTH_PAGE = "auth.jsp";

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

    private String controllAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = AUTH_PAGE;
        switch (action) {
            case "login":
                url = processLogin(request, response);
                break;
            case "signup":
                url = processSignUp(request, response);
                break;
        }

        return url;
    }

    private String processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username, password, url;
        username = request.getParameter("username").trim();
        password = request.getParameter("password").trim();

        if (AuthUtil.isValidAccount(username, password)) {
            url = HOME_PAGE;
            AccountDTO acc = AuthUtil.getAccount(username);
            request.getSession().setAttribute("account", acc);
        } else {
            url = AUTH_PAGE;
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("msgLoginError", "Username or Password is incorrect!");
        }

        request.setAttribute("isLogin", true);

        return url;
    }

    private String processSignUp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username, password, url, confirmPassword;
        boolean canCreate = true;

        url = AUTH_PAGE;
        username = request.getParameter("username").trim();
        password = request.getParameter("password").trim();
        confirmPassword = request.getParameter("confirmPassword").trim();
        
        AccountDTO acc = new AccountDTO(username, password);
        AccountDAO aDAO = new AccountDAO();

        if (!password.equals(confirmPassword)) {
            canCreate = false;
            request.setAttribute("msgConfirmPwError", "Confirm password must like password!");
        }
        
        if (username.length()==0) {
                canCreate = false;
            request.setAttribute("msgUsernameError", "Input your username!");
        } else if (aDAO.readById(username)!=null) {
            canCreate = false;
            request.setAttribute("msgUsernameError", "Username is already taken!");
        }
        
        if (!AuthUtil.isValidPassword(password)) {
            canCreate = false;
            request.setAttribute("msgPasswordError", "Password must contain at least 1 number, 1 uppercase letter, 1 lowercase letter, 1 special character and be at least 8 characters long!");
        }
        
        if (canCreate) {
            aDAO.create(acc);
            url = HOME_PAGE;
            acc = aDAO.readById(username);
            request.getSession().setAttribute("account", acc);
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("confirmPassword", confirmPassword);
            
            request.setAttribute("isLogin", false);
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
