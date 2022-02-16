CREATE SCHEMA `car_rental`;

USE `car_rental`;

CREATE TABLE `categories` (
`id` INT AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL,
`daily_rate` DECIMAL(10, 2) NOT NULL, 
`weekly_rate` DECIMAL(10, 2) NOT NULL, 
`monthly_rate` DECIMAL(10, 2) NOT NULL,
`weekend_rate` DECIMAL(10, 2) NOT NULL,
CONSTRAINT `pk_categories`
PRIMARY KEY `categories`(`id`));

INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
VALUES ('Mini-Van', 35.50, 150.99, 500, 40.99),
('Estate Car', 25.50, 110.99, 449.99, 32.99),
('Pickup-Truck', 30.50, 135.99, 485.99, 36.99);

CREATE TABLE `cars` (
`id` INT AUTO_INCREMENT,
`plate_number` VARCHAR(10) NOT NULL,
`make` VARCHAR(30) NOT NULL,
`model` VARCHAR(30) NOT NULL,
`car_year` YEAR NOT NULL,
`category_id` INT,
`doors` INT NOT NULL,
`picture` BLOB,
`car_condition` VARCHAR(30),
`available` BOOLEAN NOT NULL,
CONSTRAINT `pk_cars`
PRIMARY KEY `cars`(`id`),
CONSTRAINT `fk_cars_categories`
FOREIGN KEY `cars`(`category_id`)
REFERENCES `categories`(`id`));

INSERT INTO `cars`(`plate_number`, `make`, `model`, `car_year`, `doors`, `available`)
VALUES ('CB2081KL', 'Mercedes', '124', 1989, 5, TRUE),
('CA5214PL', 'Seat', 'Ibiza', 2005, 5, FALSE),
('CA6282LM', 'Toyota', 'Avensis', 2002, 5, FALSE);

CREATE TABLE `employees` (
`id` INT AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`title` VARCHAR(30) NOT NULL,
`notes` TEXT,
CONSTRAINT `pk_employees`
PRIMARY KEY `employees`(`id`));

INSERT INTO `employees`(`first_name`, `last_name`, `title`)
VALUES ('John', 'Smith', 'Sales Manager'),
('Annete', 'James', 'Office Manager'),
('Brian', 'Adams', 'Sales Representative');

CREATE TABLE `customers` (
`id` INT AUTO_INCREMENT,
`driver_licence_number` VARCHAR(30) UNIQUE NOT NULL,
`full_name` VARCHAR(30) NOT NULL,
`address` VARCHAR(30) NOT NULL,
`city` VARCHAR(30) NOT NULL,
`zip_code` VARCHAR(10),
`notes` TEXT,
CONSTRAINT `pk_customers`
PRIMARY KEY `customers`(`id`));

INSERT INTO `customers`(`driver_licence_number`,`full_name`, `address`, `city`)
VALUES ('123456', 'George Johnson', 'Maple street 20', 'Washington'),
('232356', 'Adam Sandler', '5th Avenue 25', 'New York'),
('123346', 'James Gordon', 'Malibu', 'Los Angeles');

CREATE TABLE `rental_orders` (
`id` INT AUTO_INCREMENT,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(50) NOT NULL,
`tank_level` VARCHAR(30) NOT NULL,
`kilometrage_start` INT NOT NULL,
`kilometrage_end` INT NOT NULL,
`total_kilometrage` INT NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
`total_days` INT NOT NULL,
`rate_applied` DOUBLE(10, 2),
`tax_rate` DOUBLE(10, 2),
`order_status` VARCHAR(50),
`notes` TEXT,
CONSTRAINT `pk_rental_orders`
PRIMARY KEY `rental_orders`(`id`),
CONSTRAINT `fk_rental_orders_employees`
FOREIGN KEY `rental_orders`(`employee_id`)
REFERENCES `employees`(`id`),
CONSTRAINT `fk_rental_orders_customers`
FOREIGN KEY `rental_orders`(`customer_id`)
REFERENCES `customers`(`id`),
CONSTRAINT `fk_rental_orders_cars`
FOREIGN KEY `rental_orders`(`car_id`)
REFERENCES `cars`(`id`));

INSERT INTO `rental_orders`(`car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`, `total_kilometrage`, `start_date`, `end_date`, `total_days`)
VALUES ('Good', 'Full', 123000, 130000, 130000, '2001-01-12', '2001-01-18', 6),
('Good', 'Full', 60000, 61000, 61000, '2001-01-13', '2001-01-15', 2),
('Good', 'Full', 50000, 55000, 55000, '2001-01-01', '2001-01-20', 19);