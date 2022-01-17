/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayoma
 */
public class addpatients extends HttpServlet {
    HttpSession session;
    String fname,mname,lname,pnumber,phone,nid,gender,dob,p_status,m_status;
    String nextpage="";
    Date sdob;
    int code;
    String message;

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
            throws ServletException, IOException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        session = request.getSession();
        nextpage="addPatient.jsp";
        
        dbConn conn = new dbConn();
        
        fname = request.getParameter("fname");
        mname = request.getParameter("mname");
        lname = request.getParameter("lname");
        pnumber = request.getParameter("pnumber");
        nid = request.getParameter("nid");
        gender = request.getParameter("gender");
        dob = request.getParameter("dob");
        phone = request.getParameter("phone");
        p_status=request.getParameter("p_status");
        m_status=request.getParameter("m_status");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //dob=(Date) sdf.parse(sdob);
        if(session.getAttribute("fullname")!=null){
             String getinfo="SELECT id,pnumber FROM patients WHERE pnumber=? OR phone=?";
               conn.pst = conn.conn.prepareStatement(getinfo);
               conn.pst.setString(1, pnumber);
               conn.pst.setString(2, phone);
               
               conn.rs = conn.pst.executeQuery();
               if(conn.rs.next()){
                    message+="User already exis<br>";
                     code=0;   
               }else{
                   
                    String inserter = "INSERT INTO patients(fname,mname,lname,pnumber,dob,nid,gender,phone,p_status,m_status) VALUES (?,?,?,?,?,?,?,?,?,?)";
                    conn.pst = conn.conn.prepareStatement(inserter);
                    conn.pst.setString(1, fname);
                    conn.pst.setString(2, mname);
                    conn.pst.setString(3, lname);
                    conn.pst.setString(4, pnumber);
                    conn.pst.setString(5, dob);
                    conn.pst.setString(6, nid);
                    conn.pst.setString(7, gender);
                    conn.pst.setString(8, phone);
                    conn.pst.setString(9, p_status);
                    conn.pst.setString(10, m_status);
       
                    conn.pst.executeUpdate();
               }
            
        }else{
            message+="not authorised";
            code=0;
            //not logged in
        }
        session.setAttribute("message", message);
       session.setAttribute("code", code);
        
        
       System.out.println("code :"+code+" message :"+message);
       response.sendRedirect(nextpage);
       
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
        } catch (ParseException ex) {
            Logger.getLogger(addpatients.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addpatients.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(addpatients.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addpatients.class.getName()).log(Level.SEVERE, null, ex);
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
