<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	</head>
	<body>
		<h1>Login Customer</h1>
		<h:form>
			<div>
				Email:
				<h:inputText value="#{loginCustomerController.email}"
					required="true" requiredMessage="Email is mandatory" id="email"
					validatorMessage="Email is not valid">
					<f:validateRegex pattern=".+@.+\\.[a-z]+" />
				</h:inputText>
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{loginCustomerController.password}"
					required="true" requiredMessage="Password is mandatory"
					id="password" />
				<h:message for="password" />
			</div>
			<div><h:outputText value="#{loginCustomerController.loginError}"/></div>
			<div>
				<h:commandButton action="#{loginCustomerController.loginCustomer}"
					value="Submit"></h:commandButton>
			</div>
		</h:form>
	</body>
</f:view>
</html>