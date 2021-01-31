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
                   updateAlumniInfoPage(request, response);

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
                    updateAlumniInfo(request, response);
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
    
    public void updateAlumniInfo(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("Email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String matrics = request.getParameter("matrics");
        String gender = request.getParameter("gender");
        String citizenship = request.getParameter("citizenship");
        String Coursename = request.getParameter("Coursename");
        String edulevel = request.getParameter("edulevel");
        String title = request.getParameter("title");
        String graduateYear = request.getParameter("graduateYear");
        String phone = request.getParameter("Phoneno");
        
        String streetName = request.getParameter("streetName");
        String houseNo = request.getParameter("houseNo");
        String postalCode = request.getParameter("postalCode");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String region = request.getParameter("region");
        
        

        try {
            Alumni alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("email"));

            AlumniAddress alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
           
            alumni.setPhoneNo(Integer.valueOf(phone));
            alumni.setTitle(title);
            alumni.setGraduateYear(Integer.valueOf(graduateYear));
            alumni.setAlumniEmail(email);
            alumni.setAlumniName(name);
            alumni.setPassword(password);
            alumni.setGender(gender);
            alumni.setAlumniMatric(matrics);
            alumni.setAlumniCitizenship(citizenship);
            alumni.setCourseName(Coursename);
            alumni.setEduLevel(edulevel);

            alumniAddress.setCity(city);
            alumniAddress.setCountry(country);
            alumniAddress.setHouseNo(houseNo);
            alumniAddress.setRegion(region);
            alumniAddress.setState(state);
            alumniAddress.setPostalCode(postalCode);
            alumniAddress.setStreetName(streetName);

            alumni.setAlumniAddress(alumniAddress);
            System.out.println("Business.AlumniController.updateAlumniInfo() : " + alumniAddress);

            alumniDao.updateAlumniDetails(alumni);
            request.setAttribute("alumniEmail", alumni.getAlumniEmail());
            request.getRequestDispatcher("alumniProfile.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public void updateAlumniInfoPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        SignIn signIn = (SignIn) session.getAttribute("signIn");
        try {
            Alumni alumni;
            AlumniAddress alumniAddress;
            System.out.println(request.getParameter("alumniEmail"));

            if (signIn != null) {
                alumni = alumniDao.getDetailedAlumniInfo(signIn.getEmail());

                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            } 
            else if (request.getParameter("alumniEmail") != null) {
                alumni = alumniDao.getDetailedAlumniInfo(request.getParameter("alumniEmail"));
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            } 
            else {
                alumni = alumniDao.getDetailedAlumniInfo("6naseer.far@wditu.com");
                alumniAddress = alumniDao.getAlumniAddressInfo(alumni.getAlumniAddressID());
            }

            
            request.setAttribute("alumni", alumni);
            request.setAttribute("alumniAddress", alumniAddress);
            request.getRequestDispatcher("editProfile.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
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
