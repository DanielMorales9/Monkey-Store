<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products</title>
	</head>
	<body>
		<h1>Products</h1>
		<h:form>
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="product" items="#{customerSession.products}">
					<tr>
						<td><h:commandLink value="#{product.name}">
							</h:commandLink></td>
						<td>${product.price}</td>
						<td><h:inputText value="#{orderController.quantity}"
								required="true" requiredMessage="Quantity is mandatory"
								id="quantity" validatorMessage="Quantity must be positive"
								converterMessage="Quantity must be a number">
								<f:validateLongRange minimum="1" />
								<f:convertNumber type="number" />
							</h:inputText> <h:message for="quantity" /> 
							<h:commandButton value="Add"
								action="#{orderController.addOrderLineToOrder}">
								<f:param value="#{product.id}" name="productId"></f:param>
							</h:commandButton></td>
					</tr>
				</c:forEach>
			</table>
			<div></div>
		</h:form>

	</body>
</f:view>
</html>