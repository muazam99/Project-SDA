package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("   <head>\r\n");
      out.write("      <meta charset=\"utf-8\">\r\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("       <title>Alumni Login System</title>\r\n");
      out.write("\r\n");
      out.write("      <!-- Bootstrap core CSS -->\r\n");
      out.write("      <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("      <style>\r\n");
      out.write("         .bd-placeholder-img {\r\n");
      out.write("           font-size: 1.125rem;\r\n");
      out.write("           text-anchor: middle;\r\n");
      out.write("           -webkit-user-select: none;\r\n");
      out.write("           -moz-user-select: none;\r\n");
      out.write("           -ms-user-select: none;\r\n");
      out.write("           user-select: none;\r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("         @media (min-width: 768px) {\r\n");
      out.write("           .bd-placeholder-img-lg {\r\n");
      out.write("             font-size: 3.5rem;\r\n");
      out.write("           }\r\n");
      out.write("         }\r\n");
      out.write("      </style>\r\n");
      out.write("\r\n");
      out.write("      <!-- Custom styles for this template -->\r\n");
      out.write("      <link href=\"css/navbar-top-fixed.css\" rel=\"stylesheet\">\r\n");
      out.write("      \r\n");
      out.write("     <!-- JQUERY -->\r\n");
      out.write("      <script\r\n");
      out.write("         src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\r\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\r\n");
      out.write("         crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script type=\"text/javascript\"\r\n");
      out.write("                src=\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js\">\r\n");
      out.write("                    \r\n");
      out.write("        </script>\r\n");
      out.write("      \r\n");
      out.write("   </head>\r\n");
      out.write("\r\n");
      out.write("   <body>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("      <main role=\"main\" class=\"container\">\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("         <div class=\"row\">\r\n");
      out.write("             <div class=\"col\"></div>\r\n");
      out.write("                 \r\n");
      out.write("            <div class=\"col-6\">\r\n");
      out.write("                \r\n");
      out.write("               <div class=\"card shadow\">\r\n");
      out.write("                  <div class=\"card-body\">\r\n");
      out.write("                     <h2>Login</h2>\r\n");
      out.write("                     <br>\r\n");
      out.write("                     <form action=\"SignInController\" method=\"post\">\r\n");
      out.write("                     <div class=\"form-floating sm-3\">\r\n");
      out.write("                         <label for=\"floatingInput\">Email address</label>\r\n");
      out.write("                         <input type=\"email\" class=\"form-control\" id=\"floatingInput\" placeholder=\"name@example.com\" name=\"Email\" required>           \r\n");
      out.write("                    </div>\r\n");
      out.write("                     \r\n");
      out.write("                    <div class=\"form-floating\">\r\n");
      out.write("                        <label for=\"floatingPassword\">Password</label>\r\n");
      out.write("                      <input type=\"password\" class=\"form-control\" id=\"floatingPassword\" placeholder=\"Password\" name=\"password\" required>  \r\n");
      out.write("                    </div>    \r\n");
      out.write("                         <br>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                         <br>\r\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-primary\">Login</button> Dont have an account yet? \r\n");
      out.write("                           <a href=\"register.html\"><button type=\"button\" class=\"btn btn-danger\" >Sign Up</button></a>\r\n");
      out.write("                     </form>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("              <div class=\"col\"></div>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("      </main>\r\n");
      out.write("\r\n");
      out.write("      <footer class=\"container\">\r\n");
      out.write("         <br />\r\n");
      out.write("        \r\n");
      out.write("      </footer>\r\n");
      out.write("      \r\n");
      out.write("      <script src=\"js/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("      <script src=\"js/popper.min.js\"></script>      \r\n");
      out.write("      <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("   </body>   \r\n");
      out.write("   \r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        $(\"#loginForm\").validate({\r\n");
      out.write("            rules: {\r\n");
      out.write("                email: {\r\n");
      out.write("                    required: true,\r\n");
      out.write("                    email: true\r\n");
      out.write("                },\r\n");
      out.write("         \r\n");
      out.write("                password: \"required\"\r\n");
      out.write("            },\r\n");
      out.write("             \r\n");
      out.write("            messages: {\r\n");
      out.write("                email: {\r\n");
      out.write("                    required: \"Please enter email\",\r\n");
      out.write("                    email: \"Please enter a valid email address\"\r\n");
      out.write("                },\r\n");
      out.write("                 \r\n");
      out.write("                password: \"Please enter password\"\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write(" \r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
