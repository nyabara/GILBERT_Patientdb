/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author ayoma
 */
public class SelectPatient extends HttpServlet {
    HttpSession session;
    String id;
    String message;
    String p_status,m_status;
    int code,errors=0;
    int pos;
    
    

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
         PrintWriter out = response.getWriter();
        session=request.getSession();
        dbConn conn=new dbConn();
        id=request.getParameter("id");
        JSONObject objfinal=new JSONObject();
        JSONObject obj=new JSONObject();
         
        errors=code=0;
        if(session.getAttribute("fullname")!=null){
            String getPatient="SELECT id,fname,lname,pnumber,dob,gender,m_status,p_status,phone,nid FROM patients WHERE id=?";
            conn.pst = conn.conn.prepareStatement(getPatient);
            conn.pst.setString(1, id);
            conn.rs = conn.pst.executeQuery();
            if(conn.rs.next()){
                //pos++;
                
                obj.put("id",conn.rs.getString(1));
                obj.put("fname", conn.rs.getString(2));
                obj.put("lname", conn.rs.getString(3));
                obj.put("pnumber", conn.rs.getString(4));
                obj.put("dob", conn.rs.getString(5));
                obj.put("gender", conn.rs.getString(6));
                obj.put("m_status", conn.rs.getString(7));
                obj.put("p_status",conn.rs.getString(8));
                obj.put("phone", conn.rs.getString(9));
                obj.put("nid", conn.rs.getString(10));
//               
                
            }
              message="patient loaded successfully";
              code=1; 
        }
        else{
            message="You do not have permissions to view this page";
            code=0;  
        }
        objfinal.put("xxx",obj);
        System.out.println(objfinal); 
        out.println(objfinal);
        
        //console.log(objfinal);
   
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
            Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
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
