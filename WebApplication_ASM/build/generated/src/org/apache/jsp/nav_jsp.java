package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    * {\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .navbar {\n");
      out.write("        background-color: #fff;\n");
      out.write("        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n");
      out.write("        padding: 10px 40px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links {\n");
      out.write("        list-style: none;\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: space-around;\n");
      out.write("        align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links li {\n");
      out.write("        position: relative;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links a {\n");
      out.write("        text-decoration: none;\n");
      out.write("        color: #333;\n");
      out.write("        padding: 10px 15px;\n");
      out.write("        display: block;\n");
      out.write("        transition: all 0.3s ease;\n");
      out.write("        font-weight: 500;\n");
      out.write("        border-bottom: 2px solid white;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-links a:hover {\n");
      out.write("        background-color: #e0f7fa;\n");
      out.write("        border-bottom: 2px solid #00acc1;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-content {\n");
      out.write("        display: none;\n");
      out.write("        position: absolute;\n");
      out.write("        top: 100%;\n");
      out.write("        left: 0;\n");
      out.write("        background-color: #fff;\n");
      out.write("        padding: 15px;\n");
      out.write("        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("        display: grid;\n");
      out.write("        grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));\n");
      out.write("        gap: 10px;\n");
      out.write("        z-index: 100;\n");
      out.write("        width: max-content;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-content a {\n");
      out.write("        padding: 5px;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        transition: background-color 0.3s;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown-content a:hover {\n");
      out.write("        background-color: #e0f7fa;\n");
      out.write("        border-bottom: 2px solid #e0f7fa;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown:hover .dropdown-content {\n");
      out.write("        display: grid;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .dropdown > a::after {\n");
      out.write("        content: \" ▼\";\n");
      out.write("        font-size: 0.8em;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<nav class=\"navbar\">\n");
      out.write("    <ul class=\"nav-links\">\n");
      out.write("        <li><a href=\"#\">Trang Chủ</a></li>\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("            <a href=\"#\">Thể Loại</a>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"#\">Action</a>\n");
      out.write("                <a href=\"#\">Adventure</a>\n");
      out.write("                <a href=\"#\">Anime</a>\n");
      out.write("                <a href=\"#\">Chuyển Sinh</a>\n");
      out.write("                <a href=\"#\">Cổ Đại</a>\n");
      out.write("                <a href=\"#\">Comedy</a>\n");
      out.write("                <a href=\"#\">Drama</a>\n");
      out.write("                <a href=\"#\">Fantasy</a>\n");
      out.write("                <a href=\"#\">Manga</a>\n");
      out.write("                <a href=\"#\">Manhwa</a>\n");
      out.write("            </div>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("            <a href=\"#\">Xếp Hạng</a>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a href=\"#\">Mới nhất</a>\n");
      out.write("                <a href=\"#\">Đọc nhiều</a>\n");
      out.write("                <a href=\"#\">Yêu thích</a>\n");
      out.write("            </div>\n");
      out.write("        </li>\n");
      out.write("        <li><a href=\"#\">Con Gái</a></li>\n");
      out.write("        <li><a href=\"#\">Con Trai</a></li>\n");
      out.write("        <li><a href=\"#\">Tìm Truyện</a></li>\n");
      out.write("        <li><a href=\"#\">Lịch Sử</a></li>\n");
      out.write("        <li><a href=\"#\">Theo Dõi</a></li>\n");
      out.write("        <li><a href=\"#\">Thảo Luận</a></li>\n");
      out.write("        <li><a href=\"#\">Fanpage</a></li>\n");
      out.write("    </ul>\n");
      out.write("</nav>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
