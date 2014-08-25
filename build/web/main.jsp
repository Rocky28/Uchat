<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uchat</title>
        <link rel="stylesheet" href="main.css" type="text/css" media="screen" />
    </head>
    <body>
        <div id="header">
            <h1>Uchat</h1>
            <div id="signin">
                <form name="frm1" action="login" method="post">
                    <table>
                        <tr><td><input type="text" name="name" placeholder="Email-Id"></td><td><input type="password" name="pass" placeholder="Password"></td></tr>
                        <tr><td><input type="submit" name="s1" value="Login"></td><td><a href="">Forgot Password</a></td></tr>
                    </table>
                    
                </form>
            </div>
        </div>
        <div id="sitemap">
            <img src="uchat.png">
        </div>
        <div id="signup">
            
            <div class="container">
    <section class="register">
      <h1>Register on Uchat</h1>
      <form method="post" action="signup">
      <div class="reg_section personal_info">
      <h3>Your Personal Information</h3>
      <input type="text" name="firstname" value="" placeholder="Firstname">
      <input type="text" name="lastname" value="" placeholder="Lastname">
      <input type="text" name="email" value="" placeholder="E-mail Address">
      <input type="text" name="phn" value="" placeholder="Phone Number">
      <input type="text" name="dob" value="" placeholder="Date of Birth">
      <input type="text" name="sex" value="" placeholder="Sex">
      </div>
      <div class="reg_section password">
      <h3>Your Password</h3>
      <input type="password" name="password" value="" placeholder="Your Password">
      <input type="password" name="confirm" value="" placeholder="Confirm Password">
      </div>
      <div class="reg_section password">
      <h3>Your Country</h3>
      <select name="country">
        <option value="India">India</option>
        <option value="USA">Usa</option>
        <option value="UK">Uk</option>
      </select>
      
      </div>
      <p class="terms">
        <label>
          
           I accept  <a href="">Uchat</a>Terms & Condition
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Sign Up"></p>
      </form>
    </section>
  </div>

  
        </div>
        
      
    </body>
</html>
