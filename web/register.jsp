<%-- 
    Document   : Register
    Created on : Jun 24, 2021, 2:37:44 PM
    Author     : ayoma
--%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
        
        <title>User Registration</title>
    </head>
    <body style="margin-top: 5%;">
        <div class="container">
            
                 <img class="avatar" src="img/user1.png">
                
                    <form action="register" method="post" style="margin-top: 0%;">
                        <div class="panel panel-body login-form">
                            <div class="text-center">
                                <div class="title">New User Registration</div>
                            </div>
                            <br>
                            <div>First Name</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="text" class="form-control" minlength="2" maxlength="40" id="fname" name="fname" placeholder="First Name"  required="true">
                            </div>
                            
                            <div>Middle Name</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="text" class="form-control" id="mname" name="mname" placeholder="Middle Name">
                            </div>
                            <div>Sur/Last Name</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="text" class="form-control" id="lname" name="lname" minlength="2" maxlength="40" placeholder="Last/Sur Name"  required="true">
                            </div>
                            <div>Email Address</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="email" class="form-control" minlength="17" maxlength="50" id="email" name="email" placeholder="Organizational Email Address"  required="true">
                            </div>
                            <div>Phone Number</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="text" class="form-control"minlength="10" maxlength="10" id="phone" name="phone" maxlength="10" placeholder="Phone Number" onkeypress='return numbers(event)' required="true"> 
                            </div>
                            <div>Password</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="password" class="form-control" minlength="3" maxlength="20" oninput="checkPasswords()" id="pass1" name="pass1" placeholder="Password"  required="true" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 5 or more characters">
                            </div>
                            <div>Repeat Password</div>
                            <div  class="form-group has-feedback has-feedback-left">
                                <input type="password" class="form-control" id="pass2" minlength="3" oninput="checkPasswords()" maxlength="20" name="pass2" placeholder="Repeat Password" required="true" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 5 or more characters">
                            </div>
                            
                            <div class="form-group" style="width: 100%;">
                                <button type="submit" class="btn btn-primary btn-block">Register User </button>
                            </div>
                            
                        </div>
                    </form>
                <div class="form-group login-options">
                    <b>Already have an Account?</b><span> <a href="index.jsp"><b>Login Here</b></a></span>
                    <br style="margin-top:2px;">  
                </div>
                
         
            
        </div>
        
        
        <%
                    Calendar cal = Calendar.getInstance();  
                    int year= cal.get(Calendar.YEAR);    
                                            
                %> 
           
            <div class="footer text-muted text-center">
                    <p align="center"> &copy <a href="#" title="Version 0.1">Medora</a> MEDORA, health <%=year%></p>
                </div>
                <br>
                 <%
                     try{
                         if(session.getAttribute("message")!=null){
                             String mess =session.getAttribute("message").toString();
                             out.print(mess);
                         }else{
                             session.removeAttribute("message");
                         }
                         
                     }catch(Exception e){
                         out.print(e.getMessage());
                         
                     }
                 %>
             
               
                
    </body>
     <script type="text/javascript" language="en">
   function numbers(evt){
var charCode=(evt.which) ? evt.which : event.keyCode
if(charCode > 31 && (charCode < 48 || charCode>57))
return false;
return true;
}
//-->
</script>
 <script type="text/javascript">
    
            function checkPasswords() {
                var password = document.getElementById('pass1');
                var conf_password = document.getElementById('pass2');

                if (password.value != conf_password.value) {
                    conf_password.setCustomValidity('Passwords do not match');
                } else {
                    conf_password.setCustomValidity('');
                }
                
          
        
            }
    
    </script>
</html>
