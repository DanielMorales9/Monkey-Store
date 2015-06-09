<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer's Details</title>
</head>
	<body>	
	
		<h1>Customer's details</h1>
			
			<h:form>
			
				<div>Click on the id to retrieve the address of the customer</div>
				<div>
					<h:commandLink 
							value="#{retrieveCustomerController.customer.id}" action="#{retrieveCustomerController.retrieveAddress}">
							<f:param name="id" value="#{retrieveCustomerController.customer.id}" />
					</h:commandLink>
				</div>
				<div>Email: ${retrieveCustomerController.customer.email}</div>
				<div>Password: ${retrieveCustomerController.customer.password}</div>
				<div>FristName: ${retrieveCustomerController.customer.firstName}</div>
				<div>LastName: ${retrieveCustomerController.customer.lastName}</div>
				<div>BirthDay: ${retrieveCustomerController.customer.birthDay}</div>		
				
				<div>Click on the id to retrieve the address of the customer</div>
			</h:form>
	</body>
</f:view>
</html>