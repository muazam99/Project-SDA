package Business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author Asus
 * @version 1.0
 * @created 30-Dec-2020 10:06:32 PM
 */

@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet{

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        
        if(command==null){
            command="";
        }
        
        try{
            
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            
            switch(command){
                
                case "Manage-User":
                    if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("/Admin/manageUser.jsp").forward(request, response);
                    }
                    break;
                    
                case "Add-User":
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("manageUser.jsp").forward(request, response);
                    }
                    break;
                    
                case "Delete-User":
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("manageUser.jsp").forward(request, response);
                    }
                    
                    break;
                   
                 default:
                     if(session.getAttribute("admin")!=null){
                        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                    }
                     break;
            }
        
        
        }catch (Exception exc) {
            throw new ServletException(exc);
        }

     
        
    }

}