/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import jdbc.AlumniDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Middleware.Alumni;
import Middleware.AlumniAddress;
import Middleware.SignIn;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SleepingLotus
 */
@WebServlet(name = "AlumniController", urlPatterns = {"/AlumniController"})
public class AlumniController extends HttpServlet {

    private AlumniDAO alumniDao;

    @Override
    public void init() throws ServletException {
        alumniDao = AlumniDAO.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("command");

        validateUser(request, response);
        try {

            // if the command is missing, then default to login
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            switch (command) {
                

                case "MY-PROFILE":
                    getAlumniInfo(request, response);
                    break;
                case "ALUMNI-INFO":
                    getAlumniInfo(request, response);
                    break;
                
                case "EDIT-PROFILE":
                   // updateAlumniInfoPage(request, response);

                    break;

                default:
                    getHomePage(request, response);

            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");

        validateUser(request, response);
        try {

            // if the command is missing, then default to login
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            switch (command) {
                case "UPDATE-ALUMNI":
                   // updateAlumniInfo(request, response);
                    break;
              
                default:
                    getHomePage(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    public void finalize() throws Throwable {

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

   

    /**
     *
     * @param alumniEmail
     */
    public void getAlumniInfo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        SignIn signIn = null;
        RequestDispatcher dispatcher;

        if (request.getParameter("command").equals("MY-PROFILE")) {
            signIn = (SignIn) session.getAttribute("signIn");
            System.out.println("Business.AlumniController.getAlumniInfo() :" + signIn.getEmail() + signIn.getName());
        }

        try {
            Alumni alumni;

            if (request.getParameter("alumniEmail") != null) {
                alumni = alumniDao.getAlumniInfo(request.getParameter("alumniEmail"));
                request.setAttribute("alumni", alumni);
            } else if (signIn != null) {
                alumni = alumniDao.getAlumniInfo(signIn.getEmail());
                request.setAttribute("alumni", alumni);
            }
              request.getRequestDispatcher("alumniProfile.jsp").forward(request, response);
              
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getAlumniList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Alumni> alumnis = alumniDao.getAlumniList();
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("/alumni/search_alumni.jsp");
            System.out.println(alumnis.get(0).toString());
            request.setAttribute("ALUMNI_LIST", alumnis);
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param alumniEmail
     */
   
    /**
     *
     * @param alumniName
     * @param query
     */
    

    /**
     *
     * @param alumniName
     */
   

    /**
     *
     * @param address
     * @param alumniEmail
     * @param phoneNo
     * @param eduLevel
     * @param graduateYear
     * @param courseName
     */
    /*  public void updateAlumniInfo(HttpServletRequest request, HttpServletResponse response) throw Exception{
        
        Alumni alumni = new Alumni();
        
        
    } */
    /**
     *
     * @param address
     * @param eduLevel
     * @param phoneNumber
     * @param title
     * @param courseName
     * @param graudateYear
     */
    public boolean validateFields(AlumniAddress address, String eduLevel, int phoneNumber, String title, String courseName, int graudateYear) {
        return false;
    }

    public void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession(true);

        try {
            if (session.getAttribute("admin") != null || session.getAttribute("signIn") != null) {

                return;

            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
