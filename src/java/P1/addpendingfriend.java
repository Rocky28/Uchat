package P1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet(name = "addpendingfriend", urlPatterns = {"/addpendingfriend"})
public class addpendingfriend extends HttpServlet {
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
    //    processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        UchatDb ob=new UchatDb();
        String frnzname="";
        HttpSession s=request.getSession(true);
        for(int i=0;;i++)
        {
            frnzname=request.getParameter("p"+(i+1));
            
            if(frnzname.equals(null))
            {
                continue;
            }
            break;
        }
        try{
        ob.addFrnz((String)s.getAttribute("current"),frnzname);
        response.sendRedirect("pending.jsp");
        }catch(Exception e){System.out.println(e);}
    //    processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
