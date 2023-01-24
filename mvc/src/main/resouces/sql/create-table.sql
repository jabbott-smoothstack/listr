CREATE TABLE IF NOT EXISTS`user` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20),
	`email` VARCHAR(35) NOT NULL,
	`password_hash` VARCHAR(35) NOT NULL,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE IF NOT EXISTS `list` (
	`list_id` INT NOT NULL AUTO_INCREMENT,
	`list_name` VARCHAR(25) NOT NULL,
	`list_user_id` INT NOT NULL,
	PRIMARY KEY(`list_id`)
);

CREATE TABLE IF NOT EXISTS `category` (
	`category_id` INT NOT NULL AUTO_INCREMENT,
	`category_name` VARCHAR(25) NOT NULL,
	`category_list_id` INT NOT NULL,
	PRIMARY KEY(`category_id`)
);

CREATE TABLE IF NOT EXISTS `item` (
	`item_id` INT NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(25) NOT NULL,
	`item_category_id` INT NOT NULL,
	PRIMARY KEY(`item_id`)
);