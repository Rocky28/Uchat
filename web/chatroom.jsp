<%@page import="java.sql.ResultSet"%>
<%@page import="P1.UchatDb"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="chatroom.css" type="text/css" media="screen" />
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
        <li><a href="#">Pending</a></li>
        <li><a href="#">Chat</a></li>
        <li><a href="#">Latest Update</a></li>
        <li><a href="#">Account Settings</a></li>
        <li><a href="#">Feedback</a></li>
        <li><a href="#">Contact Us</a></li>
        </ul>
    </div>
        
        <div id="chatmsgs">
           <form name="frm" action="send" method="post">
           <p>You are chatting with <% String wd=(String)s.getAttribute("chatwith");out.print(wd); %></p>
           <input type="text" name="t1" placeholder="Type your message here.....">
           <input type="submit" value="Send">
           </form>
       </div>

      <div id="pmsgs">
          <% UchatDb ob=new UchatDb(); ResultSet rs=ob.getMsgs((String)s.getAttribute("current"), (String)s.getAttribute("chatwith")); rs.afterLast();while(rs.previous()){ String myem=(String)s.getAttribute("current"); String em=rs.getString(1); String em1=rs.getString(2); if(em.trim().equals(myem.trim())){ %>
          <div id="mysyd"><p><% out.println(rs.getString(3)); %></p></div><br><br><% }else{ %>
          <div id="nmysyd"><p><% out.println(rs.getString(3)); %></p></div><br><br><% }} %>
      </div>

       

    </body>
</html>

    