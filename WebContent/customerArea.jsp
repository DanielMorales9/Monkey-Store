<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Details</title>
	</head>
	<body>
		<h1>Customer Area</h1>
		<div>${customerSession.customer.firstName}</div>
		<div>${customerSession.customer.lastName}</div>
		<div>${customerSession.customer.email}</div>
		<div>${customerSession.customer.birthDay}</div>

		<h:form>
			<div>
				<h:commandButton value="Create Order"
					action="#{orderController.createOrder}">

				</h:commandButton>
			</div>
		</h:form>
	</body>
</f:view>
</html>