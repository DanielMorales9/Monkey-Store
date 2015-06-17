<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Monkey Store</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" href="resources/css/panel.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand">Monkey Store</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nar navbar-left">
						<li><a href="#" data-toggle="modal" data-target="#AdminModal">Admin</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="loginCustomer.xhtml">Login</a></li>
						<li><a href="registerCustomer.xhtml">Sign up</a></li>
					</ul>
				</div>
			</div>

			<!-- /.navbar-collapse -->
			<!-- /.container-fluid -->
		</nav>

		<div class="jumbotron">
			<div class="container">
				<h1>Welcome</h1>
				<p>Monkey Store is the best e-commerce site in the web</p>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">Products Avaiable</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<h:form>
						<c:forEach var="product" items="#{productController.products}">
							<tr>
								<td><h:commandLink value="#{product.name}"
										action="#{productController.findProductById}">
										<f:param name="id" value="#{product.id}" />
									</h:commandLink></td>
								<td>${product.description}</td>
								<td>${product.price}€</td>
							</tr>
						</c:forEach>
					</h:form>
				</tbody>
			</table>
		</div>

		<footer class="footer">
			<div class="container">
				<p class="text-muted">
					Designed and built by <a href="https://github.com/DanielMorales9">Daniel</a>,
					<a href="https://github.com/Cristiano8">Cristiano</a> and <a
						href="https://github.com/FedericoMartinelli">Federico</a>
				</p>
			</div>
		</footer>

		<div class="modal fade" id="AdminModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true"></span>
						</button>
						<h4 class="modal-title">Admin panel</h4>
					</div>
					<div class="modal-body">

						<div class="panel panel-login">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-6">
										<a href="#" class="active" id="login-form-link">Login</a>
									</div>
									<div class="col-xs-6">
										<a href="#" id="register-form-link">Register</a>
									</div>
								</div>
								<hr></hr>
							</div>
							<div class="panel-body">

								<h:form id="login-form" style="display: block;">
									<div class="form-group">
										<label for="email">Email</label>
										<h:inputText styleClass="form-control"
											value="#{loginAdmin.email}" required="true"
											requiredMessage="Email is mandatory" id="email" tabindex="1">
										</h:inputText>
										<h:message styleClass="errorMessage" for="email" />
									</div>
									<div class="form-group">
										<label for="password">Password</label>
										<h:inputSecret value="#{loginAdmin.password}" required="true"
											requiredMessage="Password is mandatory" id="password"
											tabindex="2" styleClass="form-control" />
										<h:message styleClass="errorMessage" for="password" />
									</div>

									<div class="form-group">
										<div class="col-sm-6 col-sm-offset-3">
											<h:commandButton styleClass="form-control btn btn-login"
												action="#{loginAdmin.loginAdmin}" id="login-submit"
												tabindex="3" value="Log in"></h:commandButton>

										</div>
									</div>
								</h:form>
								<h:form id="register-form" style="display: none;">
									<div class="form-group">
										<label for="firstName">FirstName</label>
										<h:inputText value="#{registerAdmin.firstName}"
											styleClass="form-control" required="true"
											requiredMessage="Firstname is mandatory" id="firstName"
											tabindex="1" />
										<h:message styleClass="errorMessage" for="firstName" />
									</div>
									<div class="form-group">
										<label for="lastName">LastName</label>
										<h:inputText value="#{registerAdmin.lastName}" required="true"
											styleClass="form-control"
											requiredMessage=" Lastname is mandatory" id="lastName"
											tabindex="1" />
										<h:message styleClass="errorMessage" for="lastName" />
									</div>
									<div class="form-group">
										<label for="email">Email</label>
										<h:inputText value="#{registerAdmin.email}" required="true"
											requiredMessage="Email is mandatory" id="email"
											styleClass="form-control" tabindex="2">
										</h:inputText>
										<h:message styleClass="errorMessage" for="email" />
									</div>
									<div class="form-group">
										<label for="password">Password</label>
										<h:inputSecret value="#{registerAdmin.password}"
											required="true" styleClass="form-control"
											requiredMessage="Password is mandatory" id="password"
											tabindex="3" />
										<h:message styleClass="errorMessage" for="password" />
									</div>
									<div class="form-group">
										<h:commandButton id="register-submit" tabindex="4"
											styleClass="form-control btn btn-register"
											value="Register Now" action="#{registerAdmin.registerAdmin}" />
									</div>
									<div class="error">
										<h:outputText styleClass="errorMessage"
											value="#{registerAdmin.registerError}" />
									</div>
								</h:form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</f:view>
	<script>
		$(function() {

			$('#login-form-link').click(function(e) {
				$("#login-form").delay(100).fadeIn(100);
				$("#register-form").fadeOut(100);
				$('#register-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});
			$('#register-form-link').click(function(e) {
				$("#register-form").delay(100).fadeIn(100);
				$("#login-form").fadeOut(100);
				$('#login-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});

		});
	</script>
</body>
</html>