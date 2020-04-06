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
	<script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>ChainlinkPrototype - PROPERTIES</title>
  </head>
  <body>
    <h1>Properties</h1>
	    <div class="container-sm">
	    	<a href="newProperty" class="btn btn-success">Add Property</a>
	    	<c:choose>
	    		<c:when test="${empty intelProperties}">
	    			<div class="row">
	    				<div class="col">
	   						<h2>No Property consider Adding one</h2>
	    				</div>
	    			</div>
					<div class="row">
						<div class="col">
							<a href="newProperty" class="btn btn-success">Add Property</a>
						</div>
					</div>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${intelProperties}" var="property">
						<div class="row">
							<div class="col">
								<h3>${property.propName}</h3>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<span>Date Created:</span><span>${property.dateAdded}</span>
							</div>
							<div class="col">
								<span>Date Modified:</span><span>${property.dateModified}</span>
							</div>
						</div>
					</c:forEach>
	    		</c:otherwise>
	    	</c:choose>	    	
	    </div>	
  </body>
</html>