/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import Middleware.Alumni;
import Middleware.AlumniAddress;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlumniDAO {

    private static AlumniDAO instance;

    private String url = "jdbc:mysql://localhost:3306/alumni_database?useTimezone=true&serverTimezone=UTC";
    private String userName = "root";
    private String password = "";

    private Alumni alumni;



    private AlumniDAO() {
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
   

    public static AlumniDAO getInstance() {
        if (instance == null) {
            instance = new AlumniDAO();
        }
        return instance;
    }
    
       public int getnumberofAddresses() {
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, userName, password);
            // create sql statement
            String sql = "SELECT count(*)FROM alumniaddress";

            //"select * from alumni where Alumniemail=? "
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);
            // set params

            //execute query
            rs = ps.executeQuery();

            //check if user is found
            rs.next();
            int count = rs.getInt(1);
            return count;
        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return 0;

    }


    public AlumniAddress addAlumniAddress(AlumniAddress alumniAddress, String alumniID) {
//     
        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, userName, password);
            // create sql statement
            String insert_address = "INSERT INTO alumniaddress(Houseno, Streetname,Region , City , State , Postalcode , Country, AlumniaddressID)"
                    + " VALUES  (?,?,?,?,?,?,?,?) ";

            //"select * from alumni where Alumniemail=? "
            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(insert_address);
            // set params
            ps.setString(1, alumniAddress.getHouseNo());
            ps.setString(2, alumniAddress.getStreetName());
            ps.setString(3, alumniAddress.getRegion());
            ps.setString(4, alumniAddress.getCity());
            ps.setString(5, alumniAddress.getState());
            ps.setString(6, alumniAddress.getPostalCode());
            ps.setString(7, alumniAddress.getCountry());
            ps.setString(8, alumniID);
            //execute query
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }

        return null;
    }
    
    public List<Alumni> getAlumniList() {
        List<Alumni> alumnis = new ArrayList<>();

        Connection myConn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // get a connection
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, userName, password);
            // create sql statement
            //check if email exists
            String sql = "SELECT * FROM `alumni`";

            // create prepared statement
            stmt = myConn.createStatement();

            ps = myConn.prepareStatement(sql);

            //execute query
            rs = ps.executeQuery();

            //process resultset
            while (rs.next()) {
                Alumni foundAlumni = new Alumni(rs.getString("Alumnicitizenship"), rs.getString("Alumniemail"), rs.getString("Alumniname"), rs.getString("Batchname"), rs.getString("Edulevel"), rs.getString("Gender"), rs.getInt("Graduateyear"), rs.getString("Title"));

                //list of all managers
                alumnis.add(foundAlumni);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close JDBC objects
            close(myConn, stmt, rs);
        }
        return alumnis;
    }
    
    

   

    //close connection
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
