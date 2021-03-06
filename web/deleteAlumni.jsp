<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
    
        <title>View Alumni</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

        <!-- Custom styles for this template -->
        <link href="css/navbar-top-fixed.css" rel="stylesheet">
        </head>
           <body class="sb-nav-fixed">
            <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
             url = "jdbc:mysql://localhost/sdadatabase"
             user = "root"  password = ""/>
             <sql:query dataSource = "${snapshot}" var = "result">
                SELECT * from alumni;
             </sql:query>
             
                <jsp:include page="adminHeaderNav.jsp" />  
            
        <main class="main mt-5 d-flex flex-column justify-content-start">
            <h2 class="text-center my-5">List Of Alumnis</h2>
            <hr class="container-md"/>
         <div class="container d-flex flex-column align-items-center" style="margin-top:30px">
              



                <div class="col-sm-10 d-flex flex-column align-items-end">

              <c:forEach var="row" items="${result.rows}">
                    <table class="table table-striped table-bordered border-primary">
                        <tbody>
                             <tr >                                 
                                 <td  rowspan="6" >

                                        <img src="https://www.searchpng.com/wp-content/uploads/2019/02/Profile-ICon.png" width="100" height="100" /> 
    
                                 </td>

                             </tr>
                                         <tr>
                                            <td>No:</td>
                                            <td>${row.AlumniID}</td>
                                            <td  rowspan="5"> 
 
                                                <a href="AdminController?command=Delete-Alumni&id=${row.alumniID}">    
                                                    <button type="button" class="btn btn-danger" onclick="if (confirm('Are you sure you want to delete?')) { form.action='AdminController?command=Delete-Alumni&id=${row.alumniID}'; } else { return false; }"
                                                            >Delete</button></a>
                                                    <br><br>
                                                                             
                                             </td>
                                        </tr>
                                        
                                        <tr>
                                            <td>Name :</td>
                                            <td>${row.Alumniname}</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>Matrics No.:</td>
                                            <td>${row.Alumnimatric}</td>
                                        </tr>
                                        <tr>
                                            <td>Email :</td>
                                            <td>${row.Alumniemail}</td>
                                        </tr>
                                        <tr>
                                            <td>Phone no. :</td>
                                            <td>${row.Phoneno}</td>
                                        </tr>
                               
                           </tbody>
                       
                        </table>
                     </c:forEach>
                </div>  

            </div>
            
          
            
        </main>
      



    </body>
    
    
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        test
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
    
  
    
    
</html>

 