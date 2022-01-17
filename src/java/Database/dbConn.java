/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayoma
 */
public class dbConn {
     public ResultSet rs0,rs,rs1;
  public Statement st0,st, anc_scheduling_st,st1;
  public  PreparedStatement pst,pst1,pst2,pst3,pst4,pst5;
  public  CallableStatement csmt,csmt1,csmt2,csmt3,csmt4;
public  Connection conn = null;
    public dbConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdb","root", "admin"); // local setup
//         

                st0 = conn.createStatement();
                st = conn.createStatement();
                st1 = conn.createStatement();
                anc_scheduling_st = conn.createStatement();

          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR WHILE CONNECTING TO DATABASE. CHECK YOUR CONNECTION CREDENTIALS SETTINGS in dbConn.java");
            //error in dbase configuration 
            //call the jsp page that does configuration

        } catch (InstantiationException ex) {
            Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR WHILE CONNECTING TO DATABASE. CHECK YOUR CONNECTION CREDENTIALS SETTINGS in dbConn.java");
            //error in dbase configuration
            //call the jsp page that does configuration
      } catch (IllegalAccessException ex) {
          Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("ERROR WHILE CONNECTING TO DATABASE. CHECK YOUR CONNECTION CREDENTIALS SETTINGS in dbConn.java");
          //error in dbase configuration
          //call the jsp page that does configuration
      } catch (SQLException ex) {
          Logger.getLogger(dbConn.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("ERROR WHILE CONNECTING TO DATABASE. CHECK YOUR CONNECTION CREDENTIALS SETTINGS in dbConn.java");
          //error in dbase configuration
          //call the jsp page that does configuration
      }
    }
    
}
