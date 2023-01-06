/**
 * Listr AngularJS controller
 */

'use strict';

 app.controller("ListrUserController", ['$scope', 'ListrUserService', function($scope, ListrUserService) {
	 	
	 	var self = this;
	 	self.loginUser = loginUser;
	 	self.createUser = createUser;
	 	self.email = "";
	 	self.password = "";
	 	
	 	function createUser(firstname, lastname, email, password) {
			 ListrUserService.createUser(firstname, lastname, email, password).then(function(response){
				 console.log(response);
			 });
		 }
		 
		 function loginUser(email, password) {
			 console.log("user login");
			 ListrUserService.loginUser(email, password).then(function(response) {
				console.log("login user");
				console.log(response); 
			 });
		 }
	 }]
 );