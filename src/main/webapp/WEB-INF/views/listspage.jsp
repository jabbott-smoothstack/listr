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
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	</head>
	<body>
		<div class = "row">
			<h2 class = "logo">Listr</h2>
		</div>
		<div class = "row">
			<h4 class = "welcome-message">Welcome, (first name) !</h4>
		</div>
		<div class = "container">
			<div class = "row">
				<div class = "col-sm-4 lists-div">
					<div class = "row">
						Lists
					</div>
					<div class = "list-item">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-10">
									List 1
								</div>
								<div class = "col-md-2">
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm" aria-label="Remove List">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
											<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
											<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
										</svg>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class = "list-item">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-10">
									List 2
								</div>
								<div class = "col-md-2">
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm" aria-label="Remove List">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
											<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
											<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
										</svg>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class = "list-item">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-10">
									List 3
								</div>
								<div class = "col-md-2">
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm" aria-label="Remove List">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
											<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
											<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
										</svg>
									</button>
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
							List Name
						</div>
						
						<div id = "accordion">
							<div class = "row">
								<div class = "col-md-12">
									<div class = "row">
									
									
										<div class = "card category-card">
											<div class = "container">
												<div class = "row">
													<div class = "card-header category-card">
														<div class = "row">
															<div class = "col-md-8">
																<a class = "card-link" data-toggle="collapse" href="#category1" aria-label="Expand Category">Category 1</a>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-primary" data-toggle="modal" data-target="#addItemModal" aria-label = "Add Item">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
																	  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																	  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
																	</svg>
																</button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-danger" data-toggle="modal" data-target="#removeCategoryConfirm" aria-label = "Remove Category">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																		<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																		<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																	</svg>
																</button>
															</div>
														</div>
													</div>
													<div class = "collapse" id="category1" data-parent = "#accordion">
														<div class = "card-body">
															<div class = "container">
																<div class = "row">
																	<ul class = "item-list">
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						Item 1
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label = "Remove Item">
																							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																							  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																							  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																							</svg>
																						</button>
																					</div>
																				</div>
																			</div>
																		</li>
																		
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						Item 2
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label = "Remove Item">
																							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																							  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																							  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																							</svg>
																						</button>
																					</div>
																				</div>
																			</div>
																		</li>
																		
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						Item 3
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label ="Remove Item">
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
										
										<div class = "card category-card">
											<div class = "container">
												<div class = "row">
													<div class = "card-header category-card">
														<div class = "row">
															<div class = "col-md-8">
																<a class = "card-link" data-toggle="collapse" href="#category2">Category 2</a>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-primary" data-toggle="modal" data-target="#addItemModal" aria-label = "Add Item">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
																	  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																	  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
																	</svg>
																</button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-danger" data-toggle="modal" data-target="#removeCategoryConfirm" aria-label = "Remove Category">
																	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																		<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																		<path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																	</svg>
																</button>
															</div>
														</div>
													</div>
													<div class = "collapse" id="category2" data-parent = "#accordion">
														<div class = "card-body">
															<div class = "container">
																<div class = "row">
																	<ul class = "item-list">
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						Item 1
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label = "Remove Item">
																							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
																							  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
																							  <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
																							</svg>
																						</button>
																					</div>
																				</div>
																			</div>
																		</li>
																		
																		<li class = "item">
																			<div class = "container">
																				<div class = "row">
																					<div class = "col-md-8">
																						Item 2
																					</div>
																					<div class = "col-md-2">
																						<button class = "btn btn-danger" aria-label = "Remove Item">
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
		
		<div class = "modal" id = "addCategoryModal"">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Add Category to List</h4>
					</div>
					<div class = "modal-body">
						<div class = "container">
							<div class = "row">
								<div class = "col-md-12">
									<input type = "text" placeholder = "Category Name" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Add Category">Add Category</button>
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
		
		<div class = "modal" id = "removeCategoryConfirm">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Are you sure you wish to remove this Category?</h4>
					</div>
					<div class = "modal-body">
						<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-danger" aria-label = "Remove Category">Remove Category</button>
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
									<input type = "text" placeholder = "Item Name" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Add Item">Add Item</button>
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
									<input type = "text" placeholder = "List Name" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary" aria-label = "Create List">Create List</button>
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
		
		<div class = "modal" id = "removeListConfirm">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						<h4 class = "modal-title">Are you sure you wish to remove this List?</h4>
					</div>
					<div class = "modal-body">
						<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-danger" aria-label = "Remove List">Remove List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-primary" data-toggle = "modal" data-target = "#removeListConfirm" aria-label = "Cancel Remove List">Cancel</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>