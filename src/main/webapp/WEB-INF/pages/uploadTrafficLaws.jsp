<%@ page import="java.util.List"%>
<%@ page import="com.trafficlawlookup.service.trafficlaw.TrafficLaw"%>
<%@ page import="com.google.appengine.api.datastore.KeyFactory"%>
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
<link href="../resources/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../resources/css/navbar-fixed-top.css" rel="stylesheet">
<link href="../resources/css/custom-tlla.css" rel="stylesheet">

</head>

<body>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
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
				<a class="navbar-brand" href="/"><img alt="logo"
					src="../resources/img/logo.jpg"></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>

					<li class="dropdown active"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#">Admin <b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a href="/trafficlaw/add">Add Traffic Law</a></li>
							<li><a href="/trafficlaw/list">List Traffic Laws</a></li>
							<li><a href="/trafficlaw/upload">Upload Traffic Laws</a></li>
							<li><a href="javascript:formSubmit()">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<table class="btn-control-layout">
			<tr>
				<td><a href="add" class="btn btn-success">Add Traffic Law</a></td>
				<td><a href="list" class="btn btn-success">List Traffic
						Laws</a></td>
			</tr>
		</table>
		<hr />
		<h2>Upload Traffic Laws (CSV)</h2>
		<div>
			<form method="post" action="upload">
				<textarea class="form-control" name="csvData" id="csvData" rows="20"></textarea>
				<p>
					<button type="submit" class="btn btn-info">Upload</button>
				</p>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" type="text/javascript"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value='../resources/js/bootstrap.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='../resources/js/typeahead.bundle.js'/>" type="text/javascript"></script>
	<script src="<c:url value='../resources/js/custom-tlla.js'/>" type="text/javascript"></script>
</body>
</html>