CREATE TABLE `people` (
`id` INT UNIQUE AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(10, 2),
`weight` DOUBLE(10, 2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT(65535),
PRIMARY KEY (`id`));

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES ("Robin Hood", "m", "1990-08-15"),  
("Anne Wallder", "f", "1993-10-03"),  
("George Mason", "m", "1987-01-10"),  
("Wendy Parker", "f", "1999-12-20"),  
("Scott Adkins", "m", "1991-03-15");  
