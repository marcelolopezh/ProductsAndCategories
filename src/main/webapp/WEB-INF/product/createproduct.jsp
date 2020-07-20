<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
</style>
</head>
<body>
<div class="container">
	<div class="row my-5">
		<div class="col-md-4"></div>
		<div class="col-md-4 text-center">
			<h4>New Product</h4>
			<hr>
			<form:form action="/products/new" method="post" modelAttribute="product" class="form">
			<h5>Name</h5>
			<form:input path="name" type="text" class="form-control"/>
			<h5>Description</h5>
			<form:input path="description" type="text" class="form-control"/>
			<h5>Price</h5>
			<form:input path="price" type="number" class="form-control"/>
			<hr>
			<input type="submit" class="btn btn-success" value="Create Product">
			</form:form>
		</div>
	</div>
</div>
</body>
</html>