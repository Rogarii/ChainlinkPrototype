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
    <title>ChainlinkPrototype - DASHBOARD</title>
    <style>
    	body{
    		background-image: url("images/background.jpg");
    		background-repeat: no-repeat;
    		background-size: cover;
    	}
    </style>
  </head>
  <body>
    <div class="contrainer-fluid m-3">
    	<div class="row">
    		<div class="col ">
    			<a href="doLogout" class="btn btn-danger">Logout</a>
    		</div>
    	</div>
    	<div class="row mt-3 mx-auto" style="width: 40%;">
    		<div class="col p-1">
    			<div class="card" >
    				<img src="<c:url value="/images/music.png"/>" class="card-img-top mx-auto mt-2" style="max-height: 175px; max-width: 175px; width: auto; height: auto;">
    				<div class="card-body">
    					<h5 class="card-title">My Music (Properties)</h5>
    					<a href="properties" class="btn btn-outline-primary">View Properties</a>
    				</div>
    			</div>
    		</div>
    		<div class="col p-1">
    			<div class="card ">
    				<img src="<c:url value="/images/options.png"/>" class="card-img-top mx-auto mt-2" style="max-height: 175px; max-width: 175px; width: auto; height: auto;">
    				<div class="card-body">
    					<h5 class="card-title">My Account</h5>
    					<a href="newAccount" class="btn btn-outline-success">View Account</a>
    				</div>
    			</div>
    		</div>
    	</div>
    	<div class="row mx-auto" style="width: 40%;">
    		<div class="col p-1">
    			<div class="card" >
    				<img src="<c:url value="/images/contract.png"/>" class="card-img-top mx-auto mt-2" style="max-height: 175px; max-width: 175px; width: auto; height: auto;">
    				<div class="card-body">
    					<h5 class="card-title">My Contracts</h5>
    					<a href="properties" class="btn btn-outline-dark">View Contracts</a>
    				</div>
    			</div>
    		</div>
    		<div class="col p-1">
    			<div class="card">
    				<img src="<c:url value="/images/chart.png"/>" class="card-img-top mx-auto mt-2" style="max-height: 175px; max-width: 175px; width: auto; height: auto;">
    				<div class="card-body">
    					<h5 class="card-title">Recent Activity</h5>
    					<a href="properties" class="btn btn-outline-info">View Activity</a>
    				</div>
    			</div>
    		</div>
    	</div>
   </div>
  </body>
</html>