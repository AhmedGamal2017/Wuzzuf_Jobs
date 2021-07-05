<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, 
        Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
     -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />


</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<table>
			<tr>
				<th>Title</th>
				<th>Company</th>
				<th>Location</th>
				<th>Type</th>
				<th>Level</th>
				<th>Years of Exp</th>
				<th>Country</th>
			</tr>
			<c:forEach items="${jobs}" var="job">
				<tr>
					<td>${job.getTitle()}</td>
					<td>${job.getCompany()}</td>
					<td>${job.getLocation()}</td>
					<td>${job.getType()}</td>
					<td>${job.getLevel()}</td>
					<td>${job.getYearsExp()}</td>
					<td>${job.getCountry()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>