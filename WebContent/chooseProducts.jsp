<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/styles.css" rel="stylesheet" />
<title>Choose Products</title>
	</head>
	<body>
		<div class="panel panel-primary">
			<div class="panel-heading">Products</div>
			<div class="panel-body">
				<h:form>
					<div class="tale-responsive">
						<table class="table table-bordered table-stripped">
							<tr>
								<th>Name</th>
								<th>Description</th>
								<th>Price</th>
								
							</tr>
							<c:forEach var="product" items="#{customerSession.products}">
								<tr>
									<td><h:commandLink value="#{product.name}"
											action="#{orderLineController.findProductById}">
											<f:param name="productId" value="#{product.id}" />
										</h:commandLink></td>
									<td>${product.description}</td>
									<td>${product.price}</td>
								</tr>
							</c:forEach>
						</table>
						<div class="btn-group">
							<h:commandButton styleClass="btn btn-primary btn-block"
								value="End Order" action="#{orderController.endOrder}"></h:commandButton>

							<h:commandButton value="Cancel Order"
								styleClass="btn btn-danger btn-block"
								action="#{orderController.cancelOrder}"></h:commandButton>
						</div>
					</div>
				</h:form>
			</div>
		</div>



	</body>
</f:view>
</html>