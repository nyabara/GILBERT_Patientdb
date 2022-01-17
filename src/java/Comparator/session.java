/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayoma
 */
public class session {
    HttpSession session;
    String progess="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
           session = request.getSession();
           progess="";
           if(session.getAttribute("progress")!=null){ // read data from that session
               
               progess=session.getAttribute("progress").toString()+"<br>";
               
          if(session.getAttribute("progress").toString().startsWith("Process completed from backend")) {
             
             // session.removeAttribute("progress");
          }    
           }
     
           System.out.println("progess********************************"+progess);
           out.println(progess);
//              if( conn.conn!=null){conn.conn.close();}
    }

    
}
