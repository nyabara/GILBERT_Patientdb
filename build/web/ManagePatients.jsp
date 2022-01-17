<%-- 
    Document   : ManagePatients
    Created on : Jul 2, 2021, 3:28:39 PM
    Author     : ayoma
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
         <script src="https://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
         <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="dist/css/adminlte.min.css">  
  <link rel="stylesheet" href="jGrowl/jquery.jgrowl.css" type="text/css"/>
    <!-- Select2 -->
  <link rel="stylesheet" href="plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script type="text/javascript" src="jGrowl/jquery.jgrowl.js"></script>
       

        
        <title>JSP Page</title>
    </head>
    <body class="hold-transition sidebar-mini" style="size: 75%;">
      <div class="wrapper">
    <%@include file="menu/top.jsp"%>
    <%@include file="menu/menu.jsp"%>
          
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
		 <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
           <br>
            <div class="card">
              <div class="card-header">
                  <h3 class="card-title" style="text-align: center;">Manage all Patients</h3>
              </div>
                         <div class="card-body">  
                             <div align="right" style="margin-bottom: 5px;">
                                 <button type="button" name="add" id="add" class="btn btn-success btn-xs">AddPatient</button>
                             </div>
                             <table id="data_table" class="table table-bordered table-striped" style="width:100%; size: 12px;">
                           <thead>
                               <tr>
                                  <th>No.</th> 
                                  <th>Full Name</th> 
                                  <th>Patient Number</th> 
                                  <th>Dob</th> 
                                  <th>National Id</th> 
                                  <th>Gender</th> 
                                  <th>Phone</th> 
                                  <th>Patient Status</th> 
                                  <th>Marital Status</th> 
                                  <th></th> 
                                  
                               </tr>
                            </thead>
                            <tbody>
                            </tbody> 
                        </table>
                         </div>  
                
                </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
    </div>
                                            <%
                                                Calendar cal = Calendar.getInstance();  
                                                int year= cal.get(Calendar.YEAR);    
                                            
                                            %>
					<!-- Footer -->
                                        <div class="footer text-muted">
                                          <p align="center"> &copy <a href="#" title="Version 0.1">Medora Patient Reports</a> MEDORA, HEALTH <%=year%></p>
					</div>
					<!-- /footer -->

				</div>
                                        
                                        
                                         <div id="patient_dialog" title="Add Patient">
                                            <form id="patient_form" method="post">
                                                <div class="mb-3">
                                                  <label for="firstname" class="form-label">First Name</label>
                                                  <input type="text" class="form-control" id="fname" name="fname" placeholder="First Name"  >
                                                  <span id="error_first_name"></span>
                                                </div>

                                                <div class="mb-3">
                                                  <label for="middlenaame" class="form-label">Middle Name</label>
                                                  <input type="text" class="form-control" id="mname" name="mname" placeholder="Middle Name">
                                                </div>
                                               <div class="mb-3">
                                                  <label for="lastname" class="form-label">Last Name</label>
                                                  <input type="text" class="form-control" id="lname" name="lname" placeholder="Last Name"  >
                                                  <span id="error_last_name"></span>
                                                  
                                                </div>
                                                 <div class="mb-3">
                                                  <label for="patientnumber" class="form-label">Patient Number</label>
                                                  <input type="text" class="form-control" id="pnumber" name="pnumber" placeholder="Patient Number"  >
                                                </div>
                                                <div class="form-group">
                                                  <label for="birthday" class="form-label">DOB</label>
                                                  <input type="text" class="form-control" id="dob" name="dob"  >
                                                </div>
                                                <div class="mb-3">
                                                  <label for="maritalstatus" class="form-label">Marital Status</label>
                                                  <select name="m_status" id="m_status">
                                                      <option value="1">Single</option>
                                                      <option value="2">Married</option>
                                                      <option value="3">Widowed</option>
                                                      <option value="4">Divorced</option>
                                                  </select>
                                                </div>

                                               <div class="mb-3">
                                                   <p>
                                                  Patient Status
                                                  <input type="radio" id="p_status1" name="p_status" value="1">Alive
                                                  <input type="radio" id="p_status2" name="p_status" value="2">is_dead
                                                  </p>

                                                </div>
                                                  <div class="mb-3">
                                                      <p>
                                                  Gender
                                                  <input type="radio" id="gender1" name="gender" value="Male">Male
                                                  <input type="radio" id="gender2" name="gender" value="Female">Female
                                                  </p>
                                                  </div>
                                               <div class="mb-3">
                                                  <label for="nationalid" class="form-label">National Id</label>
                                                  <input type="text" id="nid" class="form-control"minlength="8" maxlength="10" id="nid" name="nid" maxlength="10" placeholder="National Id" onkeypress='return numbers(event)'>
                                                </div>


                                                <div class="mb-3">
                                                  <label for="phonenumber" class="form-label">Phone Number</label>
                                                  <input type="text" class="form-control"minlength="10" maxlength="10" id="phone" name="phone" maxlength="10" placeholder="Phone Number" onkeypress='return numbers(event)'  >
                                                </div>
                                                <div class="form-group">
                                                    <input type="hidden" name="action" id="action" value="addpatients"/>
                                                    <input type="hidden" name="hidden_id" id="hidden_id"/>
                                                    <input type="submit" name="form_action" id="form_action" class="btn btn-info"
                                                           value="Register"/>
                                                    
                                                </div>

                                                
                                            </form>     
                                            
                                        </div>
                                        
                                        
                                        
                                        <div id="action_alert" title="Action">
                                            
                                        </div>    
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                                       
    </body>
    
     
     <script>
   $(document).ready(function() {
   load_data();
   dialog_task();
   
   
   
   
   
}); 
    </script>
    <script>
        function load_data(){
            $.ajax({
                url:'Load_Patients',
                type:'get',
                dataType:'json',
                      success:function(users){
       var dataSet=[];
         var data = users.users;
         var code = users.code;
         var message = users.message;
         if(code===1){
    var pos,id,patientname,pnumber,dob,nid,gender,phone,p_status,m_status;
    for (var i=0; i<data.length;i++){
        var minSet = [];

                pos = data[i].pos;
                id = data[i].id;
                patientname = data[i].patientname;
                pnumber = data[i].pnumber;
                dob = data[i].dob;
                nid = data[i].nid;
                gender = data[i].gender;
                phone = data[i].phone;
                p_status = data[i].status;
                m_status = data[i].mstatus;
                
                
        var resend="<button class='btn btn-info btn-raised' onclick='return update("+pos+");' style='padding-top:1px; padding-bottom:1px;'>Update</button>";
        var deletepatient="<button class='btn btn-info btn-raised' onclick='return delete("+pos+");' style='padding-top:1px; padding-bottom:1px;'>Delete</button>";
//        var deletep="<button class='btn btn-info btn-raised' onclick='return update("+pos+");' style='padding-top:1px; padding-bottom:1px;'>Delete</button>";
        var at_="<input type='hidden' value='"+id+"' id='pos_"+pos+"' name='pos_"+pos+"'>";
       minSet.push(at_+""+pos);  
       minSet.push(patientname);  
       minSet.push(pnumber);  
       minSet.push(dob);  
       minSet.push(nid);  
       minSet.push(gender);
       minSet.push(phone); 
       minSet.push(p_status);  
       minSet.push(m_status); 
       minSet.push(resend);
       minSet.push(deletepatient);
//       minSet.push(deletep);
       
        dataSet.push(minSet);
        }
       
       console.log(dataSet);
       
        var table = $('#data_table').DataTable();
        table.destroy();
        
        
        table = $('#data_table').dataTable({
            data: dataSet,
        buttons: [
           'copy', 'csv', 'excel', 'pdf', 'print'
        ],
            responsive: true,
            className:'',
            columnDefs: []
            
        });
        
        table.on( 'responsive-resize', function ( e, datatable, columns ) {
    var count = columns.reduce( function (a,b) {
        return b === false ? a+1 : a;
    }, 0 );
 
    console.log( count +' column(s) are hidden' );
} ); 
 
        }
        else{
//            alert("failed :"+message);
          $.jGrowl(message, {
                                        position: 'center',
                                        header: '<b>Error Loading Users</b>',
                                        theme: 'bg-danger'
                                   });    
            
        }
    }
                
            });
        }
        
       
  
       
    </script>
    <script>
        function dialog_task(){
            
       $("#patient_dialog").dialog({
       autoOpen:false,
       width:500,
       resizable:true
   });
   
   
   $("#add").click(function(){
       $("#patient_dialog").attr("title","Register Patient");
       $("#action").val("addpatients");
       $("#form_action").val("Register");
       $("#patient_dialog").dialog("open");
       $("#patient_dialog").css("background-color", "#D3D3D3");
       $("#fname").val("");
       $("#mname").val("");
       $("#lname").val("");
       $("#pnumber").val("");
       $("#dob").val("");
       $("#nid").val("");
           
          //var m_status = $('#m_status option[value=1]').attr("selected","selected");
       $("input[name=p_status]:checked").val("");
       $("input[name=gender]:checked").val("");
       $("#phone").val("");
   });
   $("#patient_form").on("submit",function(event){
       event.preventDefault();
//       var error_first_name="h";
//       if($("#fname").val()==""||$("#fname").val()<2){
//           error_first_name="Proper Name is required";
//           $("#error_first_name").text(error_first_name);
//           $("#fname").css("border-color","#cc0000");
//       }
//       else{
//           error_first_name="";
//           $("#error_first_name").text(error_first_name);
//           $("#fname").css("border-color","");
//       }
//       if(error_first_name==""){
//           alert("missing ................");
//           return true;
//       }
       //else{
           //$("#form_action").attr("disabled","disabled");
           var fname = $("#fname").val();
           var mname = $("#mname").val();
           var lname = $("#lname").val();
           var pnumber = $("#pnumber").val();
           var dob = $("#dob").val();
           var nid = $("#nid").val();
           
          //var m_status = $('#m_status option[value=1]').attr("selected","selected");
          var m_status=$("#m_status option:selected").val();
           var p_status = $("input[name=p_status]:checked").val();
           var gender = $("input[name=gender]:checked").val();
           var phone = $("#phone").val();
           var form_data = {"fname":fname,"mname":mname,"lname":lname,"pnumber":pnumber,
               "dob":dob,"nid":nid,"p_status":p_status,"gender":gender,"phone":phone,"m_status":m_status};
           //alert("full name "+fname+" "+mname+" "+lname+","+"status"+p_status+""+gender+""+dob+""+nid+""+pnumber
                   //+""+phone+""+m_status);
           
           //alert(form_data);
           $.ajax({
               url:'addpatients',
               type:"post",
               data:form_data,
               
               success:function(){
                   $("#patient_dialog").dialog("close");
                   //$("#action_alert").dialog("open");
                   console.log(form_data);
               }
           });
       //}
   });
            
        }
        function update(pos){
            var id = $("#pos_"+pos).val();
           
            var id_data={"id":id};
            var getdata;
            $.ajax({
                url:'SelectPatient',
                type:"get",
                data:id_data,
                dataType:"json",
               
                success:function(patient){
                    console.log(id_data);
                    var ddata=patient.xxx;
                    var dataset=[];
                     var fnamex,mname,lname,pnumber,dob,gender,m_status,p_status,phone,nid,id;
//                    for(var i=0;i<ddata.length;i++){
//                        var set=[];
                        id=ddata.id;
                        fnamex=ddata.fname;
                        
                        mname=ddata.mname;
                        lname=ddata.lname;
                        pnumber=ddata.pnumber;
                        dob=ddata.dob;
                        gender=ddata.gender;
                        m_status=ddata.m_status;
                        p_status=ddata.p_status;
                        phone=ddata.phone;
                        nid=ddata.nid;
                        console.log(fnamex);
                        $("#patient_dialog").dialog({
                                autoOpen:true,
                                width:500,
                                resizable:true
                            });
                            $("#patient_dialog").css("background-color", "#D3D3D3");
                            $("#fname").val(fnamex);
                            $("#mname").val(mname);
                            $("#lname").val(lname);
                            $("#pnumber").val(pnumber);
                            $("#dob").val(dob);
                            $("#phone").val(phone);
                            $("#nid").val(nid);
                            //$("input[name=p_status]:check").val(p_status);
                            $("input[name=gender][value='"+gender+"']").prop("checked",true);
                            $("input[name=p_status][value='"+p_status+"']").prop("checked",true);
                            $("#m_status").val(m_status).change();
                            
                            $("#dob").datepicker({
                                maxDate:0
                                
                            });
                        
                        
                       
                        
//                    }
                    
                    console.log(m_status);
                    console.log(p_status);
                    
                    
                    
                }
            });
        }
    </script>
   
</html>
