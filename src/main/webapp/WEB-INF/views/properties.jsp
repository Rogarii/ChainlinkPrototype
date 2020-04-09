<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="m-3">
			<div class="row">
	    		<div class="col">
	    			<a href="dashboard" class="btn btn-danger">Back</a>
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
		 								<div class="row mt-3">
		 									<div class="col">
		 										<span>Name: ${prop.propName}</span>
		 									</div>
		 									<div class="col">
		 										<span>Created: ${prop.dateAdded}</span>
		 									</div>
		 									<div class="col">
		 										<span>Updated: ${prop.dateModified}</span>
		 									</div>
		 									<div class="col">
		 										<button class="btn btn-outline-primary float-right" type="button" data-toggle="collapse" data-target="#${prop.id}collapse" aria-expanded="false" aria-controls="${prop.id}collapse" id="${prop.id}button">Show More</button>
		 									</div>		
		 								</div>
		 								<div class="collapse row" id="${prop.id}collapse">
		 									<div class="col">
		 										<div class="row m-1">
			 										<div class="col">
			 											<span>Song Title: ${prop.metaSong}</span>
			 										</div>
			 										<div class="col">
			 											<span>Artist: ${prop.metaArtist}</span>
			 										</div>
			 										<div class="col">
			 											<span>Album: ${prop.metaAlbum}</span>
			 										</div>
			 										<div class="col">
			 											<span>Album Artist: ${prop.metaAlbumArtist}</span>
			 										</div>
		 										</div>
		 										<div class="row m-1">
		 											<div class="col">
			 											<span>Composer: ${prop.metaComposer}</span>
			 										</div>
			 										<div class="col">
			 											<span>Grouping: ${prop.metaGrouping}</span>
			 										</div>
			 										<div class="col">
			 											<span>Year: ${prop.metaYear}</span>
			 										</div>
			 										<div class="col">
			 											<span>BPM: ${prop.metaBpm}</span>
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