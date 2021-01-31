<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" /> 
        <title></title>
    </head>
    <body>


                <jsp:include page="headerNav.jsp" />  
          
        <div class="container" style="margin-top:100px">
            
            
            <div class="row">
                <div class="col"></div>

                <div class="col-md-6">

                    <div class="card shadow">
                        <div class="card-body">
                            <h2>Update Profile</h2>
                            <br>
                            <form action="AlumniController" method="post">
                               <input type="hidden" name="command" value="UPDATE-ALUMNI" />
                               <input type="hidden" name="email" value="${alumni.alumniEmail}" />

                                <label for="floatingPassword"><b>Name</b></label>
                                <div class="input-group mb-3">
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="title" value="${alumni.title}">
                                        <option selected>Choose Title</option>
                                        <option value="Mr">Mr</option>
                                        <option value="Ms">Ms</option>
                                        <option value="Dr">Dr</option>
                                        <option value="Ir">Ir</option>
                                        <option value="Professor">Professor</option>
                                    </select>
                                    <input type="text" class="form-control" value="${alumni.alumniName}" name="Name" required>
                                </div>



                                <div class="form-floating">
                                    <label for="floatingPassword"><b>password</b></label>
                                    <input type="password" class="form-control" id="floatingPassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                           title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" 
                                           value="${alumni.password}" name="password" required>  
                                </div>

                                <div class="form-floating">
                                    <label for="floatingInput"><b>Matrics no.</b></label>
                                    <input type="text" class="form-control" id="floatingInput" value="${alumni.alumniMatric}" name="matrics">           
                                </div>

                                <label for="floatingInput"><b>Gender</b></label><br>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="customRadioInline1" name="gender" class="custom-control-input" value="Male" selected>
                                    <label class="custom-control-label" for="customRadioInline1">Male</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="customRadioInline2" name="gender" class="custom-control-input" value="Female">
                                    <label class="custom-control-label" for="customRadioInline2">Female</label>
                                </div>
                                <br><br>
                                <label for="floatingInput"><b>Address</b></label><br>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control"  name="Houseno" value="${alumniAddress.houseNo}" >
                                    <input type="text" class="form-control" value="${alumniAddress.streetName}" name="Streetname >
                                </div>
                                
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" value="${alumniAddress.region}" name="Region">
                                    <input type="text" class="form-control" value="${alumniAddress.streetName}" name="City">
                                </div>
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" value="${alumniAddress.region}" name="State" >
                                    <input type="text" class="form-control" value="${alumniAddress.postalCode}"  name="Postalcode" >
                                    <input type="text" class="form-control" value="${alumniAddress.country}"  name="Country">
                                </div>


                                <div class="form-floating">
                                    <label for="floatingInput"><b>Citizenship</b></label>
                                    <input type="text" class="form-control" id="floatingInput" ${alumni.alumniCitizenship} name="citizenship">           
                                </div>

                                <div class="form-floating">
                                    <label for="floatingInput"><b>Email Address</b></label>
                                    <input type="email" class="form-control" id="floatingInput" value="${alumni.alumniEmail}" name="Email" required>           
                                </div>

                                <div class="form-floating">
                                    <label for="floatingInput"><b>Phone no.</b></label>
                                    <input type="text" class="form-control" id="floatingInput" value="${alumni.phoneNo}" name="Phoneno" required>           
                                </div>

                                <div class="form-floating">
                                    <label for="floatingInput"><b>Course name</b></label>
                                    <input type="text" class="form-control" id="floatingInput" value="${alumni.courseName}" name="Coursename" required>           
                                </div>

                                <label for="floatingInput"><b>Education Level</b></label><br>
                                <div class="form-row align-items-center">
                                    <div class="col-auto my-1">   
                                        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="edulevel" value="${alumni.eduLevel}">
                                            <option selected>Choose Education Level</option>
                                            <option value="Foundation">Foundation</option>
                                            <option value="Diploma">Diploma</option>
                                            <option value="Degree">Degree</option>
                                            <option value="Master">Master</option>
                                            <option value="2003">Phd.</option>
                                        </select>
                                    </div>
                                </div> 



                                <label for="floatingInput"><b>Graduate Year</b> </label><br>
                                <div class="form-row align-items-center">
                                    <div class="col-auto my-1">
                                        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Graduate Year</label>
                                        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="GraduateYear" value="${alumni.graduateYear}">
                                            <option selected>Choose Graduate Year</option>
                                            <option value="2000">2000</option>
                                            <option value="2001">2001</option>
                                            <option value="2002">2002</option>
                                            <option value="2003">2003</option>
                                            <option value="2004">2004</option>
                                            <option value="2005">2005</option>
                                            <option value="2006">2006</option>
                                            <option value="2007">2007</option>
                                            <option value="2008">2008</option>
                                            <option value="2009">2009</option>
                                            <option value="2010">2010</option>
                                            <option value="2011">2011</option>
                                            <option value="2012">2012</option>
                                            <option value="2013">2013</option>
                                            <option value="2014">2014</option>
                                            <option value="2015">2015</option>
                                            <option value="2016">2016</option>
                                            <option value="2017">2017</option>
                                            <option value="2018">2018</option>
                                            <option value="2019">2019</option>
                                            <option value="2020">2020</option>
                                        </select>
                                    </div>
                                </div> 


                                <br>
                                <button type="submit" class="btn btn-primary">Save Update</button> 
                            </form>
                        </div>
                    </div>

                </div>
                <div class="col"></div>
            </div>

                </div>
            </div>
        </div>



    </body>
</html>
