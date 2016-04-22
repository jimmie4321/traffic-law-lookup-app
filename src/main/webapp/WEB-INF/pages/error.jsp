<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="TLLA">
<meta name="author" content="James Barnett">
<link rel="icon" href="../../favicon.ico">

<title>Traffic Law Lookup Application</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/navbar-fixed-top.css" rel="stylesheet">
<link href="resources/css/custom-tlla.css" rel="stylesheet">

</head>

<body>
	<!-- Fixed navbar -->

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/"><img alt="logo" src="resources/img/logo.jpg"></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="sidebar left">
			<img src="resources/img/fake-ad.jpg" alt="Ad Space">
		</div>
		<div class="sidebar right">
			<img src="resources/img/fake-ad.jpg" alt="Ad Space">
		</div>
		<div class="content fixed-fixed">

			<!-- Example row of columns -->
			<div class="row">
				<div class="span6">
					<div class="well">
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
						 	<p>Sorry but this page is not available!</p>
						</div>
					</div>

				</div>
				
			</div>
		</div>
	</div>
	<footer class="navbar-fixed-bottom">
		<div class="well-footer">
			<div class="well-footer-inner">
				<div>
					<a
						href="mailto:jimmie4321@gmail.com?Subject=NYTrafficFines.com Mail">Contact
						Us</a> | <a href="#">Privacy Statement</a>
				</div>
				<div>Copyright &#169; 2015 NYTrafficFines.com. All rights
					Reserved.</div>
			</div>
		</div>
	</footer>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='resources/js/typeahead.bundle.js'/>" type="text/javascript"></script>
	<script src="<c:url value='resources/js/custom-tlla.js'/>"></script>
</body>
</html>