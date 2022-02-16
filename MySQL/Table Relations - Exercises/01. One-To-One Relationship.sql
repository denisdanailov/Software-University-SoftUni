CREATE SCHEMA `table_relationships`;
USE `table_relationships`;

CREATE TABLE `people` (
`person_id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50),
`salary` DECIMAL,
`passport_id` INT UNIQUE);

CREATE TABLE `passports` (
`passport_id` INT AUTO_INCREMENT PRIMARY KEY ,
`passport_number` VARCHAR(10) UNIQUE)
AUTO_INCREMENT = 101;

INSERT INTO `passports`(`passport_number`)
VALUES ('N34FG21B'), ('K65LO4R7'), ('ZE657QP2');

INSERT INTO `people`(`first_name`, `salary`, `passport_id`)
VALUES ('Roberto', 43300.00, 102), ('Tom', 56100.00, 103), ('Yana', 60200.00, 101);

ALTER TABLE `people`
ADD CONSTRAINT `fk_people_passports`
FOREIGN KEY `people`(`passport_id`)
REFERENCES `passports`(`passport_id`);

ALTER TABLE `people`
MODIFY COLUMN `salary` DECIMAL(10, 2);
