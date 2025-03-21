package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.AccountDTO;
import dto.AccountDTO;

public final class comicList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/home.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/nav.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty searchTerm}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<!DOCTYPE html>\r\n");
          out.write("<html>\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\r\n");
          out.write("\r\n");
          out.write("<header class=\"bg-primary text-white py-3\">\r\n");
          out.write("    <div class=\"container-fluid bg-primary text-white py-2\">\r\n");
          out.write("        <div class=\"container\">\r\n");
          out.write("            <div class=\"d-flex align-items-center justify-content-between\">\r\n");
          out.write("\r\n");
          out.write("                <div class=\"d-flex align-items-center\">\r\n");
          out.write("                    <!-- If you have a logo image, use: \r\n");
          out.write("                         <img src=\"logo.png\" alt=\"Logo\" class=\"me-2\" style=\"width: 40px; height: 40px;\"> -->\r\n");
          out.write("                    <span class=\"fs-4 fw-bold\">TENWEB</span>\r\n");
          out.write("                </div>\r\n");
          out.write("\r\n");
          out.write("                <form class=\"d-flex w-50 mx-3\" role=\"search\" method=\"get\" action=\"SearchServlet\">\r\n");
          out.write("                    <input \r\n");
          out.write("                        class=\"form-control me-2\" \r\n");
          out.write("                        type=\"search\" \r\n");
          out.write("                        placeholder=\"Bạn muốn tìm truyện gì\" \r\n");
          out.write("                        name=\"searchTerm\"\r\n");
          out.write("                        value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.searchTerm}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                    <button class=\"btn btn-light\" type=\"submit\">\r\n");
          out.write("                        <i class=\"bi bi-search\"></i>\r\n");
          out.write("                    </button>\r\n");
          out.write("                </form>\r\n");
          out.write("\r\n");
          out.write("                ");

                    if (session.getAttribute("account") != null) {
                        AccountDTO acc = (AccountDTO) session.getAttribute("account");
                
          out.write("\r\n");
          out.write("                <a href=\"ProfileController?action=infor\" class=\"d-flex align-items-center\">\r\n");
          out.write("                    <span class=\"me-2 text-white\">");
          out.print(acc.getName());
          out.write("</span>\r\n");
          out.write("                    <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGTgDr7zVZCP1vzULDJuI4vfRxzykZ5tjnAYSAYlRq-V3T8aIafR0nLdP_z5ln7pzSYqI&usqp=CAU\" alt=\"Avatar\" class=\"rounded-circle\" style=\"width: 40px; height: 40px;\">\r\n");
          out.write("                </a>\r\n");
          out.write("                ");

                } else {
                
          out.write("\r\n");
          out.write("                <div>\r\n");
          out.write("                    <a href=\"MainController?action=sign_up\" class=\"btn btn-light me-2\">Đăng ký</a>\r\n");
          out.write("                    <a href=\"MainController?action=login\" class=\"btn btn-light\">Đăng nhập</a>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }
                
          out.write("\r\n");
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("    </div>\r\n");
          out.write("</header>\r\n");
          out.write("\r\n");
          out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
          out.write("\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("\r\n");
          out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-white shadow-sm\">\r\n");
          out.write("    <div class=\"container\">\r\n");
          out.write("\r\n");
          out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbars\">\r\n");
          out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
          out.write("        </button>\r\n");
          out.write("\r\n");
          out.write("        <div class=\"collapse navbar-collapse\" id=\"navbars\">\r\n");
          out.write("            <ul class=\"container d-flex align-items-center justify-content-evenly navbar-nav mb-0\">\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"home.jsp\">Trang Chủ</a>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item dropdown\">\r\n");
          out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"typeDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\r\n");
          out.write("                        Thể Loại\r\n");
          out.write("                    </a>\r\n");
          out.write("                    <ul class=\"dropdown-menu\">\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Adventure</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Anime</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Chuyển Sinh</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Cổ Đại</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Comedy</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Drama</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Fantasy</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manga</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manhwa</a></li>\r\n");
          out.write("                    </ul>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item dropdown\">\r\n");
          out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"rankingDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\r\n");
          out.write("                        Xếp Hạng\r\n");
          out.write("                    </a>\r\n");
          out.write("                    <ul class=\"dropdown-menu\">\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Mới nhất</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Đọc nhiều</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Yêu thích</a></li>\r\n");
          out.write("                    </ul>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"#\">Lịch Sử</a>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"#\">Theo Dõi</a>\r\n");
          out.write("                </li>\r\n");
          out.write("            </ul>\r\n");
          out.write("        </div>\r\n");
          out.write("    </div>\r\n");
          out.write("</nav>\r\n");
          out.write("\r\n");
          out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
          out.write("\r\n");
          out.write("\r\n");
          out.write("    <head>\r\n");
          out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
          out.write("        <title>Trang chủ</title>\r\n");
          out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
          out.write("    </head>\r\n");
          out.write("    <body>\r\n");
          out.write("        <div class=\"popular-comic shadow-lg text-white p-4 mb-4 position-relative\" \r\n");
          out.write("             style=\"background-image: url('https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg'); background-size: cover; background-position: center;\">\r\n");
          out.write("\r\n");
          out.write("            <div class=\"position-absolute top-0 start-0 w-100 h-100 bg-dark opacity-50\"></div>\r\n");
          out.write("\r\n");
          out.write("            <div class=\"container position-relative\">\r\n");
          out.write("                <div class=\"row align-items-center\">\r\n");
          out.write("                    <div class=\"col-md-4\">\r\n");
          out.write("                        <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" alt=\"Comic Cover\"\r\n");
          out.write("                             class=\"img-fluid border border-white rounded shadow\">\r\n");
          out.write("                    </div>\r\n");
          out.write("\r\n");
          out.write("                    <div class=\"col-md-8\">\r\n");
          out.write("                        <div class=\"mt-3 mt-md-0\">\r\n");
          out.write("                            <h2 class=\"fs-2 mb-3\">Akumade Taidana Akuyaku Kizoku</h2>\r\n");
          out.write("\r\n");
          out.write("                            <div class=\"mb-3\">\r\n");
          out.write("                                <span class=\"badge bg-warning text-dark\">Action</span>\r\n");
          out.write("                                <span class=\"badge bg-warning text-dark\">Adventure</span>\r\n");
          out.write("                                <span class=\"badge bg-warning text-dark\">Fantasy</span>\r\n");
          out.write("                                <span class=\"badge bg-warning text-dark\">Seinen</span>\r\n");
          out.write("                            </div>\r\n");
          out.write("\r\n");
          out.write("                            <p class=\"mb-3\">\r\n");
          out.write("                                Luke is the only 3rd son of a villainous duke. By some unexpected instance he comes to know\r\n");
          out.write("                                of his own fate and attempts to avoid it. He works hard at finding a peaceful family to\r\n");
          out.write("                                marry into and researching magic. All his hard work is to live a peaceful and slothful\r\n");
          out.write("                                life... And yet he gets involved in one plan after another!\r\n");
          out.write("                            </p>\r\n");
          out.write("\r\n");
          out.write("                            <div class=\"fw-light fst-italic\">By Serota, Izo</div>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("        <div class=\"container\">\r\n");
          out.write("            <div class=\"d-flex justify-content-between\"><h3>Top Read This Week</h3> <a href=\"comicList.jsp\" class=\"arrow-link\">→</a></div>\r\n");
          out.write("            <div class=\"row row-cols-3 row-cols-md-6 g-4 mb-4\">\r\n");
          out.write("                ");

                    for (int i = 0; i < 6; i++) {
                
          out.write("\r\n");
          out.write("                <div class=\"col\">\r\n");
          out.write("                    <div class=\"card comic-card\">\r\n");
          out.write("                        <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" class=\"card-img-top w-100 h-50\" alt=\"");
 
          out.write("\" style=\"max-height: 220px;\">\r\n");
          out.write("                        <div class=\"card-body\">\r\n");
          out.write("                            <h5 class=\"card-title\"> Comic Title 1  </h5>\r\n");
          out.write("                            <p class=\"card-text\">Short description or snippet about the comic.</p>\r\n");
          out.write("                            <a href=\"#\" class=\"btn btn-primary\" >Đọc ngay</a>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }

                
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("\r\n");
          out.write("            <div class=\"d-flex justify-content-between\"><h3>Top Read This Month</h3> <a href=\"#\" class=\"arrow-link\">→</a></div>\r\n");
          out.write("            <div class=\"row row-cols-3 row-cols-md-6 g-4 mb-4\">\r\n");
          out.write("                ");
                    for (int i = 0; i < 6; i++) {
                
          out.write("\r\n");
          out.write("                <div class=\"col\">\r\n");
          out.write("                    <div class=\"card comic-card\">\r\n");
          out.write("                        <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" class=\"card-img-top w-100 h-50\" alt=\"");
 
          out.write("\" style=\"max-height: 220px;\">\r\n");
          out.write("                        <div class=\"card-body\">\r\n");
          out.write("                            <h5 class=\"card-title\"> Comic Title 1  </h5>\r\n");
          out.write("                            <p class=\"card-text\">Short description or snippet about the comic.</p>\r\n");
          out.write("                            <a href=\"#\" class=\"btn btn-primary\" >Đọc ngay</a>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }

                
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("\r\n");
          out.write("            <div class=\"d-flex justify-content-between\"><h3>Top Read This Year</h3> <a href=\"#\" class=\"arrow-link\">→</a></div>\r\n");
          out.write("            <div class=\"row row-cols-3 row-cols-md-6 g-4 mb-4\">\r\n");
          out.write("                ");
                    for (int i = 0; i < 6; i++) {
                
          out.write("\r\n");
          out.write("                <div class=\"col\">\r\n");
          out.write("                    <div class=\"card comic-card\">\r\n");
          out.write("                        <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" class=\"card-img-top w-100 h-50\" alt=\"");
 
          out.write("\" style=\"max-height: 220px;\">\r\n");
          out.write("                        <div class=\"card-body\">\r\n");
          out.write("                            <h5 class=\"card-title\"> Comic Title 1  </h5>\r\n");
          out.write("                            <p class=\"card-text\">Short description or snippet about the comic.</p>\r\n");
          out.write("                            <a href=\"#\" class=\"btn btn-primary\" >Đọc ngay</a>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }

                
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("\r\n");
          out.write("            <div class=\"d-flex justify-content-between\"><h3>Recently Added</h3> <a href=\"#\" class=\"arrow-link\">→</a></div>\r\n");
          out.write("            <div class=\"row row-cols-3 row-cols-md-6 g-4 mb-4\">\r\n");
          out.write("                ");
                    for (int i = 0; i < 6; i++) {
                
          out.write("\r\n");
          out.write("                <div class=\"col\">\r\n");
          out.write("                    <div class=\"card comic-card\">\r\n");
          out.write("                        <img src=\"https://i.pinimg.com/originals/37/3e/76/373e7691ecf16e725e49890edbca1b57.jpg\" class=\"card-img-top w-100 h-50\" alt=\"");
 
          out.write("\" style=\"max-height: 220px;\">\r\n");
          out.write("                        <div class=\"card-body\">\r\n");
          out.write("                            <h5 class=\"card-title\"> Comic Title 1  </h5>\r\n");
          out.write("                            <p class=\"card-text\">Short description or snippet about the comic.</p>\r\n");
          out.write("                            <a href=\"#\" class=\"btn btn-primary\" >Đọc ngay</a>\r\n");
          out.write("                        </div>\r\n");
          out.write("                    </div>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }

                
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("            \r\n");
          out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
          out.write("\r\n");
          out.write("    </body>\r\n");
          out.write("    ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("\r\n");
          out.write("<style>\r\n");
          out.write("    /* Example for custom icons in footer-center if you have them */\r\n");
          out.write("    .fb::before {\r\n");
          out.write("        content: \"FB\";\r\n");
          out.write("        font-weight: bold;\r\n");
          out.write("    }\r\n");
          out.write("    .ig::before {\r\n");
          out.write("        content: \"IG\";\r\n");
          out.write("        font-weight: bold;\r\n");
          out.write("    }\r\n");
          out.write("    .gh::before {\r\n");
          out.write("        content: \"GH\";\r\n");
          out.write("        font-weight: bold;\r\n");
          out.write("    }\r\n");
          out.write("</style>\r\n");
          out.write("\r\n");
          out.write("<footer class=\"bg-primary text-white\">\r\n");
          out.write("    <div class=\"container py-4\">\r\n");
          out.write("        <div class=\"row\">\r\n");
          out.write("            <!-- Left Section -->\r\n");
          out.write("            <div class=\"col-md-4 mb-3\">\r\n");
          out.write("                <p class=\"mb-1\">Trang web đọc truyện tranh online</p>\r\n");
          out.write("                <h3 class=\"h5\">TenWeb</h3>\r\n");
          out.write("                <p class=\"mb-0\">Email hỗ trợ: phuclamhong05@gmail.com</p>\r\n");
          out.write("            </div>\r\n");
          out.write("\r\n");
          out.write("            <!-- Center Section -->\r\n");
          out.write("            <div class=\"col-md-4 mb-3 d-flex align-items-center justify-content-center\">\r\n");
          out.write("                <!-- Replace with your social icons or text -->\r\n");
          out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"fb\"></i></a>\r\n");
          out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"ig\"></i></a>\r\n");
          out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"gh\"></i></a>\r\n");
          out.write("            </div>\r\n");
          out.write("\r\n");
          out.write("            <!-- Right Section -->\r\n");
          out.write("            <div class=\"col-md-4 mb-3 text-md-end text-center\">\r\n");
          out.write("                <p class=\"mb-1\">&copy; 2025</p>\r\n");
          out.write("                <p class=\"mb-0\">Không sao chép</p>\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("    </div>\r\n");
          out.write("</footer>\r\n");
          out.write("\r\n");
          out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
          out.write("\r\n");
          out.write("</html>\r\n");
          out.write("\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty searchTerm}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <head>\r\n");
          out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
          out.write("            <title>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</title>\r\n");
          out.write("            <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
          out.write("        </head>\r\n");
          out.write("        <body>\r\n");
          out.write("\r\n");
          out.write("            ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\r\n");
          out.write("\r\n");
          out.write("<header class=\"bg-primary text-white py-3\">\r\n");
          out.write("    <div class=\"container-fluid bg-primary text-white py-2\">\r\n");
          out.write("        <div class=\"container\">\r\n");
          out.write("            <div class=\"d-flex align-items-center justify-content-between\">\r\n");
          out.write("\r\n");
          out.write("                <div class=\"d-flex align-items-center\">\r\n");
          out.write("                    <!-- If you have a logo image, use: \r\n");
          out.write("                         <img src=\"logo.png\" alt=\"Logo\" class=\"me-2\" style=\"width: 40px; height: 40px;\"> -->\r\n");
          out.write("                    <span class=\"fs-4 fw-bold\">TENWEB</span>\r\n");
          out.write("                </div>\r\n");
          out.write("\r\n");
          out.write("                <form class=\"d-flex w-50 mx-3\" role=\"search\" method=\"get\" action=\"SearchServlet\">\r\n");
          out.write("                    <input \r\n");
          out.write("                        class=\"form-control me-2\" \r\n");
          out.write("                        type=\"search\" \r\n");
          out.write("                        placeholder=\"Bạn muốn tìm truyện gì\" \r\n");
          out.write("                        name=\"searchTerm\"\r\n");
          out.write("                        value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.searchTerm}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("                    <button class=\"btn btn-light\" type=\"submit\">\r\n");
          out.write("                        <i class=\"bi bi-search\"></i>\r\n");
          out.write("                    </button>\r\n");
          out.write("                </form>\r\n");
          out.write("\r\n");
          out.write("                ");

                    if (session.getAttribute("account") != null) {
                        AccountDTO acc = (AccountDTO) session.getAttribute("account");
                
          out.write("\r\n");
          out.write("                <a href=\"ProfileController?action=infor\" class=\"d-flex align-items-center\">\r\n");
          out.write("                    <span class=\"me-2 text-white\">");
          out.print(acc.getName());
          out.write("</span>\r\n");
          out.write("                    <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGTgDr7zVZCP1vzULDJuI4vfRxzykZ5tjnAYSAYlRq-V3T8aIafR0nLdP_z5ln7pzSYqI&usqp=CAU\" alt=\"Avatar\" class=\"rounded-circle\" style=\"width: 40px; height: 40px;\">\r\n");
          out.write("                </a>\r\n");
          out.write("                ");

                } else {
                
          out.write("\r\n");
          out.write("                <div>\r\n");
          out.write("                    <a href=\"MainController?action=sign_up\" class=\"btn btn-light me-2\">Đăng ký</a>\r\n");
          out.write("                    <a href=\"MainController?action=login\" class=\"btn btn-light\">Đăng nhập</a>\r\n");
          out.write("                </div>\r\n");
          out.write("                ");

                    }
                
          out.write("\r\n");
          out.write("\r\n");
          out.write("            </div>\r\n");
          out.write("        </div>\r\n");
          out.write("    </div>\r\n");
          out.write("</header>\r\n");
          out.write("\r\n");
          out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
          out.write("\r\n");
          out.write("            ");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
          out.write("\r\n");
          out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-white shadow-sm\">\r\n");
          out.write("    <div class=\"container\">\r\n");
          out.write("\r\n");
          out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbars\">\r\n");
          out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
          out.write("        </button>\r\n");
          out.write("\r\n");
          out.write("        <div class=\"collapse navbar-collapse\" id=\"navbars\">\r\n");
          out.write("            <ul class=\"container d-flex align-items-center justify-content-evenly navbar-nav mb-0\">\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"home.jsp\">Trang Chủ</a>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item dropdown\">\r\n");
          out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"typeDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\r\n");
          out.write("                        Thể Loại\r\n");
          out.write("                    </a>\r\n");
          out.write("                    <ul class=\"dropdown-menu\">\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Action</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Adventure</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Anime</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Chuyển Sinh</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Cổ Đại</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Comedy</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Drama</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Fantasy</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manga</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Manhwa</a></li>\r\n");
          out.write("                    </ul>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item dropdown\">\r\n");
          out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"rankingDropdown\" role=\"button\" data-bs-toggle=\"dropdown\">\r\n");
          out.write("                        Xếp Hạng\r\n");
          out.write("                    </a>\r\n");
          out.write("                    <ul class=\"dropdown-menu\">\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Mới nhất</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Đọc nhiều</a></li>\r\n");
          out.write("                        <li><a class=\"dropdown-item\" href=\"#\">Yêu thích</a></li>\r\n");
          out.write("                    </ul>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"#\">Lịch Sử</a>\r\n");
          out.write("                </li>\r\n");
          out.write("\r\n");
          out.write("                <li class=\"nav-item\">\r\n");
          out.write("                    <a class=\"nav-link\" href=\"#\">Theo Dõi</a>\r\n");
          out.write("                </li>\r\n");
          out.write("            </ul>\r\n");
          out.write("        </div>\r\n");
          out.write("    </div>\r\n");
          out.write("</nav>\r\n");
          out.write("\r\n");
          out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
          out.write("\r\n");
          out.write("\r\n");
          out.write("            ");
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\r\n");
          out.write("            ");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_if_3.setPageContext(_jspx_page_context);
          _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
          _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPages gt 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
          int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
          if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("                <div class=\"container mb-4\">\r\n");
              out.write("                    <h3 class=\"mt-4 mb-4\">");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
              out.write("</h3>\r\n");
              out.write("                    <div class=\"row row-cols-3 row-cols-md-6 g-4 mb-4\">\r\n");
              out.write("                        ");
              if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("                    </div>\r\n");
              out.write("                </div>\r\n");
              out.write("\r\n");
              out.write("                ");
            int pageIndex = (int) request.getAttribute("pageIndex");
                    int totalPages = (int) request.getAttribute("totalPages");
                
              out.write("\r\n");
              out.write("                <nav>\r\n");
              out.write("                    <ul class=\"pagination justify-content-center\">\r\n");
              out.write("                        <li class=\"page-item\">\r\n");
              out.write("                            <a class=\"page-link\" href=\"PageChangeServlet?target=1\" tabindex=\"-1\">Tới trang đầu</a>\r\n");
              out.write("                        </li>\r\n");
              out.write("\r\n");
              out.write("                        ");

                            for (int i = pageIndex - 3; i <= pageIndex + 3; i++) {
                                if (i > 0 && i <= totalPages) {
                        
              out.write("\r\n");
              out.write("                        <li class=\"page-item ");
              out.print((pageIndex == i) ? "active" : "");
              out.write("\"><a class=\"page-link\" href=\"PageChangeServlet?target=");
              out.print(i);
              out.write('"');
              out.write('>');
              out.print(i);
              out.write("</a></li>\r\n");
              out.write("                            ");

                                    }
                                }
                            
              out.write("\r\n");
              out.write("                        <li class=\"page-item\">\r\n");
              out.write("                            <a class=\"page-link\" href=\"PageChangeServlet?target=");
              out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPages}", java.lang.String.class, (PageContext)_jspx_page_context, null));
              out.write("\">Tới trang cuối</a>\r\n");
              out.write("                        </li>\r\n");
              out.write("                    </ul>\r\n");
              out.write("                </nav>\r\n");
              out.write("            ");
              int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
          out.write("\r\n");
          out.write("\r\n");
          out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    /* Example for custom icons in footer-center if you have them */\r\n");
      out.write("    .fb::before {\r\n");
      out.write("        content: \"FB\";\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("    .ig::before {\r\n");
      out.write("        content: \"IG\";\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("    .gh::before {\r\n");
      out.write("        content: \"GH\";\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"bg-primary text-white\">\r\n");
      out.write("    <div class=\"container py-4\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <!-- Left Section -->\r\n");
      out.write("            <div class=\"col-md-4 mb-3\">\r\n");
      out.write("                <p class=\"mb-1\">Trang web đọc truyện tranh online</p>\r\n");
      out.write("                <h3 class=\"h5\">TenWeb</h3>\r\n");
      out.write("                <p class=\"mb-0\">Email hỗ trợ: phuclamhong05@gmail.com</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Center Section -->\r\n");
      out.write("            <div class=\"col-md-4 mb-3 d-flex align-items-center justify-content-center\">\r\n");
      out.write("                <!-- Replace with your social icons or text -->\r\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"fb\"></i></a>\r\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"ig\"></i></a>\r\n");
      out.write("                <a href=\"#\" class=\"text-white fs-4 mx-2\"><i class=\"gh\"></i></a>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Right Section -->\r\n");
      out.write("            <div class=\"col-md-4 mb-3 text-md-end text-center\">\r\n");
      out.write("                <p class=\"mb-1\">&copy; 2025</p>\r\n");
      out.write("                <p class=\"mb-0\">Không sao chép</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPages eq 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <div class=\"container mb-4\">\r\n");
        out.write("                    <h3 class=\"mt-4 mb-4\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</h3>\r\n");
        out.write("                    <p>No one comic match.</p>\r\n");
        out.write("                </div>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_forEach_0.setVar("comic");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comics}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            <div class=\"col\">\r\n");
          out.write("                                <div class=\"card comic-card\">\r\n");
          out.write("                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comic.coverImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"card-img-top w-100 h-50\" alt=\"image cover comic ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comic.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"max-height: 220px;\">\r\n");
          out.write("                                    <div class=\"card-body\">\r\n");
          out.write("                                        <h5 class=\"card-title\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comic.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\r\n");
          out.write("                                        <p class=\"card-text\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comic.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                        <a href=\"#\" class=\"btn btn-primary\" >Đọc ngay</a>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                </div>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
