<html>
	<head>
		<title>Listr</title>
		<link rel="stylesheet" href="/static/css/style.css">
	</head>
	<body>
		<h2 id="logo">Listr</h2>
		<div class="form-box" ng-controller = "ListrUserController as controller">
			<input type="text" ng-model = "controller.email" placeholder="Email Address" />
			<br />
			<input type="password" ng-model = "controller.password" placeholder="Password" />
			<br />
			<button name="signin" ng-click = "controller.loginUser(email, password)">Sign In</button>
		</div>
		<div class = "center-box">
			<h4>New User?</h4>
			<a href ="signup.jsp">Sign Up</a>
		</div>
		
		<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
		<script src = "static/js/app.js"></script>
		<script src = "static/js/listr.service.js"></script>
		<script src = "static/js/listr.controller.js"></script>
		
	</body>
</html>
