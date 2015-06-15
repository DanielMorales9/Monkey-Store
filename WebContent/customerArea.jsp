<%@page import="controller.session.CustomerSessionController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/styles.css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTab a").click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		});
	});
</script>
<title>Customer Area</title>
	</head>
	<body>
		<div class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<h:form>
						<h:commandLink styleClass="navbar-text" style="font-size: large;"
							action="customerArea.jsp">
							Monkey Store
						</h:commandLink>
					</h:form>
				</div>

				<ul class="nav navbar-nav">
					<li class="navbar-text">Hi
						${customerSession.customer.firstName}!</li>
					<li class="navbar-text">${customerSession.customer.email}</li>
				</ul>

			</div>
		</div>

		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a data-toogle="tab" href="#home">Home</a></li>
			<li><a data-toogle="tab" href="#profile">Profile</a></li>
			<li><a data-toogle="tab" href="#products">Products</a></li>
		</ul>


		<div class="tab-content">

			<div class="tab-pane fade in active" id="home">
				<div class="panel panel-success actionlist">
					<div class="panel-heading">Actions</div>
					<div class="list-group">
						<h:form>
							<h:commandLink styleClass="list-group-item" value="Create Order"
								action="#{orderController.createOrder}">
							</h:commandLink>
							<h:commandLink styleClass="list-group-item"
								value="List My Orders" action="#{orderController.listOrders}"></h:commandLink>
						</h:form>
					</div>
				</div>

				<div class="panel panel-primary orderlist">
					<div class="panel-heading">Orders</div>
					<div class="list-group">
						<h:form>
							<c:forEach var="order" items="#{orderController.orders}">
								<h:commandLink styleClass="list-group-item"
									action="#{orderController.findOrderById}">
									<b>${order.id}</b> - price: ${order.total}€
							<f:param name="orderId" value="#{order.id}" />
								</h:commandLink>

							</c:forEach>
						</h:form>
					</div>
				</div>
			</div>

			<div class="tab-pane" id="products">
				<div class="panel panel-warning">
					<div class="panel-heading">Products Avaiable</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>Description</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<h:form>
								<c:forEach var="product" items="#{productController.products}">
									<tr>
										<td><h:commandLink value="#{product.name}"
												action="#{productController.findProductById}">
												<f:param name="id" value="#{product.id}" />
											</h:commandLink></td>
										<td>${product.description}</td>
										<td>${product.price}€</td>
									</tr>
								</c:forEach>
							</h:form>
						</tbody>
					</table>
				</div>
			</div>

			<div id="profile" class="tab-pane">
				<div class="jumbotron">
					<div class="container">
						<h1>${customerSession.customer.firstName}
							${customerSession.customer.lastName}</h1>
						<p>
							<a href="mailto:#">${customerSession.customer.email}</a><br>
							${customerSession.customer.birthDay}
						</p>
					</div>
				</div>
				<div class="page-header">
					<%
						CustomerSessionController cSession = (CustomerSessionController) session
									.getAttribute("customerSession");

							if (cSession.getCustomer().getAddress() == null) {
					%>
					<div class="container">
						<div class="panel panel-warning">
							<div class="panel-heading">Add Your Address</div>
							<div class="panel-body">
								<h:form>
									<h:commandButton styleClass="btn btn-primary"
										value="Add address" action="addAddress.xhtml">
									</h:commandButton>
								</h:form>
							</div>
						</div>
						<%
							} else {
						%>

						<div class="panel panel-info">
							<div class="panel-heading">Your Address</div>
							<div class="panel-body">
								<address>
									<b>${customerSession.customer.address.street}</b>,
									${customerSession.customer.address.city}<br>
									${customerSession.customer.address.state},${customerSession.customer.address.country},
									${customerSession.customer.address.zipcode}<br>
								</address>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</body>
</f:view>
</html>