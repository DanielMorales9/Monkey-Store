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
<title>OrderLine Details</title>
	</head>
	<body>
		<h1>${customerSession.orderLine.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${customerSession.orderLine.product.code}</div>
		<div>Price: ${customerSession.orderLine.product.price}</div>
		<div>Description:
			${customerSession.orderLine.product.description}</div>
		<div>Quantity: ${customerSession.orderLine.quantity}</div>
		<div>
			Total Price:
			<h:outputText value="#{customerSession.orderLine.subTotal}"></h:outputText>
		</div>
	</body>
</f:view>
</html>