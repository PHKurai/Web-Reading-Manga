/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AccountDAO;
import dto.AccountDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtil;
import utils.PasswordUtils;

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
        } catch (Exception e) {}
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
    }

    private String controllAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String url = INFOR_PAGE;
        switch (action) {
            case "infor":
                url = INFOR_PAGE;
                break;
            case "changePassword":
                url = CHANGE_PASSWORD_PAGE;
                break;
            case "editProfile":
                url = processEditProfile(request, response);
                break;
            case "logout":
                url = HOME_PAGE;
                request.getSession().invalidate();
                break;
            case "doChangePassword":
                url = processDoChangePassword(request, response);
                break;
            case "updateProfile":
                url = processUpdateProfile(request, response);
                break;
        }

        return url;
    }
    
    private String processEditProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = INFOR_PAGE;
    
        request.setAttribute("isChange", true);
        
        return url;
    }
    
    private String processUpdateProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = INFOR_PAGE, name = "", email = "", avt = "";
        boolean canChange = true;
        
        try {
            name = request.getParameter("name").trim();
            email = request.getParameter("email").trim();
            avt = request.getParameter("avatar").trim();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
                
        if (!AuthUtil.isValidName(name)) {
            canChange = false;
            request.setAttribute("msgNameError", "The name length must be greater than 4!");
        }
        
        if (!email.isEmpty() && !AuthUtil.isValidEmail(email)) {
            canChange = false;
            request.setAttribute("msgEmailError", "Invalid email!");
        }
        
        if (canChange) {
            HttpSession session = request.getSession();
            AccountDTO acc = AuthUtil.getAccount(session);
            acc.setName(name);
            acc.setEmail(email);
            acc.setAvatar(avt);
            
            aDAO.update(acc);
        } else {
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("isChange", true);
        }
        
        return url;
    }

    private String processDoChangePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = INFOR_PAGE;
        boolean canChange = true;
        
        AccountDTO account = (AccountDTO) request.getSession().getAttribute("account");
        String oldPassword = request.getParameter("oldPassword").trim();
        String newPassword = request.getParameter("newPassword").trim();
        String confirmPassword = request.getParameter("confirmPassword").trim();

        if (!PasswordUtils.checkPassword(oldPassword, account.getPassword())) {
            url = CHANGE_PASSWORD_PAGE;
            canChange = false;
            request.setAttribute("msgOldPasswordError", "Your password incorrect!");
        }

        if (!newPassword.equals(confirmPassword)) {
            url = CHANGE_PASSWORD_PAGE;
            canChange = false;
            request.setAttribute("msgConfirmPwError", "Confirm password must like password!");
        }
        
        if (newPassword.equals(oldPassword)) {
            url = CHANGE_PASSWORD_PAGE;
            canChange = false;
            request.setAttribute("msgNewPwError", "The new password cannot be the same as the old password!");
        }

        if (!AuthUtil.isValidPassword(newPassword)) {
            url = CHANGE_PASSWORD_PAGE;
            canChange = false;
            request.setAttribute("msgNewPwError", "Password must contain at least 1 number, 1 uppercase letter, 1 lowercase letter, 1 special character and be at least 8 characters long!");
        }
        
        if (canChange) {
            account.setPassword(PasswordUtils.hashPassword(newPassword));
            aDAO.update(account);
            url = INFOR_PAGE;
        } else {
            request.setAttribute("oldPassword", oldPassword);
            request.setAttribute("newPassword", newPassword);
            request.setAttribute("confirmPassword", confirmPassword);
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
