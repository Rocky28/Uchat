<%-- 
    Document   : chatmsgframe
    Created on : Aug 15, 2016, 10:17:28 PM
    Author     : rocky
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="P1.UchatDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="chatroom.css" type="text/css" media="screen" />
        
        <title>JSP Page</title>
    </head>
    <body><% HttpSession s=request.getSession(true); %>
        <div id="pmsgs">
          <% UchatDb ob=new UchatDb();ob.markallread((String)s.getAttribute("current")); ResultSet rs=ob.getMsgs((String)s.getAttribute("current"), (String)s.getAttribute("chatwith")); rs.afterLast();while(rs.previous()){ String myem=(String)s.getAttribute("current"); String em=rs.getString("sender_email_id"); String em1=rs.getString("reciever_email_id"); if(em.trim().equals(myem.trim())){ %>
          <div id="mysyd"><p><% out.println(rs.getString("msg")); %></p></div><br><br><% }else{ %>
          <div id="nmysyd"><p><% out.println(rs.getString("msg")); %></p></div><br><br><% }} %>
      </div>
    </body>
</html>
