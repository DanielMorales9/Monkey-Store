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
<title>Product Not Found</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<p class="navbar-text">Monkey Store</p>
				</div>
				<ul class="nav navbar-nav">
					<li class="navbar-text">Hi ${adminSession.admin.firstName}</li>
					<li class="navbar-text">${adminSession.admin.email}</li>
				</ul>

				<h:form styleClass="navbar-form navbar-left">
					<div class="form-group">
						<h:inputText styleClass="form-control" label="Search for product"
							value="#{productController.name}" />

					</div>
					<h:commandButton type="submit" styleClass="btn btn-default"
						value="Submit" action="#{productController.findProductByName}">
					</h:commandButton>

				</h:form>
			</div>
		</div>
		<br>
		<br>
		<br>
		<div>Sorry the product "${productController.name}" does not
			exist.</div>

	</body>
</f:view>
</html>