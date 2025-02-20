package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    header {\n");
      out.write("        background: #2563eb;\n");
      out.write("        padding: 1rem;\n");
      out.write("        color: white;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .header-content {\n");
      out.write("        max-width: 1200px;\n");
      out.write("        margin: 0 auto;\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: space-between;\n");
      out.write("        align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logo {\n");
      out.write("        font-size: 1.5rem;\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .search-bar {\n");
      out.write("        position: relative;\n");
      out.write("        flex-grow: 1;\n");
      out.write("        max-width: 400px;\n");
      out.write("        margin: 0 2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .search-bar input {\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 0.5rem 1rem;\n");
      out.write("        border: none;\n");
      out.write("        border-radius: 4px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .user-actions {\n");
      out.write("        display: flex;\n");
      out.write("        gap: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav {\n");
      out.write("        background: white;\n");
      out.write("        box-shadow: 0 2px 4px rgba(0,0,0,0.1);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-content {\n");
      out.write("        max-width: 1200px;\n");
      out.write("        margin: 0 auto;\n");
      out.write("        display: flex;\n");
      out.write("        gap: 2rem;\n");
      out.write("        padding: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-button {\n");
      out.write("        border: none;\n");
      out.write("        background: none;\n");
      out.write("        padding: 0.5rem 1rem;\n");
      out.write("        cursor: pointer;\n");
      out.write("        font-size: 1rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .nav-button.active {\n");
      out.write("        color: #2563eb;\n");
      out.write("        border-bottom: 2px solid #2563eb;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<header>\n");
      out.write("    <div class=\"header-content\">\n");
      out.write("        <div class=\"logo\">TenWeb</div>\n");
      out.write("        <div class=\"search-bar\" style=\"display: flex-box\">\n");
      out.write("            Tìm truyện <input type=\"text\" placeholder=\"Tên truyện, tác giả\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"user-actions\">\n");
      out.write("            <button>Login</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<nav>\n");
      out.write("    <div class=\"nav-content\" style=\"justify-content: center\">\n");
      out.write("        <button class=\"nav-button active\" data-category=\"home\">Trang chủ</button>\n");
      out.write("        <button class=\"nav-button\" data-category=\"type\">Thể Loại</button>\n");
      out.write("        <button class=\"nav-button\" data-category=\"rank\">Xếp Hạng</button>\n");
      out.write("        <button class=\"nav-button\" data-category=\"history\">Lịch Sử</button>\n");
      out.write("        <button class=\"nav-button\" data-category=\"favory\">Yêu Thích</button>\n");
      out.write("    </div>\n");
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
