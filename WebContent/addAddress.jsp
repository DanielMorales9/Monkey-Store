<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add address</title>
	</head>
		<body>
			<h1>Didn't you insert your address's details? Do it now!</h1>
			<h:form>
				<div>
					Street:
					<h:inputText value="#{addressController.street}"
						required="true" requiredMessage="Id is mandatory" id="street">
					</h:inputText>
					<h:message for="street" />
				</div>
				
				<div>
					City:
					<h:inputText value="#{addressController.city}"
						required="true" requiredMessage="Id is mandatory" id="city">
					</h:inputText>
					<h:message for="city" />
				</div>
				
				<div>
					State:
					<h:inputText value="#{addressController.state}"
						required="true" requiredMessage="Id is mandatory" id="state">
					</h:inputText>
					<h:message for="state" />
				</div>
				
				
				<div>
					Zipcode:
					<h:inputText value="#{addressController.zipcode}"
						required="true" requiredMessage="Id is mandatory"
						converterMessage="Zipcode is not valid" id="zipcode">
						<f:convertNumber type="number" />
					</h:inputText>
					<h:message for="zipcode" />
				</div>
				
				
				<div>
					Country:
					<h:inputText value="#{addressController.country}"
						required="true" requiredMessage="Id is mandatory" id="country">
					</h:inputText>
					<h:message for="country" />
				</div>
				
				<div>
				<h:commandButton value="Submit"
					action= "#{addressController.createAddress}"></h:commandButton>
				</div>
			</h:form>

		</body>
</f:view>
</html>