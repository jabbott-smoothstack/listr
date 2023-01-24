<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>Sign up for Listr</title>
		<link rel="stylesheet" href="/static/css/bootstrap.min.css">
		<link rel="stylesheet" href="static/css/style.css">
	</head>
	<body ng-app = "listrApp">
		<h2 class="logo">Listr</h2>
		<div class = "container">
				<div class = "row">
					<div class="form-box col-md-6" ng-controller = "ListrUserController as controller">
						<h4>Sign Up</h4>
						<div class = "col-md-12">
							<div class = "row">
								<input class = "center-input" type="text" placeholder="First Name" ng-model = "firstName" />
							</div>
							<div class = "row">
								<input class = "center-input" type="text" placeholder="Last Name (optional)" ng-model = "lastName"/>
							</div>
							<div class = "row">
								<input class = "center-input" type="text" placeholder="Email Address" ng-model = "email"/>
							</div>
							<div class = "row">
								<input class = "center-input" type="password" placeholder="Password" ng-model = "password"/>
							</div>
							<div class = "row">
								<button name="signup-button" class = "btn btn-primary signup-button-center" ng-click = "createUser(firstName, lastName, email, password)">Sign Up</button>
							</div>
						</div>
					</div>	
				</div>
				<div class = "row">
						<div class = "col-md-6 center">
							<div class = "success-message" id = "signup-success-message">
								<h4>Thank you for signing up! </h4>
								<a href = "/">Return to Login Page</a>
							</div>
							<div class = "failure-message" id = "signup-failure-message">
								<h4>An error occurred, please try again.</h4>
							</div>
						</div>
					</div>
		</div>
		
		<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
		<script src = "static/js/app.js"></script>
		<script src = "static/js/listr.service.js"></script>
		<script src = "static/js/listr.controller.js"></script>
	</body>
</html>