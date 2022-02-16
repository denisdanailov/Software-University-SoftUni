CREATE SCHEMA instd;
USE instd;

CREATE TABLE users(
`id` INT PRIMARY KEY,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL);

CREATE TABLE addresses(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT `fk_addresses_users`
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`));

CREATE TABLE photos(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL,
`views` INT NOT NULL DEFAULT 0);

CREATE TABLE comments(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT `fk_comments_photos`
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`));

CREATE TABLE users_photos(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT `fk_up_users`
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT `fk_up_photos`
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`));

CREATE TABLE likes(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`user_id` INT,
`photo_id` INT,
CONSTRAINT `fk_likes_users`
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
CONSTRAINT `fk_likes_photos`
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`));