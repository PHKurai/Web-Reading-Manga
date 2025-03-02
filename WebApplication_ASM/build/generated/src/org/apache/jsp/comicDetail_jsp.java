package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class comicDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<header class=\"bg-primary text-white py-3\">\n");
      out.write("    <div class=\"container d-flex align-items-center justify-content-between\">\n");
      out.write("        <!-- Logo -->\n");
      out.write("        <div class=\"d-flex align-items-center\">\n");
      out.write("            <!-- If you have a logo image, place it here:\n");
      out.write("                 <img src=\"logo.png\" alt=\"Logo\" width=\"40\" height=\"40\" class=\"me-2\">\n");
      out.write("            -->\n");
      out.write("            <span class=\"fs-4 fw-bold\">TENWEB</span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <form class=\"d-flex w-50\" role=\"search\">\n");
      out.write("            <input class=\"form-control me-2\" type=\"search\" placeholder=\"Bạn muốn tìm truyện gì\">\n");
      out.write("                <button class=\"btn btn-light\" type=\"submit\">\n");
      out.write("                    <!-- Example search icon (Bootstrap Icons) -->\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" \n");
      out.write("                         class=\"bi bi-search\" viewBox=\"0 0 16 16\">\n");
      out.write("                        <path d=\"M11 6a5 5 0 1 1-9.999.001A5 5 0 0 1 11 6zm-1.017 \n");
      out.write("                              3.314a6 6 0 1 0-1.414 1.414l3.85 3.85a1 1 \n");
      out.write("                              0 0 0 1.414-1.414l-3.85-3.85z\"/>\n");
      out.write("                    </svg>\n");
      out.write("                </button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <a href=\"auth.jsp?action=sign_up\" class=\"btn btn-light me-2\">Đăng ký</a>\n");
      out.write("            <a href=\"auth.jsp?action=login\" class=\"btn btn-light\">Đăng nhập</a>\n");
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container text-dark my-4\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-md-3 mb-3\">\n");
      out.write("                    <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" alt=\"Comic Cover\" class=\"img-fluid rounded\"/>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-9\">\n");
      out.write("                    <h2 class=\"fw-bold\">Tên truyện: Ta Là Tà Đế</h2>\n");
      out.write("                    <p><strong>Tác giả:</strong> Đông Cấp Nhất</p>\n");
      out.write("                    <p><strong>Tình trạng:</strong> Đang cập nhật</p>\n");
      out.write("                    <p>\n");
      out.write("                        <strong>Lượt thích:</strong> 123 &nbsp; | &nbsp;\n");
      out.write("                        <strong>Lượt theo dõi:</strong> 456 &nbsp; | &nbsp;\n");
      out.write("                        <strong>Lượt xem:</strong> 789\n");
      out.write("                    </p>\n");
      out.write("                    <p>\n");
      out.write("                        <strong>Thể loại:</strong>\n");
      out.write("                        <span class=\"badge bg-info text-dark\">Supernatural</span>\n");
      out.write("                        <span class=\"badge bg-info text-dark\">Manhua</span>\n");
      out.write("                        <span class=\"badge bg-info text-dark\">Xuyên Không</span>\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <a href=\"#\" class=\"btn btn-success me-2\">Đọc từ đầu</a>\n");
      out.write("                        <button class=\"btn btn-warning me-2\">Theo dõi</button>\n");
      out.write("                        <button class=\"btn btn-danger\">Thích</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <h5 class=\"fw-bold\">Giới thiệu</h5>\n");
      out.write("                        <p>\n");
      out.write("                            Truyện Ta Là Tà Đế được cập nhật nhanh và đầy đủ nhất tại MyComicSite.\n");
      out.write("                            Đừng quên ủng hộ và bình luận để nhóm dịch có thêm động lực nhé!\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <hr class=\"my-4\" />\n");
      out.write("            <h4 class=\"fw-bold\">Danh Sách Chương</h4>\n");
      out.write("\n");
      out.write("            <div class=\"input-group mb-3 mt-3\">\n");
      out.write("                <input\n");
      out.write("                    type=\"text\"\n");
      out.write("                    class=\"form-control\"\n");
      out.write("                    placeholder=\"Tìm chương...\"\n");
      out.write("                    aria-label=\"Search Chapter\"\n");
      out.write("                    />\n");
      out.write("                <button class=\"btn btn-secondary\" type=\"button\">Tìm</button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"table-responsive\" style=\"max-height: 600px; overflow-y: auto;\">\n");
      out.write("                <table class=\"table table-striped table-hover\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Chương</th>\n");
      out.write("                            <th>Ngày cập nhật</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            for (int i = 100; i > 0; i--) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"read-comic.html\">Chương ");
      out.print(i);
      out.write("</a></td>\n");
      out.write("                            <td>28/02/2025</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("    \n");
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
