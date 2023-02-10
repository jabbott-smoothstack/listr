/**
 * Listr AngularJS controller
 */

(function() {
'use strict';

 angular.module('listrApp').controller('ListrUserController', UserController);
 
 UserController.$inject = ['$scope', '$cookies', 'ListrUserService'];
 
 function UserController($scope, $cookies, ListrUserService) {
	 $scope.loginUser = loginUser;
	 $scope.createUser = createUser;
	 $scope.email = "";
	 $scope.password = "";
	 $scope.firstName = "";
	 $scope.lastName = "";
	 
	 function createUser(firstname, lastname, email, password) {
		 ListrUserService.createUser(firstname, lastname, email, password).then(logResponse(response));
	 }
		 
	 function loginUser(email, password) {
		 ListrUserService.loginUser(email, password).then(function(response) {
			console.log(response);
			if(response.status == 200) {
				console.log(response);
				$cookies.put("user", response.data.email);
				window.location.replace("http://localhost:8080/listspage");
			}
		 });
	 }
		 
	 function logResponse(res) {
		console.log(res);
	 }
 }
 
})();