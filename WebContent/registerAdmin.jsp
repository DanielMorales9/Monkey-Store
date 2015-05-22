<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<f:view>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Admin</title>
	</head>
	<body>
		<h1>Register Admin</h1>
		<h:form>
			<div>
				Firstname:
				<h:inputText value="#{registerAdmin.firstName}"
					required="true" requiredMessage="Firstname is mandatory"
					id="firstName" />
				<h:message for="firstName" />
			</div>
			<div>
				Lastname:
				<h:inputText value="#{registerAdmin.lastName}"
					required="true" requiredMessage="Lastname is mandatory"
					id="lastName" />
				<h:message for="lastName" />
			</div>
			<div>
				Email:
				<h:inputText value="#{registerAdmin.email}"
					required="true" requiredMessage="Email is mandatory" id="email"
					validatorMessage="Email is not valid">
					<f:validateRegex pattern=".+@.+\\.[a-z]+" />
				</h:inputText>
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{registerAdmin.password}"
					required="true" requiredMessage="Password is mandatory"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:outputText value="#{registerAdmin.registerError}" />
			</div>
			<div>
				<h:commandButton value="Register"
					action="#{registerAdmin.registerAdmin}" />
			</div>
		</h:form>
	</body>
</f:view>
</html>