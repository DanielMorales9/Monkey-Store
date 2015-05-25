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
<title>Insert New Product</title>
	</head>
	<body>
		<h1>Set Product Details</h1>
		<h:form>
			<div>
				Name:
				<h:inputText value="#{productController.name}" required="true"
					requiredMessage="Name is mandatory" id="productName" />
				<h:message for="productName" />
			</div>
			<div>
				Code:
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Code is mandatory" id="productCode" />
				<h:message for="productCode" />
			</div>
			<div>
				Price:
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Price is mandatory"
					converterMessage="Price must be a number" id="productPrice" />
				<h:message for="productPrice" />
			</div>
			<div>
				Description:
				<h:inputTextarea value="#{productController.description}"
					required="true" requiredMessage="Description is mandatory"
					id="productDescription" cols="30" rows="5" />
				<h:message for="productDescription" />
			</div>
			<div>
				<h:commandButton value="Insert"
					action="#{productController.createProduct}" />
			</div>
		</h:form>
	</body>
</f:view>
</html>