/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ChapterDAO;
import dao.ComicDAO;
import dao.PageDAO;
import dto.ChapterDTO;
import dto.ComicDTO;
import dto.PageDTO;
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
@WebServlet(name = "ChapterController", urlPatterns = {"/ChapterController"})
public class ChapterController extends HttpServlet {

    private ChapterDAO chapterDAO = new ChapterDAO();
    private PageDAO pageDAO = new PageDAO();
    private ComicDAO comicDAO = new ComicDAO();

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
            try {
                if (request.getParameter("action") != null) {
                    String action = request.getParameter("action").trim();
                    switch (action) {
                        case "addChapter":
                            url = processAdd(request, response);
                            break;
                        case "createChapter":
                            url = processCreate(request, response);
                            break;
                        case "editChapter":
                            url = processEdit(request, response);
                            break;
                        case "updateChapter":
                            url = processUpdate(request, response);
                            break;
                    }
                }
            } catch (Exception e) {
            }

        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    private String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "chapterForm.jsp";

        int comicId = Integer.parseInt(request.getParameter("comicId"));

        ComicDTO comic = comicDAO.readById(comicId);

        int chaptersCount = chapterDAO.countChapterByComicId(comicId) + 1;

        request.setAttribute("comic", comic);
        request.setAttribute("chaptersCount", chaptersCount);
        request.setAttribute("title", "Add Chapter");
        request.setAttribute("action", "createChapter");

