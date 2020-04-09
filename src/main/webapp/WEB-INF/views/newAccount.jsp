<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
  	<head>
    	<!--  Required meta tags -->
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	    <!-- Bootstrap CSS -->	
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    <!-- form:optional JavaScript -->
		<script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	    <script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	    <title>ChainlinkPrototype - NEW ACCOUNT</title>
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
			<div class="row mx-auto mt-2" style="width: 40%;">
			  	<div class="col p-1">
			  		<div class="card p-1">
			  			<div class="card-body">
			  				<h5 class="card-title">Setup Account</h5>
			  				<form:form action="createAccount" method="post" modelAttribute="newAccountForm">
					    		<div class="row">
					    			<div class="col">
					    				<div class="form-group ">
					    					<form:label path="accountType">Account Type</form:label>
					    					<p><sup>Account Use (Business Use, Artistic Group, Personal)</sup><sup class="text-danger"> Required</sup></p>
					    					<form:select path="accountType" class="form-control">
					    						<form:option value="PER" label="Personal"/>
					    						<form:option value="BUS" label="Business"/>
					    						<form:option value="GRP" label="Music Group"/>
					    					</form:select>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="accountTitle">Account Title</form:label>
					    					<p><sup>Personal Use Title for Account (Group Name, Business Title, Artist Title)</sup></p>
					    					<form:input path="accountTitle" class="form-control" placeholder="Account Title" type="text"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="citizenship">Citizenship</form:label>
					    					<p><sup>Country of Citizenship</sup><sup class="text-danger"> Required</sup></p>
					    					<form:select path="citizenship" class="form-control">
												   <form:option value="United States of America">United States of America</form:option>
					    					</form:select>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="country">Country of Residence</form:label>
					    					<p><sup>Current Country of Residence</sup><sup class="text-danger"> Required</sup></p>
					    					<form:select path="country" class="form-control">    				
											   <form:option value="United States of America">United States of America</form:option>
					    					</form:select>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="address1">Address Line 1</form:label>
					    					<p><sup>Current Address</sup><sup class="text-danger"> Required</sup></p>
					    					<form:input path="address1" class="form-control" placeholder="Address Line 1" type="text"  Required="required"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="address2">Address Line 2</form:label>
					    					<p><sup>Current Address</sup></p>
					    					<form:input path="address2" class="form-control" placeholder="Address Line 2" type="text"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="city">City</form:label>
					    					<p><sup>Current City of Residence</sup><sup class="text-danger"> Required</sup></p>
					    					<form:input path="city" class="form-control" placeholder="City" type="text"  Required="required"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="state">State</form:label>
					    					<p><sup>Current State of Residence</sup><sup class="text-danger"> Required</sup></p>
					    					<form:select path="state" class="form-control">
					    						<form:option value="AL">Alabama</form:option>
												<form:option value="AK">Alaska</form:option>
												<form:option value="AZ">Arizona</form:option>
												<form:option value="AR">Arkansas</form:option>
												<form:option value="CA">California</form:option>
												<form:option value="CO">Colorado</form:option>
												<form:option value="CT">Connecticut</form:option>
												<form:option value="DE">Delaware</form:option>
												<form:option value="DC">District of Columbia</form:option>
												<form:option value="FL">Florida</form:option>
												<form:option value="GA">Georgia</form:option>
												<form:option value="HI">Hawaii</form:option>
												<form:option value="ID">Idaho</form:option>
												<form:option value="IL">Illinois</form:option>
												<form:option value="IN">Indiana</form:option>
												<form:option value="IA">Iowa</form:option>
												<form:option value="KS">Kansas</form:option>
												<form:option value="KY">Kentucky</form:option>
												<form:option value="LA">Louisiana</form:option>
												<form:option value="ME">Maine</form:option>
												<form:option value="MD">Maryland</form:option>
												<form:option value="MA">Massachusetts</form:option>
												<form:option value="MI">Michigan</form:option>
												<form:option value="MN">Minnesota</form:option>
												<form:option value="MS">Mississippi</form:option>
												<form:option value="MO">Missouri</form:option>
												<form:option value="MT">Montana</form:option>
												<form:option value="NE">Nebraska</form:option>
												<form:option value="NV">Nevada</form:option>
												<form:option value="NH">New Hampshire</form:option>
												<form:option value="NJ">New Jersey</form:option>
												<form:option value="NM">New Mexico</form:option>
												<form:option value="NY">New York</form:option>
												<form:option value="NC">North Carolina</form:option>
												<form:option value="ND">North Dakota</form:option>
												<form:option value="OH">Ohio</form:option>
												<form:option value="OK">Oklahoma</form:option>
												<form:option value="OR">Oregon</form:option>
												<form:option value="PA">Pennsylvania</form:option>
												<form:option value="RI">Rhode Island</form:option>
												<form:option value="SC">South Carolina</form:option>
												<form:option value="SD">South Dakota</form:option>
												<form:option value="TN">Tennessee</form:option>
												<form:option value="TX">Texas</form:option>
												<form:option value="UT">Utah</form:option>
												<form:option value="VT">Vermont</form:option>
												<form:option value="VA">Virginia</form:option>
												<form:option value="WA">Washington</form:option>
												<form:option value="WV">West Virginia</form:option>
												<form:option value="WI">Wisconsin</form:option>
												<form:option value="WY">Wyoming</form:option>
					    					</form:select>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="zip">Zip Code</form:label>
					    					<p><sup>Current 5 Digit Area Code of Residence</sup><sup class="text-danger"> Required</sup></p>
					    					<form:input path="zip" class="form-control" placeholder="Zip Code" type="text"  Required="required"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="primaryPhone">Primary Phone Number</form:label>
					    					<p><sup>Primary Phone Number for Contact</sup><sup class="text-danger"> Required</sup></p>
					    					<form:input path="primaryPhone" class="form-control" placeholder="Primary Phone Number" type="text"  Required="required"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="cellPhone">Cell Phone Number</form:label>
					    					<p><sup>Cell Phone Number (Leave blank if primary and cell phone numbers are the same)</sup></p>
					    					<form:input path="cellPhone" class="form-control" placeholder="Cell Phone Number" type="text"/>
					    				</div>
					    				<div class="form-group ">
					    					<form:label path="fax">Fax Number</form:label>
					    					<p><sup>Fax Number if you would like to receive information over a Fax Machine</sup></p>
					    					<form:input path="fax" class="form-control" placeholder="Fax Number" type="text"/>
					    				</div>
					    				<div class="form-group">
					    					<button type="submit" class="btn btn-primary">Submit</button>
					    				</div>
					    			</div>
					    		</div>
    						</form:form> 		
			  			</div>
			  		</div>
			  	</div>
		  	</div>
		</div>
  	</body>
</html>