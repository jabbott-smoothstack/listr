 (function() {
	 
	 'use strict';
	 
	 angular.module('listrApp').controller('ListrListController', ListController);
	 
	 ListController.$inject = ['$scope', '$cookies', 'ListrListService'];
	 
	 function ListController($scope, $cookies, ListrListService) {
		 $scope.lists = [];
		 $scope.categories = [];
		 $scope.userFirstName = "";
		 $scope.userId = 0;
		 $scope.selectedListId = 0;
		 $scope.newListName = "";
		 $scope.selectedListName = "";
		 $scope.newCategoryName = "";
		 $scope.selectedCategoryId = 0;
		 $scope.newItemName = "";
		 $scope.selectedItemId = 0;
		 
		 $scope.createList = createList;
		 $scope.setSelectedListId = setSelectedListId;
		 $scope.deleteList = deleteList;
		 $scope.createCategory = createCategory;
		 $scope.getCategories = getCategories;
		 $scope.setSelectedCategoryId = setSelectedCategoryId;
		 $scope.deleteCategory = deleteCategory;
		 $scope.createItem = createItem;
		 $scope.deleteItem = deleteItem;
		 $scope.updateList = updateList;
		 $scope.updateCategory = updateCategory;
		 $scope.updateItem = updateItem;
		 $scope.setSelectedItemId = setSelectedItemId;
		 
		 function init() {
			 getUserFirstName();
		 }
		 
		 function getLists(userId) {
			 ListrListService.getLists(userId).then(function(response) {
				 $scope.lists = response;
				 if($scope.lists.length > 0) {
					 $scope.selectedListId = $scope.lists[0].listId;
					 getCategories($scope.selectedListId);
				 }
			 });
		 }
		 
		 async function getCategories(listId) {
			 $scope.selectedListId = listId;
			 await ListrListService.getCategories(listId).then(async function(response) {
				$scope.categories = response;
				for(var category in $scope.categories) {
					await ListrListService.getItems($scope.categories[category].categoryId).then(function(response) {
						$scope.categories[category].items = response;
					});
				}
			 });
			 $scope.$apply();
		 }
		 
		 function getUserFirstName() {
			 var userEmail = $cookies.get('user');
			 ListrListService.getUserFirstName(userEmail).then(function(response) {
				$scope.userFirstName = response.firstName;
				$scope.userId = response.userId;
				getLists($scope.userId);				
			 });
		 }
		 
		 function updateList() {
			 ListrListService.updateList($scope.selectedListId, $scope.newListName).then(function(response) {
				getLists();
			 });
		 }
		 
		 function updateCategory() {
			 console.log($scope.selectedCategoryId);
			 ListrListService.updateCategory($scope.selectedCategoryId, $scope.newCategoryName).then(function(response) {
				getCategories();
			 });
		 }
		 
		 function updateItem() {
			 ListrListService.updateItem($scope.selectedItemId, $scope.newItemName).then(function(response) {
				getCategories(); 
			 });
		 }
		 
		 function createList() {
			 ListrListService.createList($scope.newListName, $scope.userId).then(function(response) {
				 $scope.lists.push(response);
			 });
		 }
		 
		 function createCategory() {
			 ListrListService.createCategory($scope.newCategoryName, $scope.selectedListId).then(function(response) {
				$scope.categories.push(response); 
			 });
		 }
		 
		 function createItem() {
			 ListrListService.createItem($scope.selectedCategoryId, $scope.newItemName).then(function(response) {
				 getCategories($scope.selectedListId);
			 });
		 }
		 
		 function deleteList() {
			 ListrListService.deleteList($scope.selectedListId).then(function(response) {
				 getLists($scope.userId);
			 });
		 }
		 
		 function deleteCategory() {
			 ListrListService.deleteCategory($scope.selectedCategoryId).then(function(response) {
				getCategories($scope.selectedListId); 
			 });
		 }
		 
		 function deleteItem(itemId) {
			 ListrListService.deleteItem(itemId).then(function(response) {
				 getCategories($scope.selectedListId);
			 });
		 }
		 
		 function setSelectedListId(listId) {
			 $scope.selectedListId = listId;
		 }
		 
		 function setSelectedCategoryId(categoryId) {
			 $scope.selectedCategoryId = categoryId;
		 }
		 
		 function setSelectedItemId(itemId) {
			 $scope.selectedItemId = itemId;
		 }
		 
		 init();
	 }
	 
	 
 })();
 
