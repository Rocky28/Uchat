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


@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class signup extends HttpServlet {
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
        String fname=request.getParameter("firstname"),lname=request.getParameter("lastname"),em=request.getParameter("email"),phn=request.getParameter("phn"),dob=request.getParameter("dob"),sex=request.getParameter("sex"),pass=request.getParameter("password"),cpass=request.getParameter("confirm"),country=request.getParameter("country");
        if(pass.equals(cpass))
        {
            ob.insertDetails(fname, lname, em, phn, dob, sex, pass, country);
            s.setAttribute("fname", fname);
            s.setAttribute("current", em);
            ob.insertDetOnline(em);   
            response.sendRedirect("home.jsp");
            
        }
    //    processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
