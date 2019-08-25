<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/welcome.css" type="text/css" rel="stylesheet">
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
            <form class="form-container" method="post" action="/welcome" id="commentForm" name="commentForm" onsubmit="return formValidate()">
                <br>
                <button type="button" class="btn btn-dark btn-block" onClick="window.location.href='addressedComplaints.jsp'">List of Already Addressed Complaints</button>
                <br>
                <h1>Welcome ${student.fname}</h1>
                <br>
                <h1>Complaint Form</h1>
                  <div class="form-group">
                    <label for="complaintTitle">Complaint Title:</label>
                    <input type="text" class="form-control" id="complaintTitle" name="complaintTitle" placeholder="Complaint Title">
                  </div>
                  <div class="form-group">
                    <label for="complaintDescription">Complaint Description:</label>
                    <textarea rows="5" cols="50" class="form-control" id="complaintDescription" name="complaintDescription" placeholder="Complaint Description"></textarea>
                  </div>
                <input type="hidden" name="fname" value="${student.fname}">
                <input type="hidden" name="lname" value="${student.lname}">
                <input type="hidden" name="uname" value="${student.uname}">
                <input type="hidden" name="regNo" value="${student.regNo}">
                <input type="hidden" name="hostel" value="${student.hostel}">
                <input type="hidden" name="block" value="${student.block}">
                <input type="hidden" name="roomNumber" value="${student.roomNumber}">
                
                  <button type="submit" class="btn btn-success btn-block">Submit</button>
                <br>
                  <button type="button" class="btn btn-danger btn-block" onClick="window.location.href='studentLogin.jsp'">Log Out</button>
            </form>
				<!-- Form End-->
		</div>
		<div class="col-md-2 col-sm-4 col-xs-12"></div>
	</div>
	<script type="text/javascript">
	 function formValidate()                                    
     { 
         var complaintTitle = document.forms["commentForm"]["complaintTitle"];               
         var complaintDescription = document.forms["commentForm"]["complaintDescription"];
        
         if (complaintTitle.value == "")                                  
         { 
             window.alert("Please enter the Complaint Title."); 
             complaintTitle.focus(); 
             return false; 
         } 

         if (complaintDescription.value == "")                                  
         { 
             window.alert("Please enter the Complaint Description."); 
             complaintDescription.focus(); 
             return false; 
         }

         return true; 
     }	
	</script>

</body>
</html>