CREATE SCHEMA ruk_database;
USE ruk_database;

CREATE TABLE `branches`(
`id` INT AUTO_INCREMENT primary key,
`name` varchar(30) not null unique);

CREATE TABLE `employees`(
`id` int auto_increment primary key,
`first_name` varchar(20) not null,
`last_name` varchar(20) not null,
`salary` decimal(10, 2) not null,
`started_on` date not null,
`branch_id` int not null,
constraint `fk_emp_branches`
foreign key (`branch_id`)
references `branches`(`id`));

CREATE TABLE `clients`(
`id` int auto_increment primary key,
`full_name` varchar(50) not null,
`age` int not null);

CREATE TABLE `employees_clients`(
`employee_id` int,
`client_id` int, 
constraint `fk_ec_employees`
foreign key (`employee_id`)
references `employees`(`id`),
constraint `fk_ec_clients`
foreign key (`client_id`)
references `clients`(`id`));

CREATE TABLE `bank_accounts`(
`id` int auto_increment primary key,
`account_number` varchar(10) not null,
`balance` decimal(10, 2) not null,
`client_id` int not null unique,
constraint `fk_ba_clients`
foreign key (`client_id`)
references `clients`(`id`));

CREATE TABLE `cards`(
`id` int auto_increment primary key,
`card_number` varchar(19) not null,
`card_status` varchar(7) not null,
`bank_account_id` int not null,
constraint `fk_cards_ba`
foreign key (`bank_account_id`)
references `bank_accounts`(`id`));