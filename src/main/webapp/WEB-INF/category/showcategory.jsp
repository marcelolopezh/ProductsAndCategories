<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
</style>
</head>
<body>
<div class="container">
	<div class="row my-5">
		<div class="col-md-2"></div>
		<div class="col-md-8>">
			<h3> <c:out value="${ category.name }"/> </h3>
		</div>
	</div>
	<div class="row my-4">
		<div class="col-md-2"></div>
		<div class="col-md-4 text-left">
			<h5>Products:</h5>
			<c:forEach items="${ productsInCategory }" var="prodIn">
				<div class="alert alert-success" role="alert">
				  <c:out value="${prodIn.name}"/>
				</div>
			</c:forEach>
		</div>
		<div class="col-md-4">
			<h5>Add Product:</h5>
			<form:form action="/category/add/${ category.id }" method="post" modelAttribute="product">
				<form:select path="id" class="form-control" required="true">
					<c:forEach items="${ allProducts }" var="prod">
						<form:option value="${ prod.id }"><c:out value="${ prod.name }"/></form:option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Add Product" class="btn btn-success">
			</form:form>
			
		</div>
		<div class="col-md-2"></div>
		
	</div>
</div>
</body>
</html>