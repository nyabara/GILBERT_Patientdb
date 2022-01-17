<%-- 
    Document   : index
    Created on : Jun 24, 2021, 9:35:55 AM
    Author     : ayoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>

        <title>Gilbert Patient Report</title>
        
    </head>
    <body  class="hold-transition login-page">
        <div class="container">
            <form action="Login" method="post">
                <div class="login-logo">
                    <div class="title" style="color:green;">Medora_Patient Dashboards</div>
      
                </div><br>
            <img class="mb-4" src="https://png.pngtree.com/png-vector/20190704/ourmid/pngtree-businessman-user-avatar-free-vector-png-image_1538405.jpg" alt="" width="72" height="72">
            <div class="input-group mb-3">
          <input type="text" class="form-control" id="username" name="username" maxlength="50" placeholder="Email/Phone Number"  required="true">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
        <input type="password" class="form-control" id="password" name="password" maxlength="50" placeholder="Password" required="true">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
         
         <div class="form-group" style="width: 100%;">
	<button type="submit" class="btn btn-primary btn-block">Login </button>
	</div>
        </form> 
             <div class="form-group login-options" style="font-size: 14px; margin-left: 1%;">
            <b>New User?</b><span><a href="register.jsp" style=""><b> Register Here</b></a></span>
            <br style="margin-top:1%;">
            
        </div>
        </div>
       
        <%
            Calendar cal = Calendar.getInstance();
            int year= cal.get(Calendar.YEAR);
            %>
            <div class="footer">
                <p align="center"> &copy <a href="#" title="Version 0.1">Medora Health Centre</a> HEALTH_CENTRE, MEDORA <%=year%></p>
            </div>
              <%
                     try{
                         if(session.getAttribute("login")!=null){
                             String mess =session.getAttribute("login").toString();
                             out.print(mess);
                         }else{
                             session.removeAttribute("login");
                         }
                         
                     }catch(Exception e){
                         out.print(e.getMessage());
                         
                     }
                 %>
        
          
    </body>
</html>
