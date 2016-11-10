

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
<link href="bootstrap.min.css" rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
  	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Contact Form | CodyHouse</title>
	
		
</head>
<body>
	
	<div class="cd-form floating-labels">
	  	  <fieldset>
	  
	  <div class="row ">
	  <div class="col-md-4">
	  <label class="cd-label" >HotelName</label> 
	  </div>
	  <div class="col-md-4">
	  <label class="cd-label" >Price</label>
	  </div>
	  <div class="col-md-4">
	  <label class="cd-label" >TotalRooms</label>
	  </div>
	  </div>
	  
	  <c:forEach items="${hotelList}" var="current" begin="0" end="4">
       <div class="row ">
					<div class="col-md-4">
         <c:out value="${current.hotelName}" />
                      </div>
                      <div class="col-md-4">
           <c:out value="${current.price}" />
         				</div>
         				<div class="col-md-4">
           <c:out value="${current.totalRooms}" />
         				</div>
         				</div>
      </c:forEach>
	  <input type="button" value="Back" onclick=" window.history.back();">
	  </fieldset>
	  </div>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>