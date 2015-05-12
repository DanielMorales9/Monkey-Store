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
		<h1>${productDetailsController.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${productDetailsController.product.code}</div>
		<div>Price: ${productDetailsController.product.price}</div>
		<div>Description:
			${productDetailsController.product.description}</div>
		<h:form>
		Quantity:
		<h:inputText value="#{orderController.quantity}" id="quantity"
				required="true" requiredMessage="Quantity is mandatory"
				validatorMessage="Quantity must be positive"
				converterMessage="Quantity must be a number">
				<f:convertNumber type="number" />
				<f:validateLongRange minimum="1" />
			</h:inputText>
			<h:message for="quantity"></h:message>
			<h:commandButton value="Add"
				action="#{orderController.addNewProductToOrder}">
				<f:param value="#{productDetailsController.id}" name="id"></f:param>
			</h:commandButton>

		</h:form>
	</body>
</f:view>
</html>