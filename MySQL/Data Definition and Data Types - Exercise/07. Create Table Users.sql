CREATE TABLE `users` (
`id` INT AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN,
CONSTRAINT `pk_users`
PRIMARY KEY `users`(`id`));

INSERT INTO `users` (`username`, `password`)
VAlUES ('Margo Stevens', '12345'),
('Alehandro Stain', '12345'),
('George Martin', '12345'),
('Albert Einstain', '12345'),
('Elena Adkins', '12345');

