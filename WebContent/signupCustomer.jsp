<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
	</head>
	<body>
		<h1>Register Customer</h1>
		<h:form>
			<div>
				Firstname:
				<h:inputText value="#{loginCustomerController.firstName}"
					required="true" requiredMessage="Firstname is mandatory"
					id="firstName" />
				<h:message for="firstName" />
			</div>
			<div>
				Lastname:
				<h:inputText value="#{loginCustomerController.lastName}"
					required="true" requiredMessage="Lastname is mandatory"
					id="lastName" />
				<h:message for="lastName" />
			</div>
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
				Date of Birth:
				<h:inputText value="#{loginCustomerController.bDay}" required="true"
					requiredMessage="Date of Birth is mandatory"
					converterMessage="Date of Birth is not valid" id="bDay">
					<f:convertDateTime pattern="dd/mm/yyyy" />
				</h:inputText>
				<h:message for="bDay" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{loginCustomerController.password}"
					required="true" requiredMessage="Password is mandatory"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:outputText value="#{loginCustomerController.registerError}" />
			</div>
			<div>
				<h:commandButton value="Register"
					action="#{loginCustomerController.registerNewCustomer}" />
			</div>
		</h:form>
	</body>
</f:view>
</html>