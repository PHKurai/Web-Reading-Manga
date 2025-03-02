package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.AccountDTO;

public final class userInfor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/nav.jsp");
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
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("\n");
      out.write("<header class=\"bg-primary text-white py-3\">\n");
      out.write("    <div class=\"container-fluid bg-primary text-white py-2\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"d-flex align-items-center justify-content-between\">\n");
      out.write("\n");
      out.write("                <div class=\"d-flex align-items-center\">\n");
      out.write("                    <!-- If you have a logo image, use: \n");
      out.write("                         <img src=\"logo.png\" alt=\"Logo\" class=\"me-2\" style=\"width: 40px; height: 40px;\"> -->\n");
      out.write("                    <span class=\"fs-4 fw-bold\">TENWEB</span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <form class=\"d-flex w-50 mx-3\" role=\"search\">\n");
      out.write("                    <input \n");
      out.write("                        class=\"form-control me-2\" \n");
      out.write("                        type=\"search\" \n");
      out.write("                        placeholder=\"Bạn muốn tìm truyện gì\" \n");
      out.write("                        aria-label=\"Search\">\n");
      out.write("                    <button class=\"btn btn-light\" type=\"submit\">\n");
      out.write("                        <i class=\"bi bi-search\"></i>\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");

                    if (session.getAttribute("account") != null) {
                        AccountDTO acc = (AccountDTO) session.getAttribute("account");
                
      out.write("\n");
      out.write("                <div class=\"d-flex align-items-center\">\n");
      out.write("                    <span class=\"me-2\">");
      out.print(acc.getName());
      out.write("</span>\n");
      out.write("                    <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGTgDr7zVZCP1vzULDJuI4vfRxzykZ5tjnAYSAYlRq-V3T8aIafR0nLdP_z5ln7pzSYqI&usqp=CAU\" alt=\"Avatar\" class=\"rounded-circle\" style=\"width: 40px; height: 40px;\">\n");
      out.write("                </div>\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"MainController?action=sign_up\" class=\"btn btn-light me-2\">Đăng ký</a>\n");
      out.write("                    <a href=\"MainController?action=login\" class=\"btn btn-light\">Đăng nhập</a>\n");
      out.write("                </div>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-white shadow-sm\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbars\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbars\">\n");
      out.write("            <ul class=\"container d-flex align-items-center justify-content-evenly navbar-nav mb-0\">\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"home.jsp\">Trang Chủ</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"typeDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\n");
      out.write("                        Thể Loại\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Adventure</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Anime</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Chuyển Sinh</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Cổ Đại</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Comedy</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Drama</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Fantasy</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manga</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manhwa</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"rankingDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\n");
      out.write("                        Xếp Hạng\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Mới nhất</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Đọc nhiều</a></li>\n");
      out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Yêu thích</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Lịch Sử</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#\">Theo Dõi</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Thông tin tài khoản</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container py-5\">\n");
      out.write("            <h2 class=\"mb-4\">User Information</h2>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <div class=\"text-center mb-4\">\n");
      out.write("                        <!-- User Avatar -->\n");
      out.write("                        <img\n");
      out.write("                            src=\"https://via.placeholder.com/100.png?text=Avatar\"\n");
      out.write("                            alt=\"User Avatar\"\n");
      out.write("                            class=\"rounded-circle mb-2\"\n");
      out.write("                            />\n");
      out.write("                        <h5 class=\"mb-0\" id=\"usernameDisplay\">Abcd Efghijklm</h5>\n");
      out.write("                        <p class=\"text-muted\">Yogyakarta, Indonesia</p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- User Info Form -->\n");
      out.write("                    <form id=\"userInfoForm\">\n");
      out.write("                        <div class=\"row mb-3\">\n");
      out.write("                            <label class=\"col-sm-3 col-form-label\">Full Name</label>\n");
      out.write("                            <div class=\"col-sm-9\">\n");
      out.write("                                <input\n");
      out.write("                                    type=\"text\"\n");
      out.write("                                    class=\"form-control\"\n");
      out.write("                                    value=\"Abcd Efghijklm\"\n");
      out.write("                                    disabled\n");
      out.write("                                    id=\"fullName\"\n");
      out.write("                                    />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row mb-3\">\n");
      out.write("                            <label class=\"col-sm-3 col-form-label\">Email Address</label>\n");
      out.write("                            <div class=\"col-sm-9\">\n");
      out.write("                                <input\n");
      out.write("                                    type=\"email\"\n");
      out.write("                                    class=\"form-control\"\n");
      out.write("                                    value=\"abcd@gmail.com\"\n");
      out.write("                                    disabled\n");
      out.write("                                    id=\"email\"\n");
      out.write("                                    />\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <div class=\"text-end\">\n");
      out.write("                        <button class=\"btn btn-primary\" id=\"editBtn\">Edit Profile</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
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
