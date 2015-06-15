<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<title>Confirm Order</title>
</head>
<body>
	<f:view>

		<div class="panel panel-primary">
			<div class="panel-heading">Your Order</div>
			<div class="panel-body">

				<h:form>
					<div class="table-responsive">
						<table class="table table-bordered table-stripped">
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
					</div>
					<div class="panel-footer">
						<b>Total Price:</b>
						${customerSession.order.total}€
					</div>
					<div class="btn-group">
						<h:commandButton value="Confirm"
							styleClass="btn btn-primary btn-block"
							action="#{orderController.confirmOrder}"></h:commandButton>

						<h:commandButton value="Cancel Order"
							styleClass="btn btn-danger btn-block"
							action="#{orderController.cancelOrder}"></h:commandButton>
					</div>
				</h:form>
			</div>
		</div>

	</f:view>
</body>
</html>