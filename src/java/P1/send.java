package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "send", urlPatterns = {"/send"})
public class send extends HttpServlet {
/*    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {            
            out.close();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  //      processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String str=request.getParameter("t1");
        HttpSession s=request.getSession(true);
        UchatDb ob=new UchatDb();
        boolean b=ob.chkonlyn((String)s.getAttribute("chatwith"));
        ob.insertMsg((String)s.getAttribute("current"),(String)s.getAttribute("chatwith"),str,b);
        response.sendRedirect("chatroom.jsp"); 
    //    processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
