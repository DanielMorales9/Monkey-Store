<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer's Address Details</title>
</head>
	<body>
		<h1>Customer's Address Details</h1>
		
			<h:form>
		
				<div>Customer's Id: ${retrieveCustomerController.customer.id}</div>
				<div>Street: ${retrieveCustomerController.customer.address.street}</div>
				<div>City: ${retrieveCustomerController.customer.address.city}</div>
				<div>State: ${retrieveCustomerController.customer.address.state}</div>
				<div>Zipcode: ${retrieveCustomerController.customer.address.zipcode}</div>
				<div>Country: ${retrieveCustomerController.customer.address.country}</div>
		
				<div>
					<h:commandButton value="Home"	action="adminArea.jsp">
					</h:commandButton>						
				</div>
			
			</h:form>
	</body>
</f:view>
</html>