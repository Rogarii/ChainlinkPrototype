<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<!-- Optional JavaScript -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://kit.fontawesome.com/b572e6d222.js" crossorigin="anonymous"></script>
		<title>ChainlinkPrototype - PROPERTIES</title>
		<style>
    	body{
    		background-image: url("images/background.jpg");
    		background-repeat: no-repeat;
    		background-size: cover;
    	}
    	.card, .alert{
    		background-color: rgba(245, 245, 245, 0.75) !important;
    		box-shadow: 5px 5px;
    		border: 2px solid black;
    	}
    	</style>
 	</head>
	<body>
		<jsp:useBean id="date" class="java.util.Date"/>
		<div class="m-3">
			<div class="row">
	    		<div class="col">
	    			<a href="dashboard" class="btn btn-danger"><i class="fas fa-house-user"></i></a>
	    		</div>
    		</div>
			<c:choose>
		    	<c:when test="${empty intelProperties}">
		  			<div class="row mx-auto mt-5" style="width: 30%;">
						<div class="col p-1">
							<div class="card text-center">
								<div class="card-body">
							  		<h4 class="card-title">No Properties? Add Some Music!</h4>
							  			<div class="row">
							  			<div class="col">
							  				<a href="newProperty" class="btn btn-lg btn-outline-primary">Add Property</a>
							  			</div>
							  		</div>
							  	</div>
							</div>
						</div>
					</div>
		    	</c:when>
		    	<c:otherwise>
		 			<div class="row mx-auto mt-5" style="width: 50%;">
		 				<div class="col p-1">
		 					<div class="card">
		 						<div class="card-body">
		 							<div class="row">
		 								<div class="col">
		 									<h4 class="card-title">My Properties</h4>
		 								</div>
		 								<div class="col">
		 									<a href="newProperty" class="btn btn-outline-primary float-right">Add Property</a>
		 								</div>
		 							</div>
		 							<c:forEach items="${intelProperties}" var="prop">
		 							<div class="card my-2 mx-auto" style="width: 80%;">
		 								<div class="card-body">
		 									<div class="row">
		 										<div class="col-4">
			 										<span>Name: ${prop.propName}</span>
			 									</div>
			 									<div class="col-5">
			 										<span>Updated: <fmt:formatDate value="${prop.dateModified}" type="date" pattern="MM-dd-yyyy"/></span>
			 									</div>
			 									<div class="col-3">
			 										<button class="btn btn-sm btn-outline-primary float-right ml-1" title="Show More" type="button" data-toggle="collapse" data-target="#${prop.id}collapse" aria-expanded="false" aria-controls="${prop.id}collapse" id="${prop.id}button"><i class="fas fa-chevron-down"></i></button>
			 										<button class="btn btn-sm btn-outline-primary float-right dropdown-toggle" title="Options" type="button" id="${prop.id}dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-cog"></i></button>
			 										<div class="dropdown-menu" aria-labelledby="${prop.id}dropdown">
			 											<a class="dropdown-item" href="propertyInfo/${prop.id}">View Property</a>
			 											<a class="dropdown-item" href="editProperty/${prop.id}">Edit Property</a>
			 											<a class="dropdown-item" href="#">Delete Property</a>
			 										</div>
			 									</div>		
		 									</div>
			 								<div class="collapse row" id="${prop.id}collapse">
			 									<div class="col">
				 									<div class="row">
				 										<div class="col">
				 											<span>Added:</span>
				 										</div>
				 										<div class="col">
				 											<span><fmt:formatDate value="${prop.dateAdded}" type="date" pattern="MM-dd-yyyy"/></span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Song Title:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaSong}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Artist:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaArtist}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Album:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaAlbum}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Album Artist:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaAlbumArtist}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Composer:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaComposer}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Grouping:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaGrouping}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>Year:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaYear}</span>
				 										</div>
				 									</div>
				 									<div class="row">
				 										<div class="col">
				 											<span>BPM:</span>
				 										</div>
				 										<div class="col">
				 											<span>${prop.metaBpm}</span>
				 										</div>
				 									</div>
			 									</div>
			 								</div>		
			 							</div>
			 						</div>
		 							</c:forEach>
		 						</div>
		 					</div>
		 				</div>
		 			</div>
		    	</c:otherwise>
		    </c:choose>	    	
 		</div>
	</body>
</html>