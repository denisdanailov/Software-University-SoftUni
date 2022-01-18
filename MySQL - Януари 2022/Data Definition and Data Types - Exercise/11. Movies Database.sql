CREATE SCHEMA `movies`; 

USE `movies`;

CREATE TABLE `directors` (
`id` INT AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT,
CONSTRAINT `pk_directors`
PRIMARY KEY `directors` (`id`));

INSERT INTO `directors` (`director_name`)
VALUES ('Test Director Name 1'),
('Test Director Name 2'),
('Test Director Name 3'),
('Test Director Name 4'),
('Test Director Name 5');

CREATE TABLE `genres` (
`id` INT AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT,
CONSTRAINT `pk_genres`
PRIMARY KEY `genres`(`id`));

INSERT INTO `genres` (`genre_name`)
VALUES ('Test Genre Name 1'),
('Test Genre Name 2'),
('Test Genre Name 3'),
('Test Genre Name 4'),
('Test Genre Name 5');

CREATE TABLE `categories` (
`id` INT AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT,
CONSTRAINT `pk_categories`
PRIMARY KEY `categories`(`id`));

INSERT INTO `categories` (`category_name`)
VALUES ('Test Category Name 1'),
('Test Category Name 2'),
('Test Category Name 3'),
('Test Category Name 4'),
('Test Category Name 5');

CREATE TABLE `movies` (
`id` INT AUTO_INCREMENT,
`title` VARCHAR(30) NOT NULL,
`director_id` INT,
`copyright_year` INT,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT,
CONSTRAINT `pk_movies`
PRIMARY KEY `movies`(`id`),
CONSTRAINT `fk_movies_directors`
FOREIGN KEY `movies`(`director_id`)
REFERENCES `directors`(`id`),
CONSTRAINT `fk_movies_genres`
FOREIGN KEY `movies`(`genre_id`)
REFERENCES `genres`(`id`),
CONSTRAINT `fk_movies_category`
FOREIGN KEY `movies`(`category_id`)
REFERENCES `categories`(`id`)
);

INSERT INTO `movies` (`title`)
VALUES ('Test Title Name 1'),
('Test Title Name 2'),
('Test Title Name 3'),
('Test Title Name 4'),
('Test Title Name 5');
