<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel = "stylesheet" href = "/static/css/style.css">
		<title>Listr</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
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
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm"> X </button>
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
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm"> X </button>
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
									<button class = "btn btn-danger" data-toggle="modal" data-target="#removeListConfirm"> X </button>
								</div>
							</div>
						</div>
					</div>
					<div class = "row">
						<button class = "btn btn-primary center-button" name = "createList" data-toggle="modal" data-target="#addListModal">Create List</button>
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
																<a class = "card-link" data-toggle="collapse" href="#category1">Category 1</a>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-primary" data-toggle="modal" data-target="#addItemModal"> + </button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-danger" data-toggle="modal" data-target="#removeCategoryConfirm"> X </button>
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
																						<button class = "btn btn-danger"> X </button>
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
																						<button class = "btn btn-danger"> X </button>
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
																						<button class = "btn btn-danger"> X </button>
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
																<button class = "btn btn-primary" data-toggle="modal" data-target="#addItemModal"> + </button>
															</div>
															<div class = "col-md-2">
																<button class = "btn btn-danger" data-toggle="modal" data-target="#removeCategoryConfirm"> X </button>
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
																						<button class = "btn btn-danger"> X </button>
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
																						<button class = "btn btn-danger"> X </button>
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
							<button class = "btn btn-primary center-button" name = "createCategory" data-toggle="modal" data-target="#addCategoryModal">Create Category</button>
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
									<input type = "text" placeholder = "Category Name" />
								</div>
							</div>
							<div class = "row">
								<div class = "col-md-6">
									<button class = "btn btn-primary">Add Category</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger">Cancel</button>
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
									<button class = "btn btn-danger">Remove Category</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-primary">Cancel</button>
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
									<button class = "btn btn-primary">Add Item</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger">Cancel</button>
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
									<button class = "btn btn-primary">Create List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-danger">Cancel</button>
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
									<button class = "btn btn-danger">Remove List</button>
								</div>
								<div class = "col-md-6">
									<button class = "btn btn-primary">Cancel</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>