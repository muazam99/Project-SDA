<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
    
        <title>View Admin</title>

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
             url = "jdbc:mysql://localhost/alumni_database"
             user = "root"  password = ""/>
             <sql:query dataSource = "${snapshot}" var = "result">
                SELECT * from admin;
             </sql:query>
             
                <jsp:include page="adminHeaderNav.jsp" />  
            
        <main class="main mt-5 d-flex flex-column justify-content-start">
            <h2 class="text-center my-5">List Of Admin</h2>
            <hr class="container-md"/>
         <div class="container d-flex flex-column align-items-center" style="margin-top:30px">
              



                <div class="col-sm-10 d-flex flex-column align-items-end">

              <c:forEach var="row" items="${result.rows}">
                    <table class="table table-striped table-bordered border-primary">
                        <tbody>
                             <tr >                                 
                                 <td  rowspan="4">
                                    <img class="vector-6QVaxv"
                                         src="https://www.searchpng.com/wp-content/uploads/2019/02/Profile-ICon.png" width="100" height="100"
                                        /> 
                                 </td>

                             </tr>
                                         <tr>
                                            <td>No:</td>
                                            <td>${row.adminID}</td>
                                        </tr>
                                        
                                        <tr>
                                            <td>Name :</td>
                                            <td>${row.adminName}</td>
                                            
                                        </tr>
                                        <tr>
                                            <td>Email:</td>
                                            <td>${row.adminEmail}</td>
                                        </tr>
                                     
                               
                           </tbody>
                       
                        </table>
                     </c:forEach>
                </div>  

            </div>
            
          
            
        </main>
      



    </body>
    
  
    
    
</html>

 