<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<f:view>
	<head>
<title>Product</title>
	</head>
	<body>
		<h1>${creationOrderController.product}</h1>
		<h2>Details</h2>
		<div>Code: ${creationOrderController.product.code}</div>
		<div>Price: ${creationOrderController.product.price}</div>
		<div>Description: ${creationOrderController.product.description}</div>
	</body>
</f:view>
</html>