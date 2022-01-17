/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ayoma
 */
public class Load_Patients extends HttpServlet {
    HttpSession session;
    String message;
    int code,pos;
    String p_status,m_status;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        session=request.getSession();
        PrintWriter out = response.getWriter();
        dbConn conn = new dbConn();
        JSONArray jarrArray = new JSONArray();
        JSONObject obj_final = new JSONObject();
        
        message="";
        code=pos=0;
        if(session.getAttribute("fullname")!=null){
            String get_users="SELECT id, concat_ws(\" \",fname,mname,lname) AS patientname,pnumber,dob,nid,gender,phone,p_status,m_status FROM patients ORDER BY registration_date DESC";
            conn.rs = conn.st.executeQuery(get_users);
            while(conn.rs.next()){
                pos++;
                JSONObject obj = new JSONObject();
                obj.put("pos",pos);
                obj.put("id", conn.rs.getString(1));
                obj.put("patientname", conn.rs.getString(2));
                obj.put("pnumber", conn.rs.getString(3));
                obj.put("dob", conn.rs.getString(4));
                obj.put("nid", conn.rs.getString(5));
                obj.put("gender", conn.rs.getString(6));
                obj.put("phone", conn.rs.getString(7));
                
                   String status="SELECT id,name from p_status";
                    p_status="<select id='pstatus_"+pos+"' name='pstatus_"+pos+"'class=\"form-control select2\" style=\"width: 100%;\" >";
    
                    conn.rs1=conn.st1.executeQuery(status);
                    while(conn.rs1.next()){
                        if(conn.rs1.getInt(1)==conn.rs.getInt(8)){
                         p_status+="<option value='"+conn.rs1.getString(1)+"' selected>"+conn.rs1.getString(2)+"</option>";      
                        }
                        else{
                          p_status+="<option value='"+conn.rs1.getString(1)+"'>"+conn.rs1.getString(2)+"</option>";    
                        }
                    }
                   p_status+="</select>";
                    obj.put("status", p_status);
                    
                    String ma_status="SELECT id,name from m_status";
                    m_status="<select id='mstatus_"+pos+"' name='mstatus_"+pos+"'class=\"form-control select2\" style=\"width: 100%;\" >";
       //             u_status+="<option value='' >None</option>";
                    conn.rs1=conn.st1.executeQuery(ma_status);
                    while(conn.rs1.next()){
                        if(conn.rs1.getInt(1)==conn.rs.getInt(9)){
                         m_status+="<option value='"+conn.rs1.getString(1)+"' selected>"+conn.rs1.getString(2)+"</option>";      
                        }
                        else{
                          m_status+="<option value='"+conn.rs1.getString(1)+"'>"+conn.rs1.getString(2)+"</option>";    
                        }
                    }
                   m_status+="</select>";
                   obj.put("mstatus", m_status);
                   jarrArray.add(obj);
            }
            message="Users loaded successfully";
            code=1;       
        }else{
            message="You do not have permissions to view this page";
            code=0;       
        }
        obj_final.put("code", code);
        obj_final.put("message", message);
        obj_final.put("users", jarrArray);
         
            System.out.println(obj_final); 
            out.println(obj_final);
   
         if( conn.conn!=null){conn.conn.close();}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Load_Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Load_Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
