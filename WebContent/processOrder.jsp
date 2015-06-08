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
<title>Process an Order</title>
</head>
	<body>
		<h1>Orders to process</h1>
			<h:form>
				<table>
					<tr>
						<th>Order's id</th>
						<th>Total price</th>
					</tr>
					<c:forEach var="order" items="#{processOrderController.ordersToProcess}">
						<tr>
						 	 <td>
						 	 	 <h:commandLink value="#{order.id}"
									action="#{processOrderController.processOrder}">
							 		<f:param name="id" value="#{order.id}" />
								</h:commandLink>
							 </td> 
							 <td>${order.total}</td>
						</tr>
					</c:forEach>
				</table>
			</h:form>
	

	</body>
</f:view>
</html>