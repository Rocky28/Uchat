/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author rocky
 */
@WebServlet(name = "allchats", urlPatterns = {"/allchats"})
public class allchats extends HttpServlet {

    private PrepChats compData = new PrepChats();
    private HashMap composers = null;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet allchats</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allchats at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession(true);
        String email1 = (String) s.getAttribute("current");
        String em1 = (String) s.getAttribute("chatwith");
        composers = compData.getPrepchats(email1, em1);
        String action = request.getParameter("action");
       // System.out.println("I'm in allchats");
        StringBuffer sb = new StringBuffer();
        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            Iterator it = composers.keySet().iterator();
            while (it.hasNext()) 
            {
                int id =  (Integer)it.next();
                Prepput composer = (Prepput) composers.get(id);
                sb.append("<composer>");
                sb.append("<requester>" + email1 + "</requester>");
                sb.append("<senderemail>" + composer.getsenderemail() + "</senderemail>");
                sb.append("<recieveremail>" + composer.getrecieveemail() + "</recieveremail>");
                sb.append("<msg>" + composer.getmsg() + "</msg>");
                sb.append("<dnt>" + composer.getDnt() + "</dnt>");
                sb.append("</composer>");
                namesAdded = true;
            }
            if (namesAdded) 
            {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
                //System.out.println(sb.toString());
            } 
            else 
            {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }
        if (action.equals("lookup")) {
            // put the target composer in the request scope to display 
            System.out.println(response);
            context.getRequestDispatcher("/chatroom.jsp").forward(request, response);
        }
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
