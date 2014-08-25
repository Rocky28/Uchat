package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chatroom_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Uchat</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"chatroom.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1>Uchat</h1>\n");
      out.write("            <div id=\"signout\">\n");
      out.write("                <form name=\"frm1\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr><td><h2>Welcome Rocky</h2></td></tr>\n");
      out.write("                        <tr><td><input type=\"submit\" name=\"s1\" value=\"Logout\"></td></tr>\n");
      out.write("                    </table>\n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"menu_div\">\n");
      out.write("    \t<ul>\n");
      out.write("        <li id=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("        <li><a href=\"#\">Friends</a></li>\n");
      out.write("        <li><a href=\"#\">Pending</a></li>\n");
      out.write("        <li><a href=\"#\">Chat</a></li>\n");
      out.write("        <li><a href=\"#\">Latest Update</a></li>\n");
      out.write("        <li><a href=\"#\">Account Settings</a></li>\n");
      out.write("        <li><a href=\"#\">Feedback</a></li>\n");
      out.write("        <li><a href=\"#\">Contact Us</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("        <div id=\"chatmsgs\">\n");
      out.write("           <form name=\"frm\" action=\"send\" method=\"post\">\n");
      out.write("           <p>You are Chatting with</p>\n");
      out.write("           <input type=\"text\" name=\"t1\" placeholder=\"Type your message here.....\">\n");
      out.write("           <input type=\"submit\" value=\"Send\">\n");
      out.write("           </form>\n");
      out.write("       </div>\n");
      out.write("\n");
      out.write("<div id=\"pmsgs\">\n");
      out.write("         \n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    ");
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
