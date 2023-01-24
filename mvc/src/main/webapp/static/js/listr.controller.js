/**
 * Listr AngularJS controller
 */

(function() {
'use strict';

 angular.module('listrApp').controller('ListrUserController', UserController);
 
 UserController.$inject = ['$scope', 'ListrUserService'];
 
 function UserController($scope, ListrUserService) {
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
		 ListrUserService.loginUser(email, password).then(logResponse(response));
	 }
		 
	 function logResponse(res) {
		console.log(res);
	 }
 }
 
})();