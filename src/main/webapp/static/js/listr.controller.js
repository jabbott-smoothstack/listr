/**
 * Listr AngularJS controller
 */

 app.controller("listrController", function($scope, $http) {
	 $scope.getUser = function(id) {
		 $http({
			method: "GET",
			url: "/api/user/" + id,
		 }).then(function(response) {
			console.log(response);
		 });
	 }
	 
	 $scope.loginUser = function(email, passwordHash) {
		 $http({
			 method: "POST",
			 url: "/api/user/login",
			 data: {userEmail: email, password: passwordHash}
		 }).then(function(response) {
			console.log(response); 
		 });
	 }
	 
	 $scope.registerUser = function(userData) {
		 $http({
			method: "POST",
			url: "/api/user/",
			data: userData 
		 }).then(function(response) {
			 console.log(response);
		 });
	 };
 });