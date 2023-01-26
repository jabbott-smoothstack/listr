/**
 * Listr AngularJS service
 */

(function() {
'use strict';

 angular.module('listrApp').factory('ListrUserService', ['$http', '$q', UserService]);
 
 UserService.$inject = ['$http', '$q'];
 
  function UserService($http, $q) {
	 
	 var USER_SERVICE_URI = "http://localhost:8081/api/user/"
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
	 
	 function createUser(f, l, e, p) {
		 var deferred = $q.defer();
		 
		 $http({
			 method: "POST",
			 url: USER_SERVICE_URI,
			 data: {firstName: f, lastName: l, email: e, passwordHash: p}
		 }).then(function(response) {
			 createUserResolve(response);
			 deferred.resolve(response.data);
		 }, function(error) {
			 logError(error);
		 });
		 
		 return deferred.promise;
	 }
	 
	 function loginUser(e, p) {
		 var deferred = $q.defer();
		 
		 $http({
			method:"POST",
			url: USER_SERVICE_URI + "login/",
			data: {email: e, passwordHash: p} 
		 }).then(deferred.resolve(response.data), logError(errorResponse));
		 
		 return deferred.promise;
	 }
 }
})();