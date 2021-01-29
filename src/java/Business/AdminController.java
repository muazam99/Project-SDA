package Business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:32 PM
 */
public class AdminController extends HttpServlet{

	    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String command = request.getParameter("command");
        
        try{
            
            switch(command){
                
                case "Manage-User":
                    getManageUserPage(request , response);
                    break;
                    
                case "Add-User":
                    getAddUserPage(request , response );
                    break;
                    
                case "Delete-User":
                    getDeleteUserPage(request , response);
                    break;
                   
                 default:
                     getHomePage(request , response);
            }
        
        
        }catch (Exception exc) {
            throw new ServletException(exc);
        }

        }
    
        public void getHomePage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        try {
            if (session.getAttribute("admin") != null) {
                dispatcher = request.getRequestDispatcher("adminHome.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("home.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
             }
        }
        
       public void getManageUserPage(HttpServletRequest request, HttpServletResponse response) {
        
       HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("/Admin/manageUser.jsp");

       }
       
       public void getAddUserPage(HttpServletRequest request, HttpServletResponse response) {
        
       HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("/Admin/manageUser.jsp");

       }
       
        public void getDeleteUserPage(HttpServletRequest request, HttpServletResponse response) {
        
       HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("/Admin/manageUser.jsp");

       }

}