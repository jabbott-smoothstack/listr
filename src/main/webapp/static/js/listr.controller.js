/**
 * Listr AngularJS controller
 */

'use strict';

 angular.module('listrApp').controller('ListrUserController', ['$scope', 'ListrUserService', function($scope, ListrUserService) {
	 	
	 	$scope.loginUser = loginUser;
	 	$scope.createUser = createUser;
	 	$scope.email = "";
	 	$scope.password = "";
	 	$scope.firstName = "";
	 	$scope.lastName = "";
	 		 	
	 	function createUser(firstname, lastname, email, password) {
			 ListrUserService.createUser(firstname, lastname, email, password).then(function(response){
				 console.log(response);
			 });
		 }
		 
		 function loginUser(email, password) {
			 ListrUserService.loginUser(email, password).then(function(response) {
				console.log(response); 
			 });
		 }
		 
	 }]
 );