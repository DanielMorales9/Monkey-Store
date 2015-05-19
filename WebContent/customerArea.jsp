<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Area</title>
	</head>
	<body>
		<h1>${loginCustomerController.customer.firstName}
			${loginCustomerController.customer.lastName}</h1>
		<h2>Details</h2>
		<div>E-mail: ${loginCustomerController.customer.email}</div>
		<div>Birthday: ${loginCustomerController.customer.birthDay}</div>
		<div>
			<h:form>
				<h:commandButton value="Create Order"
					action="#{orderController.createNewOrder}">
					<f:param value="#{loginCustomerController.customer.id}"
						name="idCustomer"></f:param>
				</h:commandButton>
			</h:form>
		</div>
	</body>
</f:view>
</html>