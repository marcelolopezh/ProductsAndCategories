<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
</style>
</head>
<body>
<div class="container">
	<div class="row my-5">
		<div class="col-md-2"></div>
		<div class="col-md-8>">
			<h3> <c:out value="${ product.name }"/> </h3>
		</div>
	</div>
	<div class="row my-4">
		<div class="col-md-2"></div>
		<div class="col-md-4 text-left">
			<h5>Categories:</h5>
			<c:forEach items="${ categoryInList }" var="catIn">
				<div class="alert alert-primary" role="alert">
				  <c:out value="${catIn.name}"/>
				</div>
			</c:forEach>
		</div>
		<div class="col-md-4">
			<h5>Add Category:</h5>
			<form:form action="/product/add/${ product.id }" method="post" modelAttribute="category">
				<form:select path="id" class="form-control" required="true">
					<c:forEach items="${ categoryList }" var="cat">
						<form:option value="${ cat.id }"><c:out value="${ cat.name }"/></form:option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Add Category" class="btn btn-primary">
			</form:form>
			
		</div>
		<div class="col-md-2"></div>
		
	</div>
</div>
</body>
</html>