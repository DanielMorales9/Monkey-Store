<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Processed</title>
</head>
	<body>
		<h1>Order Processed</h1>
			<h:form>
				<div>You have processed the following order : ${processOrderController.id}</div>
				
				<div>
					<h:commandButton value="Home"
					action="adminArea.jsp">
					</h:commandButton>
									
				</div>
				
			</h:form>

	</body>
</f:view>
</html>