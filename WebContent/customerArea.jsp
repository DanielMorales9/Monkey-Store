<%@page import="controller.session.CustomerSessionController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Details</title>
	</head>
	<body>
		<h1>Customer Area</h1>
		<div>
			<b>FirstName:</b> ${customerSession.customer.firstName}
		</div>
		<div>
			<b>LastName:</b> ${customerSession.customer.lastName}
		</div>
		<div>
			<b>Mail</b> ${customerSession.customer.email}
		</div>
		<div>
			<b>Birthday:</b> ${customerSession.customer.birthDay}
		</div>


		<%
			CustomerSessionController cSession = (CustomerSessionController) session
						.getAttribute("customerSession");

				if (cSession.getCustomer().getAddress() == null) {
		%>
		<h5>Add Your Address</h5>
		<h:form>
			<h:commandButton value="Add address" action="addAddress.jsp">
			</h:commandButton>
		</h:form>
		<%
			} else {
		%>
		<h3>Address Details</h3>
		<div>
			<b>Street:</b> ${customerSession.customer.address.street}
		</div>
		<div>
			<b>City:</b> ${customerSession.customer.address.city}
		</div>
		<div>
			<b>State:</b> ${customerSession.customer.address.state}
		</div>
		<div>
			<b>Zip Code:</b> ${customerSession.customer.address.zipcode}
		</div>
		<div>
			<b>Country:</b> ${customerSession.customer.address.country}
		</div>
		<%
			}
		%>
		<h:form>
			<h4>Options</h4>
			<div>
				<h:commandButton value="Create Order"
					action="#{orderController.createOrder}">

				</h:commandButton>
			</div>
			<div>
				<h:commandButton value="List Orders"
					action="#{orderController.listOrders}"></h:commandButton>
			</div>
		</h:form>

	</body>
</f:view>
</html>