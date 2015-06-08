<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Details</title>
	</head>
	<body>
		<h1>Admin Area</h1>
		<div>${adminSession.admin.firstName}</div>
		<div>${adminSession.admin.lastName}</div>
		<div>${adminSession.admin.email}</div>
		
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
				<h:commandButton value="Retrieve an order's customer"
					action="retrieveCustomer.jsp">

				</h:commandButton>
			</div>
			
			<div>
				<h:commandButton value="Process an order"
					action="#{processOrderController.findOrdersToProcess}">

				</h:commandButton>
			</div>
		</h:form>

	</body>
</f:view>
</html>