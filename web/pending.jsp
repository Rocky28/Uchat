<%@page import="java.sql.ResultSet"%>
<%@page import="P1.UchatDb"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="pending.css" type="text/css" media="screen" />
    </head>
    <body>
        <div id="header">
            <h1>Uchat</h1>
            <div id="signout">
                <form name="frm1">
                    <table>
                        <tr><td><h2>Welcome <% HttpSession s=request.getSession(true); out.println((String)s.getAttribute("fname")); %></h2></td></tr>
                        <tr><td><input type="submit" name="s1" value="Logout"></td></tr>
                    </table>
                    
                </form>
            </div>
        </div>
        
        <div class="menu_div">
    	<ul>
        <li id="active"><a href="#">Home</a></li>
        <li><a href="#">Friends</a></li>
        <li><a href="#">Pending <% UchatDb ob=new UchatDb(); boolean b=ob.getPMsginfo((String)s.getAttribute("current")); boolean b1=ob.getPReqinfo((String)s.getAttribute("current"));if(b1==true || b==true){ %><img src="new-logo.jpg" width="20%" style="padding-left: 5px;"><% } %></a></li>
        <li><a href="#">Chat</a></li>
        <li><a href="#">Latest Update</a></li>
        <li><a href="#">Account Settings</a></li>
        <li><a href="#">Feedback</a></li>
        <li><a href="#">Contact Us</a></li>
        </ul>
    </div>
        
       <div id="pmsg">
           <p>Pending Messages</p><form method="post" action="seechatpage">
           <%  int c=0;try{ResultSet rs=ob.getPMsg((String)s.getAttribute("current")); while(rs.next()){ int temppending=rs.getInt(1); String from=rs.getString(2);c++;%>
           <input type="submit" name="s<% out.println(c); %>" value="<% out.println(from); %>"> <p id="p1"><% out.println(temppending); %> pending message(s)</p><% } }catch(Exception e){System.out.println(e);}%></form>
           <% if(c==0){%><p id="p2">There are no pending messages.........</p><% } %>
       </div>
        <div id="preq">
            <p>Pending Requests</p><form method="post" action="addpendingfriend">
                <% String from=""; c=0 ;try{String rs=ob.getPReq((String)s.getAttribute("current")); for(int i=0;i<rs.length();i++){ if(rs.charAt(i)==','){c++; if(from.trim().equals(",")){continue;} %>
                <input type="submit" name="<% out.print("p"+c); %>" value="<% out.println(from); %>"><p id="p4">Click to add as friend</p><% from="";continue;}from+=rs.charAt(i);}}catch(Exception e){System.out.println(e);} %></form>
           <% if(c==0){%><p id="p3">There are no pending requests.........</p><% } %>
        </div>

    </body>
</html>

    