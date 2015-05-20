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
<title>Order Details</title>
</head>
<body>
	<h1>
		Order number:
		<h:outputText value="#{customerSession.order.id}"></h:outputText>
	</h1>
	<h:form>
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="line" items="#{customerSession.order.orderLines}">
				<tr>
					<td><h:commandLink value="#{line.product.name}"
							action="#{orderLineDetails.findOrderLineById}">
							<f:param name="id" value="#{line.id}" />
						</h:commandLink></td>
					<td>${line.product.price}</td>
					<td>${line.quantity}</td>
				</tr>
			</c:forEach>
		</table>
	</h:form>
</body>
</f:view>
</html>