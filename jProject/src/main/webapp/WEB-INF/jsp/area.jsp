<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">

<c:url value="/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<c:url value="/css/fontawesome.min.css" var="fontawesomeCss" />
<link href="${fontawesomeCss}" rel="stylesheet" />
<c:url value="/css/templatemo-style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />


<title>Wuzzuf Jobs</title>

</head>
<body id="reportsPage">
	<div class="" id="home">
		<nav class="navbar navbar-expand-xl">
			<div class="container h-100">
				<a class="navbar-brand" href="index.html">
					<h1 class="tm-site-title mb-0">Wuzzuf Jobs Statistics</h1>
				</a>
				<button class="navbar-toggler ml-auto mr-0" type="button"
					data-toggle="collapse" data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-bars tm-nav-icon"></i>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mx-auto h-100">
						<li class="nav-item">
							<a class="nav-link" href="/">
								<i class="fas fa-home"></i> Home
							</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
									<i class="far fa-file-alt"></i> <span> Reports <i class="fas fa-angle-down"></i>
								</span>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/original">Original Data</a>
								<a class="dropdown-item" href="/cleaned">Cleaned Data</a>
								<a class="dropdown-item" href="/structure">Structure of Data</a>
							</div>
						</li>
							
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i class="fas fa-tachometer-alt"></i> <span>
									Statistics <i class="fas fa-angle-down"></i>
								</span>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/trendcomp">Most Demanding Companies</a>
								<a class="dropdown-item" href="/trendjob">Popular Jobs</a>
								<a class="dropdown-item active" href="/trendarea">Popular Areas</a>
								<a class="dropdown-item" href="/trendskill">Skills</a>
							</div>
						</li>
						
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-medal"></i> <span>
									Bonus <i class="fas fa-angle-down"></i>
								</span>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/factorization">Factorization</a>
								<a class="dropdown-item disabled" disabled href="/kmeans">K-means</a>
							</div></li>
					</ul>

				</div>
			</div>

		</nav>

		<div class="mx-5">
			<div class="row">
				<div class="col">
					<p class="text-white mt-5 mb-5">
						<b></b>
					</p>
				</div>
			</div>
			<!-- row -->
			<div class="row tm-content-row">
				
				<div class="col-12 tm-block-col">
				
					<div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
						<h2 class="tm-block-title">Most Popular Areas Chart</h2>
						<canvas id="barChart" width="800" height="2000"></canvas>
					</div>
					
				</div>

				<div class="col-12 tm-block-col">
					<div
						class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
						<h2 class="tm-block-title">Most Popular Areas</h2>
						<table class="table">
							<thead>
								<tr>
									<c:forEach items="${dataHeads}" var="head">
										<th scope="col">${ head}</th>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data}" var="row">
									<tr>
										<c:forEach items="${row}" var="cell">
											<td>${cell}</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<footer class="tm-footer row tm-mt-small">
			<div class="col-12 font-weight-light">
				<p class="text-center text-white mb-0 px-4 small">
					Wuzzuf Jobs Statistics
				</p>
			</div>
		</footer>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<!-- https://jquery.com/download/ -->
	<script src="js/moment.min.js"></script>
	<!-- https://momentjs.com/ -->
	<script src="js/Chart.min.js"></script>
	<!-- http://www.chartjs.org/docs/latest/ -->
	<script src="js/bootstrap.min.js"></script>
	<!-- https://getbootstrap.com/ -->
	<script src="js/tooplate-scripts.js"></script>
	<script type="text/javascript">
		Chart.defaults.global.defaultFontColor = "white";
		let ctxBar, optionsBar, configBar, barChart;

		var labels, values, coloR;

		$(document).ready(function () {
			$.ajax({
				url: "/trendareachart",
				method: "GET",
				success: function (data) {
					labels = data.data["labels"];
					values = data.data["values"];
					coloR = [];

					var dynamicColors = function () {
						var r = Math.floor(Math.random() * 255);
						var g = Math.floor(Math.random() * 255);
						var b = Math.floor(Math.random() * 255);
						return "rgb(" + r + "," + g + "," + b + ")";
					};

					for (var i in labels) {
						coloR.push(dynamicColors());
					}

					drawBarChart(labels, values, coloR,"Count [Location]", "Location");
				},
				error: function (data) {
					console.log(data);
				},
			});
		});
		// $(window).resize(function() {
		// 	updateBarChart();
		// });
	</script>
</body>

</html>