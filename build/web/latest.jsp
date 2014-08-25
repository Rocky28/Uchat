<%@page import="java.sql.ResultSet"%>
<%@page import="P1.UchatDb"%>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="latest.css" type="text/css" media="screen" />
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
        <div id="frnzupdates">
            <p id="j1">Latest Updates</p>
            <% try{UchatDb ob=new UchatDb(); ResultSet res=ob.getFrnzUpdates(); res.afterLast();String frnz=ob.getMyFrnz((String)s.getAttribute("current"));while(res.previous()){int id=res.getInt(1); String email=res.getString(2),temp="",msg=res.getString(3);for(int i=0;i<frnz.length();i++){ if(frnz.charAt(i)==','){ if(temp.trim().equals(email.trim())){ String fullname=ob.getFullName(temp.trim(),id); 
               msg=msg.trim();if(msg.charAt(0)=='#' && msg.charAt(1)=='@' && msg.charAt(2)=='$' && msg.charAt(3)=='%' && msg.charAt(4)=='i' && msg.charAt(5)=='d'){ String id1=""+msg.charAt(6)+msg.charAt(7); int intid=Integer.parseInt(id1); ResultSet rs=ob.getIdDet(intid); rs.next(); String email1=rs.getString(2); String fullname1=ob.getFullName(email1,id); %>
            <p id="j2"><% out.println(fullname); %> shared an update of <% out.println(fullname); %> at <% String ts=res.getString(4);out.println(ts); %></p><br>
            <p id="j3"><% out.println(rs.getString(3)); %></p><br><%  }else{  %>
            <p id="j2"><% out.println(fullname); %> posted an update at <% String ts=res.getString(4);out.println(ts); %></p><br>
            <p id="j3"><% out.println(msg); %></p><br><% } %>
            <div id="likebutton"><form action="like" method="post"><input id="like" type="submit" name="<% out.print("l"+id); %>" value="Like" ></form><p id="count1"><% out.print(res.getString(5)); %></p></div><div id="sharebutton"><form action="share" method="post"><input id="share" type="submit" name="<% out.print("s"+id); %>" value="Share"></form><p id="count2"><% out.print(res.getString(6)); %></p></div>
            <div id="commentbutton"><form action="comment" method="post"> <input id="textbox" type="text" name="t1" placeholder="Comment"> <input id="comnt" type="submit" name="<% out.print("c"+id); %>" value="Submit">
            <% ResultSet gtcomnt=ob.getComment(id);int c=0;while(gtcomnt.next()){ c++; String tempemail=gtcomnt.getString(1); String tempcommnt=gtcomnt.getString(3); %><p> <% out.print(tempemail); %> : <% out.print(tempcommnt); %></p><% }}temp="";continue;} temp+=frnz.charAt(i);} }}catch(Exception e){System.out.println(e);} %></form>
                                                                                                      </div>
            
        </div>
        
        
        
        

    </body>
</html>
