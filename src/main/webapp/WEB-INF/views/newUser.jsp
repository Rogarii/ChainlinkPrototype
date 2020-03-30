<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	    <title>ChainlinkPrototype - NEW USER</title>
  	</head>
	<body>
		<div class="container-sm">
			<div class ="row">
	    		<div class="col">
	    			<h2>Create User</h2>
	    		</div>
	    	</div>
			<form:form action="createUser" method="post" modelAttribute="newUserForm">
	    		<div class="row">
	    			<div class="col">
	    				<div class="form-group ">
	    					<form:label path="email">Email Address</form:label>
	    					<form:input path="email" class="form-control" placeholder="Email Address" type="email" required="required"/>
	    				</div>
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col">
	    				<div class="form-group ">
	    					<form:label path="email2">Confirm Email</form:label>
	    					<form:input path="email2" class="form-control" placeholder="Confirm Email" type="email" required="required"/>
	    				</div>
	    			</div>
	    		</div>	
	    		<div class="row">
	    			<div class="col">
		    			<div class="form-group">
		    				<form:label path="password">Password</form:label>
	    					<form:password path="password" class="form-control" placeholder="Password" required="required"/>
		    			</div>				
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col">
		    			<div class="form-group">
		    				<form:label path="password2">Confirm Password</form:label>
	    					<form:password path="password2" class="form-control" placeholder="Confirm Password" required="required"/>
		    			</div>				
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col">
		    			<div class="form-group">
		    				<form:label path="firstName">First Name</form:label>
	    					<form:input path="firstName" class="form-control" placeholder="First Name" type="text" required="required"/>
		    			</div>				
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col">
		    			<div class="form-group">
		    				<form:label path="lastName">Last Name</form:label>
	    					<form:input path="lastName" class="form-control" placeholder="Last Name" type="text" required="required"/>
		    			</div>				
	    			</div>
	    		</div>
	    		<div class="row">
	    			<div class="col">
	    				<div class="form-group">
	    					<button type="submit" class="btn btn-primary">Submit</button>
	    				</div>
	    			</div>
	    		</div>
    		</form:form> 	
		</div>
  	</body>
</html>