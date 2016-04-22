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

				<a class="navbar-brand" href="/"><img alt="logo"
					src="resources/img/logo.jpg"></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="#" data-toggle="modal" data-target="#myModal">Help</a></li>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#">Admin <b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a href="trafficlaw/add">Add Traffic Law</a></li>
							<li><a href="trafficlaw/list">List Traffic Laws</a></li>
							<li><a href="trafficlaw/upload">Upload Traffic Laws</a></li>
							<li><a href="javascript:formSubmit()">Logout</a></li>
						</ul></li>
					</c:if>
				</ul>

				<div class="col-sm-3 col-md-3 pull-right">
					<div class="navbar-form">
						<div class="input-group">
							<input type="text" class="typeahead form-control"
								placeholder="Search" name="srch-term" id="srch-term">
							<div class="input-group-btn">
								<button id="srch-btn" class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="sidebar left">
			<!-- Lawyer2 -->
			<ins class="adsbygoogle"
			     style="display:inline-block;width:160px;height:600px"
			     data-ad-client="ca-pub-3090222663054791"
			     data-ad-slot="5191525867"></ins>
			<script>
			(adsbygoogle = window.adsbygoogle || []).push({});
			</script>
		</div>
		<div class="sidebar right">
			<!-- Lawyer2 -->
			<ins class="adsbygoogle"
			     style="display:inline-block;width:160px;height:600px"
			     data-ad-client="ca-pub-3090222663054791"
			     data-ad-slot="5191525867"></ins>
			<script>
			(adsbygoogle = window.adsbygoogle || []).push({});
			</script>
		</div>
		<div class="content fixed-fixed">

			<!-- Example row of columns -->
			<div class="row">
				<div class="span6">
					<div class="well">
						<h2>Welcome to NYTrafficFines.com</h2>
						<p>This application seeks to provide the general public with
							information regarding New York State traffic offenses, including
							the likely fines, surcharges and demerit points associated with
							specific traffic offenses.</p>
					</div>
				</div>
				<div class="span6">
					<div id="data-result" class="well well-soft"></div>
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

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h2 class="modal-title">Help</h2>
				</div>
				<div class="modal-body">
					<table width="100%">
						<tr>
							<td valign="top" align="left">
								<ol>
									<li>Please locate section 2 on your traffic ticket.</li>
									<li>The number you are looking for should be labeled <u>Section
											Sub</u>.
									</li>
									<li>Take that number and proceed to type it into the
										search box above.</li>
								</ol>
							</td>
							<td><img alt="Example Ticket"
								src="resources/img/example-ticket.jpg"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
			
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value='resources/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='resources/js/typeahead.bundle.js'/>"></script>
	<script src="<c:url value='resources/js/custom-tlla.js'/>"></script>

</body>
</html>