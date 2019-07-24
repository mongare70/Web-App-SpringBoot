<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/studentRegistration.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid bg">
		<div class="row">
            <div class="col-md-2 col-sm-4 col-xs-12"></div>
			<div class="col-md-2 col-sm-4 col-xs-12"></div>
				<!-- Form Start -->
            <form class="form-container" method="post" action="/custodianRegister" name="custodian_registration_form" id="custodian_registration_form" onsubmit="return validateForm()">
                <h1>Custodian Registration Form</h1>
                <div class="form-group">
                    <label for="staffNo">Staff Number:</label>
                    <input type="text" class="form-control" id="staffNo" name="staffNo" placeholder="Staff Number">
                </div>
                <div class="form-group">
                    <label for="fname">First Name:</label>
                    <input type="text" class="form-control" id="fname" name="fname" placeholder="First Name">
                </div>
                <div class="form-group">
                    <label for="lname">Last Name:</label>
                    <input type="text" class="form-control" id="lname" name="lname" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="uname" name="uname" placeholder="Username">
                </div>
                  <div class="form-group">
                    <label for="hostel">Hostel:</label>
                    <select class="form-control" id="hostel" name="hostel">
                        <option>Nairobi</option>
                        <option>Mombasa</option>
                        <option>Eldoret</option>
                        <option>Maringo</option>
                        <option>Ruwenzori</option>
                        <option>Hollywood</option>
                        <option>Buruburu</option>
                        <option>Taifa</option>
                        <option>Uganda</option>
                        <option>Thornton</option>
                        <option>Barret</option>
                        <option>Old Hall</option>
                        <option>Amboseli</option>
                        <option>Victoria</option>
                        <option>Elementaita</option>
                        <option>Bogoria</option>
                        <option>Tana</option>
                        <option>Aberdares</option>
                        <option>Turkana</option>
                        <option>Mau</option>
                        <option>Naivasha</option>
                        <option>Tsavo</option>
                        <option>Mama Ngina</option>
                        <option>River View</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" onkeyup='check();'> <span id='message'></span>
                </div>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='hallsOfficerLogin.jsp'">Cancel</button>
            </form>
				<!-- Form End-->
            <script>
                function validateForm()                                    
                    { 
                		var staffNo = document.forms["custodian_registration_form"]["staffNo"];
                        var fname = document.forms["custodian_registration_form"]["fname"];               
                        var lname = document.forms["custodian_registration_form"]["lname"];
                        var uname = document.forms["custodian_registration_form"]["uname"];
                        var hostel = document.forms["custodian_registration_form"]["hostel"];
                        var password = document.forms["custodian_registration_form"]["password"];
                        var confirmPassword = document.forms["custodian_registration_form"]["confirmPassword"];
                        
                        if (staffNo.value == "")                                  
                        { 
                            window.alert("Please enter your Staff Number."); 
                            staffNo.focus(); 
                            return false; 
                        } 

                        if (fname.value == "")                                  
                        { 
                            window.alert("Please enter your First Name."); 
                            fname.focus(); 
                            return false; 
                        } 

                        if (lname.value == "")                                  
                        { 
                            window.alert("Please enter your Last Name."); 
                            lname.focus(); 
                            return false; 
                        } 

                        if (uname.value == "")                                  
                        { 
                            window.alert("Please enter your Username."); 
                            uname.focus(); 
                            return false; 
                        } 
                        
                        if (hostel.value == "")                        
                        { 
                            window.alert("Please enter the Hostel."); 
                            hostel.focus(); 
                            return false; 
                        } 
                        
                        if (password.value == "")                        
                        { 
                            window.alert("Please enter your Password."); 
                            password.focus(); 
                            return false; 
                        } 
                        
                        if (confirmPassword.value == "")                        
                        { 
                            window.alert("Please confirm your Password."); 
                            confirmPassword.focus(); 
                            return false; 
                        } 
                        
                        if (confirmPassword.value == password)                        
                        { 
                            window.alert("Your current password does not match with your current password."); 
                            confirmPassword.focus(); 
                            return false; 
                        } 


                        return true; 
                    }

                var check = function() {
                      if (document.getElementById('password').value ==
                        document.getElementById('confirmPassword').value) {
                        document.getElementById('message').style.color = 'green';
                        document.getElementById('message').innerHTML = 'matching';
                      } else {
                        document.getElementById('message').style.color = 'red';
                        document.getElementById('message').innerHTML = 'not matching';
                      }
                    }
	       </script>
		</div>
	</div>
</body>
</html>