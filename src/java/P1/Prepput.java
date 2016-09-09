/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package P1;

import java.util.Date;

/**
 *
 * @author rocky
 */
public class Prepput 
{
    private String senderemail;
    private String recieveemail;
    private String msg;
    private String dnt;

    public Prepput (String senderemail, String recieveemail, String msg, String dnt) {
        this.senderemail = senderemail;
        this.recieveemail = recieveemail;
        this.msg = msg;
        this.dnt = dnt;
    }

    public String getDnt() {
        return dnt;
    }

    public String getsenderemail() {
        return senderemail;
    }

    public String getrecieveemail() {
        return recieveemail;
    }

    public String getmsg() {
        return msg;
    }
    
}
