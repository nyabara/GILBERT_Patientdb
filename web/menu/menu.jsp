<%-- 
    Document   : menu
    Created on : Jun 28, 2021, 12:44:39 PM
    Author     : ayoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
    </head>
    <body>
        <aside class="main-sidebar sidebar-dark-primary elevation-4">
            <div class="sidebar">
                <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div class="info">
                        <a href="#" class="d-block" style="font-size: 200%;">PATIENT REPORT</a>
                        <b style="color:white;">
                            <%if(session.getAttribute("fullname")!=null){
                                String name=session.getAttribute("fullname").toString();
                                out.println(name); 
                            %> 
                            <%}%>
                        </b>
                        <br>
                        
                    </div>
                    
                </div>
                        <nav class="mt-2">
                            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                                <% if(session.getAttribute("fullname")!=null){%>
                                <li class="nav-item has-treeview">
                                    <a href="addPatient.jsp" class="nav-link">
                                        <i class="nav-icon fas fa-users"></i>
                                        <p>
                                            Add Patients
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item has-treeview">
                                    <a href="ManagePatients.jsp" class="nav-link">
                                        <i class="nav-icon fas fa-users"></i>
                                        <p>
                                            Manage Patients
                                        </p>
                                    </a>
                                </li>
                                
                                <%}else{
                                    String nextpage="index.jsp";
                                    response.sendRedirect(nextpage);
                                    
                                }
                                %>
                                <li class="nav-item has-treeview">
                                <a href="logout" class="nav-link">
                                  <i class="nav-icon fas fa-lock"></i>
                                  <p>
                                   Logout
                                  </p>
                                </a>
                             </li>
                                
                            </ul>
                            
                        </nav>
            </div>
        </aside>
    </body>
</html>
