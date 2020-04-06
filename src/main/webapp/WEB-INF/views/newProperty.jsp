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
	    <title>ChainlinkPrototype - NEW PROPERTY</title>
  	</head>
	<body>
		<div class="container-sm">
			<div class ="row">
	    		<div class="col">
	    			<h2>Add Property</h2>
	    		</div>
	    	</div>
	    	<form:form action="addProperty" method="post" modelAttribute="newPropertyForm" enctype="multipart/form-data">
	    		<div class="row">
	    			<div class="col">
	    				<div class="form-group ">
	    					<form:label path="propName">Property Name</form:label>
	    					<p><sup>Property Name for UI Reference</sup><sup class="text-danger"> Required</sup></p>
	    					<form:input path="propName" class="form-control" placeholder="Property Name" type="text" Required="required"/>
	    				</div>
	    				<div class="form-group ">
	    					<form:label path="lyricsData">Lyrics File</form:label>
	    					<p><sup>PDF or TXT Files</sup><sup class="text-danger">Required</sup></p>
	    					<input type="file" name="lyricsData" />
	    				</div>
	    				<div class="form-group ">
	    					<form:label path="compData">Composition File</form:label>
	    					<p><sup>PDF or TXT Files</sup><sup class="text-danger"> Required</sup></p>
	    					<input type="file" name="compData" />
	    				</div>
	    				<div class="form-group ">
	    					<h3>Meta Data: Fill in to best of ability</h3>
	    					<form:label path="metaSong">Song Title</form:label>
	    					<form:input path="metaSong" class="form-control" placeHolder="Song Title" type="text" />
	    					<form:label path="metaArtist">Artist</form:label>
	    					<form:input path="metaArtist" class="form-control" placeHolder="Artist" type="text" />
	    					<form:label path="metaAlbum">Album</form:label>
	    					<form:input path="metaAlbum" class="form-control" placeHolder="Album" type="text" />
	    					<form:label path="metaAlbumArtist">Album Artist</form:label>
	    					<form:input path="metaAlbumArtist" class="form-control" placeHolder="Album Artist" type="text" />
	    					<form:label path="metaComposer">Composer</form:label>
	    					<form:input path="metaComposer" class="form-control" placeHolder="Composer" type="text" />
	    					<form:label path="metaGrouping">Grouping</form:label>
	    					<form:input path="metaGrouping" class="form-control" placeHolder="Grouping" type="text" />
	    					<form:label path="metaGenre">Genre</form:label>
	    					<form:input path="metaGenre" class="form-control" placeHolder="Genre" type="text" />
	    					<form:label path="metaYear">Year</form:label>
	    					<form:input path="metaYear" class="form-control" placeHolder="Year" type="text" />
	    					<form:label path="metaBpm">BPM</form:label>
	    					<form:input path="metaBpm" class="form-control" placeHolder="BPM" type="text" />
	    					<form:label path="metaAlbumArt">Album Art</form:label>
	    					<input type="file" name="metaAlbumArt" />
	    				</div>
	    				<div class="form-group">
	    					<button type="submit" class="btn btn-primary">Submit</button>
	    				</div>
	    			</div>
	    		</div>
    		</form:form> 	
		</div>
  	</body>
</html>