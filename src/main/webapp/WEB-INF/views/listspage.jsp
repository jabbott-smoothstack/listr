<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel = "stylesheet" href = "/static/css/style.css">
		<title>Listr</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		
	</head>
	<body ng-app = "listrApp" ng-controller = "ListrListController as controller">
		<div class = "row">
			<h2 class = "logo">Listr</h2>
		</div>
		<div class = "row">
			<h4 class = "welcome-message">Welcome, {{userFirstName}} !</h4>
		</div>
		<div class = "container">
			<div class = "row">
				<div class = "col-sm-4 lists-div">
					<div class = "row">
						Lists
					</div>
					<div ng-repeat = "list in lists"  ng-click = "getCategories(list.listId)">
						<div class = "list-item">
							<div class = "container">
								<div class = "row">
									<div class = "col-md-8">
										{{list.listName}}
									</div>
									<div class = "col-md-2">
										<button class = "btn btn-primary" data-toggle="modal" data-target="#editListModal" aria-label="Edit List" ng-click = "setSelectedListId(list.listId)">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
											  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
											</svg>
										</button>
									</div>
									<div class = "col-md-2">
										<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm" aria-label="Remove List" ng-click = "setSelectedListId(list.listId)">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
												<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
												<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
											</svg>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					<div class = "row">
						<button class = "btn btn-primary center-button" name = "createList" data-toggle="modal" data-target="#addListModal" aria-label="Create List">Create List</button>
					</div>
					
				</div>
				<div class = "col-sm-8 main-div">
					<div class = "container">
						<div class = "row">
							{{selectedListName}}
						</div>
						
						<div id = "accordion">
							<div class = "row">
								<div class = "col-md-12">
									<div class = "row" ng-repeat = "category in categories">
									
										<div class = "card category-card">
											<div class = "container">
												<div class = "row">
													<div class = "card-header category-card">
														<div class = "row">
															<div class = "col-md-6">
																<a class = "card-link" data-toggle="collapse" href = #{{category.categoryName[0]+category.categoryId}} aria-label="Expand Category">{{category.categoryName}}</a>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-primary" data-toggle="modal" data-target="#addItemModal" aria-label = "Add Item" ng-click = "setSelectedCategoryId(category.categoryId)">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
																	  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																	  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
																	</svg>
																</button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-primary" data-toggle="modal" data-target="#editCategoryModal" aria-label = "Edit Category" ng-click = "setSelectedCategoryId(category.categoryId)">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
																	  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
																	</svg>
																</button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-danger" data-toggle="modal" data-target="#removeCategoryConfirm" aria-label = "Remove Category" ng-click = "setSelectedCategoryId(category.categoryId)">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																		<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																		<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																	</svg>
																</button>
															</div>
														</div>
													</div>
													<div class = "collapse" id = {{category.categoryName[0]+category.categoryId}} data-parent = "#accordion">
														<div class = "card-body">
															<div class = "container">
																<div class = "row">
																	<ul class = "item-list" ng-repeat = "item in category.items">
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						{{item.itemName}}
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-primary" aria-label = "Edit Item" ng-click = "setSelectedItemId(item.itemId)" data-toggle="modal" data-target="#editItemModal">
																							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
																							  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
																							</svg>
																						</button>
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label = "Remove Item" ng-click = "setSelectedCategoryId(category.categoryId); deleteItem(item.itemId)">
																							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																							  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																							  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																							</svg>
																						</button>
																					</div>
																				</div>
																			</div>
																		</li>
																	</ul>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										
									</div>
								</div>
							</div>
						</div>
						
						<div class = "row">
							<button class = "btn btn-primary center-button" name = "createCategory" data-toggle="modal" data-target="#addCategoryModal" aria-label = "Create Category">Create Category</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "addCategoryModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Add Category to List</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "Category Name" ng-model = "newCategoryName"/>
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Add Category" ng-click = "createCategory()" data-toggle = "modal" data-target = "#addCategoryModal">Add Category</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#addCategoryModal" aria-label = "Cancel Add Category">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "editCategoryModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Edit Category</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "Category Name" ng-model = "newCategoryName"/>
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Edit Category" ng-click = "updateCategory()" data-toggle = "modal" data-target = "#editCategoryModal">Add Category</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#editCategoryModal" aria-label = "Cancel Edit Category">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "removeCategoryConfirm">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Are you sure you wish to remove this Category?</h4>
					</div>
					<div class = "modal-body">
						<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-danger" aria-label = "Remove Category" ng-click = "deleteCategory()" data-toggle = "modal" data-target = "#removeCategoryConfirm">Remove Category</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-primary" data-toggle = "modal" data-target = "#removeCategoryConfirm" aria-label = "Cancel Remove Category">Cancel</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "addItemModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Add Item to Category</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "Item Name" ng-model = "newItemName" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Add Item" ng-click = "createItem()" data-toggle = "modal" data-target = "#addItemModal">Add Item</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#addItemModal" aria-label = "Cancel Add Item">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "editItemModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Edit Item</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "Item Name" ng-model = "newItemName" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Edit Item" ng-click = "updateItem()" data-toggle = "modal" data-target = "#editItemModal">Edit Item</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#editItemModal" aria-label = "Cancel Edit Item">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "addListModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Create New List</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "List Name" ng-model = "newListName"/>
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" data-toggle = "modal" data-target = "#addListModal" aria-label = "Create List" ng-click = "createList()">Create List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#addListModal" aria-label = "Cancel Create List">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "editListModal">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Edit List</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "List Name" ng-model = "newListName"/>
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" data-toggle = "modal" data-target = "#editListModal" aria-label = "Create List" ng-click = "updateList()">Edit List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger" data-toggle = "modal" data-target = "#editListModal" aria-label = "Cancel Edit List">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "modal" id = "removeListConfirm">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Are you sure you wish to remove this List?</h4>
					</div>
					<div class = "modal-body">
						<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-danger" aria-label = "Remove List" data-toggle = "modal" data-target = "#removeListConfirm" ng-click = "deleteList()">Remove List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-primary" data-toggle = "modal" data-target = "#removeListConfirm" aria-label = "Cancel Remove List">Cancel</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-cookies.js"></script>
	<script src = "/static/js/app.js"></script>
	<script src = "/static/js/listr.list.service.js"></script>
	<script src = "/static/js/listr.list.controller.js"></script>
	</body>
</html>