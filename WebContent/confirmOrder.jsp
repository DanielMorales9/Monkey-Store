<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Confirm Order</title>
</head>
<body>
	<f:view>
		<h1>Products</h1>
		<h:form>
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>

				</tr>
				<c:forEach var="line" items="#{customerSession.order.orderLines}">
					<tr>
						<td><h:commandLink
								action="#{orderLineController.findOrderLineById}"
								value="#{line.product.name}">
								<f:param name="orderLineId" value="#{line.id}" />
							</h:commandLink></td>
						<td>${line.product.price}</td>
						<td>${line.quantity}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div>Total Price: <h:outputText value="#{customerSession.order.total}"></h:outputText> </div>
			
			<div>
				<h:commandButton value="Confirm" action="customerArea"></h:commandButton>
			</div>

			<div>
				<h:commandButton value="Cancel order"
					action="#{orderController.cancelOrder}"></h:commandButton>
			</div>
		</h:form>

	</f:view>
</body>
</html>