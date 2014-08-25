<%@page import="P1.UchatDb"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="home.css" type="text/css" media="screen" />
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
        <li id="active"><a href="home.jsp">Home</a></li>
        <li><a href="friends.jsp">Friends</a></li>
        <li><a href="pending.jsp">Pending</a></li>
        <li><a href="latest.jsp">Latest Updates</a></li>
        <li><a href="#">Account Settings</a></li>
        <li><a href="#">Feedback</a></li>
        <li><a href="#">Contact Us</a></li>
        </ul>
    </div>
        
        <div id ="status">
            <form method="post" action="supdate">
                <table>
                    <tr><td><input type="text" name="t1" placeholder="Status Update"></td></tr>
                    <tr><td><input type="submit" name="s1" value="Submit"></td></tr>
                </table>
                
            </form>
            
        </div>
        <div id="frnzstatus">
            <p id="j1">Friends Online</p><form method="post" action="chat">
            <% UchatDb ob=new UchatDb();String allres=ob.getOn((String)s.getAttribute("current")),temp="";int c=0; if(allres.equals("")){%><p id="j2">No Friends Online.........</p>
            <%} for(int i=0;i<allres.length();i++){if(allres.charAt(i)==','){c++;%><input type="submit" name="<% out.print("s"+c); %>" value="<% out.println(temp); %>"><p id="j3">Click to chat</p><br><% temp="";continue;}temp+=allres.charAt(i);}%></form>
        </div>
        
        
        
        

    </body>
</html>

    