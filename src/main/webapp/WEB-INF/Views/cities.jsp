

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en" class="no-js">
<head>

 <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

  
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
  	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<title>Contact Form | CodyHouse</title>
	
	<script>

$(document).ready(function(){	
	$.ajax({
        type:"GET",
        url : "/getCities",
       
        success : function(data) {
            $('#city').empty(); //remove all child nodes
           
            
              for(var i = 0; i < data.length; i++){
                var newOption = $('<option value='+data[i]+'>'+data[i]+'</option>');
                $('#city').append(newOption);
            }   
        },
        error: function() {
            alert('Error occured');
        }
    });
	
});
</script>
</head>
<body>
	
	<form action="lowestPricedHotels" method="get" class="cd-form floating-labels"
		 >
		<fieldset>
		

		

			<div class="icon">
				<label class="cd-label" for="city"></label>
				Choose Your City
					<p class="cd-select icon">
					
					<select  id="city" name="city" class="city">
						<option value=" "></option>
					
					</select>
				</p>
			 </div> 
			 
			 		<div>
		      	<input type="submit" value="View Lowest Price Hotels">
		      	
		      		<input type="button" value="Cancel " onclick="location.href='cancelBooking';">
		      	
		    </div>
	
		   
		   
		</fieldset>

		</form>


<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>