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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<title>Customer Area</title>
	</head>
	<body>
		<h1>Customer Area</h1>
		<address>
			<strong>${customerSession.customer.firstName}
				${customerSession.customer.lastName}</strong><br> <a href="mailto:#">${customerSession.customer.email}</a><br>
			${customerSession.customer.birthDay} 
		</address>


		<%
			CustomerSessionController cSession = (CustomerSessionController) session
						.getAttribute("customerSession");

				if (cSession.getCustomer().getAddress() == null) {
		%>
		<h5>Add Your Address</h5>
		<h:form>
			<div class="container">
				<h:commandButton type="button" styleClass="btn btn-default "
					value="Add address" action="addAddress.jsp">
				</h:commandButton>
			</div>
		</h:form>
		<%
			} else {
		%>

		<address>
			<strong>Your address</strong><br>
			${customerSession.customer.address.street},
			${customerSession.customer.address.city}<br>
			${customerSession.customer.address.state},${customerSession.customer.address.country},
			${customerSession.customer.address.zipcode}<br>

		</address>

		<%
			}
		%>
		<h:form>
			<h4>Options</h4>
			<div class="btn-toolbar">
				<div class="btn-group">
					<h:commandButton styleClass="btn btn-primary" value="Create Order"
						action="#{orderController.createOrder}">
					</h:commandButton>
				</div>
				<div class="btn-group">
					<h:commandButton styleClass="btn btn-info" value="List Orders"
						action="#{orderController.listOrders}"></h:commandButton>
				</div>
			</div>
		</h:form>

	</body>
</f:view>
</html>