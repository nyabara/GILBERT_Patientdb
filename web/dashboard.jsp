<%-- 
    Document   : home
    Created on : Jan 17, 2022, 09:15:57 AM
    Author     : ayoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
         <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
         <script src="https://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
       
      
        <link rel="stylesheet" href="dist/css/adminlte.min.css">  
       
        <script src="dist/js/adminlte.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <%@include file="menu/top.jsp"%>
            <%@include file="menu/menu.jsp"%>
            <div class="content-wrapper">
                <section class="content">
                    <div class="container-fluid" style="">
                        <div  class="row">
                            <div class="col-12">
                                <br>
                                <div style="font-size: 400%; text-align: center; margin-top: 20%; font-weight: 800; color: green;">
                                   Welcome to PATIENT Retention System 
                                </div>
                                
                                
                            </div>
                            
                        </div>
                    </div>
                    
                </section>
                
            </div>
            
        </div>
    </body>
</html>
