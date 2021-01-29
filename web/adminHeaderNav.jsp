<%-- 
    Document   : adminHeaderNav
    Created on : Jan 29, 2021, 7:30:56 AM
    Author     : Muaz Amir
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

         <div class="container">
         
               <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="adminHome.jsp">Home</a>
                  </li>
                   
                  <li class="nav-item active">
                    <a class="nav-link" href="AdminController?command=getManageUserPage">Manage User</a>
                  </li>
                    <li class="nav-item active">
                    <a class="nav-link" href="AlumniController?command=ALUMNI-SEARCH">View Alumni</a>
                  </li>
                  
               </ul>

               <ul class="navbar-nav">
                  
                  <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="h#" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${admin.getAdminName()}</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown07">
                      <a class="dropdown-item" href="LogoutController">Logout</a>
                    </div>
                  </li>                  
               </ul>
            </div>
            
      </nav>    