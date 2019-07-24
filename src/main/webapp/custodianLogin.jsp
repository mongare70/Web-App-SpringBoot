<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/studentLogin.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
				<!-- Form Start -->
            <form class="form-container" method="post" action="/custodianLogin" name="custodian_login_form" id="custodian_login_form" onsubmit="return validateForm()">
                <h1>Custodian Login Form</h1>
                  <div class="form-group">
                    <label for="uname">Username</label>
                    <input type="text" class="form-control" id="uname" name="uname" placeholder="Username">
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <p class="message">Not registered? <a href="/custodianRegistration">Create an account</a></p>
            </form>
				<!-- Form End-->
		</div>
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
	</div>
	<script type="text/javascript">
	 function validateForm()                                    
     { 
         var uname = document.forms["custodian_login_form"]["uname"];               
         var password = document.forms["custodian_login_form"]["password"];
        
         if (uname.value == "")                                  
         { 
             window.alert("Please enter your Username."); 
             uname.focus(); 
             return false; 
         } 

         if (password.value == "")                                  
         { 
             window.alert("Please enter your Password."); 
             password.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>
</body>
</html>