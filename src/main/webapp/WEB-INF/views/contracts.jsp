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
    <title>ChainlinkPrototype - Contracts</title>
  </head>
  <body>
    <h1>Contracts</h1>
	    <div class="container-sm">
	    	<c:choose>
	    		<c:when test="${empty contracts}">
	    			<div class="row">
	    				<div class="col">
	   						<h2>No Active Contracts</h2>
	   						<h4>Add a property or be invited to a contract to view contracts here</h4>
	    				</div>
	    			</div>
	    		</c:when>
	    		<c:otherwise>
	    			<c:forEach items="${contracts}" var="contract">
						<div class="row">
							<div class="col">
								<h3>${contract.contractType}</h3>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<span>Date Created:</span><span>${contract.dateCreated}</span>
							</div>
							<div class="col">
								<span>Date Modified:</span><span>${contract.dateModified}</span>
							</div>
						</div>
					</c:forEach>
	    		</c:otherwise>
	    	</c:choose>	    	
	    </div>	
  </body>
</html>