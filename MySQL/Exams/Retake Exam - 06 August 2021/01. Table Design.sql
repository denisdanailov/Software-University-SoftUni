CREATE SCHEMA sgd;
USE sgd;

CREATE TABLE `addresses`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(10) NOT NULL);

CREATE TABLE `offices`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`workspace_capacity` INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL,
CONSTRAINT `fk_offices_addresses`
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`));

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10, 2) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`happiness_level` CHAR(1) NOT NULL);

CREATE TABLE `teams`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
CONSTRAINT `fk_teams_offices`
FOREIGN KEY (`office_id`)
REFERENCES `offices`(`id`),
`leader_id` INT UNIQUE,
CONSTRAINT `fk_teams_employees`
FOREIGN KEY (`leader_id`)
REFERENCES `employees`(`id`));

CREATE TABLE `games`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT NOT NULL DEFAULT 5.5,
`budget` DECIMAL(10, 2) NOT NULL,
`release_date` DATE,
`team_id` INT NOT NULL,
CONSTRAINT `fk_games_teams`
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`));

CREATE TABLE `games_categories`(
`game_id` INT NOT NULL,
CONSTRAINT `fk_gc_games`
FOREIGN KEY (`game_id`)
REFERENCES `games`(`id`),
`category_id` INT NOT NULL,
CONSTRAINT `fk_gc_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
CONSTRAINT `pk_games_categories`
PRIMARY KEY (`game_id`, `category_id`));