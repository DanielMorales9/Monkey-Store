<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<title>Orders</title>
	</head>
	<body>
		<h:form>
			<div class="panel panel-primary">
				<div class="panel-heading">Your orders</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-stripped">
							<tr>
								<th>Order Id</th>
								<th>Total Price</th>
							</tr>
							<tbody>
								<c:forEach var="order" items="#{customerSession.orders}">
									<tr>
										<td><h:commandLink value="#{order.id}"
												action="#{orderController.findOrderById}">
												<f:param name="orderId" value="#{order.id}" />
											</h:commandLink></td>
										<td>${order.total}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</h:form>
	</body>
</f:view>
</html>