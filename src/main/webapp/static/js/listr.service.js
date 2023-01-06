/**
 * Listr AngularJS service
 */

'use strict';

 angular.module('listrApp').factory('ListrUserService', ['$http', '$q', function($http, $q){
	 
	 var USER_SERVICE_URI = "/api/user/"
	 var factory = {
		 createUser: createUser,
		 loginUser: loginUser
	 }
	 
	 return factory;
	 
	 function createUser(firstname, lastname, email, password) {
		 var deferred = $q.defer();
		 $http({
			 method: "POST",
			 url: USER_SERVICE_URI,
			 data: {f: firstname, l: lastname, e: email, p: password}
		 }).then(function(response) {
			 deferred.resolve(response.data);
		 });
		 return deferred.promise;
	 }
	 
	 function loginUser(email, password) {
		 var deferred = $q.defer();
		 $http({
			method:"POST",
			url: USER_SERVICE_URI + "/login/",
			data: {e: email, p: password} 
		 }).then(function(response) {
			 deferred.resolve(response.data);
		 });
		 return deferred.promise;
	 }
	 
 }]);