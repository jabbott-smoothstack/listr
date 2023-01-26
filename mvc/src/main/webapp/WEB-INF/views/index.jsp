<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Listr</title>
		<link rel="stylesheet" href="/static/css/bootstrap.min.css">
		<link rel="stylesheet" href="/static/css/style.css">
	</head>
	<body ng-app = "listrApp">
		<h2 class="logo">Listr</h2>
		<div class="form-box" ng-controller = "ListrUserController as controller">
			<h4>Sign In</h4>
			
			<div class = "row">
				<input type="text" class = "center-input" placeholder="Email Address" name = "email" ng-model = "email"/>
			</div>
			<div class = "row">
				<input type="password" class = "center-input" placeholder="Password" name = "password" ng-model = "password"/>
			</div>
			<div class = "row">
				<input class = "btn btn-primary signup-button-center" type = "button" value = "Sign In" ng-click = "loginUser(email, password)" />
			</div>
		</div>
		<div class = "center-box">
			<div class = "col-mb-3">
				<div class = "row">
				<h4>New User?</h4>
			</div>
				<div class = "row">
					<a href ="/signup">Sign Up</a>
				</div>
			</div>
		</div>
		
		<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
		<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-cookies.js"></script>
		<script src = "static/js/app.js"></script>
		<script src = "static/js/listr.service.js"></script>
		<script src = "static/js/listr.controller.js"></script>
		
	</body>
</html>