/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jdbc.UserDAO;

/**
 *
 * @author Muaz Amir
 */
@Path("databaseController")
public class databaseController {
    
    private UserDAO jdbcUtility;
    private Connection con;
    
    @GET
    @Path("/getdata")
    @Produces(MediaType.APPLICATION_JSON)
   
    
    public ArrayList<database> getDataInJSON() throws ClassNotFoundException, SQLException
    {
        
        
       
      
        String driver = "com.mysql.jdbc.Driver";
        
        String dbName = "alumni_account";
        String url = "jdbc:mysql://localhost/" + dbName + "?" ;
        String userName = "root";
        String password = "";
        

        jdbcUtility = new UserDAO(driver,
                                      url,
                                      userName,
                                      password);

        jdbcUtility.jdbcConnect();
        
        //get JDC connection
        con = jdbcUtility.jdbcGetConnection();
        
        String query = "Select * from alumni ";
       ArrayList<database> dbb=new ArrayList<>();
       
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        
        while(rs.next())
        {
            database db = new database();
            db.setAddress(rs.getString("Address"));
            db.setCurrentJob(rs.getString("CurrentJob"));
            db.setEmail(rs.getString("Email"));
            db.setGraduateYear(rs.getInt("GraduateYear"));
            db.setName(rs.getString("Name"));
            db.setPassword(rs.getString("password"));
            db.setPhone(rs.getString("PhoneNo"));
            db.setPreviousJob(rs.getString("PreviousJob"));
            db.setSalaryCurrent(rs.getDouble("SalaryCurrent"));
            db.setSalaryPrevious(rs.getDouble("SalaryPrevious"));
            db.setStatus(rs.getString("Status"));
            dbb.add(db);
        }   
        
        String query2 ="Select * from admin";
        rs = st.executeQuery(query2);
        
        while(rs.next()){
            database db = new database();
            db.setAdminEmail(rs.getString("AdminEmail"));
            db.setAdminID(rs.getString("AdminID"));
            db.setAdminName(rs.getString("AdminName"));
            db.setAdminPassword(rs.getString("AdminPassword"));
            dbb.add(db);
        }
        
             return dbb;    
    }
      
}
