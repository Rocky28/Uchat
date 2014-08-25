<%@page import="java.sql.ResultSet"%>
<%@page import="P1.UchatDb"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="friends.css" type="text/css" media="screen" />
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
        
       <div id="ffriends">
           <p>Find Friends</p>
           <form method="post" action="find">
               <input type="text" name="frnzname" placeholder="Search"><br>
               <input type="submit" value="Submit">
           </form>
       </div>
        <div id="pymk">
            <p>People You may know</p><form method="post" action="sendreq">
            <% int c=0;UchatDb ob=new UchatDb(); try{String rs=ob.getPymk((String)s.getAttribute("current")); String temp="";for(int i=0;i<rs.length();i++){if(rs.charAt(i)==','){c++;%>
            <input type="submit" name="<% out.println("s"+c); %>" value="<% out.println(temp); %>"><p id="p2">Click to add as friend</p><% }temp+=rs.charAt(i);}}catch(Exception e){%>
            <p id="p3">Nobody on your friends list is available</p><% } %></form>
        </div>

    </body>
</html>

    