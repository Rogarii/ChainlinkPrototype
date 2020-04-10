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
	    <script src="https://kit.fontawesome.com/b572e6d222.js" crossorigin="anonymous"></script>
	    <title>ChainlinkPrototype - LOGIN</title>
	    <style>
	    	body{
	    		background-image: url("images/background.jpg");
	    		background-repeat: no-repeat;
	    		background-size: cover;
	    	}
	    	.card{
	    		background-color: rgba(245, 245, 245, 0.75) !important;
	    		box-shadow: 5px 5px;
	    		border: 2px solid black;
	    	}
	    	input{
	    		background-color: rgba(245, 245, 245, 0.75) !important;
	    	}
		</style>
	</head>
  	<body>
		<div class="m-3">
			<div class="row">
	    		<div class="col">
	    			<a href="/ChainlinkPrototype/" class="btn btn-danger"><i class="fas fa-home"></i></a>
	    		</div>
    		</div>
		  	<div class="row mx-auto mt-5" style="width: 25%;">
			  	<div class="col p-1">
			  		<div class="card p-1">
			  			<div class="card-body">
			  				<h5 class="card-title">Login</h5>
			  				<c:if test="${loginError}">
			  					<p class="text-danger"><strong>Incorrect Email/Password</strong></p>
			  				</c:if>
			  				<form action="doLogin" method="post">
			    				<div class="row">
			    					<div class="col">
			    						<div class="form-group ">
			    							<label for="emailInput">Email Address</label>
			    							<input type = "email" class="form-control" id="emailInput" placeholder="Email Address" name="username" required>
			    						</div>
			    					</div>
			    				</div>
			    				<div class="row">
			    					<div class="col">
					    				<div class="form-group">
					    					<label for="passwordInput">Password</label>
					    					<input type ="password" class="form-control" id="passwordInput" placeholder="Password" name="password" required>
					    				</div>				
				    				</div>
				    			</div>
				    			<div class="row">
				    				<div class="col">
				    					<button type="submit" class="btn btn-outline-primary float-left">Submit</button>
				    				</div>
				    				<div class="col">
				    					<a href="newUser" class="btn btn-outline-success float-right">New User</a>
				    				</div>
			    				</div>
			    			</form> 	
			  			</div>
			  		</div>
				</div>
			</div>
		</div>
	</body>
</html>