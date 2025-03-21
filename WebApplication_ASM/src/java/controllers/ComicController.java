/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CategoryDAO;
import dao.ComicCategoryDAO;
import dao.ComicDAO;
import dto.AccountDTO;
import dto.CategoryDTO;
import dto.ComicCategoryDTO;
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

/**
 *
 * @author Admin PC
 */
@WebServlet(name = "ComicController", urlPatterns = {"/ComicController"})
public class ComicController extends HttpServlet {

    private AccountDTO acc;
    private ComicDAO cDAO = new ComicDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ComicCategoryDAO comicCategoryDAO = new ComicCategoryDAO();

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
        if (AuthUtil.isAdmin(session)) {
            acc = AuthUtil.getAccount(session);

            if (request.getParameter("action") != null) {
                String action = request.getParameter("action").trim();
                switch (action) {
                    case "addComic":
                        url = processAdd(request, response);
                        break;
                    case "createComic":
                        url = processCreate(request, response);
                        break;
                    case "editComic":
                        url = processEdit(request, response);
                        break;
                    case "updateComic":
                        url = processUpdate(request, response);
                        break;
                }
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "comicForm.jsp";

        List<CategoryDTO> categoriesChoose = categoryDAO.readAll();

        request.setAttribute("categoriesChoose", categoriesChoose);
        request.setAttribute("title", "Add Comic");
        request.setAttribute("action", "createComic");

        return url;
    }

    private String processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "comicForm.jsp";
        boolean canCreate = true;
        ComicDTO comic = new ComicDTO();
        String title, author;

        if (request.getParameter("title") == null || request.getParameter("title").trim().isEmpty()) {
            request.setAttribute("errorTitle", "Title cannot be blank and less than 100 characters!");
            canCreate = false;
        } else {
            title = request.getParameter("title").trim();
            comic.setTitle(title);
        }

        if (request.getParameter("author") == null || request.getParameter("author").trim().isEmpty()) {
            request.setAttribute("errorAuthor", "Author cannot be blank and less than 50 characters!");
            canCreate = false;
        } else {
            author = request.getParameter("author").trim();
            comic.setAuthor(author);
        }

        if (canCreate) {

            comic.setAddAdmin(acc.getUsername());

            cDAO.create(comic);

            int comicId = cDAO.countComics();
            comic.setId(comicId);

            if (request.getParameter("description") != null && !request.getParameter("description").trim().isEmpty()) {
                String description = request.getParameter("description").trim();
                comic.setDescription(description);
            }

            if (request.getParameter("coverImage") != null && !request.getParameter("coverImage").trim().isEmpty()) {
                String coverImage = request.getParameter("coverImage").trim();
                comic.setCoverImage(coverImage);
            }

            if (request.getParameter("status") != null && !request.getParameter("status").trim().isEmpty()) {
                String status = request.getParameter("status").trim();
                comic.setStatus(status);
            }

            if (request.getParameter("active") != null && !request.getParameter("active").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("active").trim());
                comic.setActive(active);
            }

            if (request.getParameterValues("categories") != null) {
                String[] categoryIds = request.getParameterValues("categories");
                if (categoryIds != null) {
                    ComicCategoryDTO comicCategry;
                    for (String idStr : categoryIds) {
                        try {
                            comicCategry = new ComicCategoryDTO(comicId, Integer.parseInt(idStr));
                            comicCategoryDAO.create(comicCategry);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }

            cDAO.update(comic);

            List<CategoryDTO> categories = categoryDAO.findByComicId(comicId);

            request.setAttribute("comic", comic);
            request.setAttribute("categories", categories);
            request.setAttribute("title", "Add Comic");
            request.setAttribute("action", "createComic");
            request.setAttribute("isDone", true);
        } else {
            List<CategoryDTO> categories = new ArrayList<>();
            if (request.getParameterValues("categories") != null) {
                String[] categoryIds = request.getParameterValues("categories");
                if (categoryIds != null) {
                    
                    for (String idStr : categoryIds) {
                        try {
                            categories.add(categoryDAO.readById(Byte.parseByte(idStr)));
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }

            List<CategoryDTO> categoriesChoose = categoryDAO.readAll();

            request.setAttribute("categoriesChoose", categoriesChoose);
            request.setAttribute("categories", categories);
            request.setAttribute("comic", comic);
            request.setAttribute("title", "Add Comic");
            request.setAttribute("action", "createComic");
        }

        return url;
    }

    private String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "incorrectContent.jsp";

        if (request.getParameter("comicId") != null && !request.getParameter("comicId").trim().isEmpty()) {
            try {
                int comicId = Integer.parseInt(request.getParameter("comicId").trim());
                ComicDTO comic = cDAO.readById(comicId);

                if (comic != null) {
                    List<CategoryDTO> categories = categoryDAO.findByComicId(comicId);

                    List<CategoryDTO> categoriesChoose = categoryDAO.readAll();

                    request.setAttribute("categoriesChoose", categoriesChoose);

                    request.setAttribute("categories", categories);
                    request.setAttribute("comic", comic);
                    request.setAttribute("title", "Update");
                    request.setAttribute("action", "updateComic");

                    url = "comicForm.jsp";
                }
            } finally {
            }
        }

        return url;
    }

    private String processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "incorrectContent.jsp";
        boolean canUpdate = true;
        ComicDTO comic;
        String title, author;

        if (request.getParameter("comicId") != null) {
            try {
                int comicId = Integer.parseInt(request.getParameter("comicId").trim());
                comic = cDAO.readById(comicId);

                if (comic == null) {
                    return url;
                }
            } catch (Exception e) {
                return url;
            }
        } else {
            return url;
        }

        if (request.getParameter("title") == null || request.getParameter("title").trim().isEmpty()) {
            request.setAttribute("errorTitle", "Title cannot be blank and less than 100 characters!");
            canUpdate = false;
        } else {
            title = request.getParameter("title").trim();
            comic.setTitle(title);
        }

        if (request.getParameter("author") == null || request.getParameter("author").trim().isEmpty()) {
            request.setAttribute("errorAuthor", "Author cannot be blank and less than 50 characters!");
            canUpdate = false;
        } else {
            author = request.getParameter("author").trim();
            comic.setAuthor(author);
        }

        if (canUpdate) {

            comic.setAddAdmin(acc.getUsername());

            if (request.getParameter("description") != null && !request.getParameter("description").trim().isEmpty()) {
                String description = request.getParameter("description").trim();
                comic.setDescription(description);
            }

            if (request.getParameter("coverImage") != null && !request.getParameter("coverImage").trim().isEmpty()) {
                String coverImage = request.getParameter("coverImage").trim();
                comic.setCoverImage(coverImage);
            }

            if (request.getParameter("status") != null && !request.getParameter("status").trim().isEmpty()) {
                String status = request.getParameter("status").trim();
                comic.setStatus(status);
            }

            if (request.getParameter("active") != null && !request.getParameter("active").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("active").trim());
                comic.setActive(active);
            }

            if (request.getParameterValues("categories") != null) {
                String[] categoryIds = request.getParameterValues("categories");
                if (categoryIds != null) {
                    ComicCategoryDTO comicCategry;
                    for (String idStr : categoryIds) {
                        try {
                            comicCategry = new ComicCategoryDTO(comic.getId(), Integer.parseInt(idStr));
                            comicCategoryDAO.create(comicCategry);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }

            cDAO.update(comic);
            List<CategoryDTO> categories = categoryDAO.findByComicId(comic.getId());

            url = "comicForm.jsp";

            request.setAttribute("categories", categories);
            request.setAttribute("comic", comic);
            request.setAttribute("title", "Update");
            request.setAttribute("action", "updateComic");
            request.setAttribute("isDone", true);
        } else {
            List<CategoryDTO> categoriesChoose = categoryDAO.readAll();

            request.setAttribute("categoriesChoose", categoriesChoose);

            url = "comicForm.jsp";
            request.setAttribute("comic", comic);
            request.setAttribute("title", "Update");
            request.setAttribute("action", "updateComic");
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
