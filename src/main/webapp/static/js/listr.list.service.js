 (function() {
	'use strict';
	
	angular.module('listrApp').factory('ListrListService', ['$http', '$q', ListService]);
	
	ListService.$inject = ['$http', '$q'];
	
	function ListService($http, $q) {
		const LIST_SERVICE_URI = "/api/list/";
		const USER_SERVICE_URI = "/api/user/";
		const CATEGORY_SERVICE_URI = "/api/category/";
		const ITEM_SERVICE_URI = "/api/item/"
		
		var factory = {
			getUserFirstName: getUserFirstName,
			getLists: getLists,
			getCategories: getCategories,
			getItems: getItems,
			deleteList: deleteList,
			deleteCategory: deleteCategory,
			deleteItem: deleteItem,
			updateList: updateList,
			updateCategory: updateCategory,
			updateItem: updateItem,
			createList: createList,
			createCategory: createCategory,
			createItem: createItem
		}
		return factory;
		
		function getUserFirstName(userEmail) {
			var deferred = $q.defer();
			
			$http({
				method: 'POST',
				url: USER_SERVICE_URI + "email/",
				data: {email: userEmail}
			}).then(function(response) {
				deferred.resolve(response.data);	
			});
			
			return deferred.promise;
		}
		
		function getLists(userId) {
			var deferred = $q.defer();
			
			$http({
				method: 'GET',
				url: LIST_SERVICE_URI + "all/" + userId,
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		async function getCategories(listId) {
			var deferred = $q.defer();
			
			$http({
				method: 'GET',
				url: CATEGORY_SERVICE_URI + listId
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		async function getItems(categoryId) {
			var deferred = $q.defer();
			
			$http({
				method: 'GET',
				url: ITEM_SERVICE_URI + categoryId
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function deleteList(listId) {
			var deferred = $q.defer();
			
			$http({
				method: 'DELETE',
				url: LIST_SERVICE_URI + listId
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function deleteCategory(categoryId) {
			var deferred = $q.defer();
			
			$http({
				method: 'DELETE',
				url: CATEGORY_SERVICE_URI + categoryId
			}).then(function(response) {
				deferred.resolve(response.data);
			})
			
			return deferred.promise;
		}
		
		function deleteItem(itemId) {
			var deferred = $q.defer();
			
			$http({
				method: 'DELETE',
				url: ITEM_SERVICE_URI + itemId
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function updateList(updateListId, listName) {
			var deferred = $q.defer();
			
			$http({
				method: 'PUT',
				url: LIST_SERVICE_URI,
				data: {listId: updateListId, newListName: listName}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function updateCategory(updateCategoryId, categoryName) {
			var deferred = $q.defer();
			
			$http({
				method: 'PUT',
				url: CATEGORY_SERVICE_URI,
				data: {categoryId: updateCategoryId, newCategoryName: categoryName}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function updateItem(updateItemId, itemName) {
			var deferred = $q.defer();
			
			$http({
				method: 'PUT',
				url: ITEM_SERVICE_URI,
				data: {itemId: updateItemId, newItemName: itemName}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function createList(newListName, newListUserId) {
			var deferred = $q.defer();
			$http({
				method: 'POST',
				url: LIST_SERVICE_URI,
				data: {listName: newListName, userId: newListUserId}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function createCategory(newCategoryName, listId) {
			var deferred = $q.defer();
			$http({
				method: 'POST',
				url: CATEGORY_SERVICE_URI,
				data: {categoryName: newCategoryName, categoryListId: listId}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
		
		function createItem(currentCategoryId, newItemName) {
			var deferred = $q.defer();
			$http({
				method: 'POST',
				url: ITEM_SERVICE_URI,
				data: {itemName: newItemName, categoryId: currentCategoryId}
			}).then(function(response) {
				deferred.resolve(response.data);
			});
			
			return deferred.promise;
		}
	}
 })();