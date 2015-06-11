<%@page import="controller.ProcessOrderController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Details</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">
	</head>
	<body>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<p class="navbar-text" style="font-size: large;">Monkey Store</p>
				</div>
				<ul class="nav navbar-nav">
					<li class="navbar-text">Hi ${adminSession.admin.firstName}!</li>
					<li class="navbar-text">${adminSession.admin.email}</li>
				</ul>

				<h:form styleClass="navbar-form navbar-left">
					<div class="form-group">
						<h:inputText styleClass="form-control"
							value="#{productController.name}" />

					</div>
					<h:commandButton type="submit" styleClass="btn btn-default"
						value="Submit" action="#{productController.findProductByName}">
					</h:commandButton>

				</h:form>
			</div>
		</div>

		<br>
		<br>
		<br>
		<h:form>
			<div>
				<h:commandButton value="Insert New Product"
					action="insertNewProduct.jsp">

				</h:commandButton>
			</div>
			<div>
				<h:commandButton value="List All Products"
					action="#{productController.listProducts}">

				</h:commandButton>
			</div>

			<div>
				<h:commandButton value="Retrieve a customer order"
					action="retrieveCustomer.jsp">

				</h:commandButton>
			</div>

			<!-- 			<div> -->
			<%-- 				<h:commandButton value="Dispatch an order" --%>
			<%-- 					action="#{processOrderController.findOrdersToProcess}"> --%>

			<%-- 				</h:commandButton> --%>
			<!-- 			</div> -->
		</h:form>

		<div class="panel panel-default orderlist">
			<div class="panel-body">Orders to Process</div>

			<div class="list-group">
				<h:form>
					<c:forEach var="order"
						items="#{processOrderController.ordersToProcess}">
						<h:commandLink styleClass="list-group-item" value="#{order.id} price: #{order.total}"
							action="#{processOrderController.processOrder}">
							<f:param name="id" value="#{order.id}" />
						</h:commandLink>

					</c:forEach>
				</h:form>
			</div>
		</div>
	
	</body>
</f:view>
</html>
