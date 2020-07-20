<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
</style>
</head>
<body>
<div class="container">
	<div class="row my-5">
		<div class="col-md-4"></div>
		<div class="col-md-4 text-center">
			<h4>New Category</h4>
			<hr>
			<form:form action="/categories/new" method="post" modelAttribute="category" class="form">
			<h5>Name</h5>
			<form:input path="name" type="text" class="form-control"/>
			<hr>
			<input type="submit" class="btn btn-primary" value="Create Category">
			</form:form>
		</div>
	</div>
</div>
</body>
</html>