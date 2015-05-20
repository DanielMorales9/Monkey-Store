<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
	</head>
	<body>
		<h1>${customerSession.product.name}</h1>

		<h2>Details</h2>
		<div>Code: ${customerSession.product.code}</div>
		<div>Price: ${customerSession.product.price}</div>
		<div>Description: ${customerSession.product.description}</div>

		<h4>Add To Order</h4>
		<h:form>
			<div>
				<h:inputText id="quantity" value="#{orderController.quantity}"
					required="true" requiredMessage="Quantity is mandatory"
					validatorMessage="Quantity must be positive"
					converterMessage="Quantity must be a number">
					<f:validateLongRange minimum="1" />
					<f:convertNumber type="number" />
				</h:inputText>
				<h:message for="quantity" />
			</div>
			<div>
			<h:commandButton value="Add" action="#{orderController.addOrderLineToOrder}"></h:commandButton>
			</div>
		</h:form>
	</body>
</f:view>
</html>