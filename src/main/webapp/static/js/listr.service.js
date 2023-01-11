/**
 * Listr AngularJS service
 */

(function() {
'use strict';

 angular.module('listrApp').factory('ListrUserService', ['$http', '$q', UserService]);
 
 UserService.$inject = ['$http', '$q'];
 
  function UserService($http, $q) {
	 
	 var USER_SERVICE_URI = "/api/user/"
	 var factory = {
		 createUser: createUser,
		 loginUser: loginUser
	 }
	 
	 return factory;
	 
	 function createUserResolve(response) {
		 if(response.status == 201) {
			document.getElementById("signup-failure-message").style.display = "none";
			document.getElementById("signup-success-message").style.display = "block";
		 }
	 }
	 
	 function createUserError(errResponse) {
		 document.getElementById("signup-success-message").style.display = "none";
		 document.getElementById("signup-failure-message").style.display = "block";
		 logError(errResponse);
	 }
	 
	 function logError(errResponse) {
		 console.log(errResponse);
	 }
	 
	 function createUser(firstname, lastname, email, password) {
		 var deferred = $q.defer();
		 
		 $http({
			 method: "POST",
			 url: USER_SERVICE_URI,
			 data: {f: firstname, l: lastname, e: email, p: password}
		 }).then(function(response) {
			 createUserResolve(response);
			 deferred.resolve(response.data);
		 }, function(error) {
			 logError(error);
		 });
		 
		 return deferred.promise;
	 }
	 
	 function loginUser(email, password) {
		 var deferred = $q.defer();
		 
		 $http({
			method:"POST",
			url: USER_SERVICE_URI + "login/",
			data: {e: email, p: password} 
		 }).then(deferred.resolve(response.data), logError(errorResponse));
		 
		 return deferred.promise;
	 }
 }
})();