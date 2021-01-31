<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        
        <title>${alumni.alumniName}</title>
    </head>
    <body>


         <c:choose>
            <c:when test="${signIn != null}">
                <jsp:include page="headerNav.jsp" />  
            </c:when>
            <c:when test="${admin != null}">
                <jsp:include page="adminHeaderNav.jsp" />  
            </c:when> 
         </c:choose>
        
                        <div class="container" style="margin-top: 100px">
                            
                            <div class="text-center">
                                 <a  href="AlumniController?command=EDIT-PROFILE&alumniEmail=${alumni.alumniEmail}">
                                  <button type="button" class="btn btn-primary btn-lg">Edit Profile</button></a>
                            </div>
                            <br><br><br>
                    
            <div class="card d-flex flex-row justify-content-around align-items-center shadow">
              
                <table class="table table-striped ">
                        <tbody>
                             <tr >                                 
                                 <td  rowspan="8" style="width:20%">
                                    <img class="vector-6QVaxv"
                                         src="https://www.searchpng.com/wp-content/uploads/2019/02/Profile-ICon.png" width="100" height="100"
                                        /> 
                                 </td>

                             </tr>
                                                                      
                                        <tr>
                                            <td style="width:15%"><b>Name :</b></td>
                                            <td>${alumni.alumniName}</td>
                                            
                                        </tr>
                                        <tr>
                                            <td><b>Email :</b></td>
                                            <td>${alumni.alumniEmail}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Gender:</b></td>
                                            <td>${alumni.gender}</td>
                                        </tr>
                                        
                                        <tr>
                                            <td><b>Citizenship :</b></td>
                                            <td>${alumni.alumniCitizenship}</td>
                                        </tr>
                                        
                                         <tr>
                                             <td><b>Education Level :</b></td>
                                            <td>${alumni.eduLevel}</td>
                                        </tr>
                                        
                                         <tr>
                                             <td><b>Graduate Year :</b></td>
                                            <td>${alumni.graduateYear}</td>
                                        </tr>
                                        
                                        <tr>
                                            <td><b>Batch Name :</b></td>
                                            <td>${alumni.batchName}</td>
                                        </tr>
                               
                           </tbody>
                       
                        </table>
                

              
            </div>
        </div>
    </body>
</html>
