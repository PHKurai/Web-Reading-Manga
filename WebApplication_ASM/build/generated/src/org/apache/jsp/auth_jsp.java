package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class auth_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Auth</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"navbar navbar-expand-lg navbar-light bg-primary py-3 border-bottom\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand text-white fs-4 fw-bold\" href=\"home.jsp\">MyComicSite</a>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"container py-5\">\n");
      out.write("            <div class=\"row align-items-center\">\n");
      out.write("                <div class=\"col-lg-6 text-center text-lg-start mb-4 mb-lg-0\">\n");
      out.write("                    <div class=\"web-icon d-inline-block\"></div>\n");
      out.write("                    <h2 class=\"fw-bold\">Welcome to MyComicSite</h2>\n");
      out.write("                    <p>Register or login to access your favorite comics!</p>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <ul class=\"nav nav-tabs mb-4\" id=\"authTab\" role=\"tablist\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <button class=\"nav-link\" id=\"register-tab\" data-bs-toggle=\"tab\" data-bs-target=\"#register\" type=\"button\" role=\"tab\">\n");
      out.write("                                Register\n");
      out.write("                            </button>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <button class=\"nav-link\" id=\"login-tab\" data-bs-toggle=\"tab\" data-bs-target=\"#login\" type=\"button\" role=\"tab\">\n");
      out.write("                                Login\n");
      out.write("                            </button>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <div class=\"tab-content\">\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"register\" role=\"tabpanel\" aria-labelledby=\"register-tab\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h4 class=\"card-title mb-3\">Create Your Account</h4>\n");
      out.write("                                    <form>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Username</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"e.g. John Doe\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Email</label>\n");
      out.write("                                            <input type=\"email\" class=\"form-control\" placeholder=\"john@example.com\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Password</label>\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" placeholder=\"********\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Confirm Password</label>\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" placeholder=\"********\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary w-100\">SIGN UP</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"login\" role=\"tabpanel\" aria-labelledby=\"login-tab\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h4 class=\"card-title mb-3\">Login</h4>\n");
      out.write("                                    <form>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Username or Email</label>\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Your username or email\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"mb-3\">\n");
      out.write("                                            <label class=\"form-label\">Password</label>\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" placeholder=\"********\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary w-100\">LOGIN</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            document.addEventListener(\"DOMContentLoaded\", function () {\n");
      out.write("                const urlParams = new URLSearchParams(window.location.search);\n");
      out.write("                const tab = urlParams.get(\"action\");\n");
      out.write("\n");
      out.write("                if (tab === \"login\") {\n");
      out.write("                    document.getElementById(\"login-tab\").classList.add(\"active\");\n");
      out.write("                    document.getElementById(\"register-tab\").classList.remove(\"active\");\n");
      out.write("\n");
      out.write("                    document.getElementById(\"login\").classList.add(\"show\", \"active\");\n");
      out.write("                    document.getElementById(\"register\").classList.remove(\"show\", \"active\");\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"register-tab\").classList.add(\"active\");\n");
      out.write("                    document.getElementById(\"login-tab\").classList.remove(\"active\");\n");
      out.write("\n");
      out.write("                    document.getElementById(\"register\").classList.add(\"show\", \"active\");\n");
      out.write("                    document.getElementById(\"login\").classList.remove(\"show\", \"active\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    /* Example for custom icons in footer-center if you have them */\n");
      out.write("    .fb::before {\n");
      out.write("        content: \"FB\";\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("    .ig::before {\n");
      out.write("        content: \"IG\";\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("    .gh::before {\n");
      out.write("        content: \"GH\";\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<footer class=\"bg-primary text-white\">\n");
      out.write("    <div class=\"container py-4\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <!-- Left Section -->\n");
      out.write("            <div class=\"col-md-4 mb-3\">\n");
      out.write("                <p class=\"mb-1\">Trang web đọc truyện tranh online</p>\n");
      out.write("                <h3 class=\"h5\">TenWeb</h3>\n");
      out.write("                <p class=\"mb-0\">Email hỗ trợ: phuclamhong05@gmail.com</p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Center Section -->\n");
      out.write("            <div class=\"col-md-4 mb-3 d-flex align-items-center justify-content-center\">\n");
      out.write("                <!-- Replace with your social icons or text -->\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"fb\"></i></a>\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"ig\"></i></a>\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"gh\"></i></a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Right Section -->\n");
      out.write("            <div class=\"col-md-4 mb-3 text-md-end text-center\">\n");
      out.write("                <p class=\"mb-1\">&copy; 2025</p>\n");
      out.write("                <p class=\"mb-0\">Không sao chép</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\n");
      out.write("</html>\n");
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
