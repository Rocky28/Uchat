/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;
import java.util.HashMap;
/**
 *
 * @author rocky
 */
import java.sql.*;
public class PrepChats 
{
    private HashMap prep = new HashMap();
    UchatDb ob=new UchatDb();
    PreparedStatement ps;
    ResultSet rs;

    public HashMap getPrepchats(String em,String em1) {
        try{
           ps=ob.db.prepareStatement("select * from chats where (sender_email_id=? or sender_email_id=?) and (reciever_email_id=? or reciever_email_id=?) order by dnt desc");
           ps.setString(1, em.trim());
           ps.setString(2, em1.trim());
           ps.setString(3, em.trim());
           ps.setString(4, em1.trim());
           rs=ps.executeQuery();
           int i=1;
           while(rs.next())
           {
               String semid = rs.getString("sender_email_id");
               String remid = rs.getString("reciever_email_id");
               String chtmsg = rs.getString("msg");
               String datentime = rs.getString("dnt");
               prep.put(i, new Prepput(semid, remid, chtmsg, datentime));
               i++;
           }
      }catch(Exception e){System.out.println(e);}
      
        return prep;
    }

    public PrepChats() {
        
    }
    
}
