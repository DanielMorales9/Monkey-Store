<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer's Details</title>
</head>
	<body>	
		<h1>Customer's details</h1>
			<div>${customerController.customer.email}</div>
			<div>${customerController.customer.password}</div>
			<div>${customerController.customer.firstName}</div>
			<div>${customerController.customer.lastName}</div>
			<div>${customerController.customer.birthDay}</div>				
	</body>
</f:view>
</html>