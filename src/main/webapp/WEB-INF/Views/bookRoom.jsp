

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

	var bookedRooms=null;
	 var totalRooms=null;
	 
	  $(function() {
		    $( "#checkInDate" ).datepicker({
		        changeMonth: true,
		        changeYear: true,
		        yearRange: "c-1:c+5",
		        dateFormat: "dd-mm-yy"
		    });
		    //$( "#checkInDate" ).datepicker("show");
		    $( "#checkOutDate" ).datepicker({
		        changeMonth: true,
		        changeYear: true,
		        yearRange: "c-1:c+5",
		        dateFormat: "dd-mm-yy",
		    beforeShow: end_Range});
		    //$( "#checkOutDate" ).datepicker("show");
		 });
	 
	 function end_Range(){
		 //alert("check in date "+$("#checkInDate").datepicker("getDate"));
	        if ($("#checkInDate").datepicker("getDate") == null ){
	        	
	             $("#checkInDate").focus();
	            
	        } else {
	            // set minimum date range
	            $("#checkOutDate").datepicker("option", "minDate", new Date ($("#checkInDate").datepicker("getDate")));
	        };
	    };
	  
	 $('#cities').change(function() {
		   
		   /* alert('cities');
		   alert('city is '+$('#cities').val()); */
		    $.ajax({
		        type:"GET",
		        url : "/getHotels",
		        data : { city: $('#cities').val()},
		        success : function(data) {
		            $('#hotels').empty(); //remove all child nodes
		            
		            
		             for(var i = 0; i < data.length; i++){
		                var newOption = $('<option value='+data[i]+'>'+data[i]+'</option>');
		                $('#hotels').append(newOption);
		            }   
		        },
		        error: function() {
		            alert('Error occured');
		        }
		    });
		});

	 
 	 
	 $('#reservationForm').submit(function()
			 {
	
		 if($('#cities').val() !='' && $('#hotels').val() !='' && $('#checkInDate')!='' && $('#checkOutDate').val() !='')
		 {
			 $.ajax({
		 
		        type:"GET",
		        url : "/checkRoomAvailability",
		        async:false,
		        data : { city: $('#cities').val(),hotelName:$('#hotels').val(),inDate:$('#checkInDate').val(),outDate:$('#checkOutDate').val()},
		        success : function(data) {
		           bookedRooms=data;
		           
		        },
		        error: function() {
		            alert('Error occured bookedrooms');
		        }
		    });
		 
		 $.ajax({
		        type:"GET",
		        url : "/getTotalRooms",
		        async:false,
		        data : { city: $('#cities').val(),hotelName:$('#hotels').val()},
		        success : function(data) {
		           totalRooms=data;
		          
		        },
		        error: function() {
		            alert('Error occured gettotalrooms');
		        }
		    });
		 
		
		if((totalRooms-bookedRooms)<0 )
		 { alert('Rooms are not available for booking this time period');
		 return false;
		 }
		else
		{	
			
				alert('Rooms are avilable .You are Good with this booking ');
	 return true;
		}
		 }//end if
		});
		 
			 
			 }); 
	 
 
</script>
	
	
</head>
<body>
	<fieldset>
	<form:form action="reserveRoom" method="post" class="cd-form floating-labels"
		commandName="reservationForm" id='reservationForm'>
		
			<legend>Account Info</legend>

		

			<div class="icon">
				<label class="cd-label" for="cd-name"></label>
				Choose Your City
					<p class="cd-select icon">
					
					<form:select path="city" id="cities" name="cd-name" class="city">
						<option value=" "></option>
						<c:forEach var="city" items="${requestScope.cities}">
							<option value="${city}">${city}</option>
						</c:forEach>
					</form:select>
					
				</p>
				<div class="error-message"><form:errors path="city" cssStyle="color:red;"/></div>
			 </div> 
			 
			 <div class="icon">
				<label class="cd-label" for="cd-hotel">Choose Your hotel</label>
				Choose Your Hotel
					<p class="cd-select icon">
					
					<form:select path="hotelName" id="hotels" name="cd-hotel">
						<c:forEach var="hotel" items="${requestScope.hotels}">
							<option value="${hotel}">${hotel}</option>
						</c:forEach>
					</form:select>
					
				</p>
				<div class="error-message"><form:errors path="hotelName" cssStyle="color:red;"/></div>
			 </div> 
			  <div class="icon">
			  Choose Check in Date:
						<form:input path="inDate" type="text"
						id="checkInDate" />
						
					   <div class="error-message">	<form:errors path="inDate" cssStyle="color:red;" /></div>
	      </div>
	      <div class="error-message">	<form:errors path="inDate" /></div>
	      <div class="icon">
			  Choose Check Out Date:
						<form:input path="outDate"
						type="text" id="checkOutDate" />
						
						<div>	<form:errors path="outDate" cssStyle="color:red;"/></div>
	      </div> 
	      
	      <div class="icon">
			  Enter Guest Name:
						<form:input path="guestName" type="text"
						id="guestName" />
						</div>
							<div ><form:errors path="guestName" cssStyle="color:red;"/>
	      </div> 
	      
	        <div class="icon">
			  Rooms Required:
						<form:input path="roomsReserved" type="text"
						id="roomsReserved" /></div>
						
						<div>	<form:errors path="roomsReserved" cssStyle="color:red;"/>
	      </div> 
	
					
			<div class="icon">	
		<div>
		      	<input type="submit" value="Book Room">
		      	<input type="button" value="Cancel Booking" onclick="location.href='cancelBooking';">
		      	
		    </div>
		     	
		    </div>
		   
		

		</form:form>
		
</fieldset>

<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>