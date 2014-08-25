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
           <form>
               <input type="text" placeholder="Search"><br>
               <input type="submit" value="Submit">
           </form>
       </div>
        <div id="found">
            <p>People Found</p>
            <form action="sendreq" method="post"><% UchatDb ob=new UchatDb();int c=0;String tempname=""; String res=(String)s.getAttribute("search");if(res.equals("No search results......")){%><p id="p6">No search results......</p><%}else{ for(int i=0;i<res.length();i++){ if(res.charAt(i)==','){
                               String forreq=ob.chckforreq((String)s.getAttribute("current"),tempname);if(forreq.equals("Request")){%><p id="p7">You have already sent <% out.println(tempname); %> a Friend Request</p><%}else if(forreq.equals("Friend")){%><p id="p8">You have already added <% out.println(tempname); %> as a Friend</p><%} else{ c++;%> 
                <input type="submit" name="<% out.print("s"+c); %>" value="<% out.println(tempname); %>"><p id="p5">Click to send request to</p>
                <%tempname=""; continue;}}tempname+=res.charAt(i);}} %></form>
        </div> 
        

    </body>
</html>

    