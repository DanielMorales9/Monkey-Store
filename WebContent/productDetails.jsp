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
		<h1>${orderLineController.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${orderLineController.product.code}</div>
		<div>Price: ${orderLineController.product.price}</div>
		<div>Description: ${orderLineController.product.description}</div>
		<h:form>
			<h:inputText id="quantity" value="#{orderLineController.quantity}"
				required="true" requiredMessage="Quantity is mandatory"
				validatorMessage="Quantity must be positive"
				converterMessage="Quantity must be a number">
				<f:validateLongRange minimum="1" />
				<f:convertNumber type="number" />
			</h:inputText>
			<h:message for="quantity"></h:message>
		</h:form>
	</body>
</f:view>
</html>