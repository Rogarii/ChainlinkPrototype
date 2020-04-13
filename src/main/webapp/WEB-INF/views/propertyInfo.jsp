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
		<title>ChainlinkPrototype - PROPERTY INFO</title>
		<style>
    	body{
    		background-image: url("/ChainlinkPrototype/images/background.jpg");
    		background-repeat: no-repeat;
    		background-size: cover;
    	}
    	.card, .alert{
    		background-color: rgba(245, 245, 245, 0.75) !important;
    		box-shadow: 5px 5px;
    		border: 2px solid black;
    	}
    	#iframeOverlayLyrics, #iframeOverlayComp{
    		position: fixed;
    		width: 100%;
    		height: 100%;
    		top: 0;
    		right: 0;
    		background-color: rgba(0, 0, 0, 0.75) !important;
    		z-index: 10;
    	}
    	iframe{
    		background-color: rgba(245, 245, 245, 0.75) !important;
    		width: 100%;
    	}
    	</style>
 	</head>
	<body>
		<jsp:useBean id="date" class="java.util.Date"/>
		<div class="m-3">
			<div class="row">
	    		<div class="col">
	    			<a href="/ChainlinkPrototype/dashboard" class="btn btn-danger"><i class="fas fa-house-user"></i></a>
	    		</div>
    		</div>
    		<c:choose>
    			<c:when test="${property == null}">
    				<div class="row mx-auto mt-5" style="width: 30%;">
						<div class="col p-1">
							<div class="card text-center">
								<div class="card-body">
							  		<h4 class="card-title">Property Not Found</h4>
							  	</div>
							</div>
						</div>
					</div>
    			</c:when>
    			<c:otherwise>
    				<div class="d-none" id="iframeOverlayLyrics">
    					<button id="lyricsCloseButton" class="btn btn-sm btn-danger float-right m-3"><i class="fas fa-times-circle"></i></button>
    					<div class="mx-auto mt-5 p-1" style="width: 50%;">
    						<div class="card h-100">
    							<div class="card-body">
    								<div class="row">
    									<div class="col">
    										<iframe src="/ChainlinkPrototype/propertyLyrics/${property.id}" style="height: 500px;"></iframe>
    									</div>
    								</div>
    								<div class="row mt-2">
    									<div class="col">
    										<a href="/ChainlinkPrototype/propertyLyrics/${property.id}" title="Download" class="btn btn-outline-primary float-right"><i class="fas fa-file-download"></i></a>
    									</div>
    								</div>			
    							</div>
    						</div>										
    					</div>
    				</div>
    				<div class="d-none" id="iframeOverlayComp">
    					<button id="compCloseButton" class="btn btn-sm btn-danger float-right m-3"><i class="fas fa-times-circle"></i></button>
    					<div class="mx-auto mt-5 p-1" style="width: 50%;">
    						<div class="card h-100">
    							<div class="card-body">
    								<div class="row">
    									<div class="col">
    										<iframe src="/ChainlinkPrototype/propertyComp/${property.id}" style="height: 500px;"></iframe>
    									</div>
    								</div>
    								<div class="row mt-2">
    									<div class="col">
    										<a href="/ChainlinkPrototype/propertyComp/${property.id}" title="Download" class="btn btn-outline-primary float-right"><i class="fas fa-file-download"></i></a>
    									</div>
    								</div>			
    							</div>
    						</div>										
    					</div>
    				</div>
    				<div class="row mx-auto mt-5" style="width: 50%;">
		 				<div class="col p-1">
		 					<div class="card">
		 						<div class="card-body">
		 							<button class="btn btn-sm btn-outline-primary float-right dropdown-toggle" title="Options" type="button" id="dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-cog"></i></button>
		 								<div class="dropdown-menu" aria-labelledby="dropdown">
			 								<a class="dropdown-item" href="#">Edit Property</a>
			 								<a class="dropdown-item" href="#">Delete Property</a>
			 							</div>
		 							<h4 class="card-title">${property.propName}</h4>
		 							<div class="row">
		 								<div class="col">
		 									<span>Date Added:</span> 
		 								</div>
		 								<div class="col">
		 									<span><fmt:formatDate value="${property.dateAdded}" type="date" pattern="MM-dd-yyyy"/></span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Date Updated:</span>
		 								</div>
		 								<div class="col">
		 									<span><fmt:formatDate value="${property.dateModified}" type="date" pattern="MM-dd-yyyy"/></span>
		 								</div>
		 							</div>
		 							<div class="row mt-2">
		 								<div class="col">
		 									<button id="compButton" class="btn btn-outline-primary">Composition</button>
		 								</div>
		 								<div class="col">
		 									<button id="lyricsButton" class="btn btn-outline-primary">Lyrics</button>
		 								</div>
		 							</div>
		 							<div class="row mt-2">
		 								<div class="col">
		 									<h5>Property Meta Data</h5>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Song Title:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaSong}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Artist:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaArtist}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Album Artist:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaAlbumArtist}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Composer:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaComposer}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Grouping:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaGrouping}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Genre:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaGenre}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>Year:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaYear}</span>
		 								</div>
		 							</div>
		 							<div class="row">
		 								<div class="col">
		 									<span>BPM:</span>
		 								</div>
		 								<div class="col">
		 									<span>${property.metaBpm}</span>
		 								</div>
		 							</div>
		 						</div>
		 					</div>
		 				</div>
		 			</div>
    			</c:otherwise>
    		</c:choose>
 		</div>
 		<script>
			$("#compButton").click(function(){
				$("#iframeOverlayComp").toggleClass("d-none");
				});
			$("#lyricsButton").click(function(){
				$("#iframeOverlayLyrics").toggleClass("d-none");
				});
			$("#compCloseButton").click(function(){
				$("#iframeOverlayComp").toggleClass("d-none");
				});
			$("#lyricsCloseButton").click(function(){
				$("#iframeOverlayLyrics").toggleClass("d-none");
				});
 		</script>
	</body>
</html>