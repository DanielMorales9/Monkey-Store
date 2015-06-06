<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Details</title>
</head>
	<body>
	
		<h1>Your address's details</h1>
		
			<div>Street: ${customerSession.customer.address.street}</div>
			<div>City: ${customerSession.customer.address.city}</div>
			<div>State: ${customerSession.customer.address.state}</div>
			<div>Zipcode: ${customerSession.customer.address.zipcode}</div>
			<div>Country: ${customerSession.customer.address.country}</div>

	</body>
</html>