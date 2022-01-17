  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    HttpSession session;
    String fname,mname,lname,email,phone,pass,password;
    String message;
    int code;
    String Email_Key="",nextpage="";
    MessageDigest m;
    int len_erorr;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        session = request.getSession();
        len_erorr=code=0;
        Email_Key="";
        nextpage="index.jsp";
        
         dbConn conn = new dbConn();
       
        fname = request.getParameter("fname");
        mname = request.getParameter("mname");
        lname = request.getParameter("lname");
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        
        email = email.toLowerCase();
        
         message="";
         
        if(fname.length()<2){
            len_erorr++;
            message+=len_erorr+". First Name must be more than 1 character<br>";
        }
        if(lname.length()<2){
            len_erorr++;
            message+=len_erorr+". Last/Sur Name must be more than 1 character<br>";
        }
        if(email.length()<16){
            len_erorr++;
            message+=len_erorr+". Enter correct email address<br>";
        }
        if(phone.length()!=10){
            len_erorr++;
            message+=len_erorr+". Enter correct phone number<br>";
        }
       if(len_erorr==0){
           
           String  pass1 = request.getParameter("pass1");
           String  pass2 = request.getParameter("pass2");
           pass = pass1;
           
           m = MessageDigest.getInstance("MD5");
           m.update(pass.getBytes(), 0, pass.length());
           password = new BigInteger(1, m.digest()).toString(16);
           
           if((pass1.equals(pass2)) && pass1.length()>4){
               
               String getinfo="SELECT uid,email FROM users WHERE email=? OR phone=?";
               conn.pst = conn.conn.prepareStatement(getinfo);
               conn.pst.setString(1, email);
               conn.pst.setString(2, phone);
               
               conn.rs = conn.pst.executeQuery();
               if(conn.rs.next()){
                    message+="Account already exist. Kindly login using your correct username and password or reset your password using your as required <br>";
                     code=0;   
               }else{
                   
                    String inserter = "INSERT INTO users(fname,mname,lname,phone,email,password) VALUES (?,?,?,?,?,?)";
                    conn.pst = conn.conn.prepareStatement(inserter);
                    conn.pst.setString(1, fname);
                    conn.pst.setString(2, mname);
                    conn.pst.setString(3, lname);
                    conn.pst.setString(4, phone);
                    conn.pst.setString(5, email);
                    conn.pst.setString(6, password);
       
                    conn.pst.executeUpdate();
               }
           } else{
               message = "Password and confirm password do not match or meet required integrity";   
               code=0;
           }
       }else{
           code=0; 
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
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
