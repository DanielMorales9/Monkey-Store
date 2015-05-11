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
<title>Products</title>
	</head>
	<body>
		<h1>Products</h1>
		<h:form>
			<table>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach var="product" items="#{creationOrderController.products}">
					<tr>
						<td><h:commandLink
								action="#{creationOrderController.findProductById}"
								value="#{product.name}">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.price}</td>
						<td><h:form>
							Quantity:
							<h:inputText value="#{creationOrderController.quantity}"
									id="quantity" required="true"
									requiredMessage="Quantity is mandatory"
									validatorMessage="Quantity must be positive"
									converterMessage="Quantity must be a number">
									<f:validateLongRange minimum="1" />
									<!-- in futuro il controllo sarà fatto sulla pagina es.: maximum="#{product.maxQuantity}" -->
									<f:convertNumber type="number" />
								</h:inputText>
								<h:message for="quantity"></h:message>
								<h:commandButton
									action="#{creationOrderController.addNewProductToOrder}"
									value="Add" > 
									<f:param name="id" value="#{product.id}" />
									</h:commandButton>
							</h:form></td>
					</tr>
				</c:forEach>
			</table>
		</h:form>

	</body>
</f:view>
</html>