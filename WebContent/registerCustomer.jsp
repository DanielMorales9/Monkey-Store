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
				<h:inputText value="#{loginCustomer.firstName}"
					required="true" requiredMessage="Firstname is mandatory"
					id="firstName" />
				<h:message for="firstName" />
			</div>
			<div>
				Lastname:
				<h:inputText value="#{loginCustomer.lastName}"
					required="true" requiredMessage="Lastname is mandatory"
					id="lastName" />
				<h:message for="lastName" />
			</div>
			<div>
				Email:
				<h:inputText value="#{loginCustomer.email}"
					required="true" requiredMessage="Email is mandatory" id="email"
					validatorMessage="Email is not valid">
					<f:validateRegex pattern=".+@.+\\.[a-z]+" />
				</h:inputText>
				<h:message for="email" />
			</div>
			<div>
				Date of Birth:
				<h:inputText value="#{loginCustomer.birthDay}"
					required="true" requiredMessage="Date of Birth is mandatory"
					converterMessage="Date of Birth is not valid" id="bDay">
					<f:convertDateTime pattern="dd/mm/yyyy" />
				</h:inputText>
				<h:message for="bDay" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{loginCustomer.password}"
					required="true" requiredMessage="Password is mandatory"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:outputText value="#{loginCustomer.registerError}" />
			</div>
			<div>
				<h:commandButton value="Register"
					action="#{loginCustomer.registerCustomer}" />
			</div>
		</h:form>
	</body>
</f:view>
</html>