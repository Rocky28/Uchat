package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {
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
        HttpSession s=request.getSession(true);
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        try{
        ResultSet b=ob.chckDet(name);
        if(b.next())
        {
            String fname=b.getString(1);
            String detpass=b.getString(7);
            if(pass.equals(detpass))
            {
               s.setAttribute("fname", fname);
               s.setAttribute("current", name);
               ob.insertDetOnline(name);
               response.sendRedirect("home.jsp");
            }
            response.sendRedirect("main.jsp");
        }
        }catch(Exception e){}
    //    processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
