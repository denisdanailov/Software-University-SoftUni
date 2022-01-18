ALTER TABLE `towns`
RENAME COLUMN `town_id` TO `id`;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT `my_fk`
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);