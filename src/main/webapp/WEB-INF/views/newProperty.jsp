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
    	<script src="https://kit.fontawesome.com/b572e6d222.js" crossorigin="anonymous"></script>
	    <title>ChainlinkPrototype - NEW PROPERTY</title>
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
	    	.custom-file-label{
	    		background-color: rgba(245, 245, 245, 0.75) !important;
	    	}
	    	.custom-file-label::after{
	    		background-color: rgba(245, 245, 245, 1) !important;
	    	}
    	</style>
  	</head>
	<body>
		<div class="m-3">
			<div class="row">
	    		<div class="col">
	    			<a href="properties" class="btn btn-danger" title="Back to Properties"><i class="fas fa-long-arrow-alt-left"></i></a>
	    		</div>
    		</div>
			<form:form action="addProperty" method="post" modelAttribute="newPropertyForm" enctype="multipart/form-data">
				<div class="row mx-auto mt-2" style="width: 40%;">	
					<div class="col p-1">
				  		<div class="card p-1">
				  			<div class="card-body">
				  				<h4 class="card-title">Add Property</h4>	  					
						    	<div class="row">
							    	<div class="col">
							    		<div class="form-group ">
							    			<form:label path="propName" title="Property Name for UI Reference">Property Name</form:label>
							    			<form:label path="propName"><sup class="text-danger">Required</sup></form:label>
							    			<form:input path="propName" class="form-control" placeholder="Property Name" type="text" Required="required"/>
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="lyricsData" title="PDF or TXT Files">Lyrics File</form:label>
							    			<form:label path="propName"><sup class="text-danger">Required</sup></form:label>
							    			<div class="input-group">
  												<div class="custom-file">
    												<input type="file" class="custom-file-input" name="lyricsData" id="lyricsData">
    												<label class="custom-file-label" for="lyricsData">Choose file</label>
  												</div>
							    			</div>
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="compData" title="PDF or TXT Files">Composition File</form:label>
							    			<form:label path="propName"><sup class="text-danger">Required</sup></form:label>
							    			<div class="input-group">
  												<div class="custom-file">
    												<input type="file" class="custom-file-input" name="compData" id="compData">
    												<label class="custom-file-label" for="compData">Choose file</label>
  												</div>
							    			</div>
							    		</div>
							    	</div>
							    </div>
						    </div>
						</div>
				  	</div>
				</div>
			  	<div class="row mx-auto mt-2" style="width: 40%;">
			  		<div class="col p-1">
			  			<div class="card p-1">
				  			<div class="card-body">
				  				<h4 class="card-title">Meta Data</h4>
				  				<h6>Fill in to best of ability</h6>
				  				<div class="row">
				  					<div class="col">
				  						<div class="form-group ">
							    			<form:label path="metaSong">Song Title</form:label>
								    		<form:input path="metaSong" class="form-control" placeHolder="Song Title" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaArtist">Artist</form:label>
								    		<form:input path="metaArtist" class="form-control" placeHolder="Artist" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaAlbum">Album</form:label>
								    		<form:input path="metaAlbum" class="form-control" placeHolder="Album" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaAlbumArtist">Album Artist</form:label>
								    		<form:input path="metaAlbumArtist" class="form-control" placeHolder="Album Artist" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaComposer">Composer</form:label>
								    		<form:input path="metaComposer" class="form-control" placeHolder="Composer" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaGrouping">Grouping</form:label>
								    		<form:input path="metaGrouping" class="form-control" placeHolder="Grouping" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaGenre">Genre</form:label>
								    		<form:input path="metaGenre" class="form-control" placeHolder="Genre" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaYear">Year</form:label>
								    		<form:input path="metaYear" class="form-control" placeHolder="Year" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaBpm">BPM</form:label>
								    		<form:input path="metaBpm" class="form-control" placeHolder="BPM" type="text" />
							    		</div>
							    		<div class="form-group ">
							    			<form:label path="metaAlbumArt">Album Art</form:label>
								    		<div class="input-group">
  												<div class="custom-file">
    												<input type="file" class="custom-file-input" name="metaAlbumArt" id="metaAlbumArt">
    												<label class="custom-file-label" for="metaAlbumArt"></label>
  												</div>
							    			</div>
							    		</div>
							    		<div class="form-group mx-auto" style="width: 50px;">
					    					<button type="submit" class="btn btn-outline-primary mt-3">Submit</button>
					    				</div>
				  					</div>
				  				</div>	  	
				  			</div>
				  		</div> 
			  		</div>
			  	</div>
		  	</form:form> 
		</div>
		<script>
			document.addEventListener("DOMContentLoaded", function(event){
				$("#lyricsData").on("change", function(){
					var fileName = $(this).val();
					$(this).next(".custom-file-label").html(fileName);
					});
				$("#compData").on("change", function(){
					var fileName = $(this).val();
					$(this).next(".custom-file-label").html(fileName);
					});
				$("#metaAlbumArt").on("change", function(){
					var fileName = $(this).val();
					$(this).next(".custom-file-label").html(fileName);
					});
				});		
		</script>
	</body>
</html>