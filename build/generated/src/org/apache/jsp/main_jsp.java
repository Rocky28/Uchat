package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Uchat</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"main.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <h1>Uchat</h1>\r\n");
      out.write("            <div id=\"signin\">\r\n");
      out.write("                <form name=\"frm1\" action=\"login\" method=\"post\">\r\n");
      out.write("                    <table>\r\n");
      out.write("                        <tr><td><input type=\"text\" name=\"name\" placeholder=\"Email-Id\"></td><td><input type=\"password\" name=\"pass\" placeholder=\"Password\"></td></tr>\r\n");
      out.write("                        <tr><td><input type=\"submit\" name=\"s1\" value=\"Login\"></td><td><a href=\"\">Forgot Password</a></td></tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    \r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"sitemap\">\r\n");
      out.write("            <img src=\"uchat.png\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"signup\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("    <section class=\"register\">\r\n");
      out.write("      <h1>Register on Uchat</h1>\r\n");
      out.write("      <form method=\"post\" action=\"signup\">\r\n");
      out.write("      <div class=\"reg_section personal_info\">\r\n");
      out.write("      <h3>Your Personal Information</h3>\r\n");
      out.write("      <input type=\"text\" name=\"firstname\" value=\"\" placeholder=\"Firstname\">\r\n");
      out.write("      <input type=\"text\" name=\"lastname\" value=\"\" placeholder=\"Lastname\">\r\n");
      out.write("      <input type=\"text\" name=\"email\" value=\"\" placeholder=\"E-mail Address\">\r\n");
      out.write("      <input type=\"text\" name=\"phn\" value=\"\" placeholder=\"Phone Number\">\r\n");
      out.write("      <input type=\"text\" name=\"dob\" value=\"\" placeholder=\"Date of Birth\">\r\n");
      out.write("      <input type=\"text\" name=\"sex\" value=\"\" placeholder=\"Sex\">\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"reg_section password\">\r\n");
      out.write("      <h3>Your Password</h3>\r\n");
      out.write("      <input type=\"password\" name=\"password\" value=\"\" placeholder=\"Your Password\">\r\n");
      out.write("      <input type=\"password\" name=\"confirm\" value=\"\" placeholder=\"Confirm Password\">\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"reg_section password\">\r\n");
      out.write("      <h3>Your Country</h3>\r\n");
      out.write("      <select name=\"country\">\r\n");
      out.write("        <option value=\"India\">India</option>\r\n");
      out.write("        <option value=\"USA\">Usa</option>\r\n");
      out.write("        <option value=\"UK\">Uk</option>\r\n");
      out.write("      </select>\r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write("      <p class=\"terms\">\r\n");
      out.write("        <label>\r\n");
      out.write("          \r\n");
      out.write("           I accept  <a href=\"\">Uchat</a>Terms & Condition\r\n");
      out.write("        </label>\r\n");
      out.write("      </p>\r\n");
      out.write("      <p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Sign Up\"></p>\r\n");
      out.write("      </form>\r\n");
      out.write("    </section>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("    </body>\r\n");
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
}