        return url;
    }

    private String processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "chapterForm.jsp";
        boolean canCreate = true;
        ChapterDTO chapter = new ChapterDTO();
        boolean missingPage = false, havePage = false;
        List<String> pageDataList = new ArrayList<>();

        int comicId = Integer.parseInt(request.getParameter("comicId"));
        ComicDTO comic = comicDAO.readById(comicId);

        if (request.getParameter("chapterNumber") != null && !request.getParameter("chapterNumber").trim().isEmpty()) {
            int chapterNumber = Integer.parseInt(request.getParameter("chapterNumber").trim());
            chapter.setChapterNumber(chapterNumber);
        } else {
            canCreate = false;
        }

        chapter.setComicId(comicId);
        
        int chapterId = chapterDAO.countAllChapter();
        chapter.setId(chapterId);

        String[] pageNumbersStr = request.getParameterValues("pageNumber");
        String[] pageDataArr = request.getParameterValues("pageData");

        if (pageNumbersStr != null && pageDataArr != null) {
            havePage = true;
            for (int i = 0; i < pageNumbersStr.length; i++) {
                if (pageDataArr[i] == null || pageDataArr[i].trim().isEmpty()) {
                    missingPage = true;
                    break;
                } else {
                    pageDataList.add(pageDataArr[i]);
                }
            }
        }

        if (missingPage) {
            request.setAttribute("errorPages", "One or more pages are missing an image. Please add all pages before submitting.");
            request.setAttribute("pageDataList", pageDataList);
            canCreate = false;
        }

        if (canCreate) {
            chapterDAO.create(chapter);

            if (request.getParameter("chapterTitle") != null && !request.getParameter("chapterTitle").trim().isEmpty()) {
                String title = request.getParameter("chapterTitle").trim();
                chapter.setTitle(title);
            }

            if (request.getParameter("chapterActive") != null && !request.getParameter("chapterActive").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("chapterActive").trim());
                chapter.setIsActive(active);
            }

            chapterDAO.update(chapter);

            if (havePage) {
                PageDTO page;
                for (int i = 0; i < pageNumbersStr.length; i++) {
                    page = new PageDTO(chapterId, pageDataArr[i], i);
                    pageDAO.create(page);
                }
            }

            request.setAttribute("pageDataList", pageDataList);
            request.setAttribute("comic", comic);
            request.setAttribute("chapter", chapter);
            request.setAttribute("title", "Add Comic");
            request.setAttribute("action", "createComic");
            request.setAttribute("isDone", true);
            url = "chapterForm.jsp";
        } else {

            if (request.getParameter("chapterTitle") != null && !request.getParameter("chapterTitle").trim().isEmpty()) {
                String title = request.getParameter("chapterTitle").trim();
                chapter.setTitle(title);
            }

            if (request.getParameter("chapterActive") != null && !request.getParameter("chapterActive").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("chapterActive").trim());
                chapter.setIsActive(active);
            }

            request.setAttribute("comic", comic);
            request.setAttribute("chapter", chapter);
            request.setAttribute("title", "Add Chapter");
            request.setAttribute("action", "createChapter");
        }

        return url;
    }

    private String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "incorrectContent.jsp";
        int comicId = Integer.parseInt(request.getParameter("comicId"));
        ComicDTO comic = comicDAO.readById(comicId);

        if (request.getParameter("chapterId") != null && !request.getParameter("chapterId").trim().isEmpty()) {
            try {
                int chapterId = Integer.parseInt(request.getParameter("chapterId").trim());
                ChapterDTO chapter = chapterDAO.readById(chapterId);

                if (chapter != null) {
                    List<PageDTO> pages = pageDAO.readByChapter(chapterId);
                    List<String> pageDataList = new ArrayList<>();
                    for (PageDTO page : pages) {
                        pageDataList.add(page.getImageText());
                    }
                    request.setAttribute("pageDataList", pageDataList);

                    request.setAttribute("comic", comic);
                    request.setAttribute("chapter", chapter);
                    request.setAttribute("title", "Update Chapter");
                    request.setAttribute("action", "updateChapter");

                    url = "chapterForm.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    private String processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "incorrectContent.jsp";
        boolean canUpdate = true;
        ChapterDTO chapter = new ChapterDTO();
        boolean missingPage = false;
        List<String> pageDataList = new ArrayList<>();

        int comicId = Integer.parseInt(request.getParameter("comicId"));
        ComicDTO comic = comicDAO.readById(comicId);
        chapter.setComicId(comicId);

        if (request.getParameter("chapterId") != null && !request.getParameter("chapterId").trim().isEmpty()) {
            int chapterId = Integer.parseInt(request.getParameter("chapterId").trim());
            chapter.setId(chapterId);
        } else {
            canUpdate = false;
        }

        if (request.getParameter("chapterNumber") != null && !request.getParameter("chapterNumber").trim().isEmpty()) {
            int chapterNumber = Integer.parseInt(request.getParameter("chapterNumber").trim());
            chapter.setChapterNumber(chapterNumber);
        } else {
            canUpdate = false;
        }

        String[] pageNumbersStr = request.getParameterValues("pageNumber");
        String[] pageDataArr = request.getParameterValues("pageData");

        if (pageNumbersStr != null && pageDataArr != null) {
            for (int i = 0; i < pageNumbersStr.length; i++) {
                if (pageDataArr[i] == null || pageDataArr[i].trim().isEmpty()) {
                    missingPage = true;
                    break;
                } else {
                    pageDataList.add(pageDataArr[i]);
                }
            }
        }

        if (missingPage) {
            request.setAttribute("errorPages", "One or more pages are missing an image, or the updated chapter has fewer pages than before. Please check your input.");
            request.setAttribute("pageDataList", pageDataList);
            canUpdate = false;
        }

        if (canUpdate) {
            // Update chapter title and active flag if provided
            if (request.getParameter("chapterTitle") != null && !request.getParameter("chapterTitle").trim().isEmpty()) {
                String title = request.getParameter("chapterTitle").trim();
                chapter.setTitle(title);
            }
            if (request.getParameter("chapterActive") != null && !request.getParameter("chapterActive").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("chapterActive").trim());
                chapter.setIsActive(active);
            }

            // Update chapter in DB
            chapterDAO.update(chapter);

            // Clear previous pages for this chapter:
            pageDAO.deleteByChapterId(chapter.getId());

            // Create new pages using submitted data
            for (int i = 0; i < pageNumbersStr.length; i++) {
                int pageNum = Integer.parseInt(pageNumbersStr[i].trim());
                String pageData = pageDataArr[i];
                PageDTO page = new PageDTO();
                page.setChapterId(chapter.getId());
                page.setPageNumber(pageNum);
                page.setImageText(pageData);
                pageDAO.create(page);
            }

            request.setAttribute("pageDataList", pageDataList);
            request.setAttribute("comic", comic);
            request.setAttribute("chapter", chapter);
            request.setAttribute("title", "Update Comic");
            request.setAttribute("action", "createComic");
            request.setAttribute("isDone", true);
            url = "chapterForm.jsp";
        } else {
            if (request.getParameter("chapterTitle") != null && !request.getParameter("chapterTitle").trim().isEmpty()) {
                String title = request.getParameter("chapterTitle").trim();
                chapter.setTitle(title);
            }
            if (request.getParameter("chapterActive") != null && !request.getParameter("chapterActive").trim().isEmpty()) {
                boolean active = Boolean.parseBoolean(request.getParameter("chapterActive").trim());
                chapter.setIsActive(active);
            }
            request.setAttribute("comic", comic);
            request.setAttribute("chapter", chapter);
            request.setAttribute("title", "Update Chapter");
            request.setAttribute("action", "updateChapter");
            // The pageDataList is already set above for repopulation
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
