/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdatePatients extends HttpServlet {
    HttpSession session;
    String id,p_status,m_status;
    String message,header;
    int code=0,errors=0;

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
        errors=code=0;
        message="";
        if(session.getAttribute("fullname")!=null){
            id=request.getParameter("at");
           p_status=request.getParameter("p_status");
           m_status=request.getParameter("m_status");
            if(errors==0){
                String updateUser="UPDATE patients SET m_status=?,p_status=? WHERE id=?";
                conn.pst = conn.conn.prepareStatement(updateUser);
                conn.pst.setString(1, m_status);
                conn.pst.setString(2, p_status);
                conn.pst.setString(3, id);
        
                conn.pst.executeUpdate();
        
                message = "User updated successfully";
                code=1;
            }
            else{
                
            }
        }
        else{
            message="Uknown user. Login to try again";
            code=0;
        }
        
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("message", message);
    
        
        out.println(obj);
        
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
            Logger.getLogger(UpdatePatients.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdatePatients.class.getName()).log(Level.SEVERE, null, ex);
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
