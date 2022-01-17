<%-- 
    Document   : addPatient
    Created on : Jun 30, 2021, 3:36:55 PM
    Author     : ayoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="../../../../favicon.ico">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!-- Bootstrap core CSS -->
        
         
         <link rel="stylesheet" href="dist/css/adminlte.min.css">  
        <script src="dist/js/adminlte.min.js"></script>
    </head>
    <body class="hold-transition sidebar-mini" style="size: 75%;">
        <div class="wrapper">
            <%@include file="menu/top.jsp"%>
            <%@include file="menu/menu.jsp"%>
            <div class="content-wrapper">
                <main role="main" class="container">
            <h1 class="mt-5">Register New Patients</h1>
            <div class="row">
                <div class="col-4">
                    <img src="img/user1.png"class="img-fluid"/>
                    
                </div>
                <div class="col-6">
                    <form action="addpatients" method="post">
				  <div class="mb-3">
				    <label for="firstname" class="form-label">First Name <b style="color:red;"> *</b>F</label>
                                    <input type="text" class="form-control" name="fname" placeholder="First Name" required="true">
				  </div>

				  <div class="mb-3">
				    <label for="middlenaame" class="form-label">Middle Name<b style="color:red;"> *</b>MN</label>
                                    <input type="text" class="form-control" name="mname" placeholder="Middle Name" required="true">
				  </div>
                                 <div class="mb-3">
				    <label for="lastname" class="form-label">Last Name<b style="color:red;"> *</b>L</label>
                                    <input type="text" class="form-control" name="lname" placeholder="Last Name" required="true">
				  </div>
				   <div class="mb-3">
				    <label for="patientnumber" class="form-label">Patient Number<b style="color:red;"> *</b>PN</label>
                                    <input type="text" class="form-control" name="pnumber" placeholder="Patient Number" required="true">
				  </div>
				  <div class="mb-3">
				    <label for="birthday" class="form-label">DOB<b style="color:red;"> *</b>DOB</label>
				    <input type="date" class="form-control" name="dob" required="true">
				  </div>
				  <div class="mb-3">
				    <label for="maritalstatus" class="form-label">Marital Status <b style="color:red;"> *</b>MS</label>
				    <select name="m_status">
                                        <option value="1">Single</option>
                                        <option value="2">Married</option>
                                        <option value="3">Widowed</option>
                                        <option value="4">Divorced</option>
                                    </select>
				  </div>
                        
				 <div class="mb-3">
				     <p>
                                    Patient Status <b style="color:red;"> *</b>PS
                                    <input type="radio" name="p_status" value="1">Active
                                    <input type="radio" name="p_status" value="2">is_dead
                                    </p>
                               
				  </div>
                                    <div class="mb-3">
                                        <p>
                                    Gender <b style="color:red;"> *</b>G
                                    <input type="radio" name="gender" value="Male">Male
                                    <input type="radio" name="gender" value="Female">Female
                                    </p>
                                    </div>
                                 <div class="mb-3">
				    <label for="nationalid" class="form-label">National Id<b style="color:red;"> *</b>id</label>
				    <input type="text" class="form-control"minlength="10" maxlength="10" id="nid" name="nid" maxlength="10" placeholder="National Id" onkeypress='return numbers(event)'>
				  </div>
                                    
				 
				  <div class="mb-3">
				    <label for="phonenumber" class="form-label">Phone Number<b style="color:red;"> *</b>P</label>
				    <input type="text" class="form-control"minlength="10" maxlength="10" id="phone" name="phone" maxlength="10" placeholder="Phone Number" onkeypress='return numbers(event)' required="true">
				  </div>
				 
				  <button type="submit" name="save" class="btn btn-primary">Save</button>
		</form>
                    
                </div>
                
            </div>

        </main>
                
            </div>
        
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
            
        </div>
         
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
</html>
