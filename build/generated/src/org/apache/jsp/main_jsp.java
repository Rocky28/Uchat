package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Uchat</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"main.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1>Uchat</h1>\n");
      out.write("            <div id=\"signin\">\n");
      out.write("                <form name=\"frm1\" action=\"login\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr><td><input type=\"text\" name=\"name\" placeholder=\"Email-Id\"></td><td><input type=\"password\" name=\"pass\" placeholder=\"Password\"></td></tr>\n");
      out.write("                        <tr><td><input type=\"submit\" name=\"s1\" value=\"Login\"></td><td><a href=\"\">Forgot Password</a></td></tr>\n");
      out.write("                    </table>\n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"sitemap\">\n");
      out.write("            <img src=\"uchat.png\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"signup\">\n");
      out.write("            \n");
      out.write("            <div class=\"container\">\n");
      out.write("    <section class=\"register\">\n");
      out.write("      <h1>Register on Uchat</h1>\n");
      out.write("      <form method=\"post\" action=\"signup\">\n");
      out.write("      <div class=\"reg_section personal_info\">\n");
      out.write("      <h3>Your Personal Information</h3>\n");
      out.write("      <input type=\"text\" name=\"firstname\" value=\"\" placeholder=\"Firstname\">\n");
      out.write("      <input type=\"text\" name=\"lastname\" value=\"\" placeholder=\"Lastname\">\n");
      out.write("      <input type=\"text\" name=\"email\" value=\"\" placeholder=\"E-mail Address\">\n");
      out.write("      <input type=\"text\" name=\"phn\" value=\"\" placeholder=\"Phone Number\">\n");
      out.write("      <input type=\"text\" name=\"dob\" value=\"\" placeholder=\"Date of Birth\">\n");
      out.write("      <input type=\"text\" name=\"sex\" value=\"\" placeholder=\"Sex\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"reg_section password\">\n");
      out.write("      <h3>Your Password</h3>\n");
      out.write("      <input type=\"password\" name=\"password\" value=\"\" placeholder=\"Your Password\">\n");
      out.write("      <input type=\"password\" name=\"confirm\" value=\"\" placeholder=\"Confirm Password\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"reg_section password\">\n");
      out.write("      <h3>Your Country</h3>\n");
      out.write("      <select name=\"country\">\n");
      out.write("        <option value=\"India\">India</option>\n");
      out.write("        <option value=\"USA\">Usa</option>\n");
      out.write("        <option value=\"UK\">Uk</option>\n");
      out.write("      </select>\n");
      out.write("      \n");
      out.write("      </div>\n");
      out.write("      <p class=\"terms\">\n");
      out.write("        <label>\n");
      out.write("          \n");
      out.write("           I accept  <a href=\"\">Uchat</a>Terms & Condition\n");
      out.write("        </label>\n");
      out.write("      </p>\n");
      out.write("      <p class=\"submit\"><input type=\"submit\" name=\"commit\" value=\"Sign Up\"></p>\n");
      out.write("      </form>\n");
      out.write("    </section>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("    </body>\n");
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
