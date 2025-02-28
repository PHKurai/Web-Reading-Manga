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
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("</style>\n");
      out.write("<header class=\"bg-primary text-white py-3\">\n");
      out.write("  <div class=\"container d-flex align-items-center justify-content-between\">\n");
      out.write("    <!-- Logo -->\n");
      out.write("    <div class=\"d-flex align-items-center\">\n");
      out.write("      <!-- If you have a logo image, place it here:\n");
      out.write("           <img src=\"logo.png\" alt=\"Logo\" width=\"40\" height=\"40\" class=\"me-2\">\n");
      out.write("      -->\n");
      out.write("      <span class=\"fs-4 fw-bold\">TENWEB</span>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Search Bar -->\n");
      out.write("    <form class=\"d-flex w-50\" role=\"search\">\n");
      out.write("      <input class=\"form-control me-2\" type=\"search\" placeholder=\"Bạn muốn tìm truyện gì\" aria-label=\"Search\">\n");
      out.write("      <button class=\"btn btn-light\" type=\"submit\">\n");
      out.write("        <!-- Example search icon (Bootstrap Icons) -->\n");
      out.write("        <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" \n");
      out.write("             class=\"bi bi-search\" viewBox=\"0 0 16 16\">\n");
      out.write("          <path d=\"M11 6a5 5 0 1 1-9.999.001A5 5 0 0 1 11 6zm-1.017 \n");
      out.write("                   3.314a6 6 0 1 0-1.414 1.414l3.85 3.85a1 1 \n");
      out.write("                   0 0 0 1.414-1.414l-3.85-3.85z\"/>\n");
      out.write("        </svg>\n");
      out.write("      </button>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <!-- Auth Buttons -->\n");
      out.write("    <div>\n");
      out.write("      <button class=\"btn btn-light me-2\">Đăng ký</button>\n");
      out.write("      <button class=\"btn btn-light\">Đăng nhập</button>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</header>");
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
