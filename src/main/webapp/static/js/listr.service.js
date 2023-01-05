/**
 * Listr AngularJS service
 */

 angular.module('listrApp').factory('ListrUserService', ['$http', '$q', function($http, $q){
	 
	 var USER_SERVICE_URI = "/api/user/"
	 var factory = {
		 createUser: createUser,
		 
	 }
	 
	 return factory;
	 
	 function createUser(firstname, lastname, email, password) {
		 var deferred = $q.defer();
		 $http({
			 method: "POST",
			 url: USER_SERVICE_URI,
			 data: {}
		 })
	 }
	 
 }]);