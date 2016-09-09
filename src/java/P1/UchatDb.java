package P1;

import java.sql.*;
import java.util.Date;

public class UchatDb 
{
    Connection db;
    PreparedStatement ps;
    ResultSet rs,rs1,rs2;
    public UchatDb()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            db=DriverManager.getConnection("jdbc:ucanaccess://C:/Users/rocky/Documents/GitHub/Uchat/Uchat.accdb");
        }
        catch(Exception e1)
        {
            System.out.println(e1.toString());
        }
    }
    
    public void insertDetails(String fname,String lname, String em, String phn, String dob, String sex, String pass, String country)
    {
        int r=0;
        try{
            ps=db.prepareStatement("insert into signup(firstname,lastname,emailaddress,phone,dob,sex,password,country) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, em);
            ps.setString(4, phn);
            ps.setString(5, dob);
            ps.setString(6, sex);
            ps.setString(7, pass);
            ps.setString(8, country);
            r=ps.executeUpdate();
        }catch(Exception e){}
    }
  public String findfrnz(String em,String req)
  {
      String str="";
      try{
          ps=db.prepareStatement("select emailaddress from signup where firstname=? or lastname=?");
          ps.setString(1, req);
          ps.setString(2, req);
          rs=ps.executeQuery();
          ps=db.prepareStatement("select friend from friends where emailaddress=?");
          ps.setString(1, em);
          ResultSet rs1=ps.executeQuery();
          if(rs1.next()){
          int c=0;
          String prevfrnz=rs1.getString(1),tempfrnz="";
          outer : while(rs.next())
          {
              String str1=rs.getString(1);
              inner : for(int i=0;i<prevfrnz.length();i++)
              {
                  if(prevfrnz.charAt(i)==',')
                  {
                      if(tempfrnz.equals(str1))
                      {
                          tempfrnz="";
                          continue outer;
                      }
                      tempfrnz="";
                      continue inner;
                  }
                  tempfrnz+=prevfrnz.charAt(i);
              }
              str+=str1+",";
          }}
          while(rs.next())
          {
              String temp=rs.getString(1);
              str+=temp+",";
          }
      }catch(Exception e){System.out.println(e);}
      if(str.equals(""))
      {
          return "No search results......";
      }
      return str;
  }
  public void addFrnz(String em,String frnzname)
  {
      try{
          frnzname=frnzname.trim();
          ps=db.prepareStatement("select friend from friends where emailaddress=?");
          ps.setString(1, em);
          rs=ps.executeQuery();
          boolean b=rs.next();
          if(b==false)
          {
              ps=db.prepareStatement("insert into friends(emailaddress,friend) values(?,?)");
              ps.setString(1, em);
              ps.setString(2, frnzname+",");
              int r=ps.executeUpdate();
          
          }
          else
          {
              String res=rs.getString(1);
              res+=frnzname+",";
              
              ps=db.prepareStatement("update friends set friend=? where emailaddress=?");
              ps.setString(1, res);
              ps.setString(2, em.trim());
              int r=ps.executeUpdate();
          }
          frnzname=frnzname.trim();
          ps=db.prepareStatement("select friend from friends where emailaddress=?");
          ps.setString(1, frnzname);
          rs2=ps.executeQuery();
          boolean b1=rs2.next();
          if(b1==false)
          {
              ps=db.prepareStatement("insert into friends(emailaddress,friend) values(?,?)");
              ps.setString(1, frnzname);
              ps.setString(2, em+",");
              int r=ps.executeUpdate();
          
          }
          else
          {
              String res=rs2.getString(1);
              res+=em+",";
              
              ps=db.prepareStatement("update friends set friend=? where emailaddress=?");
              ps.setString(1, res);
              ps.setString(2, frnzname);
              int r=ps.executeUpdate();
          }
          ps=db.prepareStatement("select * from pendingreq");
          rs1=ps.executeQuery();
          int count=0;
          String str="",str1="",newstr="",temp="";
          em=em.trim();
          while(rs1.next())
          {
             str=rs1.getString("emailaddress");
             str=str.trim();
             str1=rs1.getString("semailaddress");
             int c=0;
             b=false;
             System.out.println(em.length()+" ,"+str.length());
             for(int i=0;i<str.length();i++)
                    {
                       
                       if(str.charAt(i)==em.charAt(i))
                       {
                           
                           c++;
                       }
                       else
                       {
                           break;
                       }
                    }
                  System.out.println(c+","+str.length());
                  if(c==str.length())
                  {
                      b=true;
                  }
                  System.out.println(b);
             if(b)
             {
                 for(int i=0;i<str1.length();i++)
                 {
                     if(str1.charAt(i)==',')
                     {
                         if(frnzname.trim().equals(temp.trim()))
                         {
                             temp="";
                             continue;
                         }
                         else
                         {
                             temp=temp.trim();
                             newstr+=temp+",";
                             temp="";
                             continue;
                         }
                     }
                     temp+=str1.charAt(i);
                 }
                 System.out.println(str+em+newstr);
                 ps=db.prepareStatement("update pendingreq set semailaddress=? where emailaddress=?");
                 ps.setString(1, newstr);
                 ps.setString(2, em);
                 int r=ps.executeUpdate();
                 System.out.println(r);
             }
          }
      }catch(Exception e){System.out.println(e);}
  }
  
  public ResultSet getPMsg(String em)
  {
      ResultSet rs1=null;
      try{
          ps=db.prepareStatement("select pending,semailaddress from pendingmsg where emailaddress=?");
          ps.setString(1, em);
          rs=ps.executeQuery();
          
      }catch(Exception e){System.out.println(e);}
      return rs;
  }
  
  public String getPReq(String em)
  {
      String req="";
      try{
          ps=db.prepareStatement("select * from pendingreq");
          rs=ps.executeQuery();
          while(rs.next())
          {
            String str=rs.getString("emailaddress");
            str=str.trim();
            String str1=rs.getString("semailaddress");
            if(str.equals(em))
            {
                req+=str1;
            }
          }
          
      }catch(Exception e){System.out.println(e);}
      System.out.println(req);
      return req;
  }
  public boolean getPMsginfo(String em)
  {
      boolean b=false;
      try{
          ps=db.prepareStatement("select pending,semailaddress from pendingmsg where emailaddress=?");
          ps.setString(1, em);
          rs=ps.executeQuery();
          b=rs.next();
      }catch(Exception e){}
      return b;
  }
  
  public boolean getPReqinfo(String em)
  {
      try{
          ps=db.prepareStatement("select * from pendingreq");
          rs=ps.executeQuery();
          while(rs.next())
          {
            String str=rs.getString(1);
            str=str.trim();
            String str1=rs.getString(2);
            if(str.equals(em) && str1.charAt(0)!=' ' && str.charAt(1)==',')
            {
                return true;
            }
          }
      }catch(Exception e){}
      return false;
  }
  public ResultSet chckDet(String name)
  {
      try{
          ps=db.prepareStatement("select * from signup where emailaddress=?");
          ps.setString(1,name);
          rs=ps.executeQuery();
      }catch(Exception e){}
      return rs;
  }
  
  public String getPymk(String em)
  {
      String sugfrnz="";
      try{
          ps=db.prepareStatement("select friend from friends where emailaddress=?");
          ps.setString(1, em.trim());
          rs=ps.executeQuery();
          rs.next();
          String prevfrnz=rs.getString(1),tempfrnz="";
          System.out.println(prevfrnz);
          for(int i=0;i<prevfrnz.length();i++)
          {
              if(prevfrnz.charAt(i)==',')
              {
                  ps=db.prepareStatement("select friend from friends where emailaddress=?");
                  ps.setString(1, tempfrnz.trim());
                  rs1=ps.executeQuery();
                  rs1.next();
                  String frnzfrnz=rs1.getString(1),tempfrnz1="";
                  System.out.println(frnzfrnz);
                  for(int j=0;j<frnzfrnz.length();j++)
                  {
                    if(frnzfrnz.charAt(j)==',')
                    {
                        if(tempfrnz1.trim().equals(em.trim()))
                        {
                            System.out.println(tempfrnz1);
                            tempfrnz1="";
                            continue;
                        }
                        else
                        {
                            String tempfrnz2="";
                            int c=0;
                            for(int k=0;k<prevfrnz.length();k++)
                            {
                                if(prevfrnz.charAt(k)==',')
                                {
                                    System.out.println(tempfrnz1+tempfrnz2);
                                    if(tempfrnz1.trim().equals(tempfrnz2.trim()))
                                    {
                                        tempfrnz2="";
                                        c++;
                                        continue;
                                    }
                                    tempfrnz2="";
                                    continue;
                                }
                                tempfrnz2+=prevfrnz.charAt(k);
                            }
                            if(c==0)
                            {
                                sugfrnz+=tempfrnz1+",";
                            }
                        }
                        tempfrnz1="";
                        continue;
                    }
                    tempfrnz1+=frnzfrnz.charAt(j);
                  }
                  tempfrnz="";
                  continue;
              }
              tempfrnz+=prevfrnz.charAt(i);
          }
      }catch(Exception e){System.out.println(e);}
      if(sugfrnz.equals(""))
      {
          return null;
      }
      return sugfrnz;
  }
  
  public void addReq(String em,String frnz)
  {
      int r=0;
      try{
          ps=db.prepareStatement("select * from pendingreq");
          rs=ps.executeQuery();
          while(rs.next())
          {
              String str=rs.getString("emailaddress"),str1;
              System.out.println(str+frnz);
              if(str.trim().equals(frnz.trim()))
              {
                  str1=rs.getString("semailaddress");
                  str1+=em+",";
                  System.out.println(str1);
                  ps=db.prepareStatement("update pendingreq set semailaddress=? where emailaddress=?");
                  ps.setString(1, str1);
                  ps.setString(2, frnz.trim());
                  r=ps.executeUpdate();
                  System.out.println(r);
              }
          }
          if(r==0)
          {
              ps=db.prepareStatement("insert into pendingreq(emailaddress,semailaddress) values(?,?)");
                  ps.setString(1,frnz.trim());
                  ps.setString(2,em.trim()+",");
                  ps.executeUpdate();
          }
      }catch(Exception e){System.out.println(e);}
  }
  
  public String chckforreq(String em,String frnd)
  {
      try{
          ps=db.prepareStatement("select * from pendingreq");
          rs=ps.executeQuery();
          boolean b=false;
          while(rs.next())
          {
              String temp1=rs.getString(1);
              String temp2=rs.getString(2),temp3="";
              
              if(temp1.trim().compareTo(frnd.trim())==0)
              {
                  temp2=temp2.trim();
                  em=em.trim();
                  
                  for(int j=0;j<temp2.length();j++)
                  {
                      if(temp2.charAt(j)==',')
                      {
                          temp3=temp3.trim();
                          int c=0;
                           for(int i=0;i<temp3.length();i++)
                           {
                                
                                if(temp3.charAt(i)==em.charAt(i))
                                {
                                    c++;
                                }                     
                           }
                           System.out.println(c+","+temp3.length());
                           if(c==temp3.length())
                             {
                                 b=true;
                                 break;
                             }
                      }
                      temp3+=temp2.charAt(j);
                  }
                    
              }
          }
          System.out.println(b);
          if(b)
          {
              return "Request";
          }
          else
          {
              System.out.println(em);
              ps=db.prepareStatement("select friend from friends where emailaddress=?");
              ps.setString(1, em);
              rs1=ps.executeQuery();
              String tempfrnd="";
              if(rs1.next())
              {
                  String prevfrnz=rs1.getString(1);
                  System.out.println(prevfrnz);
                  for(int i=0;i<prevfrnz.length();i++)
                  {
                      if(prevfrnz.charAt(i)==',')
                      {
                          if(frnd.equals(tempfrnd))
                          {
                              System.out.println("F");
                              return "Friend";
                          }
                          else
                          {
                              tempfrnd="";
                              continue;
                          }
                      }
                      tempfrnd+=prevfrnz.charAt(i);
                  }
                  System.out.println("U");
                  return "Unknown";
              }
              else
              {
                  System.out.println("U");
                  return "Unknown";
              }
          }       
      }catch(Exception e){}
      return "Unknown";
  }
  public void insertDetOnline(String em)
  {
      Date dt=new Date();
      String newdate=dt.toString(),allres="";
      try{
          ps=db.prepareStatement("insert into online(emailaddress,dnt) values(?,?)");
          ps.setString(1, em.trim());
          ps.setString(2, newdate);
          ps.executeUpdate();
      }catch(Exception e){}
  }
  public String getOn(String em)
  {
      
      String allres="";
      try{
          ps=db.prepareStatement("select friend from friends where emailaddress=?");
          ps.setString(1, em.trim());
          rs=ps.executeQuery();
          rs.next();
          String frnz=rs.getString(1);
          System.out.println(frnz);
          ps=db.prepareStatement("select * from online where emailaddress<>?");
          ps.setString(1, em.trim());
          rs1=ps.executeQuery();
          while(rs1.next())
          {
              String email=rs1.getString("emailaddress"),temp="";
              String dnt=rs1.getString("dnt");
              System.out.println(email+dnt);
              for(int i=0;i<frnz.length();i++)
              {
                  if(frnz.charAt(i)==',')
                  {
                      if(temp.trim().equals(email.trim()))
                      {
                          allres+=temp.trim()+",";
                          temp="";
                          continue;
                      }
                      temp="";
                      continue;
                  }
                  temp+=frnz.charAt(i);
              }
          }
          System.out.println(allres);
      }catch(Exception e){}
      return allres;
  }
  public void addUpdate(String em,String str)
  {
      Date ob=new Date();
      String newdate=ob.toString();
      try{
              
              ps=db.prepareStatement("insert into status(emailaddress,statusup,dnt,lyk,share) values(?,?,?,?,?)");
              ps.setString(1, em);
              ps.setString(2, str);
              ps.setString(3, newdate);
              ps.setInt(4,0);
              ps.setInt(5,0);
              ps.executeUpdate();
          
      }catch(Exception e){System.out.println(e);}
  }
  
  public ResultSet getFrnzUpdates()
  {
      try{
          ps=db.prepareStatement("select * from status",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          rs=ps.executeQuery();      
          
      }catch(Exception e){System.out.println(e);}
      return rs;
  }
  
  public String getMyFrnz(String em)
  {
      String res="";
      try{ 
          String sql="select friend from friends where emailaddress=?";
          ps=db.prepareStatement(sql);
          ps.setString(1,em);
          rs=ps.executeQuery();
          rs.next();
          res=rs.getString(1)+em.trim()+",";
          System.out.println(res);
      }catch(Exception e){}
      return res;
  }
  public String getFullName(String em,int id)
  {
      String fullname="";
      try{
          ps=db.prepareStatement("select firstname,lastname from signup where emailaddress=?");
          ps.setString(1, em);
          rs=ps.executeQuery();
          rs.next();
          fullname=rs.getString(1)+" "+rs.getString(2);
      }catch(Exception e){}
      System.out.println("id"+id);
      return fullname;
  }
  public void incLike(int id)
  {
      try{
          ps=db.prepareStatement("select lyk from status where id=?");
          ps.setInt(1, id);
          rs=ps.executeQuery();
          rs.next();
          int like=rs.getInt(1);
          like++;
          ps=db.prepareStatement("update status set lyk=? where id=?");
          ps.setInt(1, like);
          ps.setInt(2, id);
          ps.executeUpdate();
      }catch(Exception e){}
  }
  public void incShare(int id)
  {
      try{
          ps=db.prepareStatement("select share from status where id=?");
          ps.setInt(1, id);
          rs=ps.executeQuery();
          rs.next();
          int share=rs.getInt(1);
          share++;
          ps=db.prepareStatement("update status set share=? where id=?");
          ps.setInt(1, share);
          ps.setInt(2, id);
          ps.executeUpdate();
      }catch(Exception e){}
  }
  public void addShare(String em,int id)
  {
      Date ob=new Date();
      String newdate=ob.toString();
      try{
              String strid="#@$%id"+id;
              ps=db.prepareStatement("insert into status(emailaddress,statusup,dnt,lyk,share) values(?,?,?,?,?)");
              ps.setString(1, em);
              ps.setString(2, strid);
              ps.setString(3, newdate);
              ps.setInt(4,0);
              ps.setInt(5,0);
              ps.executeUpdate();
          
      }catch(Exception e){System.out.println(e);}
  }
  public void addComnt(int id,String comnt,String em)
  {
      try{
          ps=db.prepareStatement("insert into comment(emailaddress,updateid,comnt) values(?,?,?)");
          ps.setString(1, em);
          ps.setInt(2, id);
          ps.setString(3, comnt);
          ps.executeUpdate();
      }catch(Exception e){}
  }
  
  public ResultSet getIdDet(int id)
  {
      try{
          ps=db.prepareStatement("select * from status where id=?");
          ps.setInt(1, id);
          rs=ps.executeQuery();
      }catch(Exception e){}
      return rs;
  }
  public ResultSet getComment(int id)
  {
      try{
          ps=db.prepareStatement("select * from comment where updateid=?");
          ps.setInt(1, id);
          rs=ps.executeQuery();
      }catch(Exception e){}
      return rs;
  }
  
  public ResultSet getMsgs(String em,String em1)
  {
      try{
          ps=db.prepareStatement("select * from chats where (sender_email_id=? or sender_email_id=?) and (reciever_email_id=? or reciever_email_id=?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          ps.setString(1, em.trim());
          ps.setString(2, em1.trim());
          ps.setString(3, em.trim());
          ps.setString(4, em1.trim());
          rs=ps.executeQuery();
      }catch(Exception e){System.out.println(e);}
      return rs;
  }
  
  public void insertMsg(String em,String em1,String str,boolean b)
  {
      Date ob=new Date();
      String dt=ob.toString();
      try{
          ps=db.prepareStatement("insert into chats(sender_email_id,reciever_email_id,msg,dnt,check_msg) values(?,?,?,?,?)");
          ps.setString(1, em.trim());
          ps.setString(2, em1.trim());
          ps.setString(3, str.trim());
          ps.setString(4, dt);
          ps.setString(5,"UNREAD");
          ps.executeUpdate();
          if(b==false)
          {
              ps=db.prepareStatement("select pending from pendingmsg where emailaddress=? and semailaddress=?");
              ps.setString(1, em1.trim());
              ps.setString(2, em.trim());
              rs=ps.executeQuery();
              if(rs.next())
              {
                  int count=rs.getInt(1);
                  count++;
                  ps=db.prepareStatement("update set pending=? where emailaddress=? and semailaddress=?");
                  ps.setInt(1, count);
                  ps.setString(2, em1.trim());
                  ps.setString(3, em.trim());
                  ps.executeUpdate();       
              }
              else
              {
                  ps=db.prepareStatement("insert into pendingmsg(emailaddress,pending,semailaddress) values(?,?,?)");
                  ps.setString(1, em1.trim());
                  ps.setInt(2, 1);
                  ps.setString(3, em.trim());
                  ps.executeUpdate();
              }
          }
      }catch(Exception e){}
  }
  public boolean chkonlyn(String em)
  {
      boolean b=false;
      try{
          String sql="select * from online where emailaddress=?";
          ps=db.prepareStatement(sql);
          ps.setString(1, em.trim());
          rs=ps.executeQuery();
          while(rs.next())
          { 
              b=true;
              break;
          }
      }catch(Exception e){System.out.println(e);}
      System.out.println(b);
      return b;
  }
  public boolean checkfornewmsg(String email)
  {
      boolean b=false;
      String chkstat="";
      try{
          String sql="select check_msg from chats where reciever_email_id=?";
          ps=db.prepareStatement(sql);
          ps.setString(1, email);
          rs=ps.executeQuery();
          while(rs.next())
          {
             chkstat=rs.getString(1);
             if(chkstat.equals("READ"))
             {
                 continue;
             }
             else
             {
                 return true;
             }
          }
          
      }catch(Exception e){System.out.println(e);}
      return b;
  }
  public void markallread(String em)
  {
      try{
          String sql="update chats set check_msg='READ' where reciever_email_id=? and check_msg='UNREAD'";
          ps=db.prepareStatement(sql);
          ps.setString(1, em);
          ps.executeUpdate();
      }catch(Exception e){}
  }
}
