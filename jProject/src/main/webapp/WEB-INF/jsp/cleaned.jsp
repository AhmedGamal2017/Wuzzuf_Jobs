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
						<li class="nav-item"><a class="nav-link" href="/">
								<i class="fas fa-home"></i> Home <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="far fa-file-alt"></i> <span>
									Reports <i class="fas fa-angle-down"></i>
							</span>
						</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/original">Original Data</a>
								<a class="dropdown-item active" href="/cleaned">Cleaned Data</a>
								<a class="dropdown-item" href="/structure">Structure of Data</a>
								<a class="dropdown-item" href="/summary">Summary of Data</a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href="/piechart">
								<i class="fas fa-chart-pie"></i> Pie Chart
						</a></li>

						<li class="nav-item"><a class="nav-link" href="/barchart">
								<i class="far fa-chart-bar"></i> Bar Chart
						</a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-medal"></i> <span>
									Bonus <i class="fas fa-angle-down"></i>
								</span>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/factorization">Factorization</a>
								<a class="dropdown-item" href="/kmeans">K-means</a>
							</div></li>
					</ul>

				</div>
			</div>

		</nav>

		<div class="container">
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
					<div
						class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
						<h2 class="tm-block-title">Cleaned Data</h2>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Company</th>
									<th scope="col">Location</th>
									<th scope="col">Type</th>
									<th scope="col">Level</th>
									<th scope="col">Years of Exp</th>
									<th scope="col">Country</th>
									<th scope="col">Skills</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${jobs}" var="job">
									<tr>
										<th scope="row"><b>${job.getTitle()}</b></th>
										<td><b>${job.getCompany()}</b></td>
										<td>${job.getLocation()}</td>
										<td>${job.getType()}</td>
										<td>${job.getLevel()}</td>
										<td>${job.getYearsExp()}</td>
										<td>${job.getCountry()}</td>
										<td>${job.getSkillsS()}</td>
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
					Copyright &copy; <b>2018</b> All rights reserved. Design: <a
						rel="nofollow noopener" href="https://templatemo.com"
						class="tm-footer-link">Template Mo</a>
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
</body>

</html>