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
public class Login extends HttpServlet {
    HttpSession session;
    String username,pass,password;
    String message;
    int code;
    String Email_Key="",nextpage="";
    MessageDigest m;
    int len_erorr;

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
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        dbConn conn=new dbConn();
        session=request.getSession();
        
        username=request.getParameter("username");
        pass=request.getParameter("password");
        
        username=username.toLowerCase();
         m=MessageDigest.getInstance("MD5");
         m.update(pass.getBytes(), 0, pass.length());
         password=new BigInteger(1, m.digest()).toString(16);
         
          String checker="SELECT uid, concat_ws(\" \",fname,mname,lname) AS fullname,phone,email,password FROM users WHERE (phone=? OR email=?) AND password=?";
          conn.pst = conn.conn.prepareStatement(checker);
          
           conn.pst.setString(1, username);
           conn.pst.setString(2, username);
           conn.pst.setString(3, password);
            
           conn.rs = conn.pst.executeQuery();
           
           if(conn.rs.next()){
              session.setAttribute("uid", conn.rs.getString("uid"));
              session.setAttribute("fullname", conn.rs.getString("fullname"));
              session.setAttribute("phone", conn.rs.getString("phone"));
              session.setAttribute("email", conn.rs.getString("email"));
              
             code=1;
             nextpage="home.jsp";
           } else{
                message = "Unknown email/phone and password combination";
                code=0;
                nextpage="index.jsp"; 
           }
           if(code==1){
              nextpage="home.jsp";  
            }
            else{
                session.setAttribute("login", message);
                session.setAttribute("code", code);
            }
            
            
            System.out.println("nextpage:"+nextpage);
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
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
