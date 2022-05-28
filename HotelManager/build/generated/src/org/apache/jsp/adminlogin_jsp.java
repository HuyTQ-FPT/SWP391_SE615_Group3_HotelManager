package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("  \t<title>Login Admin</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\t\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style_1.css\">\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\t<body class=\"img js-fullheight\" style=\"background-image: url(img/bg.jpg);\">\n");
      out.write("\t<section class=\"ftco-section\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row justify-content-center\">\n");
      out.write("\t\t\t\t<div class=\"col-md-6 text-center mb-5\">\n");
      out.write("\t\t\t\t\t<h2 class=\"heading-section\">Login Admin</h2>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row justify-content-center\">\n");
      out.write("\t\t\t\t<div class=\"col-md-6 col-lg-4\">\n");
      out.write("\t\t\t\t\t<div class=\"login-wrap p-0\">\n");
      out.write("\t\t      \t<h3 class=\"mb-4 text-center\">Have an account?</h3>\n");
      out.write("                        <form action=\"ControllerLogin_Admin?do=CheckLogin\" class=\"signin-form\" method=\"post\">\n");
      out.write("\t\t      \t\t<div class=\"form-group\">\n");
      out.write("                                    <input name=\"username\" type=\"text\" class=\"form-control\" placeholder=\"Username\" required>\n");
      out.write("\t\t      \t\t</div>\n");
      out.write("\t            <div class=\"form-group\">\n");
      out.write("                        <input id=\"password-field\" name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"Password\" required>\n");
      out.write("\t              <span toggle=\"#password-field\" class=\"fa fa-fw fa-eye field-icon toggle-password\"></span>\n");
      out.write("\t            </div>\n");
      out.write("                             <h4 id=\"er\" style=\"color: red;font-size: 15px; position: fixed;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("                            <br>\n");
      out.write("                   \n");
      out.write("\t            <div class=\"form-group\">\n");
      out.write("\t            \t<button type=\"submit\" class=\"form-control btn btn-primary submit px-3\">Sign In</button>\n");
      out.write("\t            </div>\n");
      out.write("\t            <div class=\"form-group d-md-flex\">\n");
      out.write("\t            \t<div class=\"w-50\">\n");
      out.write("\t\t            \t<label class=\"checkbox-wrap checkbox-primary\">Remember Me\n");
      out.write("\t\t\t\t\t\t\t\t\t  <input type=\"checkbox\" checked>\n");
      out.write("\t\t\t\t\t\t\t\t\t  <span class=\"checkmark\"></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"w-50 text-md-right\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\" style=\"color: #fff\">Forgot Password</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t            </div>\n");
      out.write("\t          </form>\n");
      out.write("\t          <!--<p class=\"w-100 text-center\">&mdash; Or Sign In With &mdash;</p>-->\n");
      out.write("<!--\t          <div class=\"social d-flex text-center\">\n");
      out.write("\t          \t<a href=\"#\" class=\"px-2 py-2 mr-md-1 rounded\"><span class=\"ion-logo-facebook mr-2\"></span> Facebook</a>\n");
      out.write("\t          \t<a href=\"#\" class=\"px-2 py-2 ml-md-1 rounded\"><span class=\"ion-logo-twitter mr-2\"></span> Twitter</a>\n");
      out.write("\t          </div>-->\n");
      out.write("\t\t      </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("\n");
      out.write("\t<script src=\"js/jquery.min.js\"></script>\n");
      out.write("  <script src=\"js/popper_1.js\"></script>\n");
      out.write("  <script src=\"js/bootstrap.min_1.js\"></script>\n");
      out.write("  <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
