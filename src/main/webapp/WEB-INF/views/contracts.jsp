<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	    <title>ChainlinkPrototype - Contracts</title>
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
		    	<c:when test="${empty contracts}">
		  			<div class="row mx-auto mt-5" style="width: 30%;">
						<div class="col p-1">
							<div class="card text-center">
								<div class="card-body">
							  		<h4 class="card-title">No Contracts Found</h4>
							  		<div class="row">
							  			<div class="col">
							  				<P>Upload a New Property to have us generate a Royalties Contract for you!</p>
							  				<p>Or Propose a Contract to another User!</p>
							  			</div>
							  		</div>
							  			<div class="row">
							  				<div class="col">
								  				<a href="#" class="btn btn-lg btn-outline-primary">Make Contract</a>
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
		 									<h4 class="card-title">My Contracts</h4>
		 								</div>
		 								<div class="col">
		 									<a href="#" class="btn btn-outline-primary float-right">Make Contract</a>
		 								</div>
		 							</div>
		 							<c:forEach items="${contracts}" var="con">
			 							<div class="card my-2 mx-auto" style="width: 80%;">
			 								<div class="card-body">
			 									<div class="row">
			 										<div class="col-4">
			 											<c:set var="propertiesList" value="properties${con.id}" />
				 										<c:if test="${fn:length(requestScope[propertiesList]) <= 1}" >
				 											<span>Contract: ${requestScope[propertiesList][0].propName}</span>
				 										</c:if>
				 										<c:if test="${fn:length(requestScope[propertiesList]) > 1}" >
				 											<span>Contract: ${requestScope[propertiesList][0]} + ${fn:length(requestScope[propertiesList])} More</span>
				 										</c:if>
				 									</div>
				 									<div class="col-5">
				 										<span>Updated: <fmt:formatDate value="${con.dateModified}" type="date" pattern="MM-dd-yyyy"/></span>
				 									</div>
				 									<div class="col-3">
				 										<button class="btn btn-sm btn-outline-primary float-right ml-1" title="Show More" type="button" data-toggle="collapse" data-target="#${con.id}collapse" aria-expanded="false" aria-controls="${con.id}collapse" id="${con.id}button"><i class="fas fa-chevron-down"></i></button>
				 										<button class="btn btn-sm btn-outline-primary float-right dropdown-toggle" title="Options" type="button" id="${con.id}dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-cog"></i></button>
				 										<div class="dropdown-menu" aria-labelledby="${con.id}dropdown">
				 											<a class="dropdown-item" href="#">View Contract</a>
				 											<a class="dropdown-item" href="#">Edit Contract</a>
				 											<c:if test="${!con.deployed}">
					 											<a class="dropdown-item" href="#">Activate Contract</a>
					 										</c:if>
				 										</div>
				 									</div>		
			 									</div>
				 								<div class="collapse row" id="${con.id}collapse">
				 									<div class="col">
					 									<div class="row">
					 										<div class="col">
					 											<span>Created:</span>
					 										</div>
					 										<div class="col">
					 											<span><fmt:formatDate value="${con.dateCreated}" type="date" pattern="MM-dd-yyyy"/></span>
					 										</div>
					 									</div>
					 									<div class="row">
					 										<div class="col">
					 											<span>Type:</span>
					 										</div>
					 										<div class="col">
					 											<c:choose>
				 													<c:when test="${con.contractType == 'ROY'}">
				 														Royalty
				 													</c:when>
				 												</c:choose>
					 										</div>
					 									</div>
					 									<div class="row">
					 										<div class="col">
					 											<span>Active Status:</span>
					 										</div>
					 										<div class="col">
					 											<span>
					 												<c:if test="${con.deployed}">
					 													Active
					 												</c:if>
					 												<c:if test="${!con.deployed}">
					 													Inactive
					 												</c:if>
					 											</span>
					 										</div>
					 									</div>
					 									<div class="row">
					 										<div class="col">
					 											<span><strong>Associated Properties:</strong></span>
					 										</div>
					 									</div>	
					 									<c:set var="propertiesList" value="properties${con.id}" />
					 									<c:forEach items="${requestScope[propertiesList]}" var="prop">	 									
					 										<div class="row">
					 											<div class="col">
					 												<span>${prop.propName}</span>
					 											</div>
					 											<div class="col">
					 												<a class="btn btn-sm btn-outline-primary float-right" href="#"><i class="fas fa-cog"></i></a>
					 											</div>
					 										</div>
					 									</c:forEach>
					 									<div class="row">
					 										<div class="col">
					 											<span><strong>Associated Users:</strong></span>
					 										</div>
					 									</div>	
					 									<c:set var="usersList" value="users${con.id}" />	
					 									<c:forEach items="${requestScope[usersList]}" var="account">	 	
					 										<div class="row">
					 											<div class="col">
					 												<span>${account.user.firstName} </span>
					 												<span>${account.user.lastName}</span>
					 											</div>
					 											<div class="col">
					 												<a class="btn btn-sm btn-outline-primary float-right" href="#"><i class="fas fa-cog"></i></a>
					 											</div>
					 										</div>
					 									</c:forEach>							
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